// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.user.entities;

import java.lang.String;

privileged aspect Account_Roo_ToString {
    
    public String Account.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Enabled: ").append(getEnabled()).append(", ");
        sb.append("Grupy: ").append(getGrupy() == null ? "null" : getGrupy().size()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Password: ").append(getPassword()).append(", ");
        sb.append("Roles: ").append(getRoles() == null ? "null" : getRoles().size()).append(", ");
        sb.append("Username: ").append(getUsername()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}