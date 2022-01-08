package model;

import java.io.Serializable;

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

}