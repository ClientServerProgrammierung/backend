package gateway;

import java.util.List;

import javax.persistence.TypedQuery;

import model.KostenArten;

public class KostenArtenGateway extends Gateway {
	public List<KostenArten> getAllKostenArten() {

		TypedQuery<KostenArten> query = manager.createQuery("SELECT f FROM kosten_arten f", KostenArten.class);

		List<KostenArten> liste = query.getResultList();
		return liste;
	}

	public KostenArten getKostenArtenById(Integer id) {
		KostenArten kostenarten = manager.find(KostenArten.class, id);
		return kostenarten;
	}

	public void insertKostenArten(KostenArten... kostenarten) {
		manager.getTransaction().begin();
		for (KostenArten k : kostenarten) {
			manager.persist(k);
		}
		manager.getTransaction().commit();
	}

	public void deleteKostenArten(KostenArten... kostenArten) {
		for (KostenArten k : kostenArten) {
			// manager.remove(manager.contains(k) ? k : manager.merge(k));
			manager.remove(k);
		}
	}

	public void updateKostenArten(KostenArten kostenArten) {
		manager.getTransaction().begin();
		manager.merge(kostenArten);
		manager.getTransaction().commit();
	}

}
