package net.twerno.eduserver.security;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSaltSource implements SaltSource {
	
    public Object getSalt(UserDetails user) {
    	if (user instanceof SaltedUserDetails)
    		return ((SaltedUserDetails) user).getSalt();
    	else
			return "";
    }
}
