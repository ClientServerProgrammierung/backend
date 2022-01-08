package gateway;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class Gateway {

	protected final EntityManager manager;
	
	public Gateway() {
		manager = Helper.getManager();
	}
	
	public void update() {
		/**
		 * This method saves pending updates. Just run this method and every entity will be saved,
		 * that has been changed through their setters.
		 * */
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
	}
}
