package tp.minibankWS.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/gestionTauxFrais/")
//@Produces("application/xml") //par defaut pour toutes les methodes de la classe
public class GestionTauxFraisRestAdaptateur  {
	
	//serviceDevises (Spring) a injecter dans l'apadateur REST
	private GestionTauxFrais gestionTauxFrais;

    //injection
	public void setGestionTauxFrais(GestionTauxFrais gestionTauxFrais) {
		this.gestionTauxFrais = gestionTauxFrais;
	}

	@GET
	@Path("/tauxInteretCourant")
	// pour URL = http://localhost:8080/bankWS/services/rest/
                                //gestionTauxFrais/tauxInteretCourant?nb_mois=240
	@Produces("text/plain")
	public double getTauxInteretCourant(@QueryParam("nb_mois")int nb_mois) {		
		return gestionTauxFrais.getTauxInteretCourant(nb_mois);
	}

	@GET
	@Path("/fraisDossier")
	// pour URL = http://localhost:8080/bankWS/services/rest/
                                //gestionTauxFrais/fraisDossier?montant=50000
	@Produces("text/plain")
	public double getFraisDossier(@QueryParam("montant")double montant){
		return gestionTauxFrais.getFraisDossier(montant);
	}
	

}
