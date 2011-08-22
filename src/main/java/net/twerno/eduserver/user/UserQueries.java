package net.twerno.eduserver.user;

import javax.persistence.TypedQuery;

import net.twerno.eduserver.user.entities.Grupa;

public class UserQueries {
	
	public static boolean GrupaByNameExisits(String grupaName) {
		if (grupaName == null || grupaName.length() == 0) throw new IllegalArgumentException("The nazwa argument is required");
		TypedQuery<Long> q = Grupa.entityManager().createQuery("SELECT COUNT(o) FROM Grupa o WHERE o.nazwa = :nazwaGrupy", Long.class);
		q.setParameter("nazwaGrupy", grupaName);
		return q.getSingleResult() == 1;
	}
}
