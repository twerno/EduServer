package net.twerno.eduserver.services;

import java.util.Set;

import net.twerno.eduserver.user.UserRole;
import net.twerno.eduserver.user.domain.Grupa;

import org.springframework.dao.DataAccessException;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingExclude;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RemotingDestination
public interface UserService extends UserDetailsService {
	
	boolean saveUser(UserDetails userDetails);

	@RemotingExclude
	UserDetails loadUserByUsername(String arg0) 
			throws UsernameNotFoundException, DataAccessException;

	String getUsername();

	Set<Grupa> getCurrentUserGroups();

	Set<Grupa> getUserGroups(String username) 
			throws UsernameNotFoundException;
	
	@Secured("ROLE_ADMIN")
//	@Secured(UserRole.ROLE_UCZEN.toString())
	boolean dodajDoGrupy(String username, String grupa) 
			throws UsernameNotFoundException;
	
	boolean usunZGrupy(String username, String grupa) 
			throws UsernameNotFoundException;
}
