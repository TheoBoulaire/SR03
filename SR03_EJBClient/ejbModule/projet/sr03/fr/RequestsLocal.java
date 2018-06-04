package projet.sr03.fr;

import java.util.List;

import javax.ejb.Local;

import model.Couleur;
import model.Motorisation;
import model.OptionSup;
import model.Voiture;

@Local
public interface RequestsLocal {
	public void deleteCouleur(Integer cId);
	public String getCouleurOfVoiture(Integer vId);
	public List<String> getMotorisations();
	public List<Couleur> getCouleurs();
	public Couleur getCouleurOfId(Integer cId);
	public Long countMotorisations();
	public List<OptionSup> getOptionSupForVoiture(Integer voitureId);
}
