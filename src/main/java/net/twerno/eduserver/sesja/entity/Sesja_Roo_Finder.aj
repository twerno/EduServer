// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.sesja.entity;

import java.lang.String;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import net.twerno.eduserver.sesja.entity.Sesja;

privileged aspect Sesja_Roo_Finder {
    
    public static TypedQuery<Sesja> Sesja.findSesjasByZadaneZadanieId(String zadaneZadanieId) {
        if (zadaneZadanieId == null || zadaneZadanieId.length() == 0) throw new IllegalArgumentException("The zadaneZadanieId argument is required");
        EntityManager em = Sesja.entityManager();
        TypedQuery<Sesja> q = em.createQuery("SELECT o FROM Sesja AS o WHERE o.zadaneZadanieId = :zadaneZadanieId", Sesja.class);
        q.setParameter("zadaneZadanieId", zadaneZadanieId);
        return q;
    }
    
}
