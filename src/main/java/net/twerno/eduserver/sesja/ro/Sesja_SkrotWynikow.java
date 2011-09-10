package net.twerno.eduserver.sesja.ro;

import java.util.Date;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Sesja_SkrotWynikow {
	private int lp; 
	
	private String accountId;
	
	private String username;
	
	private String sesjaId;
	
	private Date dt_otwarcia;
	
	private double len;
	
	private double wynik;
	

	public Sesja_SkrotWynikow() {}
	
	public Sesja_SkrotWynikow(Object accountId, Object username,
			Object sesjaId, Object dt_otwarcia, Object len, Object wynik) {
		super();
		
		DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");

		this.accountId   = accountId.toString();
		this.username    = username.toString();
		this.sesjaId     = sesjaId.toString();
		this.dt_otwarcia = dtf.parseDateTime(dt_otwarcia.toString()).toDate();
		this.len         = Double.parseDouble(len.toString());
		this.wynik       = Double.parseDouble(wynik.toString());
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSesjaId() {
		return sesjaId;
	}

	public void setSesjaId(String sesjaId) {
		this.sesjaId = sesjaId;
	}

	public Date getDt_otwarcia() {
		return dt_otwarcia;
	}

	public void setDt_otwarcia(Date dt_otwarcia) {
		this.dt_otwarcia = dt_otwarcia;
	}

	public double getLen() {
		return len;
	}

	public void setLen(double len) {
		this.len = len;
	}

	public double getWynik() {
		return wynik;
	}

	public void setWynik(double wynik) {
		this.wynik = wynik;
	}

	public int getLp() {
		return lp;
	}

	public void setLp(int lp) {
		this.lp = lp;
	}
	

}
