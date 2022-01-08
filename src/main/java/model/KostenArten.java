package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kosten_arten database table.
 * 
 */
@Entity
@Table(name="kosten_arten")
@NamedQuery(name="KostenArten.findAll", query="SELECT k FROM KostenArten k")
public class KostenArten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String beschreibung;
	
	private boolean isIncome;

	public KostenArten() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public boolean getIsIncome() {
	    return this.isIncome;
	}
	
	public void setIsIncome(boolean isIncome) {
	    this.isIncome = isIncome;
	}

}