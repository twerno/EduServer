// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import net.twerno.eduserver.pytanie.entity.PytaniePosortuj;
import net.twerno.eduserver.pytanie.entity.ZbiorPytan;

privileged aspect PytaniePosortuj_Roo_Finder {
    
    public static TypedQuery<PytaniePosortuj> PytaniePosortuj.findPytaniePosortujsByZbiorPytan(ZbiorPytan zbiorPytan) {
        if (zbiorPytan == null) throw new IllegalArgumentException("The zbiorPytan argument is required");
        EntityManager em = PytaniePosortuj.entityManager();
        TypedQuery<PytaniePosortuj> q = em.createQuery("SELECT o FROM PytaniePosortuj AS o WHERE o.zbiorPytan = :zbiorPytan", PytaniePosortuj.class);
        q.setParameter("zbiorPytan", zbiorPytan);
        return q;
    }
    
    public static TypedQuery<PytaniePosortuj> PytaniePosortuj.findPytaniePosortujsByZbiorPytanAndUsuniety(ZbiorPytan zbiorPytan, boolean usuniety) {
        if (zbiorPytan == null) throw new IllegalArgumentException("The zbiorPytan argument is required");
        EntityManager em = PytaniePosortuj.entityManager();
        TypedQuery<PytaniePosortuj> q = em.createQuery("SELECT o FROM PytaniePosortuj AS o WHERE o.zbiorPytan = :zbiorPytan AND o.usuniety = :usuniety", PytaniePosortuj.class);
        q.setParameter("zbiorPytan", zbiorPytan);
        q.setParameter("usuniety", usuniety);
        return q;
    }
    
}
