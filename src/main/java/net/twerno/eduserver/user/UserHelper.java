package net.twerno.eduserver.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.twerno.eduserver.security.SaltedUser;
import net.twerno.eduserver.security.SaltedUserDetails;
import net.twerno.eduserver.user.entity.Account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserHelper {
	public static SaltedUserDetails getUserDetailsFromAccount(Account account) {
		if (account == null) return null;
		SaltedUser userDetails = new SaltedUser(account.getUsername(), 
			            account.getPassword(),
		                account.getEnabled(), 
				        true, 
				        true, 
				        true,
				        getAuthorities(account.getRoles()));
		userDetails.setSalt(account.getSalt());
		return userDetails;
	}

	public static ArrayList<GrantedAuthorityImpl> getAuthorities(
			Set<UserRole> roles) {
      ArrayList<GrantedAuthorityImpl> result = new ArrayList<GrantedAuthorityImpl>();
	  for (UserRole role : roles)
        result.add(new GrantedAuthorityImpl(role.name()));
	  return result;
	}
	
	public static Account getAccountFromUserDetails(SaltedUserDetails userDetails) {
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
	
	public static void zamazSalt(Account account) {
		account.setSalt("");
	}
	
	public static void zamazHasla(List<Account> accounts) {
		for (Account account : accounts) 
			zamazHaslo(account);
	}
	
	public static void zamazSalt(List<Account> accounts) {
		for (Account account : accounts) 
			zamazSalt(account);
	}
	
	public static Account getCurrentUser(boolean zamazDaneWrazliwe) {
		SaltedUser user = (SaltedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account account = getAccountFromUserDetails(user);
		if (zamazDaneWrazliwe) {
			zamazHaslo(account);
			zamazSalt(account);
		}
		return account;
	}
	
	public static Account getCurrentUser() {
		return getCurrentUser(true);
	}
}
