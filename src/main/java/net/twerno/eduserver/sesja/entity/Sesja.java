package net.twerno.eduserver.sesja.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.sesja.SesjaStan;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders={"findSesjasByZadaneZadanieId"})
public class Sesja {
	
	@Id
	private String id;
	
	@NotNull
	private String uczenId;
	
	@NotNull
	private String zadaneZadanieId;
	
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dtOtwarcia;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dtZamkniecia;
    
    @NotNull
    private SesjaStan stanSesji = SesjaStan.SESJA_ROZPOCZETA;
    
    @NotNull
    private double wynik = 0;
    
    @OneToMany(mappedBy="sesja")
    private Set<KartaOdpowiedzi> odpowiedzi = new HashSet<KartaOdpowiedzi>();
    
    @OneToOne
    private Sesja_Zasady zasady = new Sesja_Zasady();
}
