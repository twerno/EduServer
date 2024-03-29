// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.sesja.entity;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import net.twerno.eduserver.sesja.entity.KartaOdpowiedzi;
import org.springframework.transaction.annotation.Transactional;

privileged aspect KartaOdpowiedzi_Roo_Entity {
    
    declare @type: KartaOdpowiedzi: @Entity;
    
    @PersistenceContext
    transient EntityManager KartaOdpowiedzi.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer KartaOdpowiedzi.version;
    
    public Integer KartaOdpowiedzi.getVersion() {
        return this.version;
    }
    
    public void KartaOdpowiedzi.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void KartaOdpowiedzi.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void KartaOdpowiedzi.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            KartaOdpowiedzi attached = KartaOdpowiedzi.findKartaOdpowiedzi(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void KartaOdpowiedzi.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void KartaOdpowiedzi.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public KartaOdpowiedzi KartaOdpowiedzi.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        KartaOdpowiedzi merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager KartaOdpowiedzi.entityManager() {
        EntityManager em = new KartaOdpowiedzi().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long KartaOdpowiedzi.countKartaOdpowiedzis() {
        return entityManager().createQuery("SELECT COUNT(o) FROM KartaOdpowiedzi o", Long.class).getSingleResult();
    }
    
    public static List<KartaOdpowiedzi> KartaOdpowiedzi.findAllKartaOdpowiedzis() {
        return entityManager().createQuery("SELECT o FROM KartaOdpowiedzi o", KartaOdpowiedzi.class).getResultList();
    }
    
    public static KartaOdpowiedzi KartaOdpowiedzi.findKartaOdpowiedzi(String id) {
        if (id == null || id.length() == 0) return null;
        return entityManager().find(KartaOdpowiedzi.class, id);
    }
    
    public static List<KartaOdpowiedzi> KartaOdpowiedzi.findKartaOdpowiedziEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM KartaOdpowiedzi o", KartaOdpowiedzi.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
