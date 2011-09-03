package net.twerno.eduserver.pytanie.services;

import java.util.List;
import java.util.UUID;

import net.twerno.eduserver.pytanie.PytanieQueries;
import net.twerno.eduserver.pytanie.entity.PytanieZamkniete;
import net.twerno.eduserver.pytanie.entity.ZbiorPytan;
import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.zadanie.TypZadania;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service("pytanieService")
public class PytanieServiceImpl implements PytanieService {

	@Override
	@Transactional
	public ZbiorPytan zapiszZbiorPytan(ZbiorPytan zbior,
			List<PytanieZamkniete> pytania) throws Exception {
		Account currentUser = UserHelper.getCurrentUser();
		ZbiorPytan cleanZb = null;
		
		if (!zbior.getId().isEmpty())
			cleanZb = ZbiorPytan.findZbiorPytan(zbior.getId());
		
//		 jeœli nie jest nowy i nie jesteœmy autorem tego zbioru to nie mo¿na go edytowaæ
		if (cleanZb != null &&  
			!cleanZb.getAutorId().equals(currentUser.getId()))
			throw new Exception("Nie jesteœ autorem zbioru: " +cleanZb.getOpis());

		zbior.setAutorId(currentUser.getId());
		if (zbior.getId().isEmpty())
			zbior.setId(UUID.randomUUID().toString());
		if (cleanZb != null)
			zbior.setVersion(cleanZb.getVersion());

		zbior.merge();

		for (PytanieZamkniete pytanie: pytania) {
			pytanie.setTypZadania(zbior.getTypZadania());
			pytanie.setZbiorPytanId(zbior.getId());
			pytanie.merge();
		}

		return zbior;
	}

	@Override
	public ZbiorPytan wczytajZbiorPytan(String zbiorPytanId) throws Exception {
		// 1.. czy moge wczytac ten zbior - moj, lub publiczny
		Account currentUser = UserHelper.getCurrentUser();
		ZbiorPytan zbiorPytan = ZbiorPytan.findZbiorPytan(zbiorPytanId);

		if (!zbiorPytan.getAutorId().equals(currentUser.getId()) || !zbiorPytan.isIsPublic())
			throw new Exception("Nie masz uprawnieñ do przegl¹dania zbioru: " +zbiorPytan.getOpis());
		
		return zbiorPytan;
	}

	@Override
	public List<PytanieZamkniete> wczytajPytania(String zbiorPytanId) throws Exception {
		// 1.. czy moge wczytac ten zbior - moj, lub publiczny
		Account currentUser = UserHelper.getCurrentUser();
		ZbiorPytan zbiorPytan = ZbiorPytan.findZbiorPytan(zbiorPytanId);

		if (!zbiorPytan.isIsPublic() && !zbiorPytan.getAutorId().equals(currentUser.getId()))
			throw new Exception("Nie masz uprawnieñ do przegl¹dania zbioru: " +zbiorPytan.getOpis());

		return PytanieZamkniete.findPytanieZamknietesByZbiorPytanIdAndUsuniety(zbiorPytanId, false).getResultList();
	}

	@Override
	public List<ZbiorPytan> wczytajDostepneZbiory() {
		return PytanieQueries.dajDostepneZbioryPytan(UserHelper.getClearCurrentAccount());
	}

	@Override
	public List<ZbiorPytan> wczytajDostepneZbioryTypu(TypZadania typZadania) {
		return PytanieQueries.dajDostepneZbioryPytan(UserHelper.getClearCurrentAccount(), typZadania);
	}

	@Override
	public List<PytanieZamkniete> internalWczytajPytania(long zadaneZadanieId) {
		return null;
		//TODO
//		return PytanieZamkniete.;
	}

	@Override
	public String usunZbiorPytan(String zbiorPytanId) throws Exception {
		Account currentUser = UserHelper.getCurrentUser();
		ZbiorPytan cleanZb = null;

		if (!zbiorPytanId.isEmpty())
			cleanZb = ZbiorPytan.findZbiorPytan(zbiorPytanId);

		if (cleanZb == null)
			throw new Exception("Nie istnieje zbiór pytañ o id: " +zbiorPytanId);

//		 jeœli nie jest nowy i nie jesteœmy autorem tego zbioru to nie mo¿na go edytowaæ
		if (cleanZb != null &&  
			!cleanZb.getAutorId().equals(currentUser.getId()))
			throw new Exception("Nie jesteœ autorem zbioru: " +cleanZb.getOpis());

		cleanZb.setUsuniety(true);
		cleanZb.merge();
		return cleanZb.getId();
	}

}
