package net.twerno.eduserver.zadanie.services;

import java.util.List;

import net.twerno.eduserver.user.UserRole;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;
import net.twerno.eduserver.zadanie.entity.Zadanie;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.security.access.annotation.Secured;

@RemotingDestination
public interface ZadanieService {

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	void zapiszZadanie(Zadanie zadanie);

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<Zadanie> dajMojeZadania();

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	void zapiszZadaneZadanie(ZadaneZadanie zadanie);

	@Secured(UserRole._ROLE_NAUCZYCIEL)
	List<ZadaneZadanie> dajZadanePrzezeMnie();
	
	@Secured(UserRole._ROLE_UCZEN)
	List<ZadaneZadanie> dajZadaneMi();
}
