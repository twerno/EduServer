package net.twerno.eduserver.sesja;

import net.twerno.eduserver.sesja.entity.KartaOdpowiedzi;
import net.twerno.eduserver.sesja.entity.Sesja;

public class SesjaHelper {

	public static double wyliczWynik(Sesja sesja) {
		if (sesja.getOdpowiedzi().size() == 0)
			return 0;

		double wynik = 0;

		for (KartaOdpowiedzi ko: sesja.getOdpowiedzi()) {
			if (ko.isTnPoprawna()) {
				wynik += 1/(ko.getIloscProb() +1);
			}
		}

		return wynik/sesja.getOdpowiedzi().size();
	}
}
