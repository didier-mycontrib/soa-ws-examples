package tp.minibankWS.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_FraisDossier")
public class PlageFraisDossier {
	@Id
	private int num_plage;
    private int montant_min;
    private int montant_max;
    private double frais;
    
    
    public int getMontant_min() {
		return montant_min;
	}
	public void setMontant_min(int montant_min) {
		this.montant_min = montant_min;
	}

	
    
	public int getNum_plage() {
		return num_plage;
	}
	public void setNum_plage(int num_plage) {
		this.num_plage = num_plage;
	}
	public int getMontant_max() {
		return montant_max;
	}
	public void setMontant_max(int montant_max) {
		this.montant_max = montant_max;
	}
	public double getFrais() {
		return frais;
	}
	public void setFrais(double frais) {
		this.frais = frais;
	}
	
	@Override
	public String toString() {
		
		return "plage_frais_dossier:" + this.num_plage + "," 
		+ this.montant_min+ ","+ this.montant_max+ "," + this.frais;
	}
	
    
}
