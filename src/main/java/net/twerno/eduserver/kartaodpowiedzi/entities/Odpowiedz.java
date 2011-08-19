package net.twerno.eduserver.kartaodpowiedzi.entities;

import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Odpowiedz {
	
	@NotNull
	private Long idPytanie;
	
	@NotNull
	private int lpPytanie;
	
	@NotNull
	private int iloscProb;
	
	@NotNull
	private boolean podpowiedz;
	
	@NotNull
	private boolean poprawnaOdpowiedz;
	
	@NotNull
	private double dpOcena;
}
