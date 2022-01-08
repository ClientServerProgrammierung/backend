package gateway;

import java.util.List;
import javax.persistence.TypedQuery;

import model.KostenArten;

public class KostenArtenGateway extends Gateway {


	public List<KostenArten> getAll() {
		TypedQuery<KostenArten> query = manager.createQuery("SELECT k FROM KostenArten k", KostenArten.class);
		
		List<KostenArten> liste = query.getResultList();
		return liste;
	}
	
	public KostenArten getById(Integer id) throws Exception {
		TypedQuery<KostenArten> query = manager.createQuery("SELECT k FROM KostenArten k WHERE k.id= ?1", KostenArten.class);
		query.setParameter(1, id);
		
		return query.getResultList().stream()
				.findAny()
				.orElseThrow(() -> new Exception("Not exactly 1 found."));
	}
	
	public void insertKostenArten(KostenArten ... arten) {
		manager.getTransaction().begin();
		for (KostenArten k : arten) {
			manager.persist(k);
		}
		manager.getTransaction().commit();
	}

	

	public void updateKostenArten(KostenArten kostenArten) {
		manager.getTransaction().begin();
		manager.merge(kostenArten);
		manager.getTransaction().commit();
	}


	public void deleteKosten(KostenArten ... arten) {
		manager.getTransaction().begin();
		for (KostenArten k : arten) {
			manager.remove(k);
		}
		manager.getTransaction().commit();
	}

}
