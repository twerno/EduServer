package net.twerno.eduserver.sesja.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class KartaOdpowiedzi {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	@ManyToOne
	private Sesja sesja;

	@NotNull
	private String idPytanie;

	@NotNull
	private int iloscProb;

	@NotNull
	private boolean tnPoprawna;
	
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dtOdpowiedzi;
    
    public KartaOdpowiedzi() {
		// TODO Auto-generated constructor stub
	}

    public KartaOdpowiedzi(Sesja sesja, String idPytanie, int iloscProb, boolean tnPoprawna) {
		this.id           = UUID.randomUUID().toString();
		this.sesja        = sesja;
		this.idPytanie    = idPytanie;
		this.iloscProb    = iloscProb;
		this.tnPoprawna   = tnPoprawna;
		this.dtOdpowiedzi = new Date();
	}
}
