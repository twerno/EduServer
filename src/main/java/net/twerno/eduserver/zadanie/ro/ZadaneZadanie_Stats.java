package net.twerno.eduserver.zadanie.ro;

public class ZadaneZadanie_Stats {
	
	private boolean czas_bronze;
	
	private boolean czas_silver;
	
	private boolean czas_gold;
	
	private boolean bezblednie;
	
	private boolean punkty_bronze;
	
	private boolean punkty_silver;
	
	private boolean punkty_gold;
	
	private boolean ukonczone;
	
	private double maxWynik;
	
	private int minCzas;
	
	private int iloscPodejsc;
	
	private int iloscZdanych;

	public ZadaneZadanie_Stats() {
		
	}
	
	public void fill(Object maxWynik, Object minCzas, Object ukonczone, Object bezblednie, 
			Object czas_bronze, Object czas_silver, Object czas_gold, 
			Object punkty_bronze, Object punkty_silver, Object punkty_gold, 
			Object iloscPodejsc, Object iloscZdanych) {
		this.czas_bronze   = getBoolFrom(czas_bronze);
		this.czas_silver   = getBoolFrom(czas_silver);
		this.czas_gold     = getBoolFrom(czas_gold);
		this.bezblednie    = getBoolFrom(bezblednie);
		this.punkty_bronze = getBoolFrom(punkty_bronze);
		this.punkty_silver = getBoolFrom(punkty_silver);
		this.punkty_gold   = getBoolFrom(punkty_gold);
		this.ukonczone     = getBoolFrom(ukonczone);
		this.maxWynik      = getDoubleFromObj(maxWynik);
		this.minCzas       = getIntFromObj(minCzas);
		this.iloscPodejsc  = getIntFromObj(iloscPodejsc);
		this.iloscZdanych  = getIntFromObj(iloscZdanych);
	}
	
	private boolean getBoolFrom(Object o) {
		if (o == null)
			return false;
		return Integer.valueOf(o.toString()).intValue() > 0;
	}
	
	private int getIntFromObj(Object o) {
		if (o == null)
			return 0;
		return Integer.valueOf(o.toString()).intValue();		
	}
	
	private double getDoubleFromObj(Object o) {
		if (o == null)
			return 0;
		return Double.valueOf(o.toString()).doubleValue();		
	}

	public boolean isCzas_bronze() {
		return czas_bronze;
	}

	public void setCzas_bronze(boolean czas_bronze) {
		this.czas_bronze = czas_bronze;
	}

	public boolean isCzas_silver() {
		return czas_silver;
	}

	public void setCzas_silver(boolean czas_silver) {
		this.czas_silver = czas_silver;
	}

	public boolean isCzas_gold() {
		return czas_gold;
	}

	public void setCzas_gold(boolean czas_gold) {
		this.czas_gold = czas_gold;
	}

	public boolean isBezblednie() {
		return bezblednie;
	}

	public void setBezblednie(boolean bezblednie) {
		this.bezblednie = bezblednie;
	}

	public boolean isPunkty_bronze() {
		return punkty_bronze;
	}

	public void setPunkty_bronze(boolean punkty_bronze) {
		this.punkty_bronze = punkty_bronze;
	}

	public boolean isPunkty_silver() {
		return punkty_silver;
	}

	public void setPunkty_silver(boolean punkty_silver) {
		this.punkty_silver = punkty_silver;
	}

	public boolean isPunkty_gold() {
		return punkty_gold;
	}

	public void setPunkty_gold(boolean punkty_gold) {
		this.punkty_gold = punkty_gold;
	}

	public boolean isUkonczone() {
		return ukonczone;
	}

	public void setUkonczone(boolean ukonczone) {
		this.ukonczone = ukonczone;
	}

	public double getMaxWynik() {
		return maxWynik;
	}

	public void setMaxWynik(double maxWynik) {
		this.maxWynik = maxWynik;
	}

	public int getMinCzas() {
		return minCzas;
	}

	public void setMinCzas(int minCzas) {
		this.minCzas = minCzas;
	}

	public int getIloscPodejsc() {
		return iloscPodejsc;
	}

	public void setIloscPodejsc(int iloscPodejsc) {
		this.iloscPodejsc = iloscPodejsc;
	}

	public int getIloscZdanych() {
		return iloscZdanych;
	}

	public void setIloscZdanych(int iloscZdanych) {
		this.iloscZdanych = iloscZdanych;
	}
	
	
}
