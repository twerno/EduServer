// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.zadanie.entity;

import java.lang.String;
import java.util.Date;
import java.util.Set;
import net.twerno.eduserver.zadanie.TrybSprawdzenia;
import net.twerno.eduserver.zadanie.TypWyboruPytan;
import net.twerno.eduserver.zadanie.TypZadania;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie_Zasady;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie_ZbiorPytan;

privileged aspect ZadaneZadanie_Roo_JavaBean {
    
    public String ZadaneZadanie.getId() {
        return this.id;
    }
    
    public void ZadaneZadanie.setId(String id) {
        this.id = id;
    }
    
    public String ZadaneZadanie.getNazwa() {
        return this.nazwa;
    }
    
    public void ZadaneZadanie.setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
    public String ZadaneZadanie.getAutorId() {
        return this.autorId;
    }
    
    public void ZadaneZadanie.setAutorId(String autorId) {
        this.autorId = autorId;
    }
    
    public TypZadania ZadaneZadanie.getTypZadania() {
        return this.typZadania;
    }
    
    public void ZadaneZadanie.setTypZadania(TypZadania typZadania) {
        this.typZadania = typZadania;
    }
    
    public TypWyboruPytan ZadaneZadanie.getTypWyboruPytan() {
        return this.typWyboruPytan;
    }
    
    public void ZadaneZadanie.setTypWyboruPytan(TypWyboruPytan typWyboruPytan) {
        this.typWyboruPytan = typWyboruPytan;
    }
    
    public boolean ZadaneZadanie.isObowiazkowe() {
        return this.obowiazkowe;
    }
    
    public void ZadaneZadanie.setObowiazkowe(boolean obowiazkowe) {
        this.obowiazkowe = obowiazkowe;
    }
    
    public int ZadaneZadanie.getMinimalnyWynik() {
        return this.minimalnyWynik;
    }
    
    public void ZadaneZadanie.setMinimalnyWynik(int minimalnyWynik) {
        this.minimalnyWynik = minimalnyWynik;
    }
    
    public Date ZadaneZadanie.getDtOd() {
        return this.dtOd;
    }
    
    public void ZadaneZadanie.setDtOd(Date dtOd) {
        this.dtOd = dtOd;
    }
    
    public Date ZadaneZadanie.getDtDo() {
        return this.dtDo;
    }
    
    public void ZadaneZadanie.setDtDo(Date dtDo) {
        this.dtDo = dtDo;
    }
    
    public int ZadaneZadanie.getLimitCzasowy() {
        return this.limitCzasowy;
    }
    
    public void ZadaneZadanie.setLimitCzasowy(int limitCzasowy) {
        this.limitCzasowy = limitCzasowy;
    }
    
    public int ZadaneZadanie.getIloscPytan() {
        return this.iloscPytan;
    }
    
    public void ZadaneZadanie.setIloscPytan(int iloscPytan) {
        this.iloscPytan = iloscPytan;
    }
    
    public TrybSprawdzenia ZadaneZadanie.getTrybSprawdzenia() {
        return this.trybSprawdzenia;
    }
    
    public void ZadaneZadanie.setTrybSprawdzenia(TrybSprawdzenia trybSprawdzenia) {
        this.trybSprawdzenia = trybSprawdzenia;
    }
    
    public Set<ZadaneZadanie_ZbiorPytan> ZadaneZadanie.getZadanie_zbioryPytan() {
        return this.zadanie_zbioryPytan;
    }
    
    public void ZadaneZadanie.setZadanie_zbioryPytan(Set<ZadaneZadanie_ZbiorPytan> zadanie_zbioryPytan) {
        this.zadanie_zbioryPytan = zadanie_zbioryPytan;
    }
    
    public ZadaneZadanie_Zasady ZadaneZadanie.getZasady() {
        return this.zasady;
    }
    
    public void ZadaneZadanie.setZasady(ZadaneZadanie_Zasady zasady) {
        this.zasady = zasady;
    }
    
    public Set<String> ZadaneZadanie.getGrupy() {
        return this.grupy;
    }
    
    public void ZadaneZadanie.setGrupy(Set<String> grupy) {
        this.grupy = grupy;
    }
    
}
