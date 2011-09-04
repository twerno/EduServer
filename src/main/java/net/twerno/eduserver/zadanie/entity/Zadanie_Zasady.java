package net.twerno.eduserver.zadanie.entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Zadanie_Zasady {
	
	@Id
	private String id;
	
	@NotNull
	@OneToOne
	private Zadanie zadanie;
	
	private int czas_bronze;
	
	private int czas_silver;
	
	private int czas_gold;
	
	private int punkty_bronze;
	
	private int punkty_silver;
	
	private int punkty_gold;
}
