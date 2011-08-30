package net.twerno.eduserver.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findGrupasByNazwaEquals" })
public class Grupa {

    @NotNull
    @Column(unique = true)
    @Size(min = 3, max = 30)
    private String nazwa;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="account_grupa",
    joinColumns={@JoinColumn(name="grupa_id")},
    inverseJoinColumns={@JoinColumn(name="account_id")})
    private Set<Account> accounts = new HashSet<Account>();
}
