// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.sesjaZadania.entities;

import java.lang.Long;
import java.util.Date;
import net.twerno.eduserver.sesjaZadania.StanSesji;

privileged aspect SesjaZadania_Roo_JavaBean {
    
    public Long SesjaZadania.getIdUczen() {
        return this.idUczen;
    }
    
    public void SesjaZadania.setIdUczen(Long idUczen) {
        this.idUczen = idUczen;
    }
    
    public Long SesjaZadania.getIdZadaneZadanie() {
        return this.idZadaneZadanie;
    }
    
    public void SesjaZadania.setIdZadaneZadanie(Long idZadaneZadanie) {
        this.idZadaneZadanie = idZadaneZadanie;
    }
    
    public Date SesjaZadania.getDtRozpoczecia() {
        return this.dtRozpoczecia;
    }
    
    public void SesjaZadania.setDtRozpoczecia(Date dtRozpoczecia) {
        this.dtRozpoczecia = dtRozpoczecia;
    }
    
    public Date SesjaZadania.getDtZakonczenia() {
        return this.dtZakonczenia;
    }
    
    public void SesjaZadania.setDtZakonczenia(Date dtZakonczenia) {
        this.dtZakonczenia = dtZakonczenia;
    }
    
    public StanSesji SesjaZadania.getStanSesji() {
        return this.stanSesji;
    }
    
    public void SesjaZadania.setStanSesji(StanSesji stanSesji) {
        this.stanSesji = stanSesji;
    }
    
}