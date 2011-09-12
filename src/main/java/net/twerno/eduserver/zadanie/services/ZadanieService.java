package net.twerno.eduserver.zadanie.services;

import java.util.List;

import net.twerno.eduserver.user.UserRole;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;
import net.twerno.eduserver.zadanie.entity.Zadanie;
import net.twerno.eduserver.zadanie.ro.ZadaneZadanie_WithStats;
import net.twerno.eduserver.zadanie.ro.ZadaneZadanie_Wynik;
import net.twerno.eduserver.zadanie.ro.ZadaneZadanie_Wynik_WithSkrot;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.security.access.annotation.Secured;

@RemotingDestination
public interface ZadanieService {

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	Zadanie zapiszZadanie(Zadanie zadanie);

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<Zadanie> dajMojeZadania();

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	void zadajZadanie(String zadanieID, List<String> grupy)
			throws Exception;

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<ZadaneZadanie> dajZadanePrzezeMnie();

	@Secured(UserRole._ROLE_UCZEN)
	List<ZadaneZadanie_WithStats> dajZadaneMi(boolean ukonczone);
	
	@Secured(UserRole._ROLE_UCZEN)
	List<ZadaneZadanie_Wynik> dajTabliceWynikow(String zadaneZadanieId);
	
	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<ZadaneZadanie_Wynik_WithSkrot> dajSkroconeWyniki(String zadaneZadanieId);
	
	@Secured(UserRole._ROLE_NAUCZYCIEL)
	void usunZadanie(String zadanieId)
			throws Exception;;
}
