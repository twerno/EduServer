// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entity;

import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import net.twerno.eduserver.pytanie.entity.PytaniePosortuj;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PytaniePosortuj_Roo_Entity {
    
    declare @type: PytaniePosortuj: @Entity;
    
    @PersistenceContext
    transient EntityManager PytaniePosortuj.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long PytaniePosortuj.id;
    
    @Version
    @Column(name = "version")
    private Integer PytaniePosortuj.version;
    
    public Long PytaniePosortuj.getId() {
        return this.id;
    }
    
    public void PytaniePosortuj.setId(Long id) {
        this.id = id;
    }
    
    public Integer PytaniePosortuj.getVersion() {
        return this.version;
    }
    
    public void PytaniePosortuj.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void PytaniePosortuj.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void PytaniePosortuj.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PytaniePosortuj attached = PytaniePosortuj.findPytaniePosortuj(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void PytaniePosortuj.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void PytaniePosortuj.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public PytaniePosortuj PytaniePosortuj.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PytaniePosortuj merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager PytaniePosortuj.entityManager() {
        EntityManager em = new PytaniePosortuj().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long PytaniePosortuj.countPytaniePosortujs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PytaniePosortuj o", Long.class).getSingleResult();
    }
    
    public static List<PytaniePosortuj> PytaniePosortuj.findAllPytaniePosortujs() {
        return entityManager().createQuery("SELECT o FROM PytaniePosortuj o", PytaniePosortuj.class).getResultList();
    }
    
    public static PytaniePosortuj PytaniePosortuj.findPytaniePosortuj(Long id) {
        if (id == null) return null;
        return entityManager().find(PytaniePosortuj.class, id);
    }
    
    public static List<PytaniePosortuj> PytaniePosortuj.findPytaniePosortujEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PytaniePosortuj o", PytaniePosortuj.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
