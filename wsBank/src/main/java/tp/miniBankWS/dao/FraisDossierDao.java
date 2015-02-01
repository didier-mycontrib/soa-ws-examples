package tp.miniBankWS.dao;

import java.util.List;

import tp.miniBankWS.entity.PlageFraisDossier;

public interface FraisDossierDao {
	
	public List<PlageFraisDossier> getPlagesFraisDossier();
	public PlageFraisDossier getPlageFraisDossierSelonMontant(double montant);
    // + ...
}
