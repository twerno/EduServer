package net.twerno.eduserver.sesja.service;

import java.util.List;

import net.twerno.eduserver.sesja.entity.Sesja;
import net.twerno.eduserver.sesja.ro.SesjaOtwartaRO;
import net.twerno.eduserver.user.UserRole;

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

	// wyniki na potrzeby wyliczenia zestawu pytan

	@RemotingExclude
	Sesja InternalDajSesje(String sesjaId)
			throws Exception;
	
	@RemotingExclude
	void sprawdzZasady(Sesja sesja);
}
