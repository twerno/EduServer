package net.twerno.eduserver.zadanie.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import net.twerno.eduserver.sesja.ro.Sesja_SkrotWynikow;
import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;
import net.twerno.eduserver.zadanie.ro.ZadaneZadanie_Stats;
import net.twerno.eduserver.zadanie.ro.ZadaneZadanie_WithStats;
import net.twerno.eduserver.zadanie.ro.ZadaneZadanie_Wynik;
import net.twerno.eduserver.zadanie.ro.ZadanieZadanie_Wynik_WithSkrot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InternalZadanieService {
	
	private JdbcTemplate jdbcTemplate;
	
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<ZadaneZadanie_WithStats> dajZadaneMi(boolean ukonczone) {
		String SQL = " SELECT z.id, "
				    +"   sum(sz.bezblednie) as b, sum(sz.ukonczone) as u,"
				    +"   sum(sz.czas_bronze) as c1, sum(sz.czas_silver) as c2, sum(sz.czas_gold) as c3,"
				    +"   sum(sz.punkty_bronze) as w1, sum(sz.punkty_silver) as w2, sum(sz.punkty_gold) as w3,"
				    +"   max(sz.wynik)as mw, min(sz.czas) as mc,"
				    +"   count(s.id) as iloscPodejsc, sum(sz.ukonczone) as iloscZdanych"
		     		+" FROM      account_grupa        a"
				    +" JOIN zadane_zadanie_grupy      zzg  ON zzg.grupy           = a.grupa_id"
				    +" JOIN zadane_zadanie            z    ON z.id                = zzg.zadane_zadanie"
				    +" LEFT JOIN sesja                s    ON s.zadane_zadanie_id = z.id "
				    +"                                    AND s.uczen_id          = a.account_id"
				    +" LEFT JOIN sesja_wynik          sz   ON sz.id               = s.zasady"
				    +" WHERE a.account_id = ?";
		
		String ukonczone_warunek    = " GROUP BY z.id"
				                     +" HAVING sum(sz.ukonczone) > 0";
		
		String nieukonczone_warunek = "   AND ((z.dt_od is NULL) OR (z.dt_od > now()))"
		                             +"   AND ((z.dt_do is NULL) OR (z.dt_do < now()))"
		                             +" GROUP BY z.id"
		                             +" HAVING (sum(sz.ukonczone) = 0) OR (sum(sz.ukonczone) is NULL)";
		
		ZadaneZadanie_WithStats zadWithStats;
		ZadaneZadanie_Stats zadStats;
		List<ZadaneZadanie_WithStats> result = new ArrayList<ZadaneZadanie_WithStats>();
		List<Map<String,Object>> queryResult = jdbcTemplate.queryForList(
				SQL +((ukonczone) ? ukonczone_warunek : nieukonczone_warunek), 
				new Object[] { UserHelper.getCurrentUserId() });

		if (!queryResult.isEmpty())
			for (Map<String, Object> row: queryResult) {
				zadWithStats = new ZadaneZadanie_WithStats();
				zadWithStats.setZadanie(ZadaneZadanie.findZadaneZadanie(row.get("id").toString()));
				zadStats = new ZadaneZadanie_Stats();
				fillZadStatsFromRow(zadStats, row);
				zadWithStats.setZadanie_stats(zadStats);
				result.add(zadWithStats);
			}

		return result;
	}

	public List<ZadaneZadanie_Wynik> dajTabliceWynikow(String zadaneZadanieId) {
		String SQL = " SELECT a.username,"
				    +"   sum(sz.bezblednie) as b, sum(sz.ukonczone) as u,"
				    +"   sum(sz.czas_bronze) as c1, sum(sz.czas_silver) as c2, sum(sz.czas_gold) as c3,"
				    +"   sum(sz.punkty_bronze) as w1, sum(sz.punkty_silver) as w2, sum(sz.punkty_gold) as w3,"
				    +"   max(sz.wynik)as mw, min(sz.czas) as mc,"
				    +"   count(s.id) as iloscPodejsc, sum(sz.ukonczone) as iloscZdanych"
				    +" FROM      zadane_zadanie_grupy zzg"
				    +" JOIN      account_grupa        ag   ON ag.grupa_id         = zzg.grupy"
				    +" JOIN      account_roles        ar   ON ar.account          = ag.account_id    "
				    +"                                    AND ar.roles            = 1 /* role - uczen */"
				    +" JOIN      account              a    ON a.id                = ag.account_id    "
				    +" LEFT JOIN sesja                s    ON s.zadane_zadanie_id = zzg.zadane_zadanie "
				    +"                                    AND s.uczen_id          = ag.account_id"
				    +" LEFT JOIN sesja_wynik          sz   ON sz.id               = s.zasady"
				    +" WHERE zzg.zadane_zadanie = ?"
				    +" GROUP BY a.username";
		List<ZadaneZadanie_Wynik> result = new ArrayList<ZadaneZadanie_Wynik>();
		List<Map<String,Object>> queryResult = jdbcTemplate.queryForList(
				SQL, new Object[] { zadaneZadanieId });

		ZadaneZadanie_Wynik zadWyn;
		
		if (!queryResult.isEmpty())
			for (Map<String, Object> row: queryResult) {
				zadWyn = new ZadaneZadanie_Wynik();
				zadWyn.setUsername(row.get("username").toString());
				fillZadStatsFromRow(zadWyn, row);
				result.add(zadWyn);
			}

		return result;
	}

	public List<ZadanieZadanie_Wynik_WithSkrot> dajSkroconeWyniki(String zadaneZadanieId) {
		List<ZadaneZadanie_Wynik> tablica            = dajTabliceWynikow(zadaneZadanieId);
		Map<String, List<Sesja_SkrotWynikow>> skroty = dajSzczegolyWynikow(zadaneZadanieId);
		List<ZadanieZadanie_Wynik_WithSkrot>  result = new ArrayList<ZadanieZadanie_Wynik_WithSkrot>();
		
		ZadanieZadanie_Wynik_WithSkrot skrot;
		
		for (ZadaneZadanie_Wynik wynik: tablica) {
			skrot = new ZadanieZadanie_Wynik_WithSkrot();
			skrot.fill(wynik);
			skrot.setUsername(wynik.getUsername());
			skrot.setSkroty_wynikow(skroty.get(skrot.getUsername()));
			result.add(skrot);
		}

		return result;
	}
	
	public Map<String, List<Sesja_SkrotWynikow>> dajSzczegolyWynikow(String zadaneZadanieId) {
		String SQL = " SELECT "
				    +"    a.id as accountId,"
					+"    a.username, "
					+"    s.id as sesjaId, "
					+"    s.dt_otwarcia, "
					+"    (s.dt_zamkniecia -s.dt_otwarcia) as len, "
					+"    sz.wynik"
					+" FROM sesja                s"
					+" JOIN account              a  ON a.id  = s.uczen_id"
					+" JOIN sesja_wynik          sz ON sz.id = s.zasady"
					+" WHERE s.dt_zamkniecia is NOT NULL" /* tylko zamkniete sesje */
					+"   AND s.zadane_zadanie_id = ?"
					+" ORDER BY s.dt_otwarcia";
		
		Map<String, List<Sesja_SkrotWynikow>> result = 
				new HashMap<String, List<Sesja_SkrotWynikow>>();
		List<Map<String,Object>> queryResult = jdbcTemplate.queryForList(
				SQL, new Object[] { zadaneZadanieId });
		
		Sesja_SkrotWynikow skrotWyn;
		List<Sesja_SkrotWynikow> lista;

		if (!queryResult.isEmpty())
			for (Map<String, Object> row: queryResult) {
				skrotWyn = new Sesja_SkrotWynikow(
						row.get("accountId"),
						row.get("username"),
						row.get("sesjaId"),
						row.get("dt_otwarcia"),
						row.get("len"),
						row.get("wynik"));
				
				lista = result.get(skrotWyn.getUsername());
				if (lista != null)
					lista.add(skrotWyn);
				else {
					lista = new ArrayList<Sesja_SkrotWynikow>();
					lista.add(skrotWyn);
					result.put(skrotWyn.getUsername(), lista);
				}
				skrotWyn.setLp(lista.size());
			}

		return result;
	}
	
	private void fillZadStatsFromRow(ZadaneZadanie_Stats zadStats, Map<String, Object> row) {
		zadStats.fill(row.get("mw"), row.get("mc"),
				      row.get("u" ), row.get("b" ), 
				      row.get("c1"), row.get("c2"), row.get("c3"),
				      row.get("w1"), row.get("w2"), row.get("w3"),
				      row.get("iloscPodejsc"), row.get("iloscZdanych"));
	}
}
