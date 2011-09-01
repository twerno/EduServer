package net.twerno.eduserver.security;

import java.util.Set;

import net.twerno.eduserver.user.entity.Grupa;

import org.springframework.security.core.userdetails.UserDetails;

public interface SaltedUserDetails extends UserDetails {
	
	String getSalt();
	
	String getId();
	
	Set<Grupa> getGrupy();
}
