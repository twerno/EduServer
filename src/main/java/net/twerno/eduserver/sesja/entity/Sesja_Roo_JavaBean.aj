// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.sesja.entity;

import java.util.Date;
import net.twerno.eduserver.sesja.SesjaStan;

privileged aspect Sesja_Roo_JavaBean {
    
    public long Sesja.getUczenId() {
        return this.uczenId;
    }
    
    public void Sesja.setUczenId(long uczenId) {
        this.uczenId = uczenId;
    }
    
    public long Sesja.getZadaneZadanieId() {
        return this.zadaneZadanieId;
    }
    
    public void Sesja.setZadaneZadanieId(long zadaneZadanieId) {
        this.zadaneZadanieId = zadaneZadanieId;
    }
    
    public Date Sesja.getDtSesja() {
        return this.dtSesja;
    }
    
    public void Sesja.setDtSesja(Date dtSesja) {
        this.dtSesja = dtSesja;
    }
    
    public SesjaStan Sesja.getStanSesji() {
        return this.stanSesji;
    }
    
    public void Sesja.setStanSesji(SesjaStan stanSesji) {
        this.stanSesji = stanSesji;
    }
    
    public double Sesja.getWynik() {
        return this.wynik;
    }
    
    public void Sesja.setWynik(double wynik) {
        this.wynik = wynik;
    }
    
    public boolean Sesja.isUkonczone() {
        return this.ukonczone;
    }
    
    public void Sesja.setUkonczone(boolean ukonczone) {
        this.ukonczone = ukonczone;
    }
    
}
