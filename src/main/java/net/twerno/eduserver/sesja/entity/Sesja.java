package net.twerno.eduserver.sesja.entity;

import java.util.Date;

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
@RooEntity
public class Sesja {
	
	@NotNull
	private long uczenId;
	
	@NotNull
	private long zadaneZadanieId;
	
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dtSesja;
    
    @NotNull
    private SesjaStan stanSesji;
    
    @NotNull
    private double wynik;
    
    @NotNull
    private boolean ukonczone;
}
