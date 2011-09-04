package net.twerno.eduserver.sesja;

import net.twerno.eduserver.sesja.entity.KartaOdpowiedzi;
import net.twerno.eduserver.sesja.entity.Sesja;

public class SesjaHelper {

	public static double wyliczWynik(Sesja sesja) {
		if (sesja.getOdpowiedzi().size() == 0)
			return 0;

		double wynik = 0;

		for (KartaOdpowiedzi ko: sesja.getOdpowiedzi()) {
			if (ko.isTnPoprawna() && ko.getIloscProb() == 0) {
				wynik += 1;
			}
		}

		return wynik;
	}
}
