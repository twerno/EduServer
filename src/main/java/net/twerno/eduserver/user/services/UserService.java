package net.twerno.eduserver.user.services;

import java.util.Set;

import net.twerno.eduserver.user.entities.Grupa;

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
	boolean dodajDoGrupy(String username, String grupa) 
			throws UsernameNotFoundException;
	
	boolean usunZGrupy(String username, String grupa) 
			throws UsernameNotFoundException;
}
