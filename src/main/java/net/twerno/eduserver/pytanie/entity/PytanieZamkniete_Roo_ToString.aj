// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entity;

import java.lang.String;

privileged aspect PytanieZamkniete_Roo_ToString {
    
    public String PytanieZamkniete.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Kategoria: ").append(getKategoria()).append(", ");
        sb.append("Odpowiedzi: ").append(getOdpowiedzi() == null ? "null" : getOdpowiedzi().size()).append(", ");
        sb.append("TrescPytania: ").append(getTrescPytania()).append(", ");
        sb.append("TypZdania: ").append(getTypZdania()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("ZbiorPytanId: ").append(getZbiorPytanId()).append(", ");
        sb.append("Usuniety: ").append(isUsuniety());
        return sb.toString();
    }
    
}