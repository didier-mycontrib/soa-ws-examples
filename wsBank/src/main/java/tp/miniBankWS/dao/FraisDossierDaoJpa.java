package tp.minibankWS.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tp.minibankWS.entity.PlageFraisDossier;

public class FraisDossierDaoJpa implements FraisDossierDao {

@PersistenceContext
private EntityManager entityManager;
	
	
	public PlageFraisDossier getPlageFraisDossierSelonMontant(double montant) {
		List<PlageFraisDossier> plages = entityManager.createQuery("select p from PlageFraisDossier as p" +
		" where p.montant_max >= " + montant + " and p.montant_min <= " + montant).getResultList();
		return plages.get(0);
	}

	public List<PlageFraisDossier> getPlagesFraisDossier() {
		return entityManager.createQuery("select p from PlageFraisDossier as p").getResultList();
		
	}

}
