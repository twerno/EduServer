package net.twerno.eduserver.pytanie.services;

import java.util.List;

import net.twerno.eduserver.pytanie.entity.PytaniePosortuj;
import net.twerno.eduserver.pytanie.entity.PytanieQuiz;
import net.twerno.eduserver.pytanie.entity.ZbiorPytan;
import net.twerno.eduserver.user.UserRole;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.security.access.annotation.Secured;

@RemotingDestination
public interface PytanieService {
	
	@Secured(UserRole._ROLE_NAUCZYCIEL)
	void zapiszZbior_Posortuj(ZbiorPytan zbior, List<PytaniePosortuj> pytania)
			throws Exception;

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<PytaniePosortuj> wczytajZbior_Posortuj(ZbiorPytan zbior)
			throws Exception;

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	void zapiszZbior_Quiz(ZbiorPytan zbior, List<PytanieQuiz> pytania)
			throws Exception;

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<PytanieQuiz> wczytajZbior_Quiz(ZbiorPytan zbior)
			throws Exception;

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<ZbiorPytan> dajDostepneZbiory();

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<ZbiorPytan> dajDostepneZbiory_Posortuj();

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<ZbiorPytan> dajDostepneZbiory_Quiz();

	//wczytaj zbiory na potrzeby prezentacji zadania
}
