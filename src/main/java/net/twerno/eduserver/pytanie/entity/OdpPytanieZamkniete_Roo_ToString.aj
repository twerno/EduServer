// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.pytanie.entity;

import java.lang.String;

privileged aspect OdpPytanieZamkniete_Roo_ToString {
    
    public String OdpPytanieZamkniete.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("PytanieZamkniete: ").append(getPytanieZamkniete()).append(", ");
        sb.append("StOdpowiedz: ").append(getStOdpowiedz()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("TnPoprawna: ").append(isTnPoprawna());
        return sb.toString();
    }
    
}
