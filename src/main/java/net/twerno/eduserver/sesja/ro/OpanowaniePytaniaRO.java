package net.twerno.eduserver.sesja.ro;

public class OpanowaniePytaniaRO {

	private String pytanieId;
	
	private int iloscPodejsc;
	
	private int correctAnswers;

	public OpanowaniePytaniaRO() {
		
	}
	
	public OpanowaniePytaniaRO(String pytanieId, int iloscPodejsc,
			int correctAnswers) {
		super();
		this.pytanieId      = pytanieId;
		this.iloscPodejsc   = iloscPodejsc;
		this.correctAnswers = correctAnswers;
	}

	public String getPytanieId() {
		return pytanieId;
	}

	public void setPytanieId(String pytanieId) {
		this.pytanieId = pytanieId;
	}

	public int getIloscPodejsc() {
		return iloscPodejsc;
	}

	public void setIloscPodejsc(int iloscPodejsc) {
		this.iloscPodejsc = iloscPodejsc;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
}
