package net.twerno.eduserver.pytanie.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class ZbiorPytan {

    @NotNull
    private String opis;

    @NotNull
    private String kategoria;

    @NotNull
    private String poziom;

    @NotNull
    private Long idAutor;

    @NotNull
    private boolean prywatny;

    @NotNull
    private String idTypDanych;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zbiorPytan")
    private Set<Pytanie> pytania = new HashSet<Pytanie>();
}
