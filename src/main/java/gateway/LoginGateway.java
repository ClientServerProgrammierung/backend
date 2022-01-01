package gateway;

import javax.persistence.TypedQuery;

import model.Benutzer;


public class LoginGateway extends Gateway {
	public boolean IsLogged(Benutzer benutzer) {
	
		TypedQuery<Benutzer> query = manager.createQuery("SELECT b FROM Benutzer b WHERE b.email = ?1 and b.password =?2", Benutzer.class);
		query.setParameter(1, benutzer.getEmail());
		query.setParameter(2, benutzer.getPassword());
		if (query.getResultList().isEmpty()) {
			return false;
		}
		return true;
		
	}

}
