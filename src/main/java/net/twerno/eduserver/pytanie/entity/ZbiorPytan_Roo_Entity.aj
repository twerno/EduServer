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
import net.twerno.eduserver.pytanie.entity.ZbiorPytan;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ZbiorPytan_Roo_Entity {
    
    declare @type: ZbiorPytan: @Entity;
    
    @PersistenceContext
    transient EntityManager ZbiorPytan.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer ZbiorPytan.version;
    
    public Integer ZbiorPytan.getVersion() {
        return this.version;
    }
    
    public void ZbiorPytan.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void ZbiorPytan.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ZbiorPytan.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ZbiorPytan attached = ZbiorPytan.findZbiorPytan(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ZbiorPytan.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ZbiorPytan.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ZbiorPytan ZbiorPytan.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ZbiorPytan merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager ZbiorPytan.entityManager() {
        EntityManager em = new ZbiorPytan().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ZbiorPytan.countZbiorPytans() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ZbiorPytan o", Long.class).getSingleResult();
    }
    
    public static List<ZbiorPytan> ZbiorPytan.findAllZbiorPytans() {
        return entityManager().createQuery("SELECT o FROM ZbiorPytan o", ZbiorPytan.class).getResultList();
    }
    
    public static ZbiorPytan ZbiorPytan.findZbiorPytan(String id) {
        if (id == null || id.length() == 0) return null;
        return entityManager().find(ZbiorPytan.class, id);
    }
    
    public static List<ZbiorPytan> ZbiorPytan.findZbiorPytanEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ZbiorPytan o", ZbiorPytan.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
