package gateway;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import model.Benutzer;

public class BenutzerGateway extends Gateway {

	public List<Benutzer> getAllBenutzer() {
		TypedQuery<Benutzer> query = manager.createQuery("SELECT f FROM Benutzer f", Benutzer.class);

		List<Benutzer> liste = query.getResultList();
		return liste;
	}

	public List<Benutzer> getBenutzerByEmail(String email) {
		try {
			TypedQuery<Benutzer> query = manager.createQuery("SELECT f FROM Benutzer f WHERE f.email = ?1",
					Benutzer.class);
			query.setParameter(1, email);
			return query.getResultList();
		} catch (PersistenceException ex) {
			return new ArrayList<Benutzer>();
		}
	}

	public void deleteBenutzer(Benutzer... benutzer) {
		for (Benutzer b : benutzer) {
			manager.remove(b);
		}
	}

	public void insertBenutzer(Benutzer benutzer) {
		try {
			TypedQuery<Benutzer> query = manager.createQuery("SELECT b FROM Benutzer b WHERE b.email = ?1",
					Benutzer.class);
			query.setParameter(1, benutzer.getEmail());
			if (query.getResultList().isEmpty()) {
				System.out.println("user DOES NOT exist.");
				System.out.println("create user:" + benutzer.getEmail());
				manager.getTransaction().begin();
				manager.persist(benutzer);
				manager.getTransaction().commit();
			}
		} catch (PersistenceException ex) {
			System.out.println(ex);
		}
	}

}
