// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import net.twerno.eduserver.pytanie.entity.PytanieQuiz;
import net.twerno.eduserver.pytanie.entity.ZbiorPytan;

privileged aspect PytanieQuiz_Roo_Finder {
    
    public static TypedQuery<PytanieQuiz> PytanieQuiz.findPytanieQuizesByZbiorPytan(ZbiorPytan zbiorPytan) {
        if (zbiorPytan == null) throw new IllegalArgumentException("The zbiorPytan argument is required");
        EntityManager em = PytanieQuiz.entityManager();
        TypedQuery<PytanieQuiz> q = em.createQuery("SELECT o FROM PytanieQuiz AS o WHERE o.zbiorPytan = :zbiorPytan", PytanieQuiz.class);
        q.setParameter("zbiorPytan", zbiorPytan);
        return q;
    }
    
    public static TypedQuery<PytanieQuiz> PytanieQuiz.findPytanieQuizesByZbiorPytanAndUsuniety(ZbiorPytan zbiorPytan, boolean usuniety) {
        if (zbiorPytan == null) throw new IllegalArgumentException("The zbiorPytan argument is required");
        EntityManager em = PytanieQuiz.entityManager();
        TypedQuery<PytanieQuiz> q = em.createQuery("SELECT o FROM PytanieQuiz AS o WHERE o.zbiorPytan = :zbiorPytan AND o.usuniety = :usuniety", PytanieQuiz.class);
        q.setParameter("zbiorPytan", zbiorPytan);
        q.setParameter("usuniety", usuniety);
        return q;
    }
    
}
