// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.zadanie.entities;

import java.lang.String;

privileged aspect ZadanieMetadane_Roo_ToString {
    
    public String ZadanieMetadane.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("IdWartosc: ").append(getIdWartosc()).append(", ");
        sb.append("StWartosc: ").append(getStWartosc()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Zadanie: ").append(getZadanie());
        return sb.toString();
    }
    
}