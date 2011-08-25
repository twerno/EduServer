package net.twerno.eduserver.zadanie.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.pytanie.entity.ZbiorPytan;
import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.zadanie.TypZadania;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findZadaniesByAutor" })
public class Zadanie {

    @NotNull
    private String nazwa;

    @NotNull
    private String opis;

    @NotNull
    @OneToOne
    private Account autor;

    @NotNull
    private TypZadania typZdania;

    @NotNull
    @ManyToMany
    private Set<ZbiorPytan> zbiorPytan = new HashSet<ZbiorPytan>();
}
