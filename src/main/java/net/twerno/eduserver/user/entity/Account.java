package net.twerno.eduserver.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.twerno.eduserver.user.UserRole;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findAccountsByUsernameEquals" })
public class Account {

    @NotNull
    @Column(unique = true)
    @Size(min = 3, max = 30)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Boolean enabled;
    
    @NotNull
    private String salt;

    @ElementCollection
    private Set<UserRole> roles = new HashSet<UserRole>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="account_grupa",
    	       joinColumns={@JoinColumn(name="account_id")},
    	       inverseJoinColumns={@JoinColumn(name="grupa_id")})
    private Set<Grupa> grupy = new HashSet<Grupa>();
    
    public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = true;
	}

	public Account() {
        enabled = true;
    }
	
	public boolean equals(Account account) {
		return this.getId() == account.getId();
	}
}
