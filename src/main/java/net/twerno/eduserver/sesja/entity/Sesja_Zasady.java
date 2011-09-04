package net.twerno.eduserver.sesja.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Sesja_Zasady {
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	@NotNull
	@OneToOne
	private Sesja sesja;
	
	private boolean czas_bronze;
	
	private boolean czas_silver;
	
	private boolean czas_gold;
	
	private boolean bezblednie;
	
	private boolean punkty_bronze;
	
	private boolean punkty_silver;
	
	private boolean punkty_gold;
	
	private boolean ukonczone;
}
