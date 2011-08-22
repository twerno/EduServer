package net.twerno.eduserver.user.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.user.UserQueries;
import net.twerno.eduserver.user.entities.Account;
import net.twerno.eduserver.user.entities.Grupa;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException, DataAccessException {
		Account account = loadAccountByName(arg0);
		return UserHelper.getUserDetailsFromAccount(account);
	}

	@Override
	public boolean registerUser(Account account) {
		account.setEnabled(true);
		account.merge();
		return true;
	}

	@Override
	public Account getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account account = UserHelper.getAccountFromUserDetails(user);
		UserHelper.zamazHaslo(account);
		return account;
	}

	@Override
	public List<Account> findAllAccounds() {
		List<Account> accounts = Account.findAllAccounts();
		UserHelper.zamazHasla(accounts);
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
}
