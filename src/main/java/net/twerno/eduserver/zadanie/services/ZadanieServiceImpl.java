package net.twerno.eduserver.zadanie.services;

import java.util.List;
import java.util.UUID;

import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.zadanie.entity.Zadanie;
import net.twerno.eduserver.zadanie.entity.Zadanie_ZbiorPytan;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service("zadanieService")
public class ZadanieServiceImpl implements ZadanieService {

	@Override
	@Transactional
	public Zadanie zapiszZadanie(Zadanie zadanie) {
		zadanie.setAutorId(UserHelper.getCurrentUser().getId());
		if (zadanie.getId() == "")
			zadanie.setId(UUID.randomUUID().toString());
		else {
			Zadanie cleanZadanie = Zadanie.findZadanie(zadanie.getId());
			zadanie.setVersion(cleanZadanie.getVersion());
			cleanZadanie.getZadanie_zbioryPytan().removeAll(zadanie.getZadanie_zbioryPytan());
			for (Zadanie_ZbiorPytan zzp: cleanZadanie.getZadanie_zbioryPytan())
				zzp.remove();
		}

		for (Zadanie_ZbiorPytan zzp: zadanie.getZadanie_zbioryPytan()) {
			if (zzp.getId().isEmpty())
				zzp.setId(UUID.randomUUID().toString());
			else
				zzp.setVersion(Zadanie_ZbiorPytan.findZadanie_ZbiorPytan(zzp.getId()).getVersion());
		}
		zadanie.merge();
		return zadanie;
	}

	@Override
	public List<Zadanie> dajMojeZadania() {
		return Zadanie.findZadaniesByAutorId(UserHelper.getCurrentUserId()).getResultList();
	}

//	@Override
//	public void zapiszZadaneZadanie(ZadaneZadanie zadanie) {
////		zadanie.setAutor(UserHelper.getCurrentUser());
//		zadanie.merge();
//	}
//
//	@Override
//	public List<ZadaneZadanie> dajZadanePrzezeMnie() {
////		return ZadaneZadanie.findZadaneZadaniesByAutor(UserHelper.getCurrentUser()).getResultList();
//	}
//
//	@Override
//	public List<ZadaneZadanie> dajZadaneMi() {
//		return ZadanieQueries.dajZadaneMi(UserHelper.getCurrentUser());
//	}
}
