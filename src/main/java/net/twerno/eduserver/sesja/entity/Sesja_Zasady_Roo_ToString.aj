// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.sesja.entity;

import java.lang.String;

privileged aspect Sesja_Zasady_Roo_ToString {
    
    public String Sesja_Zasady.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Czas: ").append(getCzas()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Wynik: ").append(getWynik()).append(", ");
        sb.append("Bezblednie: ").append(isBezblednie()).append(", ");
        sb.append("Czas_bronze: ").append(isCzas_bronze()).append(", ");
        sb.append("Czas_gold: ").append(isCzas_gold()).append(", ");
        sb.append("Czas_silver: ").append(isCzas_silver()).append(", ");
        sb.append("Punkty_bronze: ").append(isPunkty_bronze()).append(", ");
        sb.append("Punkty_gold: ").append(isPunkty_gold()).append(", ");
        sb.append("Punkty_silver: ").append(isPunkty_silver()).append(", ");
        sb.append("Ukonczone: ").append(isUkonczone());
        return sb.toString();
    }
    
}
