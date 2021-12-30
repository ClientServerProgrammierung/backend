package gateway;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Benutzer;


public class BenutzerGateway extends Gateway {
	

	public List<Benutzer> getAllBenutzer() {
		TypedQuery<Benutzer> query = manager.createQuery("SELECT f FROM Benutzer f", Benutzer.class);
		
		List<Benutzer> liste = query.getResultList();
		return liste;
	}
	
	public List<Benutzer> getBenutzerByEmail(String email) {
		TypedQuery<Benutzer> query = manager.createQuery("SELECT f FROM Benutzer f WHERE f.email = ?1", Benutzer.class);
		query.setParameter(1, email);
		
		return query.getResultList();
	}
	
	public void deleteBenutzer(Benutzer ... benutzer) {
		for (Benutzer b : benutzer) {
			manager.remove(b);
		}
	}
	
	public void insertBenutzer(Benutzer ... benutzer) {
		manager.getTransaction().begin();
		for (Benutzer b : benutzer) {
			manager.persist(b);
		}
		manager.getTransaction().commit();
	}
	


}
