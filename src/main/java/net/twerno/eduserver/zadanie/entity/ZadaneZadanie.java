package net.twerno.eduserver.zadanie.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
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
@RooEntity(finders={"findZadaneZadaniesByAutorId"})
public class ZadaneZadanie {

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
	
	private int minimalnyWynik;
	
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
    private Set<ZadaneZadanie_ZbiorPytan> zadanie_zbioryPytan = new HashSet<ZadaneZadanie_ZbiorPytan>();
    
    @NotNull
    @ElementCollection
    private Set<String> grupy = new HashSet<String>();
    
    public ZadaneZadanie() {
		// TODO Auto-generated constructor stub
	}
    
    public ZadaneZadanie(String id) {
		this.id = id;
	}    
    
    public static ZadaneZadanie createFromZadanie(Zadanie zadanie) {
    	ZadaneZadanie zadZad = new ZadaneZadanie();
    	zadZad.setId(UUID.randomUUID().toString());
    	zadZad.nazwa           = zadanie.getNazwa();
    	zadZad.autorId         = zadanie.getAutorId();
    	zadZad.typZadania      = zadanie.getTypZadania();
    	zadZad.typWyboruPytan  = zadanie.getTypWyboruPytan();
    	zadZad.minimalnyWynik  = zadanie.getMinimalnyWynik();
    	zadZad.obowiazkowe     = zadanie.isObowiazkowe();
    	zadZad.dtOd            = zadanie.getDtOd();
    	zadZad.dtDo            = zadanie.getDtDo();
    	zadZad.limitCzasowy    = zadanie.getLimitCzasowy();
    	zadZad.limitPytan      = zadanie.getLimitPytan();
    	zadZad.trybSprawdzenia = zadanie.getTrybSprawdzenia();

    	ZadaneZadanie_ZbiorPytan zadZadZZP;

    	for (Zadanie_ZbiorPytan zzp: zadanie.getZadanie_zbioryPytan()) {
    		zadZadZZP = new ZadaneZadanie_ZbiorPytan();
    		zadZadZZP.setId(UUID.randomUUID().toString());
    		zadZadZZP.setNieWiecejNiz(zzp.getNieWiecejNiz());
    		zadZadZZP.setCoNajmniej(zzp.getCoNajmniej());
    		zadZadZZP.setZadanie(zadZad);
    		zadZadZZP.setZbiorPytanId(zzp.getZbiorPytanId());
    		zadZad.getZadanie_zbioryPytan().add(zadZadZZP);
    	}
    	// brakuje jeszcze grup
    	return zadZad;
    }
}
