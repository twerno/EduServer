package net.twerno.eduserver.pytanie.services;

import java.util.List;

import net.twerno.eduserver.pytanie.PytanieQueries;
import net.twerno.eduserver.pytanie.entity.PytaniePosortuj;
import net.twerno.eduserver.pytanie.entity.PytanieQuiz;
import net.twerno.eduserver.pytanie.entity.ZbiorPytan;
import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.zadanie.TypZadania;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service("pytaniaService")
public class PytaniaServiceImpl implements PytanieService {

	@Override
	@Transactional
	public void zapiszZbior_Posortuj(ZbiorPytan zbior,
			List<PytaniePosortuj> pytania) throws Exception {
		Account currentUser = UserHelper.getCurrentUser();

		// jeœli nie jest nowy i nie jesteœmy autorem tego zbioru to nie mo¿na go edytowaæ
		if (zbior.getId() != 0 && 
			ZbiorPytan.findZbiorPytan(zbior.getId()).getAutor().getId() != currentUser.getId())
			throw new Exception("Nie jesteœ autorem zbioru: " +zbior.getOpis());

		zbior.setAutor(currentUser);
		zbior.setTypZdania(TypZadania.POSORTUJ);
		zbior.merge();

		List<PytaniePosortuj> cleanPytania = PytaniePosortuj.findPytaniePosortujsByZbiorPytanAndUsuniety(zbior, false).getResultList();

		for (PytaniePosortuj pytanie: pytania) {
			pytanie.setZbiorPytan(zbior);
			pytanie.merge();
			cleanPytania.remove(pytanie);
		}

		// odznaczamy pytania, ktorych brakowalo jako usuniete
		for (PytaniePosortuj pytanie: cleanPytania) {
			pytanie.setUsuniety(true);
			pytanie.merge();
		}
	}

	@Override
	public List<PytaniePosortuj> wczytajZbior_Posortuj(ZbiorPytan zbior) throws Exception {
		// 1.. czy moge wczytac ten zbior - moj, lub publiczny
		Account currentUser = UserHelper.getCurrentUser();
		ZbiorPytan cleanZbior = ZbiorPytan.findZbiorPytan(zbior.getId());

		if (!cleanZbior.getAutor().equals(currentUser) || !cleanZbior.isIsPublic())
			throw new Exception("Nie masz uprawnieñ do przegl¹dania zbioru: " +cleanZbior.getOpis());
		if (cleanZbior.getTypZdania() != TypZadania.POSORTUJ)
			throw new Exception("Nieprawid³owy typ zadania.");

		return PytaniePosortuj.findPytaniePosortujsByZbiorPytanAndUsuniety(cleanZbior, false).getResultList();
	}

	@Override
	public void zapiszZbior_Quiz(ZbiorPytan zbior, List<PytanieQuiz> pytania) throws Exception {
		Account currentUser = UserHelper.getCurrentUser();

		// jeœli nie jest nowy i nie jesteœmy autorem tego zbioru to nie mo¿na go edytowaæ
		if (zbior.getId() != 0 && 
			ZbiorPytan.findZbiorPytan(zbior.getId()).getAutor().getId() != currentUser.getId())
			throw new Exception("Nie jesteœ autorem zbioru: " +zbior.getOpis());

		zbior.setAutor(currentUser);
		zbior.setTypZdania(TypZadania.QUIZ);
		zbior.merge();

		List<PytanieQuiz> cleanPytania = PytanieQuiz.findPytanieQuizesByZbiorPytanAndUsuniety(zbior, false).getResultList();

		for (PytanieQuiz pytanie: pytania) {
			pytanie.setZbiorPytan(zbior);
			pytanie.merge();
			cleanPytania.remove(pytanie);
		}

		// odznaczamy pytania, ktorych brakowalo jako usuniete
		for (PytanieQuiz pytanie: cleanPytania) {
			pytanie.setUsuniety(true);
			pytanie.merge();
		}
	}

	@Override
	public List<PytanieQuiz> wczytajZbior_Quiz(ZbiorPytan zbior) throws Exception {
		Account currentUser = UserHelper.getCurrentUser();
		ZbiorPytan cleanZbior = ZbiorPytan.findZbiorPytan(zbior.getId());

		if (!cleanZbior.getAutor().equals(currentUser) || !cleanZbior.isIsPublic())
			throw new Exception("Nie masz uprawnieñ do przegl¹dania zbioru: " +cleanZbior.getOpis());
		if (cleanZbior.getTypZdania() != TypZadania.QUIZ)
			throw new Exception("Nieprawid³owy typ zadania.");

		return PytanieQuiz.findPytanieQuizesByZbiorPytanAndUsuniety(cleanZbior, false).getResultList();
	}

	@Override
	public List<ZbiorPytan> dajDostepneZbiory() {
		List<ZbiorPytan> result = ZbiorPytan.findZbiorPytansByAutorAndUsuniety(UserHelper.getCurrentUser(), false).getResultList();
		result.addAll(ZbiorPytan.findZbiorPytansByIsPublicAndUsuniety(true, false).getResultList());
		return result;
	}

	@Override
	public List<ZbiorPytan> dajDostepneZbiory_Posortuj() {
		List<ZbiorPytan> result = PytanieQueries.findByAutorAndUsunietyAndTyp(UserHelper.getCurrentUser(), false, TypZadania.POSORTUJ).getResultList();
		result.addAll(PytanieQueries.findByIsPublicAndUsunietyAndTyp(true, false, TypZadania.POSORTUJ).getResultList());
		return result;
	}

	@Override
	public List<ZbiorPytan> dajDostepneZbiory_Quiz() {
		List<ZbiorPytan> result = PytanieQueries.findByAutorAndUsunietyAndTyp(UserHelper.getCurrentUser(), false, TypZadania.QUIZ).getResultList();
		result.addAll(PytanieQueries.findByIsPublicAndUsunietyAndTyp(true, false, TypZadania.QUIZ).getResultList());
		return result;
	}
}
