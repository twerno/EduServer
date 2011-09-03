package net.twerno.eduserver.zadanie.services;

import java.util.List;
import java.util.UUID;

import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;
import net.twerno.eduserver.zadanie.entity.Zadanie;
import net.twerno.eduserver.zadanie.entity.Zadanie_ZbiorPytan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service("zadanieService")
public class ZadanieServiceImpl implements ZadanieService {
	
	@Autowired
	private InternalZadanieService internalZadanieService;
	
	@Override
	@Transactional
	public Zadanie zapiszZadanie(Zadanie zadanie) {
		zadanie.setAutorId(UserHelper.getCurrentUser().getId());
		if (zadanie.getId().isEmpty())
			zadanie.setId(UUID.randomUUID().toString());
		else {
			Zadanie cleanZadanie = Zadanie.findZadanie(zadanie.getId());
			zadanie.setVersion(cleanZadanie.getVersion());
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

	@Override
	public void zadajZadanie(String zadanieID, List<String> grupy) throws Exception {
		Zadanie zadanie = Zadanie.findZadanie(zadanieID);
		if (zadanie == null)
			throw new Exception("Nie istnieje zadanie o id: " +zadanieID);
		if (!zadanie.getAutorId().equals(UserHelper.getCurrentUserId()))
			throw new Exception("Nie jesteœ autorem zadania o id: " +zadanieID);
		
		ZadaneZadanie zadZad = ZadaneZadanie.createFromZadanie(zadanie);
		for (String grupa: grupy)
			zadZad.getGrupy().add(grupa);
		zadZad.merge();		
	}

	@Override
	public List<ZadaneZadanie> dajZadanePrzezeMnie() {
		return ZadaneZadanie.findZadaneZadaniesByAutorId(UserHelper.getCurrentUserId()).getResultList();
	}

	@Override
	public List<ZadaneZadanie> dajZadaneMi() {
		return internalZadanieService.dajZadaneMi();
	}
}
