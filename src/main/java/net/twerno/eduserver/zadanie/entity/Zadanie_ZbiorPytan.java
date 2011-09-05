package net.twerno.eduserver.zadanie.entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Zadanie_ZbiorPytan {

	@Id
//	@GeneratedValue(generator="uuid")
//	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;
	
	@NotNull
	private int iloscPytan;
	
	@NotNull
	@ManyToOne
	private Zadanie zadanie;
	
	@NotNull
	private String zbiorPytanId;
	
	public boolean equals(Object o) {
		if (!(o instanceof Zadanie_ZbiorPytan))
			return false;

		Zadanie_ZbiorPytan zzp = (Zadanie_ZbiorPytan)o;
		return this.zadanie == zzp.zadanie && this.zbiorPytanId == zzp.zbiorPytanId;
	}
}
