package tp.miniBankWS.calcul;

import javax.jws.WebService;

@WebService(endpointInterface="tp.miniBankWS.calcul.CalculEmprunt")
public class CalculEmpruntImpl implements CalculEmprunt {

	public double getMensualite(double montant, int nb_mois,
			double taux_mens_pct) {
		double tauxMensuel = taux_mens_pct / 100;
		double mens = montant * tauxMensuel / (1 - Math.pow(1.0 + tauxMensuel,-nb_mois));
		return mens;
	}

}
