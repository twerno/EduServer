// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entity;

import java.lang.String;

privileged aspect ZbiorPytan_Roo_ToString {
    
    public String ZbiorPytan.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AutorId: ").append(getAutorId()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Opis: ").append(getOpis()).append(", ");
        sb.append("Przedmiot: ").append(getPrzedmiot()).append(", ");
        sb.append("TypZadania: ").append(getTypZadania()).append(", ");
        sb.append("IsPublic: ").append(isIsPublic()).append(", ");
        sb.append("Usuniety: ").append(isUsuniety());
        return sb.toString();
    }
    
}
