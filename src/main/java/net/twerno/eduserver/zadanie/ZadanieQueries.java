package net.twerno.eduserver.zadanie;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;

@Component
public class ZadanieQueries {

	private JdbcTemplate jt;
	

	
	public static List<ZadaneZadanie> dajZadaneMi(Account account) {
//		
//		System.out.println(dataSource);
		
		String SQL = " SELECT z" 
	                +" FROM      account_grupa        a" 
					+" LEFT JOIN zadane_zadanie_grupy zzg"
					+" LEFT JOIN zadane_zadanie       z"
					+" WHERE "
					+"  a.account_id = :account_id AND"
					+" zzg.grupy    = a.grupa_id AND" 
					+" z.id         = zzg.zadane_zadanie";
		TypedQuery<ZadaneZadanie> q = ZadaneZadanie.entityManager().createQuery(SQL, ZadaneZadanie.class);
		q.setParameter("account_id", account.getId());
		return q.getResultList();
	}
}
