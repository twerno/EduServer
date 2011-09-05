package net.twerno.eduserver.sesja.ro;

import java.util.ArrayList;
import java.util.List;

import net.twerno.eduserver.pytanie.entity.PytanieZamkniete;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;

public class SesjaOtwartaRO {
	
	private String sesjaId;
	
	private ZadaneZadanie zadanie;
	
	private List<PytanieZamkniete> pytania = new ArrayList<PytanieZamkniete>();
	
	private List<OpanowaniePytaniaRO> opanowanePytania = new ArrayList<OpanowaniePytaniaRO>();

	
	
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

	public List<OpanowaniePytaniaRO> getOpanowanePytania() {
		return opanowanePytania;
	}

	public void setOpanowanePytania(List<OpanowaniePytaniaRO> opanowanePytania) {
		this.opanowanePytania = opanowanePytania;
	}

}
