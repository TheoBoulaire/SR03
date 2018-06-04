package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the type_jante database table.
 * 
 */
@Entity
@Table(name="type_jante")
@NamedQuery(name="TypeJante.findAll", query="SELECT t FROM TypeJante t")
public class TypeJante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private BigDecimal diametre;

	private String matiere;

	private BigDecimal prix;

	//bi-directional many-to-many association to TypeFinition
	@ManyToMany
	@JoinTable(
		name="type_jante_type_finition"
		, joinColumns={
			@JoinColumn(name="type_jante_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="type_finition_id")
			}
		)
	private List<TypeFinition> typeFinitions;

	//bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy="typeJante")
	private List<Voiture> voitures;

	public TypeJante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getDiametre() {
		return this.diametre;
	}

	public void setDiametre(BigDecimal diametre) {
		this.diametre = diametre;
	}

	public String getMatiere() {
		return this.matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public List<TypeFinition> getTypeFinitions() {
		return this.typeFinitions;
	}

	public void setTypeFinitions(List<TypeFinition> typeFinitions) {
		this.typeFinitions = typeFinitions;
	}

	public List<Voiture> getVoitures() {
		return this.voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public Voiture addVoiture(Voiture voiture) {
		getVoitures().add(voiture);
		voiture.setTypeJante(this);

		return voiture;
	}

	public Voiture removeVoiture(Voiture voiture) {
		getVoitures().remove(voiture);
		voiture.setTypeJante(null);

		return voiture;
	}

}