package net.twerno.eduserver.zadanie.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.zadanie.TrybSprawdzenia;
import net.twerno.eduserver.zadanie.TypWyboruPytan;
import net.twerno.eduserver.zadanie.TypZadania;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findZadaniesByAutorId" })
public class Zadanie {

	@Id
	private String id;
	
    @NotNull
    private String nazwa;

    @NotNull
    @OrderColumn
    private String autorId;

    @NotNull
    private TypZadania typZadania;
    
	@NotNull
	private TypWyboruPytan typWyboruPytan;
	
	@NotNull
	private boolean obowiazkowe;
	
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dtOd;
	
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dtDo;
	
	@NotNull
	private int limitCzasowy;
	
	@NotNull 
	private int limitPytan;
	
	@NotNull
	private TrybSprawdzenia trybSprawdzenia;

    @NotNull
    @OneToMany(mappedBy="zadanie", cascade=CascadeType.ALL)
    private Set<Zadanie_ZbiorPytan> zadanie_zbioryPytan = new HashSet<Zadanie_ZbiorPytan>();
}
