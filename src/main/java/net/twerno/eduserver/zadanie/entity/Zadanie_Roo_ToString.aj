// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.zadanie.entity;

import java.lang.String;

privileged aspect Zadanie_Roo_ToString {
    
    public String Zadanie.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Autor: ").append(getAutor()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Nazwa: ").append(getNazwa()).append(", ");
        sb.append("Opis: ").append(getOpis()).append(", ");
        sb.append("TypZdania: ").append(getTypZdania()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("ZbiorPytan: ").append(getZbiorPytan() == null ? "null" : getZbiorPytan().size());
        return sb.toString();
    }
    
}
