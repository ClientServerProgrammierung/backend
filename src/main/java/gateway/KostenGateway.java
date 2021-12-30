package gateway;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Fahrrad;
import model.Kosten;

public class KostenGateway extends Gateway {

	public List<Kosten> getAll() {
		TypedQuery<Kosten> query = manager.createQuery("SELECT k FROM kosten k", Kosten.class);
		
		List<Kosten> liste = query.getResultList();
		return liste;
	}

	public List<Kosten> getKostenByRahmennummer(String rahmennummer) {
		TypedQuery<Kosten> query = manager.createQuery("SELECT k FROM kosten k WHERE k.fahrradnummer= ?1", Kosten.class);
		query.setParameter(1, rahmennummer);
		
		return query.getResultList();
	}
	
	public void insertKosten(Kosten ... kosten) {
		manager.getTransaction().begin();
		for (Kosten k : kosten) {
			manager.persist(k);
		}
		manager.getTransaction().commit();
	}
	
	public void deleteKosten(Kosten ... kosten) {
		for (Kosten k : kosten) {
			manager.remove(k);
		}
	}
}
