package net.twerno.eduserver.zadanie.entity;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.zadanie.TypWyboruPytan;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class TypWyboru {
	
	@NotNull
	private TypWyboruPytan typWyboruPytan;
	
	// procentowa wartosc - ile pytan z zadania wybierane jest sposrod pytan, ktorych uczne jeszcze nie zna
	// procentowa ilosc poprawnych odpowiedzi w ostatnich 10zadaniach jest mniejsza niz 45%
	@NotNull
	private int pytaniaNieznane = 0;

	@NotNull
	// procentowa wartosc - ile pytan z zadania wybierane jest sposrod pytan, ktore uczen zna niezle
	// procentowa ilosc poprawnych odpowiedzi w ostatnich 10zadaniach jest wieksza niz 45%, ale mniejsza niz 80%
	private int pytaniaZnaneSlabo = 0;

	@NotNull
	// procentowa wartosc - ile pytan z zadania wybierane jest sposrod pytan, ktore uczen zna dobrze
	// procentowa ilosc poprawnych odpowiedzi w ostatnich 10zadaniach jest wieksza niz 80%
	private int pytaniaZnaneDobrze = 0;

	@NotNull
	@OneToOne
	private ZadaneZadanie zadaneZadanie;
	
	public void sprawdz() throws Exception {
		if (typWyboruPytan == TypWyboruPytan.INTELIGENTNIE && 
			pytaniaNieznane +pytaniaZnaneSlabo +pytaniaZnaneDobrze != 100)
			throw new Exception("Procentowa iloœæ pytañ nie sumuje siê do 100%.");
	}
}
