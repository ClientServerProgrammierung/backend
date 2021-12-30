package gateway;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Fahrrad;
import model.Kosten;

public class FahrradGateway extends Gateway {
	
	public List<Fahrrad> getAll() {
		TypedQuery<Fahrrad> query = manager.createQuery("SELECT f FROM Fahrrad f", Fahrrad.class);
		
		List<Fahrrad> liste = query.getResultList();
		return liste;
	}
	
	public List<Fahrrad> getFahrradByMarke(String marke) {
		TypedQuery<Fahrrad> query = manager.createQuery("SELECT f FROM Fahrrad f WHERE f.marke = ?1", Fahrrad.class);
		query.setParameter(1, marke);
		
		return query.getResultList();
	}

	public List<Fahrrad> getFahrradByModel(String model) {
		TypedQuery<Fahrrad> query = manager.createQuery("SELECT f FROM Fahrrad f WHERE f.model = ?1", Fahrrad.class);
		query.setParameter(1, model);
		
		return query.getResultList();
	}
	
	public List<Fahrrad> getFahrradByNummer(String rahmenNummer) {
		TypedQuery<Fahrrad> query = manager.createQuery("SELECT f FROM Fahrrad f WHERE f.rahmennummer = ?1", Fahrrad.class);
		query.setParameter(1, rahmenNummer);
		
		return query.getResultList();
	}
	
	public void insertFahrrad(Fahrrad ... fahrrad) {
		manager.getTransaction().begin();
		for (Fahrrad f : fahrrad) {
			manager.persist(f);
		}
		manager.getTransaction().commit();
	}
	
	public void deleteFahrrad(Fahrrad ... fahrrad) {
		for (Fahrrad f : fahrrad) {
			manager.remove(f);
		}
	}
	
	public boolean fahrradIsGemietet(Fahrrad fahrrad, Date wunschDatum) {
		/*
		 * kann man auslaggern in servlet oder so
		 * */
		KostenGateway kostengateway = new KostenGateway();
		List<Kosten> kosten = kostengateway.getKostenByRahmennummer(fahrrad.getRahmennummer());

		for (Kosten k : kosten) {
			Date date1 = wunschDatum;
		    Date date2 = k.getDatum();
		    long diff = date2.getTime() - date1.getTime();
		    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		    if(diff - k.getDauer() <= 0) {
		        return true; 
		    }
		}
		
		return false;
	}
}
