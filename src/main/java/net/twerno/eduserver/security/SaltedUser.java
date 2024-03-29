package net.twerno.eduserver.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.twerno.eduserver.user.entity.Grupa;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SaltedUser extends User implements SaltedUserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String salt;
	
	private String id;
	
	private Set<Grupa> grupy = new HashSet<Grupa>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SaltedUser(String id, String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.id = id;
	}

	@Override
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public Set<Grupa> getGrupy() {
		return grupy;
	}
}
