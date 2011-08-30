package net.twerno.eduserver.pytanie.entity;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class OdpPytanieZamkniete {
	
	@NotNull
	@ManyToOne
	private PytanieZamkniete pytanieZamkniete;
	
	@NotNull
	private String stOdpowiedz;
	
	@NotNull 
	private boolean tnPoprawna;
}
