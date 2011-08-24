package net.twerno.eduserver.pytanie.entity;

import javax.validation.constraints.NotNull;

import net.twerno.eduserver.zadanie.TypZadania;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class ZbiorPytan {

	@NotNull
	private TypZadania typZdania;

	@NotNull
	private String opis;

	@NotNull
	private String kategoria;

	@NotNull
	private long autorId;

	@NotNull
	private boolean isPublic;
}
