package net.twerno.eduserver.kartaodpowiedzi.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class KartaOdpowiedzi {
	
	@NotNull
	private Long idSesja;
	
	@NotNull
	private double dpOcena;
	
	@OneToMany
	private Set<Odpowiedz> grupy = new HashSet<Odpowiedz>();
}
