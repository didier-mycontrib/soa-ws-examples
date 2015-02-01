package tp.minibankWS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_TauxInterets")
public class PlageTauxInteret {
	@Id
    private int num_plage;
    private int nb_mois_min;
    private int nb_mois_max;
    
    @Column(name="taux_mens")
    private double taux_mensuel;
    
    @Override
	public String toString() {
		
		return "plage_taux_interet:" + this.num_plage + "," 
		+this.nb_mois_min+ "," + this.nb_mois_max+ "," + this.taux_mensuel;
	}
    
	public int getNb_mois_min() {
		return nb_mois_min;
	}

	public void setNb_mois_min(int nb_mois_min) {
		this.nb_mois_min = nb_mois_min;
	}

	public int getNum_plage() {
		return num_plage;
	}
	public void setNum_plage(int num_plage) {
		this.num_plage = num_plage;
	}
	public int getNb_mois_max() {
		return nb_mois_max;
	}
	public void setNb_mois_max(int nb_mois_max) {
		this.nb_mois_max = nb_mois_max;
	}
	public double getTaux_mensuel() {
		return taux_mensuel;
	}
	public void setTaux_mensuel(double taux_mensuel) {
		this.taux_mensuel = taux_mensuel;
	}
    
    
}
