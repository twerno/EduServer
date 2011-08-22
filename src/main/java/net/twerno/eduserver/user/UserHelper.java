package net.twerno.eduserver.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.twerno.eduserver.user.entities.Account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserHelper {
	public static UserDetails getUserDetailsFromAccount(Account account) {
		if (account == null) return null;

		return new User(account.getUsername(), 
			            account.getPassword(),
		                account.getEnabled(), 
				        true, 
				        true, 
				        true,
				        getAuthorities(account.getRoles()));
	}

	public static ArrayList<GrantedAuthorityImpl> getAuthorities(
			Set<UserRole> roles) {
      ArrayList<GrantedAuthorityImpl> result = new ArrayList<GrantedAuthorityImpl>();
	  for (UserRole role : roles)
        result.add(new GrantedAuthorityImpl(role.name()));
	  return result;
	}
	
	public static Account getAccountFromUserDetails(UserDetails userDetails) {
		Account account = new Account();
		account.setEnabled(true);
		account.setUsername(userDetails.getUsername());
		account.setPassword(userDetails.getPassword());
		UserRole newRole;
		for (GrantedAuthority role: userDetails.getAuthorities()) {
			newRole = UserRole.valueOf(role.getAuthority());
			if (newRole != null)
				account.getRoles().add(newRole);
		}
		return account;
	}
	
	public static void zamazHaslo(Account account) {
		account.setPassword("***");
	}
	
	public static void zamazHasla(List<Account> accounts) {
		for (Account account : accounts) 
			zamazHaslo(account);
	}
}
