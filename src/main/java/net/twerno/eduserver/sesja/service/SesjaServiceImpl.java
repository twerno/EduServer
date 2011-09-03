package net.twerno.eduserver.sesja.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import net.twerno.eduserver.pytanie.entity.PytanieZamkniete;
import net.twerno.eduserver.sesja.SesjaHelper;
import net.twerno.eduserver.sesja.SesjaStan;
import net.twerno.eduserver.sesja.entity.KartaOdpowiedzi;
import net.twerno.eduserver.sesja.entity.Sesja;
import net.twerno.eduserver.sesja.ro.SesjaOtwartaRO;
import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie_ZbiorPytan;

import org.springframework.flex.remoting.RemotingExclude;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("sesjaService")
public class SesjaServiceImpl implements SesjaService {

	@Override
	public SesjaOtwartaRO otworzSesje(String zadanieId) throws Exception {
		zamknijWszystkieSesje();

		ZadaneZadanie zadanie = ZadaneZadanie.findZadaneZadanie(zadanieId);
		if (zadanie == null)
			throw new Exception("Brak zadania o id: " +zadanieId);
		if (!UserHelper.getCurrentUser().hasGrupa(zadanie.getGrupy()))
			throw new Exception("Nie zosta³eœ przypisany zadania o id: " +zadanieId);
		if (zadanie.getDtDo() != null && zadanie.getDtDo().after(new Date()))
			throw new Exception("Min¹³ czas na rozwi¹zanie zadania: " +zadanieId);
		if (zadanie.getDtOd() != null && zadanie.getDtOd().before(new Date()))
			throw new Exception("Za wczeœnie na rozwi¹zanie zadania: " +zadanieId);

		//rejestrujemy nowa sesje
		Sesja sesja = new Sesja();
		sesja.setId(UUID.randomUUID().toString());
		sesja.setDtOtwarcia(new Date());
		sesja.setUczenId(UserHelper.getCurrentUserId());
		sesja.setZadaneZadanieId(zadanieId);
		sesja.merge();
		
		SesjaOtwartaRO sesjaOtwarta = new SesjaOtwartaRO();
		sesjaOtwarta.setSesjaId(sesja.getId());
		sesjaOtwarta.setZadanie(zadanie);
		for (ZadaneZadanie_ZbiorPytan zzzp: zadanie.getZadanie_zbioryPytan())
			sesjaOtwarta.getPytania().addAll(
					PytanieZamkniete
					.findPytanieZamknietesByZbiorPytanIdAndUsuniety(zzzp.getZbiorPytanId(), false)
					.getResultList());

		return sesjaOtwarta;
	}

	@Override
	public void zamknijSesje(String sesjaId) throws Exception {
		Sesja sesja = InternalDajSesje(sesjaId);
		sesja.setDtZamkniecia(new Date());
		sesja.setStanSesji(SesjaStan.SESJA_ZAKONCZONA);
		sesja.setWynik(SesjaHelper.wyliczWynik(sesja));
		sesja.merge();
	}

	@Override
	public void zamknijWszystkieSesje() {
		// TODO Auto-generated method stub

	}

	@Override
	public void zapiszOdpowiedz(String sesjaId, String pytanieId,
			boolean poprawna, int iloscProb) throws Exception {

		Sesja sesja = InternalDajSesje(sesjaId);

		PytanieZamkniete pytanie = PytanieZamkniete.findPytanieZamkniete(pytanieId);
		if (pytanie == null)
			throw new Exception("Nie istnieje pytanie o id: " +pytanieId);

		ZadaneZadanie zadanie = ZadaneZadanie.findZadaneZadanie(sesja.getZadaneZadanieId());

		boolean poprawnyZbiorPytan = 
				ZadaneZadanie_ZbiorPytan
				.findZadaneZadanie_ZbiorPytansByZadanieAndZbiorPytanId(
						zadanie, 
						pytanie.getZbiorPytanId())
				.getResultList().size() != 0;

		if (!poprawnyZbiorPytan)
			throw new Exception("Sesja id: " +sesjaId +" Pytanie id: " +pytanieId +" nie nale¿y do ¿adnego ze zbiorów pytañ z zadania id: " +sesja.getZadaneZadanieId());

		KartaOdpowiedzi ko = new KartaOdpowiedzi(sesja, pytanieId, iloscProb, poprawna);
		ko.merge();
		sesja.getOdpowiedzi().add(ko);
		sesja.merge();
	}

	@Override
	public List<Sesja> dajWyniki(String zadaneZadanieId) {
		return Sesja.findSesjasByZadaneZadanieId(zadaneZadanieId).getResultList();
	}

	@RemotingExclude
	@Override
	public Sesja InternalDajSesje(String sesjaId)
			throws Exception {
		Sesja sesja = Sesja.findSesja(sesjaId);
		if (sesja == null)
			throw new Exception("Nie istnieje sesja o id: " +sesjaId);
		if (sesja.getStanSesji() != SesjaStan.SESJA_ROZPOCZETA)
			throw new Exception("Sesja o id: "+sesjaId +" nie jest ju¿ otwarta.");
		if (!sesja.getUczenId().equals(UserHelper.getCurrentUserId()))
			throw new Exception("User o id: "+ UserHelper.getCurrentUserId() +" nie jest przypisany do sesji o id: " +sesjaId);
		return sesja;
	}
}
