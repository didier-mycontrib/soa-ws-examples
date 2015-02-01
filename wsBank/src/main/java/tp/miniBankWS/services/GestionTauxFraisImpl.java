package tp.minibankWS.services;

import javax.jws.WebService;

import tp.minibankWS.dao.FraisDossierDao;
import tp.minibankWS.dao.TauxInteretDao;
import tp.minibankWS.entity.PlageFraisDossier;
import tp.minibankWS.entity.PlageTauxInteret;

@WebService(endpointInterface="tp.minibankWS.services.GestionTauxFrais")
public class GestionTauxFraisImpl implements GestionTauxFrais {

	FraisDossierDao fraisDossierDao = null;
	TauxInteretDao tauxInteretDao=null;
	

	public void setFraisDossierDao(FraisDossierDao fraisDossierDao) {
		this.fraisDossierDao = fraisDossierDao;
	}

	public void setTauxInteretDao(TauxInteretDao tauxInteretDao) {
		this.tauxInteretDao = tauxInteretDao;
	}

	public double getFraisDossier(double montant) {
		PlageFraisDossier p = 
			  fraisDossierDao.getPlageFraisDossierSelonMontant(montant);
		return p.getFrais();
	}

	public double getTauxInteretCourant(int nb_mois) {
		PlageTauxInteret p = 
			 tauxInteretDao.getPlageTauxInteretSelonDuree(nb_mois);
		return p.getTaux_mensuel();
	}

}
