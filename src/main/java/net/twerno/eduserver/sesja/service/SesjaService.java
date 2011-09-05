package net.twerno.eduserver.sesja.service;

import java.util.List;

import net.twerno.eduserver.pytanie.entity.PytanieZamkniete;
import net.twerno.eduserver.sesja.entity.Sesja;
import net.twerno.eduserver.sesja.ro.OpanowaniePytaniaRO;
import net.twerno.eduserver.sesja.ro.SesjaOtwartaRO;
import net.twerno.eduserver.user.UserRole;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingExclude;
import org.springframework.security.access.annotation.Secured;

@RemotingDestination
public interface SesjaService {
	
	@Secured(UserRole._ROLE_UCZEN)
	SesjaOtwartaRO otworzSesje(String zadanieId)
			throws Exception;
	
	@Secured(UserRole._ROLE_UCZEN)
	void zamknijSesje(String sesjaId)
		throws Exception;
	
	@Secured(UserRole._ROLE_UCZEN)
	void zamknijWszystkieSesje();

	@Secured(UserRole._ROLE_UCZEN)
	void zapiszOdpowiedz(String sesjaId, String pytanieId, boolean poprawna, int iloscProb) 
			throws Exception;

	// powinno zwracac wyspecjalizowany obiekt z nazwami uzytkownikow
	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<Sesja> dajWyniki(String zadaneZadanieId);

	@RemotingExclude
	Sesja InternalDajSesje(String sesjaId)
			throws Exception;
	
	@RemotingExclude
	void sprawdzZasady(Sesja sesja);
	
	@RemotingExclude
	List<OpanowaniePytaniaRO> dajOpanowaniePytania(String sesjaId, String userId);
	
	// metoda wewneczna - wczytuje pytania na potrzeby rozwiazanaia zadania
	@RemotingExclude
	List<PytanieZamkniete> internalWczytajPytania(ZadaneZadanie zadaneZadanie);
}
