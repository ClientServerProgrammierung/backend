package gateway;

import java.util.List;
import javax.persistence.TypedQuery;
import model.Kosten;

public class KostenGateway extends Gateway {

	public List<Kosten> getAll() {
		TypedQuery<Kosten> query = manager.createQuery("SELECT k FROM Kosten k", Kosten.class);
		
		List<Kosten> liste = query.getResultList();
		return liste;
	}

	public List<Kosten> getKostenByRahmennummer(String fahrradnummer) {
		TypedQuery<Kosten> query = manager.createQuery("SELECT k FROM Kosten k WHERE k.fahrradnummer= ?1", Kosten.class);
		query.setParameter(1, fahrradnummer);
		
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
		manager.getTransaction().begin();
		for (Kosten k : kosten) {
			manager.remove(k);
		}
		manager.getTransaction().commit();
	}
}
