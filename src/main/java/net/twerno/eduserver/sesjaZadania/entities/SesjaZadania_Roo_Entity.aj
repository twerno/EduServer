// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.sesjaZadania.entities;

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
import net.twerno.eduserver.sesjaZadania.entities.SesjaZadania;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SesjaZadania_Roo_Entity {
    
    declare @type: SesjaZadania: @Entity;
    
    @PersistenceContext
    transient EntityManager SesjaZadania.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long SesjaZadania.id;
    
    @Version
    @Column(name = "version")
    private Integer SesjaZadania.version;
    
    public Long SesjaZadania.getId() {
        return this.id;
    }
    
    public void SesjaZadania.setId(Long id) {
        this.id = id;
    }
    
    public Integer SesjaZadania.getVersion() {
        return this.version;
    }
    
    public void SesjaZadania.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void SesjaZadania.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void SesjaZadania.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            SesjaZadania attached = SesjaZadania.findSesjaZadania(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void SesjaZadania.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void SesjaZadania.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public SesjaZadania SesjaZadania.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SesjaZadania merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager SesjaZadania.entityManager() {
        EntityManager em = new SesjaZadania().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long SesjaZadania.countSesjaZadanias() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SesjaZadania o", Long.class).getSingleResult();
    }
    
    public static List<SesjaZadania> SesjaZadania.findAllSesjaZadanias() {
        return entityManager().createQuery("SELECT o FROM SesjaZadania o", SesjaZadania.class).getResultList();
    }
    
    public static SesjaZadania SesjaZadania.findSesjaZadania(Long id) {
        if (id == null) return null;
        return entityManager().find(SesjaZadania.class, id);
    }
    
    public static List<SesjaZadania> SesjaZadania.findSesjaZadaniaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SesjaZadania o", SesjaZadania.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
