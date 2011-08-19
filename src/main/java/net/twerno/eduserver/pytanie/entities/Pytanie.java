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
public class Pytanie {
	
	@NotNull
	private String pytanie;
	
	@NotNull
	private ZbiorPytan zbiorPytan;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pytanie")
    private Set<PytanieMetadane> pytanieMetadane = new HashSet<PytanieMetadane>();
}
