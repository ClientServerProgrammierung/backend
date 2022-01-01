package model;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the benutzer database table.
 * 
 */
@Entity
@NamedQuery(name="Benutzer.findAll", query="SELECT b FROM Benutzer b")
public class Benutzer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="BENUTZER_ID_GENERATOR", sequenceName="BENUTZER_ID_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BENUTZER_ID_GENERATOR")
	private Integer id;

	private String adresse;

	private String email;
	private String password;

	@Temporal(TemporalType.DATE)
	private Date geburtstdatum;

	private String nachname;

	private String vorname;

	public Benutzer() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getGeburtstdatum() {
		return this.geburtstdatum;
	}

	public void setGeburtstdatum(Date geburtstdatum) {
		this.geburtstdatum = geburtstdatum;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}