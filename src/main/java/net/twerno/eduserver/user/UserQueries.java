package net.twerno.eduserver.user;

import javax.persistence.TypedQuery;

import net.twerno.eduserver.user.entities.Grupa;

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
}
