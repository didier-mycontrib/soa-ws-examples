package tp.miniBankWS.dao;

import java.util.List;

import tp.miniBankWS.entity.PlageTauxInteret;

public interface TauxInteretDao {
	
	public List<PlageTauxInteret> getPlagesTauxInteret();
	public PlageTauxInteret getPlageTauxInteretSelonDuree(int nb_mois);
    // + ...
}
