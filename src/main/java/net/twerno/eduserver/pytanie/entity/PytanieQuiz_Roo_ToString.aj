// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entity;

import java.lang.String;

privileged aspect PytanieQuiz_Roo_ToString {
    
    public String PytanieQuiz.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Odpowiedzi: ").append(getOdpowiedzi() == null ? "null" : getOdpowiedzi().size()).append(", ");
        sb.append("TrescPytania: ").append(getTrescPytania()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("ZbiorPytanId: ").append(getZbiorPytanId());
        return sb.toString();
    }
    
}
