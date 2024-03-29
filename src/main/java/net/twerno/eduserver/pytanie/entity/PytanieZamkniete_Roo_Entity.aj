// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entity;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import net.twerno.eduserver.pytanie.entity.PytanieZamkniete;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PytanieZamkniete_Roo_Entity {
    
    declare @type: PytanieZamkniete: @Entity;
    
    @PersistenceContext
    transient EntityManager PytanieZamkniete.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer PytanieZamkniete.version;
    
    public Integer PytanieZamkniete.getVersion() {
        return this.version;
    }
    
    public void PytanieZamkniete.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void PytanieZamkniete.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void PytanieZamkniete.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PytanieZamkniete attached = PytanieZamkniete.findPytanieZamkniete(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void PytanieZamkniete.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void PytanieZamkniete.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public PytanieZamkniete PytanieZamkniete.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PytanieZamkniete merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager PytanieZamkniete.entityManager() {
        EntityManager em = new PytanieZamkniete().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long PytanieZamkniete.countPytanieZamknietes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PytanieZamkniete o", Long.class).getSingleResult();
    }
    
    public static List<PytanieZamkniete> PytanieZamkniete.findAllPytanieZamknietes() {
        return entityManager().createQuery("SELECT o FROM PytanieZamkniete o", PytanieZamkniete.class).getResultList();
    }
    
    public static PytanieZamkniete PytanieZamkniete.findPytanieZamkniete(String id) {
        if (id == null || id.length() == 0) return null;
        return entityManager().find(PytanieZamkniete.class, id);
    }
    
    public static List<PytanieZamkniete> PytanieZamkniete.findPytanieZamknieteEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PytanieZamkniete o", PytanieZamkniete.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
