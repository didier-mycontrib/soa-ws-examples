package tp.minibankWS.dao;

import java.util.List;

import tp.minibankWS.entity.PlageTauxInteret;

public interface TauxInteretDao {
	
	public List<PlageTauxInteret> getPlagesTauxInteret();
	public PlageTauxInteret getPlageTauxInteretSelonDuree(int nb_mois);
    // + ...
}
