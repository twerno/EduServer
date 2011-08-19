package net.twerno.eduserver.zadanie.entities;

import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class ZadanieMetadane {

    @NotNull
    private Zadanie zadanie;

    @NotNull
    private String idWartosc;

    @NotNull
    private String stWartosc;
}
