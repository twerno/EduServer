package net.twerno.eduserver.pytanie;

import java.util.List;

import javax.persistence.TypedQuery;

import net.twerno.eduserver.pytanie.entity.PytanieZamkniete;
import net.twerno.eduserver.pytanie.entity.ZbiorPytan;
import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.zadanie.TypZadania;

public class PytanieQueries {
	
	// ROO nie potrafi stworzyc findera z Enum jako parametr
    public static TypedQuery<ZbiorPytan> findByAutorAndUsunietyAndTyp(Account autor, boolean usuniety, TypZadania typZdania) {
        if (autor == null) throw new IllegalArgumentException("The autor argument is required");
        TypedQuery<ZbiorPytan> q = ZbiorPytan.entityManager().createQuery("SELECT o FROM ZbiorPytan AS o WHERE o.autor = :autor AND o.usuniety = :usuniety AND o.typZadania = :typZadania", ZbiorPytan.class);
        q.setParameter("autor",      autor);
        q.setParameter("usuniety",   usuniety);
        q.setParameter("typZadania", typZdania);
        return q;
    }

	// ROO nie potrafi stworzyc findera z Enum jako parametr
    public static TypedQuery<ZbiorPytan> findByIsPublicAndUsunietyAndTyp(boolean isPublic, boolean usuniety, TypZadania typZdania) {
        TypedQuery<ZbiorPytan> q = ZbiorPytan.entityManager().createQuery("SELECT o FROM ZbiorPytan AS o WHERE o.isPublic = :isPublic AND o.usuniety = :usuniety AND o.typZadania = :typZadania", ZbiorPytan.class);
        q.setParameter("isPublic",   isPublic);
        q.setParameter("usuniety",   usuniety);
        q.setParameter("typZadania", typZdania);
        return q;
    }
    
    public static List<ZbiorPytan> dajDostepneZbioryPytan(Account autor) {
    	String SQL = "SELECT o FROM ZbiorPytan o WHERE ((o.isPublic = 1) OR (o.autorId = :autorId)) AND o.usuniety = 0";
    	return ZbiorPytan.entityManager()
    				.createQuery(SQL, ZbiorPytan.class)
    				.setParameter("autorId", autor.getId())
    				.getResultList();
    }
    
    public static List<ZbiorPytan> dajDostepneZbioryPytan(Account autor, TypZadania typZadania) {
    	String SQL = "SELECT o FROM ZbiorPytan o WHERE ((o.isPublic = 1) OR (o.autorId = :autorId)) AND o.usuniety = 0 AND o.typZadania = :typZadania";
    	return ZbiorPytan.entityManager()
    				.createQuery(SQL, ZbiorPytan.class)
    				.setParameter("autorId",    autor.getId())
    				.setParameter("typZadania", typZadania)
    				.getResultList();
    }
    
    public static void usunPytaniaZeZbioru(long zbiorPytanId) {
    	String SQL = "UPDATE PytanieZamkniete SET usuniety = 1 WHERE zbiorPytanId = :zbiorPytanId";
    	PytanieZamkniete.entityManager()
    		.createQuery(SQL, PytanieZamkniete.class)
    		.setParameter("zbiorPytanId", zbiorPytanId)
    		.executeUpdate();
    }

}
