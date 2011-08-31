package net.twerno.eduserver.pytanie.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class OdpPytanieZamkniete {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	@NotNull
	@ManyToOne
	private PytanieZamkniete pytanieZamkniete;

	@NotNull
	private String stOdpowiedz;

	@NotNull 
	private boolean tnPoprawna;
}
