package net.twerno.eduserver.pytanie.entities;

import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class PytanieMetadane {
	
	@NotNull
	private Pytanie pytanie;
	
	@NotNull
	private String idWartosc;
	
	@NotNull
	private String stWartosc;	
}
