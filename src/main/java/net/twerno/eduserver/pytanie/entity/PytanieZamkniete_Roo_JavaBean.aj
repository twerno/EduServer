// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entity;

import java.lang.String;
import java.util.Set;
import net.twerno.eduserver.pytanie.entity.OdpPytanieZamkniete;
import net.twerno.eduserver.zadanie.TypZadania;

privileged aspect PytanieZamkniete_Roo_JavaBean {
    
    public boolean PytanieZamkniete.isUsuniety() {
        return this.usuniety;
    }
    
    public void PytanieZamkniete.setUsuniety(boolean usuniety) {
        this.usuniety = usuniety;
    }
    
    public long PytanieZamkniete.getZbiorPytanId() {
        return this.zbiorPytanId;
    }
    
    public void PytanieZamkniete.setZbiorPytanId(long zbiorPytanId) {
        this.zbiorPytanId = zbiorPytanId;
    }
    
    public String PytanieZamkniete.getTrescPytania() {
        return this.trescPytania;
    }
    
    public void PytanieZamkniete.setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
    }
    
    public TypZadania PytanieZamkniete.getTypZdania() {
        return this.typZdania;
    }
    
    public void PytanieZamkniete.setTypZdania(TypZadania typZdania) {
        this.typZdania = typZdania;
    }
    
    public String PytanieZamkniete.getKategoria() {
        return this.kategoria;
    }
    
    public void PytanieZamkniete.setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
    
    public Set<OdpPytanieZamkniete> PytanieZamkniete.getOdpowiedzi() {
        return this.odpowiedzi;
    }
    
    public void PytanieZamkniete.setOdpowiedzi(Set<OdpPytanieZamkniete> odpowiedzi) {
        this.odpowiedzi = odpowiedzi;
    }
    
}