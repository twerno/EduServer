// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.sesjaZadania.entities;

import java.lang.String;

privileged aspect SesjaZadania_Roo_ToString {
    
    public String SesjaZadania.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DtRozpoczecia: ").append(getDtRozpoczecia()).append(", ");
        sb.append("DtZakonczenia: ").append(getDtZakonczenia()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("IdUczen: ").append(getIdUczen()).append(", ");
        sb.append("IdZadaneZadanie: ").append(getIdZadaneZadanie()).append(", ");
        sb.append("StanSesji: ").append(getStanSesji()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
