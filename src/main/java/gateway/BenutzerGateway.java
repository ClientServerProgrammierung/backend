package gateway;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.bouncycastle.util.encoders.Hex;

import model.Benutzer;
import model.KostenArten;

public class BenutzerGateway extends Gateway {

	public List<Benutzer> getAllBenutzer() {
		TypedQuery<Benutzer> query = manager.createQuery("SELECT f FROM Benutzer f", Benutzer.class);

		List<Benutzer> liste = query.getResultList();
		return liste;
	}

	public Benutzer getBenutzerByEmail(String email) {
		try {
			TypedQuery<Benutzer> query = manager.createQuery("SELECT f FROM Benutzer f WHERE f.email = ?1",
					Benutzer.class);
			query.setParameter(1, email);
			return query.getSingleResult();
		} catch (PersistenceException ex) {
			return new Benutzer();
		}
	}

	public Benutzer getBenutzerById(Integer id) {

		Benutzer benutzer = manager.find(Benutzer.class, id);
		if (benutzer == null) {
			throw new EntityNotFoundException("Can't find Benutzer for ID " + id);
		}
		return benutzer;

	}

	public void deleteBenutzer(Benutzer... benutzer) {
		for (Benutzer b : benutzer) {
			manager.remove(b);
		}
	}

	public void insertBenutzer(Benutzer benutzer) {
		try {
			TypedQuery<Benutzer> query = manager.createQuery("SELECT b FROM Benutzer b WHERE b.email = ?1",
					Benutzer.class);
			query.setParameter(1, benutzer.getEmail());
			if (query.getResultList().isEmpty()) {
				System.out.println("user DOES NOT exist.");
				System.out.println("create user:" + benutzer.getEmail());
				manager.getTransaction().begin();
				manager.persist(hashBenutzerPassword(benutzer));
				manager.getTransaction().commit();
			}
		} catch (PersistenceException ex) {
			System.out.println(ex);
		}
	}

	public Benutzer hashBenutzerPassword(Benutzer benutzer) {
		String passwordToHash = benutzer.getPassword();
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
			String sha256hex = new String(Hex.encode(hash));
            benutzer.setPassword(sha256hex);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return benutzer;
	}

	public void updateBenutzer(Benutzer benutzer) {
		manager.getTransaction().begin();
		manager.merge(benutzer);
		manager.getTransaction().commit();
	}

}
