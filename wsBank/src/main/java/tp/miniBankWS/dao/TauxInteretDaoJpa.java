package tp.miniBankWS.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tp.miniBankWS.entity.PlageTauxInteret;
 
public class TauxInteretDaoJpa implements TauxInteretDao {

@PersistenceContext
private EntityManager entityManager;
	
	
	public PlageTauxInteret getPlageTauxInteretSelonDuree(int nb_mois) {
		List<PlageTauxInteret> plages = entityManager.createQuery("select p from PlageTauxInteret as p" +
		" where p.nb_mois_max >= " + nb_mois + " and p.nb_mois_min <= " +nb_mois).getResultList();;
		return plages.get(0);
	}

	public List<PlageTauxInteret> getPlagesTauxInteret() {
		return entityManager.createQuery("select p from PlageTauxInteret as p").getResultList();
	}

}
