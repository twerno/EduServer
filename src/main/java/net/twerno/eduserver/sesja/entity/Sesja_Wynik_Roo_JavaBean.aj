// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.twerno.eduserver.sesja.entity;

import java.lang.Integer;
import java.lang.String;

privileged aspect Sesja_Wynik_Roo_JavaBean {
    
    public String Sesja_Wynik.getId() {
        return this.id;
    }
    
    public void Sesja_Wynik.setId(String id) {
        this.id = id;
    }
    
    public Integer Sesja_Wynik.getCzas() {
        return this.czas;
    }
    
    public void Sesja_Wynik.setCzas(Integer czas) {
        this.czas = czas;
    }
    
    public double Sesja_Wynik.getWynik() {
        return this.wynik;
    }
    
    public void Sesja_Wynik.setWynik(double wynik) {
        this.wynik = wynik;
    }
    
    public boolean Sesja_Wynik.isCzas_bronze() {
        return this.czas_bronze;
    }
    
    public void Sesja_Wynik.setCzas_bronze(boolean czas_bronze) {
        this.czas_bronze = czas_bronze;
    }
    
    public boolean Sesja_Wynik.isCzas_silver() {
        return this.czas_silver;
    }
    
    public void Sesja_Wynik.setCzas_silver(boolean czas_silver) {
        this.czas_silver = czas_silver;
    }
    
    public boolean Sesja_Wynik.isCzas_gold() {
        return this.czas_gold;
    }
    
    public void Sesja_Wynik.setCzas_gold(boolean czas_gold) {
        this.czas_gold = czas_gold;
    }
    
    public boolean Sesja_Wynik.isBezblednie() {
        return this.bezblednie;
    }
    
    public void Sesja_Wynik.setBezblednie(boolean bezblednie) {
        this.bezblednie = bezblednie;
    }
    
    public boolean Sesja_Wynik.isPunkty_bronze() {
        return this.punkty_bronze;
    }
    
    public void Sesja_Wynik.setPunkty_bronze(boolean punkty_bronze) {
        this.punkty_bronze = punkty_bronze;
    }
    
    public boolean Sesja_Wynik.isPunkty_silver() {
        return this.punkty_silver;
    }
    
    public void Sesja_Wynik.setPunkty_silver(boolean punkty_silver) {
        this.punkty_silver = punkty_silver;
    }
    
    public boolean Sesja_Wynik.isPunkty_gold() {
        return this.punkty_gold;
    }
    
    public void Sesja_Wynik.setPunkty_gold(boolean punkty_gold) {
        this.punkty_gold = punkty_gold;
    }
    
    public boolean Sesja_Wynik.isUkonczone() {
        return this.ukonczone;
    }
    
    public void Sesja_Wynik.setUkonczone(boolean ukonczone) {
        this.ukonczone = ukonczone;
    }
    
}