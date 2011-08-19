// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entities;

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
import net.twerno.eduserver.pytanie.entities.PytanieMetadane;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PytanieMetadane_Roo_Entity {
    
    declare @type: PytanieMetadane: @Entity;
    
    @PersistenceContext
    transient EntityManager PytanieMetadane.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long PytanieMetadane.id;
    
    @Version
    @Column(name = "version")
    private Integer PytanieMetadane.version;
    
    public Long PytanieMetadane.getId() {
        return this.id;
    }
    
    public void PytanieMetadane.setId(Long id) {
        this.id = id;
    }
    
    public Integer PytanieMetadane.getVersion() {
        return this.version;
    }
    
    public void PytanieMetadane.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void PytanieMetadane.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void PytanieMetadane.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PytanieMetadane attached = PytanieMetadane.findPytanieMetadane(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void PytanieMetadane.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void PytanieMetadane.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public PytanieMetadane PytanieMetadane.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PytanieMetadane merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager PytanieMetadane.entityManager() {
        EntityManager em = new PytanieMetadane().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long PytanieMetadane.countPytanieMetadanes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PytanieMetadane o", Long.class).getSingleResult();
    }
    
    public static List<PytanieMetadane> PytanieMetadane.findAllPytanieMetadanes() {
        return entityManager().createQuery("SELECT o FROM PytanieMetadane o", PytanieMetadane.class).getResultList();
    }
    
    public static PytanieMetadane PytanieMetadane.findPytanieMetadane(Long id) {
        if (id == null) return null;
        return entityManager().find(PytanieMetadane.class, id);
    }
    
    public static List<PytanieMetadane> PytanieMetadane.findPytanieMetadaneEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PytanieMetadane o", PytanieMetadane.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}