package net.twerno.eduserver.sesja.ro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.twerno.eduserver.pytanie.entity.PytanieZamkniete;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie_ZbiorPytan;

public class SesjaOtwartaRO {
	
	private String sesjaId;
	
	private ZadaneZadanie zadanie;
	
	private List<PytanieZamkniete> pytania = new ArrayList<PytanieZamkniete>();
	

	
	
	public SesjaOtwartaRO() {
		
	}
	
	public String getSesjaId() {
		return sesjaId;
	}

	public void setSesjaId(String sesjaId) {
		this.sesjaId = sesjaId;
	}

	public List<PytanieZamkniete> getPytania() {
		return pytania;
	}

	public void setPytania(List<PytanieZamkniete> pytania) {
		this.pytania = pytania;
	}

	public ZadaneZadanie getZadanie() {
		return zadanie;
	}

	public void setZadanie(ZadaneZadanie zadanie) {
		this.zadanie = zadanie;
	}

}
