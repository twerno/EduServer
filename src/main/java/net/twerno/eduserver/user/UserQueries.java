package net.twerno.eduserver.user;

import javax.persistence.TypedQuery;

import net.twerno.eduserver.helpers.HibernateHelper;
import net.twerno.eduserver.user.entity.Grupa;

import org.hibernate.Session;

public class UserQueries {
	
	public static boolean GrupaByNameExisits(String grupaName) {
		if (grupaName == null || grupaName.length() == 0) throw new IllegalArgumentException("The nazwa argument is required");
		TypedQuery<Long> q = Grupa.entityManager().createQuery("SELECT COUNT(o.nazwa) FROM Grupa o WHERE o.nazwa = :nazwaGrupy", Long.class);
		q.setParameter("nazwaGrupy", grupaName);
		return q.getSingleResult() == 1;
	}
	
	public static boolean UserByNameExisits(String username) {
		if (username == null || username.length() == 0) throw new IllegalArgumentException("The nazwa argument is required");
		TypedQuery<Long> q = Grupa.entityManager().createQuery("SELECT COUNT(o.username) FROM Account o WHERE o.username = :username", Long.class);
		q.setParameter("username", username);
		return q.getSingleResult() == 1;
	}
	
	
	public static void deleteGrupa(long grupaID) throws Exception {
		String SQL_1 = "delete from account_grupy where grupy = :grupaId";
		String SQL_2 = "delete from grupa where id = :grupaId";
		
//		getHi
//		
//		HibernateTemplate t = HibernateTempl
//		org.springframework.orm.hibernate3.
		
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();// .getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.createSQLQuery(SQL_1).setParameter("grupaId", grupaID).executeUpdate();
			session.createSQLQuery(SQL_2).setParameter("grupaId", grupaID).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}
}
