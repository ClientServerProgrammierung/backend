package gateway;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Helper {

	protected static EntityManager getManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("backend"); // PU
		return factory.createEntityManager();
	}
}
