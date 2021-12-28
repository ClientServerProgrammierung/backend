package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kosten database table.
 * 
 */
@Entity
@NamedQuery(name="Kosten.findAll", query="SELECT k FROM Kosten k")
public class Kosten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KOSTEN_ID_GENERATOR", sequenceName="KOSTEN_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KOSTEN_ID_GENERATOR")
	private Integer id;

	private Integer benutzer;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String fahrradnummer;

	private double hoehe;

	@Column(name="kosten_art")
	private Integer kostenArt;

	public Kosten() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBenutzer() {
		return this.benutzer;
	}

	public void setBenutzer(Integer benutzer) {
		this.benutzer = benutzer;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getFahrradnummer() {
		return this.fahrradnummer;
	}

	public void setFahrradnummer(String fahrradnummer) {
		this.fahrradnummer = fahrradnummer;
	}

	public double getHoehe() {
		return this.hoehe;
	}

	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}

	public Integer getKostenArt() {
		return this.kostenArt;
	}

	public void setKostenArt(Integer kostenArt) {
		this.kostenArt = kostenArt;
	}

}