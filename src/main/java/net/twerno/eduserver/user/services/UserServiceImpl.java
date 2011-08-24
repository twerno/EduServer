package net.twerno.eduserver.user.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import net.twerno.eduserver.security.SaltHelper;
import net.twerno.eduserver.security.SaltedUser;
import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.user.UserQueries;
import net.twerno.eduserver.user.UserRole;
import net.twerno.eduserver.user.entities.Account;
import net.twerno.eduserver.user.entities.Grupa;
import net.twerno.eduserver.user.exceptions.NoRolesException;
import net.twerno.eduserver.user.exceptions.UserExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
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
			throw new NoRolesException("Nie przypisano 풹dnej roli do u퓓tkownika: "+username);

		UserRole role = null;
		if (role_uczen)
			role = UserRole.ROLE_UCZEN;
		else if (role_nauczyciel)
			role = UserRole.ROLE_NAUCZYCIEL;
		
		InternalRegisterUser(username, password, role);
	}

	@Override
	public Account getLoggedUser() {
		SaltedUser user = (SaltedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account account = UserHelper.getAccountFromUserDetails(user);
		UserHelper.zamazHaslo(account);
		UserHelper.zamazSalt(account);
		return account;
	}

	@Override
	public List<Account> findAllAccounds() {
		List<Account> accounts = Account.findAllAccounts();
		UserHelper.zamazHasla(accounts);
		UserHelper.zamazSalt(accounts);
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
	public boolean dodajGrupe(String nazwaGrupy) {
		if (!UserQueries.GrupaByNameExisits(nazwaGrupy)) {
			Grupa grupa = new Grupa();
			grupa.setNazwa(nazwaGrupy);
			grupa.merge();
			return true;
		}
		return false;
	}

	@Override
	public boolean usunGrupe(String nazwaGrupy) {
		if (UserQueries.GrupaByNameExisits(nazwaGrupy)) {
			Grupa grupa = Grupa.findGrupasByNazwaEquals(nazwaGrupy).getSingleResult();
			grupa.remove();
			return true;
		}
		return false;
	}

	@Override
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
		return Grupa.findAllGrupas();
	}

	@Override
	public void InternalRegisterUser(String username, String password,
			UserRole role) {
		if (UserQueries.UserByNameExisits(username))
			throw new UserExistsException("U퓓tkownik o nazwie: " +username +" ju� istnieje.");
		if (role == null)
			throw new NoRolesException("Nie przypisano 풹dnej roli do u퓓tkownika: "+username);

		String salt = SaltHelper.getSalt();
		Account account = new Account();
		account.setUsername(username);
		account.setPassword( shaPasswordEncoder.encodePassword(password, salt) );
		account.setSalt(salt);
		account.setEnabled(true);
		account.getRoles().add(role);
		account.merge();
	}
}
