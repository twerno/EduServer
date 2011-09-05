package net.twerno.eduserver.zadanie.entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders={"findZadaneZadanie_ZbiorPytansByZadanieAndZbiorPytanId"})
public class ZadaneZadanie_ZbiorPytan {

	@Id
//	@GeneratedValue(generator="uuid")
//	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;
	
	@NotNull
	private int iloscPytan;
	
	@NotNull
	@ManyToOne
	private ZadaneZadanie zadanie;
	
	@NotNull
	private String zbiorPytanId;
}
