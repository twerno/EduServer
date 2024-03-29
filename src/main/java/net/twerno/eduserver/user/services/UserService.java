package net.twerno.eduserver.user.services;

import java.util.List;

import net.twerno.eduserver.user.UserRole;
import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.user.entity.Grupa;
import net.twerno.eduserver.user.exceptions.NoRolesException;
import net.twerno.eduserver.user.exceptions.UserExistsException;

import org.springframework.dao.DataAccessException;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingExclude;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RemotingDestination
public interface UserService extends UserDetailsService {
	
	@RemotingExclude
	Account loadAccountByName(String username)
			throws UsernameNotFoundException;

	@RemotingExclude
	UserDetails loadUserByUsername(String arg0) 
			throws UsernameNotFoundException, DataAccessException;
	
	@RemotingExclude
	void InternalRegisterUser(String username, String password, UserRole role);
	
	@PreAuthorize("permitAll()")
	void registerUser(String username, String password, boolean role_uczen, boolean role_nauczyciel)
			throws UserExistsException, NoRolesException;

	@PreAuthorize("permitAll()")
	Account getLoggedUser();

	@Secured(UserRole._ROLE_ADMIN)
	List<Account> findAllAccounds();

	@Secured(UserRole._ROLE_ADMIN)
	void dodajDoGrupy(String username, String nazwaGrupy) 
			throws UsernameNotFoundException;

	@Secured(UserRole._ROLE_ADMIN)
	void usunZGrupy(String username, String nazwaGrupy) 
			throws UsernameNotFoundException;

	@Secured(UserRole._ROLE_ADMIN)
	List<Grupa> findAllGroups();
	
	@Secured(UserRole._ROLE_ADMIN)
	Grupa dodajGrupe(String nazwaGrupy)
			throws Exception;

	@Secured(UserRole._ROLE_ADMIN)
	void usunGrupe(String nazwaGrupy) 
			throws Exception;
	
	@Secured(UserRole._ROLE_ADMIN)
	void zapiszAccount(Account account);
	
	@PreAuthorize("isAuthenticated()")
	void zmienMojeHaslo(String noweHaslo);
	
	@Secured(UserRole._ROLE_ADMIN)
	void zmienHaslo(String username, String noweHaslo);
}
