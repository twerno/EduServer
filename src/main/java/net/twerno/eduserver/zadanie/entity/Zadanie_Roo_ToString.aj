// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.zadanie.entity;

import java.lang.String;

privileged aspect Zadanie_Roo_ToString {
    
    public String Zadanie.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AutorId: ").append(getAutorId()).append(", ");
        sb.append("DtDo: ").append(getDtDo()).append(", ");
        sb.append("DtOd: ").append(getDtOd()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("LimitCzasowy: ").append(getLimitCzasowy()).append(", ");
        sb.append("LimitPytan: ").append(getLimitPytan()).append(", ");
        sb.append("MinimalnyWynik: ").append(getMinimalnyWynik()).append(", ");
        sb.append("Nazwa: ").append(getNazwa()).append(", ");
        sb.append("TrybSprawdzenia: ").append(getTrybSprawdzenia()).append(", ");
        sb.append("TypWyboruPytan: ").append(getTypWyboruPytan()).append(", ");
        sb.append("TypZadania: ").append(getTypZadania()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Zadanie_zbioryPytan: ").append(getZadanie_zbioryPytan() == null ? "null" : getZadanie_zbioryPytan().size()).append(", ");
        sb.append("Zasady: ").append(getZasady()).append(", ");
        sb.append("Obowiazkowe: ").append(isObowiazkowe());
        return sb.toString();
    }
    
}
