package gateway;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
		TypedQuery<Fahrrad> query = manager.createQuery("SELECT f FROM Fahrrad f WHERE f.rahmennummer = ?1",
				Fahrrad.class);
		query.setParameter(1, rahmenNummer);

		return query.getResultList();
	}

	public void insertFahrrad(Fahrrad... fahrrad) {
		manager.getTransaction().begin();
		for (Fahrrad f : fahrrad) {
			manager.persist(f);
		}
		manager.getTransaction().commit();
	}

	public void deleteFahrrad(Fahrrad... fahrrad) {
		manager.getTransaction().begin();
		for (Fahrrad f : fahrrad) {
			manager.remove(f);
		}
		manager.getTransaction().commit();
	}

	public boolean fahrradIsGemietet(String rahmennummer, Date wunschDatum) {
		KostenGateway kostengateway = new KostenGateway();
		List<Kosten> kosten = kostengateway.getKostenByRahmennummer(rahmennummer);

		for (Kosten k : kosten) {
			Date date1 = wunschDatum;
			// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			// System.out.println("DATE1:" + formatter.format(date1));
			Date date2 = k.getDatum();
			Calendar c = Calendar.getInstance();
			c.setTime(date2);
			c.add(Calendar.DATE, k.getDauer());
			date2 = c.getTime();
			// System.out.println("DATE2:" + formatter.format(date2));
			long diffInMillies = date2.getTime() - date1.getTime();
			if (diffInMillies > 0) {
				return true;
			}
		}

		return false;
	}
}
