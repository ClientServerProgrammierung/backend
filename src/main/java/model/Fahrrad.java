package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the fahrrad database table.
 * 
 */
@Entity
@NamedQuery(name="Fahrrad.findAll", query="SELECT f FROM Fahrrad f")
@XmlRootElement
public class Fahrrad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String rahmennummer;

	private String marke;

	private String model;

	public Fahrrad() {
	}

	public Fahrrad(String rahmennummer, String marke, String model) {
		this.rahmennummer = rahmennummer;
		this.marke = marke;
		this.model = model;
		
	}
	public String getRahmennummer() {
		return this.rahmennummer;
	}

	public void setRahmennummer(String rahmennummer) {
		this.rahmennummer = rahmennummer;
	}

	public String getMarke() {
		return this.marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public  List<Fahrrad> getFahrrader () {
		EntityManagerFactory factory = null;
		factory = Persistence.createEntityManagerFactory("shop");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Fahrrad> query = manager.createQuery("SELECT f FROM Fahrrad f", Fahrrad.class);
		List<Fahrrad> allFahrrader = query.getResultList();
		
		return allFahrrader;
		
	}

}