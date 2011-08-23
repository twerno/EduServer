package net.twerno.eduserver.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface SaltedUserDetails extends UserDetails {
	String getSalt();
}
