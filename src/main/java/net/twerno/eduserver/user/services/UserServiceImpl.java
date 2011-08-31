package net.twerno.eduserver.user.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import net.twerno.eduserver.security.SaltHelper;
import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.user.UserQueries;
import net.twerno.eduserver.user.UserRole;
import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.user.entity.Grupa;
import net.twerno.eduserver.user.exceptions.NoRolesException;
import net.twerno.eduserver.user.exceptions.UserExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private ShaPasswordEncoder shaPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException, DataAccessException {
		Account account = loadAccountByName(arg0);
		return UserHelper.getUserDetailsFromAccount(account);
	}

	@Override
	public void registerUser(String username, String password,
			boolean role_uczen, boolean role_nauczyciel)
			throws UserExistsException, NoRolesException {
		if (!role_uczen && !role_nauczyciel)
			throw new NoRolesException("Nie przypisano ¿adnej roli do u¿ytkownika: "+username);

		UserRole role = null;
		if (role_uczen)
			role = UserRole.ROLE_UCZEN;
		else if (role_nauczyciel)
			role = UserRole.ROLE_NAUCZYCIEL;
		
		InternalRegisterUser(username, password, role);
	}

	@Override
	public Account getLoggedUser() {
		Account account = UserHelper.getCurrentUser();
		UserHelper.przygotujAccount(account);
		return account;
	}

	@Override
	public List<Account> findAllAccounds() {
		List<Account> accounts = Account.findAllAccounts();
		UserHelper.przygotujAccount(accounts);
		return accounts;
	}

	@Override
	public void dodajDoGrupy(String username, String nazwaGrupy)
			throws UsernameNotFoundException {
		Account account = loadAccountByName(username);
		Grupa grupa = Grupa.findGrupasByNazwaEquals(nazwaGrupy).getSingleResult();
		account.getGrupy().add(grupa);
		account.persist();
	}

	@Override
	public void usunZGrupy(String username, String nazwaGrupy)
			throws UsernameNotFoundException {
		Account account = loadAccountByName(username);
		for (Grupa grupa : account.getGrupy())
			if (grupa.getNazwa() == nazwaGrupy)
				account.getGrupy().remove(grupa);
		account.persist();
	}

	@Override
	public Grupa dodajGrupe(String nazwaGrupy) throws Exception {
		if (UserQueries.GrupaByNameExisits(nazwaGrupy))
			throw new Exception("Grupa o nazwie: "+nazwaGrupy+" ju¿ istnieje.");
		Grupa grupa = new Grupa();
		grupa.setNazwa(nazwaGrupy);
		grupa.merge();
		return grupa;
	}

	@Override
	public void usunGrupe(String nazwaGrupy) throws Exception {
		if (!UserQueries.GrupaByNameExisits(nazwaGrupy))
			return;

		Grupa grupa = Grupa.findGrupasByNazwaEquals(nazwaGrupy).getSingleResult();
		grupa.getAccounts().clear();
		grupa.remove();
	}

	@Override
//	@RemotingExclude
	public Account loadAccountByName(String username)
			throws UsernameNotFoundException {
        try {
        	return Account.findAccountsByUsernameEquals(username).getSingleResult();
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException(
            	String.format("Nie znaleziono uzytkownika o nazwie: '%s'.", username));
        }
	}

	@Override
	public List<Grupa> findAllGroups() {
		List<Grupa> grupy = Grupa.findAllGrupas(); 
		UserHelper.usunKontaZGrupy(grupy);
		return grupy;
	}

	@Override
	public void InternalRegisterUser(String username, String password,
			UserRole role) {
		if (UserQueries.UserByNameExisits(username))
			throw new UserExistsException("U¿ytkownik o nazwie: " +username +" ju¿ istnieje.");
		if (role == null)
			throw new NoRolesException("Nie przypisano ¿adnej roli do u¿ytkownika: "+username);

		String salt = SaltHelper.getSalt();
		Account account = new Account();
		account.setUsername(username);
		account.setPassword( shaPasswordEncoder.encodePassword(password, salt) );
		account.setSalt(salt);
		account.setEnabled(true);
		account.getRoles().add(role);
		account.merge();
	}

	@Override
	public void zapiszAccount(Account account) {
		Account cleanAccount = Account.findAccount(account.getId());
		cleanAccount.setEnabled(account.getEnabled());

		cleanAccount.getRoles().clear();
		for (UserRole role: account.getRoles())
			cleanAccount.getRoles().add(role);

		cleanAccount.getGrupy().clear();
		for (Grupa grupa: account.getGrupy())
			cleanAccount.getGrupy().add(Grupa.findGrupa(grupa.getId()));
		cleanAccount.merge();
	}

	@Override
	public void zmienMojeHaslo(String noweHaslo) {
		Account account = getLoggedUser();
		account.setPassword( shaPasswordEncoder.encodePassword(noweHaslo, account.getSalt()) );
		account.merge();
	}

	@Override
	public void zmienHaslo(String username, String noweHaslo) {
		Account account = Account.findAccountsByUsernameEquals(username).getSingleResult();
		account.setPassword( shaPasswordEncoder.encodePassword(noweHaslo, account.getSalt()) );
		account.merge();		
	}
}
