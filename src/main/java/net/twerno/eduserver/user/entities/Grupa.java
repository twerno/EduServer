package net.twerno.eduserver.user.entities;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Grupa {

    @NotNull
    @Column(unique = true)
    @Size(min = 3, max = 30)
    private String nazwa;
}
