package net.twerno.eduserver.zadanie.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.user.entity.Grupa;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findZadaneZadaniesByAutor" })
public class ZadaneZadanie {

    @NotNull
    @ManyToOne
    private Zadanie zadanie;

    @NotNull
    private boolean obowiazkowe;

    @NotNull
    @ManyToMany
    private Set<Grupa> grupy = new HashSet<Grupa>();

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dataUtworzenia;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dtOd;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dtDo;

    @NotNull
    private int maxIloscPytan;

    @NotNull
    @OneToOne(mappedBy = "zadaneZadanie", cascade = CascadeType.ALL)
    private TypWyboru typWyboru;

    @NotNull
    @OneToOne
    private Account autor;
}
