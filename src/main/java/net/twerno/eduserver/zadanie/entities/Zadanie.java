package net.twerno.eduserver.zadanie.entities;

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
public class Zadanie {

    @NotNull
    private Long idAutor;

    @NotNull
    private String przedmiot;

    private String opis;

    @NotNull
    private boolean prywatny;

    @NotNull
    private String idTypDanych;
    
    private Set<Long> zbioryPytanIDs = new HashSet<Long>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zadanie")
    private Set<ZadanieMetadane> zadanieMetadane = new HashSet<ZadanieMetadane>();
}
