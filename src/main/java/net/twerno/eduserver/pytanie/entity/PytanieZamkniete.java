package net.twerno.eduserver.pytanie.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.zadanie.TypZadania;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findPytanieZamknietesByZbiorPytanIdAndUsuniety" })
public class PytanieZamkniete {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;
	
    @NotNull
    private boolean usuniety;

    @NotNull
    private String zbiorPytanId;

    @NotNull
    private String trescPytania;

    @NotNull
    private TypZadania typZadania;

//    @NotNull
    private String kategoria;

//    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private Set<OdpPytanieZamkniete> odpowiedzi = new HashSet<OdpPytanieZamkniete>();
}
