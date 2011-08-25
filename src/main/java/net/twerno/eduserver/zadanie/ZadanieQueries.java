package net.twerno.eduserver.zadanie;

import java.util.List;

import javax.persistence.TypedQuery;

import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;

public class ZadanieQueries {

	public static List<ZadaneZadanie> dajZadaneMi(Account account) {
		String SQL = " SELECT z.*" 
	                +" FROM      account_grupy        a" 
					+" LEFT JOIN zadane_zadanie_grupy zzg ON zzg.grupy = a.grupy"
					+" LEFT JOIN zadane_zadanie       z   ON z.id      = zzg.zadane_zadanie"
					+" WHERE a.account = :account_id;";
		TypedQuery<ZadaneZadanie> q = ZadaneZadanie.entityManager().createQuery(SQL, ZadaneZadanie.class);
		q.setParameter("account_id", account.getId());
		return q.getResultList();
	}
	
}
