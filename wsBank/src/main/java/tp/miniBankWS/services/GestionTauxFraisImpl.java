package tp.miniBankWS.services;

import javax.jws.WebService;

import tp.miniBankWS.dao.FraisDossierDao;
import tp.miniBankWS.dao.TauxInteretDao;
import tp.miniBankWS.entity.PlageFraisDossier;
import tp.miniBankWS.entity.PlageTauxInteret;

@WebService(endpointInterface="tp.miniBankWS.services.GestionTauxFrais")
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
