// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.zadanie.entity;

import java.util.Date;
import java.util.Set;
import net.twerno.eduserver.user.entities.Grupa;
import net.twerno.eduserver.zadanie.entity.TypWyboru;
import net.twerno.eduserver.zadanie.entity.Zadanie;

privileged aspect ZadaneZadanie_Roo_JavaBean {
    
    public Zadanie ZadaneZadanie.getZadanie() {
        return this.zadanie;
    }
    
    public void ZadaneZadanie.setZadanie(Zadanie zadanie) {
        this.zadanie = zadanie;
    }
    
    public boolean ZadaneZadanie.isObowiazkowe() {
        return this.obowiazkowe;
    }
    
    public void ZadaneZadanie.setObowiazkowe(boolean obowiazkowe) {
        this.obowiazkowe = obowiazkowe;
    }
    
    public Set<Grupa> ZadaneZadanie.getGrupy() {
        return this.grupy;
    }
    
    public void ZadaneZadanie.setGrupy(Set<Grupa> grupy) {
        this.grupy = grupy;
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
    
    public int ZadaneZadanie.getMaxIloscPytan() {
        return this.maxIloscPytan;
    }
    
    public void ZadaneZadanie.setMaxIloscPytan(int maxIloscPytan) {
        this.maxIloscPytan = maxIloscPytan;
    }
    
    public TypWyboru ZadaneZadanie.getTypWyboru() {
        return this.typWyboru;
    }
    
    public void ZadaneZadanie.setTypWyboru(TypWyboru typWyboru) {
        this.typWyboru = typWyboru;
    }
    
}
