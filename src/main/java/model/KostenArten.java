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
	//@SequenceGenerator(name="KOSTEN_ARTEN_ID_GENERATOR", sequenceName="KOSTEN_ARTEN_ID_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KOSTEN_ARTEN_ID_GENERATOR")
	private Integer id;

	private String beschreibung;

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

}