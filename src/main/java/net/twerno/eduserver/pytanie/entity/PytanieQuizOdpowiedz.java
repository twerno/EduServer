package net.twerno.eduserver.pytanie.entity;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class PytanieQuizOdpowiedz {
	
	@NotNull
	private String trescOdpowiedzi;
	
	@NotNull
	private boolean poprawnaOdpowiedz;

	@NotNull
	@ManyToOne
	private PytanieQuiz pytanieQuiz;
}
