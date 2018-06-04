package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the type_finition database table.
 * 
 */
@Entity
@Table(name="type_finition")
@NamedQuery(name="TypeFinition.findAll", query="SELECT t FROM TypeFinition t")
public class TypeFinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private BigDecimal prix;

	private String type;

	//bi-directional many-to-many association to Couleur
	@ManyToMany(mappedBy="typeFinitions")
	private List<Couleur> couleurs;

	//bi-directional many-to-many association to Modele
	@ManyToMany(mappedBy="typeFinitions")
	private List<Modele> modeles;

	//bi-directional many-to-many association to Motorisation
	@ManyToMany(mappedBy="typeFinitions")
	private List<Motorisation> motorisations;

	//bi-directional many-to-many association to OptionSup
	@ManyToMany(mappedBy="typeFinitions")
	private List<OptionSup> optionSups;

	//bi-directional many-to-many association to TypeJante
	@ManyToMany(mappedBy="typeFinitions")
	private List<TypeJante> typeJantes;

	//bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy="typeFinition")
	private List<Voiture> voitures;

	public TypeFinition() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Couleur> getCouleurs() {
		return this.couleurs;
	}

	public void setCouleurs(List<Couleur> couleurs) {
		this.couleurs = couleurs;
	}

	public List<Modele> getModeles() {
		return this.modeles;
	}

	public void setModeles(List<Modele> modeles) {
		this.modeles = modeles;
	}

	public List<Motorisation> getMotorisations() {
		return this.motorisations;
	}

	public void setMotorisations(List<Motorisation> motorisations) {
		this.motorisations = motorisations;
	}

	public List<OptionSup> getOptionSups() {
		return this.optionSups;
	}

	public void setOptionSups(List<OptionSup> optionSups) {
		this.optionSups = optionSups;
	}

	public List<TypeJante> getTypeJantes() {
		return this.typeJantes;
	}

	public void setTypeJantes(List<TypeJante> typeJantes) {
		this.typeJantes = typeJantes;
	}

	public List<Voiture> getVoitures() {
		return this.voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public Voiture addVoiture(Voiture voiture) {
		getVoitures().add(voiture);
		voiture.setTypeFinition(this);

		return voiture;
	}

	public Voiture removeVoiture(Voiture voiture) {
		getVoitures().remove(voiture);
		voiture.setTypeFinition(null);

		return voiture;
	}

}