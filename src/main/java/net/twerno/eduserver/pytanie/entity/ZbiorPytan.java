package net.twerno.eduserver.pytanie.entity;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.zadanie.TypZadania;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findZbiorPytansByAutorAndUsuniety", "findZbiorPytansByIsPublicAndUsuniety" })
public class ZbiorPytan {

    @NotNull
    private TypZadania typZadania;

    @NotNull
    private String opis;

    @NotNull
    private String kategoria;

    @NotNull
    @OneToOne
    private Account autor;

    @NotNull
    private boolean isPublic;

    @NotNull
    private boolean usuniety; 
}
