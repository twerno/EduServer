package net.twerno.eduserver.pytanie;

import javax.persistence.TypedQuery;

import net.twerno.eduserver.pytanie.entity.ZbiorPytan;
import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.zadanie.TypZadania;

public class PytanieQueries {
	
    public static TypedQuery<ZbiorPytan> findByAutorAndUsunietyAndTyp(Account autor, boolean usuniety, TypZadania typZdania) {
        if (autor == null) throw new IllegalArgumentException("The autor argument is required");
        TypedQuery<ZbiorPytan> q = ZbiorPytan.entityManager().createQuery("SELECT o FROM ZbiorPytan AS o WHERE o.autor = :autor AND o.usuniety = :usuniety AND o.typZadania = :typZadania", ZbiorPytan.class);
        q.setParameter("autor",      autor);
        q.setParameter("usuniety",   usuniety);
        q.setParameter("typZadania", typZdania);
        return q;
    }
    
    public static TypedQuery<ZbiorPytan> findByIsPublicAndUsunietyAndTyp(boolean isPublic, boolean usuniety, TypZadania typZdania) {
        TypedQuery<ZbiorPytan> q = ZbiorPytan.entityManager().createQuery("SELECT o FROM ZbiorPytan AS o WHERE o.isPublic = :isPublic AND o.usuniety = :usuniety AND o.typZadania = :typZadania", ZbiorPytan.class);
        q.setParameter("isPublic",   isPublic);
        q.setParameter("usuniety",   usuniety);
        q.setParameter("typZadania", typZdania);
        return q;
    }

}
