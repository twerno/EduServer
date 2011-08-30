package net.twerno.eduserver.pytanie.services;

import java.util.List;

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
	public void zapiszZbiorPytan(ZbiorPytan zbior,
			List<PytanieZamkniete> pytania) throws Exception {
		Account currentUser = UserHelper.getCurrentUser();

		// jeœli nie jest nowy i nie jesteœmy autorem tego zbioru to nie mo¿na go edytowaæ
		if (zbior.getId() != 0 && 
			ZbiorPytan.findZbiorPytan(zbior.getId()).getAutor().getId() != currentUser.getId())
			throw new Exception("Nie jesteœ autorem zbioru: " +zbior.getOpis());

		zbior.setAutor(currentUser);
		zbior.merge();

		PytanieQueries.usunPytaniaZeZbioru(zbior.getId());
		
		for (PytanieZamkniete pytanie: pytania) {
			pytanie.setTypZdania(zbior.getTypZdania());
			pytanie.setZbiorPytanId(zbior.getId());
			pytanie.merge();
		}
	}

	@Override
	public ZbiorPytan wczytajZbiorPytan(long zbiorPytanId) throws Exception {
		// 1.. czy moge wczytac ten zbior - moj, lub publiczny
		Account currentUser = UserHelper.getCurrentUser();
		ZbiorPytan zbiorPytan = ZbiorPytan.findZbiorPytan(zbiorPytanId);

		if (!zbiorPytan.getAutor().equals(currentUser) || !zbiorPytan.isIsPublic())
			throw new Exception("Nie masz uprawnieñ do przegl¹dania zbioru: " +zbiorPytan.getOpis());
		
		return zbiorPytan;
	}

	@Override
	public List<PytanieZamkniete> wczytajPytania(long zbiorPytanId) throws Exception {
		// 1.. czy moge wczytac ten zbior - moj, lub publiczny
		Account currentUser = UserHelper.getCurrentUser();
		ZbiorPytan zbiorPytan = ZbiorPytan.findZbiorPytan(zbiorPytanId);

		if (!zbiorPytan.getAutor().equals(currentUser) || !zbiorPytan.isIsPublic())
			throw new Exception("Nie masz uprawnieñ do przegl¹dania zbioru: " +zbiorPytan.getOpis());

		return PytanieZamkniete.findPytanieZamknietesByZbiorPytanId(zbiorPytanId).getResultList();
	}

	@Override
	public List<ZbiorPytan> wczytajDostepneZbiory() {
		return PytanieQueries.dajDostepneZbioryPytan(UserHelper.getCurrentUser());
	}

	@Override
	public List<ZbiorPytan> wczytajDostepneZbioryTypy(TypZadania typZadania) {
		return PytanieQueries.dajDostepneZbioryPytan(UserHelper.getCurrentUser(), typZadania);
	}

	@Override
	public List<PytanieZamkniete> internalWczytajPytania(long zadaneZadanieId) {
		return null;
//		return PytanieZamkniete.;
	}

}
