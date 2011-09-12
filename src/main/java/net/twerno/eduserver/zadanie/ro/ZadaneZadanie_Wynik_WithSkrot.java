package net.twerno.eduserver.zadanie.ro;

import java.util.List;

import net.twerno.eduserver.sesja.ro.Sesja_SkrotWynikow;

public class ZadaneZadanie_Wynik_WithSkrot extends ZadaneZadanie_Wynik {
	private List<Sesja_SkrotWynikow> skroty_wynikow;

	public List<Sesja_SkrotWynikow> getSkroty_wynikow() {
		return skroty_wynikow;
	}

	public void setSkroty_wynikow(List<Sesja_SkrotWynikow> skroty_wynikow) {
		this.skroty_wynikow = skroty_wynikow;
	}
}
