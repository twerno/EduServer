package net.twerno.eduserver.user.services;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import net.twerno.eduserver.user.UserHelper;
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
		Account account = null;
        try {
        	account = Account.findAccountsByUsernameEquals(arg0).getSingleResult();
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException(
            		String.format("Nie znaleziono uzytkownika o nazwie: '%s'.", arg0));
        }
		return UserHelper.getUserDetailsFromAccount(account);
	}

	public boolean saveUser(UserDetails userDetails) {
		Account account = UserHelper.getAccountFromUserDetails(userDetails);
		account.persist();
//		Account.
		return true;
	}

	@Override
	public Set<Grupa> getCurrentUserGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Grupa> getUserGroups(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dodajDoGrupy(String username, String grupa)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean usunZGrupy(String username, String grupa)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerUser(Account account) {
		account.setEnabled(true);
		account.merge();
		return true;
	}

	@Override
	public Account getAccount() {
//		System.out.println("get account");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println("user: "+user.getUsername());
		Account account = UserHelper.getAccountFromUserDetails(user);
		account.setPassword("****");
//		System.out.println(account.toString());
		return account;
	}

	@Override
	public List<Account> findAllAccounds() {
		List<Account> accounts = Account.findAllAccounts();
		for (Account account : accounts) {
			account.setPassword("****");
		}
		return accounts;
	}
}
