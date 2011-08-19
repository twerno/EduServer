package net.twerno.eduserver.sesjaZadania.entities;

import java.util.Date;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.sesjaZadania.StanSesji;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class SesjaZadania {
	
	@NotNull
	private Long idUczen;
	
	@NotNull
	private Long idZadaneZadanie;
	
	@NotNull
	private Date dtRozpoczecia;
	
	@NotNull
	private Date dtZakonczenia;
	
    @Enumerated
    private StanSesji stanSesji;
}
