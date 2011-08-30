package net.twerno.eduserver.pytanie.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import net.twerno.eduserver.zadanie.TypZadania;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findPytanieZamknietesByZbiorPytanId" })
public class PytanieZamkniete {

    @NotNull
    private boolean usuniety;

    @NotNull
    private long zbiorPytanId;

    @NotNull
    private String trescPytania;

    @NotNull
    private TypZadania typZdania;

    @NotNull
    private String kategoria;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private Set<OdpPytanieZamkniete> odpowiedzi = new HashSet<OdpPytanieZamkniete>();
}
