package gateway;

import javax.persistence.EntityManager;

public abstract class Gateway {

	protected final EntityManager manager;
	
	public Gateway() {
		manager = Helper.getManager();
	}
}
