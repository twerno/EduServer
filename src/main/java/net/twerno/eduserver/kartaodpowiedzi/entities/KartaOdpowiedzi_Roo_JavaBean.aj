// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.kartaodpowiedzi.entities;

import java.lang.Long;
import java.util.Set;
import net.twerno.eduserver.kartaodpowiedzi.entities.Odpowiedz;

privileged aspect KartaOdpowiedzi_Roo_JavaBean {
    
    public Long KartaOdpowiedzi.getIdSesja() {
        return this.idSesja;
    }
    
    public void KartaOdpowiedzi.setIdSesja(Long idSesja) {
        this.idSesja = idSesja;
    }
    
    public double KartaOdpowiedzi.getDpOcena() {
        return this.dpOcena;
    }
    
    public void KartaOdpowiedzi.setDpOcena(double dpOcena) {
        this.dpOcena = dpOcena;
    }
    
    public Set<Odpowiedz> KartaOdpowiedzi.getGrupy() {
        return this.grupy;
    }
    
    public void KartaOdpowiedzi.setGrupy(Set<Odpowiedz> grupy) {
        this.grupy = grupy;
    }
    
}
