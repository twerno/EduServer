// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.zadanie.entity;

import java.lang.String;

privileged aspect ZadaneZadanie_ZbiorPytan_Roo_ToString {
    
    public String ZadaneZadanie_ZbiorPytan.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("IloscPytan: ").append(getIloscPytan()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Zadanie: ").append(getZadanie()).append(", ");
        sb.append("ZbiorPytanId: ").append(getZbiorPytanId());
        return sb.toString();
    }
    
}
