package net.twerno.eduserver.pytanie.services;

import java.util.List;

import net.twerno.eduserver.pytanie.entity.PytanieZamkniete;
import net.twerno.eduserver.pytanie.entity.ZbiorPytan;
import net.twerno.eduserver.user.UserRole;
import net.twerno.eduserver.zadanie.TypZadania;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.security.access.annotation.Secured;

@RemotingDestination
public interface PytanieService {

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	ZbiorPytan zapiszZbiorPytan(ZbiorPytan zbior, List<PytanieZamkniete> pytania)
			throws Exception;
	
	@Secured(UserRole._ROLE_NAUCZYCIEL)
	String usunZbiorPytan(String zbiorPytanId)
			throws Exception;

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	ZbiorPytan wczytajZbiorPytan(String zbiorPytanId)
			 throws Exception;

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<PytanieZamkniete> wczytajPytania(String zbiorPytanId)
			throws Exception;;

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<ZbiorPytan> wczytajDostepneZbiory();

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<ZbiorPytan> wczytajDostepneZbioryTypu(TypZadania typZadania);
	
//	@Secured(UserRole._ROLE_NAUCZYCIEL)
//	List<PytanieZamkniete> dajPytaniaZZbioru(String sesjaId, String userId);
}
