package net.twerno.eduserver.zadanie.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.pytanie.entity.ZbiorPytan;
import net.twerno.eduserver.zadanie.TypZadania;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Zadanie {
	
	@NotNull
	private String nazwa;

	@NotNull
	private String opis;

	@NotNull
	private long autorId;

	@NotNull
	private TypZadania typZdania;

	@NotNull
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<ZbiorPytan> zbiorPytan = new HashSet<ZbiorPytan>();
}
