package net.twerno.eduserver.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.twerno.eduserver.security.SaltedUser;
import net.twerno.eduserver.security.SaltedUserDetails;
import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.user.entity.Grupa;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserHelper {
	public static SaltedUserDetails getUserDetailsFromAccount(Account account) {
		if (account == null) return null;
		SaltedUser userDetails = new SaltedUser(account.getId(),
						account.getUsername(), 
			            account.getPassword(),
		                account.getEnabled(), 
				        true, 
				        true, 
				        true,
				        getAuthorities(account.getRoles()));
		userDetails.setSalt(account.getSalt());
		for (Grupa grupa: account.getGrupy())
			userDetails.getGrupy().add(grupa);
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
		account.setId(userDetails.getId());
		account.setEnabled(true);
		account.setUsername(userDetails.getUsername());
		account.setPassword(userDetails.getPassword());
		UserRole newRole;
		for (GrantedAuthority role: userDetails.getAuthorities()) {
			newRole = UserRole.valueOf(role.getAuthority());
			if (newRole != null)
				account.getRoles().add(newRole);
		}

		Grupa newGrupa;
		for (Grupa grupa: userDetails.getGrupy()) {
			newGrupa = new Grupa();
			newGrupa.setNazwa(grupa.getNazwa());
			newGrupa.setId(grupa.getId());
			account.getGrupy().add(newGrupa);
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
	
	public static void usunKontaZGrupy(Grupa grupa) {
		grupa.getAccounts().clear();
	}
	
	public static void usunKontaZGrupy(List<Grupa> grupy) {
		for (Grupa grupa : grupy) 
			usunKontaZGrupy(grupa);
	}
	
	public static void usunKontaZGrup(Account account) {
		for (Grupa grupa: account.getGrupy())
			usunKontaZGrupy(grupa);
	}
	
	public static void usunKontaZGrup(List<Account> accounts) {
		for (Account account : accounts) 
			usunKontaZGrup(account);
	}
	
	public static Account getCurrentUser() {
		SaltedUser user = (SaltedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return getAccountFromUserDetails(user);
//		Account account = getClearCurrentAccount();
//		if (zamazDaneWrazliwe) {
//			zamazHaslo(account);
//			zamazSalt(account);
//			usunKontaZGrup(account);
//		}
//		return account;
	}
	
	public static String getCurrentUserId() {
		return getCurrentUser().getId();
	}
	
	public static Account getClearUser() {
		return Account.findAccount(getCurrentUser().getId());
	}
	
//	public static Account getCurrentUser() {
//		return getCurrentUser(true);
//	}
	
	public static void przygotujDoSerializacji(Account account) {
		zamazHaslo(account);
		zamazSalt(account);
		usunKontaZGrup(account);
	}
	
	public static void przygotujDoSerializacji(List<Account> accounts) {
		for (Account account : accounts) 
			przygotujDoSerializacji(account);
	}
	
	public static Account getClearCurrentAccount() {
		SaltedUser user = (SaltedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Account.findAccount(user.getId());
	}
}
