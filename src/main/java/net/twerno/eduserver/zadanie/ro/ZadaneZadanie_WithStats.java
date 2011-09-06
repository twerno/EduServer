package net.twerno.eduserver.zadanie.ro;

import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;

public class ZadaneZadanie_WithStats {
	
	private ZadaneZadanie zadanie;
	
	private ZadaneZadanie_Stats zadanie_stats;

	
	
	public ZadaneZadanie_WithStats() {
	}
	
	public ZadaneZadanie_WithStats(ZadaneZadanie zadanie,
			ZadaneZadanie_Stats zadanie_stats) {
		super();
		this.zadanie = zadanie;
		this.zadanie_stats = zadanie_stats;
	}
	
	public ZadaneZadanie getZadanie() {
		return zadanie;
	}

	public void setZadanie(ZadaneZadanie zadanie) {
		this.zadanie = zadanie;
	}

	public ZadaneZadanie_Stats getZadanie_stats() {
		return zadanie_stats;
	}

	public void setZadanie_stats(ZadaneZadanie_Stats zadanie_stats) {
		this.zadanie_stats = zadanie_stats;
	}
}
