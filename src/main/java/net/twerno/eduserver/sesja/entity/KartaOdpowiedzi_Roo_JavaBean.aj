// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.sesja.entity;

import java.lang.String;
import java.util.Date;
import net.twerno.eduserver.sesja.entity.Sesja;

privileged aspect KartaOdpowiedzi_Roo_JavaBean {
    
    public String KartaOdpowiedzi.getId() {
        return this.id;
    }
    
    public void KartaOdpowiedzi.setId(String id) {
        this.id = id;
    }
    
    public Sesja KartaOdpowiedzi.getSesja() {
        return this.sesja;
    }
    
    public void KartaOdpowiedzi.setSesja(Sesja sesja) {
        this.sesja = sesja;
    }
    
    public String KartaOdpowiedzi.getIdPytanie() {
        return this.idPytanie;
    }
    
    public void KartaOdpowiedzi.setIdPytanie(String idPytanie) {
        this.idPytanie = idPytanie;
    }
    
    public int KartaOdpowiedzi.getIloscProb() {
        return this.iloscProb;
    }
    
    public void KartaOdpowiedzi.setIloscProb(int iloscProb) {
        this.iloscProb = iloscProb;
    }
    
    public boolean KartaOdpowiedzi.isTnPoprawna() {
        return this.tnPoprawna;
    }
    
    public void KartaOdpowiedzi.setTnPoprawna(boolean tnPoprawna) {
        this.tnPoprawna = tnPoprawna;
    }
    
    public Date KartaOdpowiedzi.getDtOdpowiedzi() {
        return this.dtOdpowiedzi;
    }
    
    public void KartaOdpowiedzi.setDtOdpowiedzi(Date dtOdpowiedzi) {
        this.dtOdpowiedzi = dtOdpowiedzi;
    }
    
}
