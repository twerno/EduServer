// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.zadanie.entities;

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
import net.twerno.eduserver.zadanie.entities.Zadanie;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Zadanie_Roo_Entity {
    
    declare @type: Zadanie: @Entity;
    
    @PersistenceContext
    transient EntityManager Zadanie.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Zadanie.id;
    
    @Version
    @Column(name = "version")
    private Integer Zadanie.version;
    
    public Long Zadanie.getId() {
        return this.id;
    }
    
    public void Zadanie.setId(Long id) {
        this.id = id;
    }
    
    public Integer Zadanie.getVersion() {
        return this.version;
    }
    
    public void Zadanie.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Zadanie.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Zadanie.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Zadanie attached = Zadanie.findZadanie(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Zadanie.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Zadanie.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Zadanie Zadanie.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Zadanie merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Zadanie.entityManager() {
        EntityManager em = new Zadanie().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Zadanie.countZadanies() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Zadanie o", Long.class).getSingleResult();
    }
    
    public static List<Zadanie> Zadanie.findAllZadanies() {
        return entityManager().createQuery("SELECT o FROM Zadanie o", Zadanie.class).getResultList();
    }
    
    public static Zadanie Zadanie.findZadanie(Long id) {
        if (id == null) return null;
        return entityManager().find(Zadanie.class, id);
    }
    
    public static List<Zadanie> Zadanie.findZadanieEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Zadanie o", Zadanie.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
