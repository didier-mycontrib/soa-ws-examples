package tp.minibankWS.dao;

import java.util.List;

import tp.minibankWS.entity.PlageFraisDossier;

public interface FraisDossierDao {
	
	public List<PlageFraisDossier> getPlagesFraisDossier();
	public PlageFraisDossier getPlageFraisDossierSelonMontant(double montant);
    // + ...
}
