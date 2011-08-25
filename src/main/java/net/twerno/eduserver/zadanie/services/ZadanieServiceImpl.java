package net.twerno.eduserver.zadanie.services;

import java.util.List;

import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.zadanie.ZadanieQueries;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;
import net.twerno.eduserver.zadanie.entity.Zadanie;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("zadanieService")
public class ZadanieServiceImpl implements ZadanieService {

	@Override
	public void zapiszZadanie(Zadanie zadanie) {
		zadanie.setAutor(UserHelper.getCurrentUser());
		zadanie.merge();
	}

	@Override
	public List<Zadanie> dajMojeZadania() {
		return Zadanie.findZadaniesByAutorAndUsuniete(UserHelper.getCurrentUser(), false).getResultList();
	}
	
	@Override
	public void zapiszZadaneZadanie(ZadaneZadanie zadanie) {
		zadanie.setAutor(UserHelper.getCurrentUser());
		zadanie.merge();
	}

	@Override
	public List<ZadaneZadanie> dajZadanePrzezeMnie() {
		return ZadaneZadanie.findZadaneZadaniesByAutor(UserHelper.getCurrentUser()).getResultList();
	}

	@Override
	public List<ZadaneZadanie> dajZadaneMi() {
		return ZadanieQueries.dajZadaneMi(UserHelper.getCurrentUser());
	}
}
