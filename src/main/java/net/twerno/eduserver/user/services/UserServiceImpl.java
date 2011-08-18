package net.twerno.eduserver.user.services;

import java.util.Set;

import javax.persistence.EntityNotFoundException;

import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.user.domain.Account;
import net.twerno.eduserver.user.domain.Grupa;
import net.twerno.eduserver.services.UserService;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
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
}
