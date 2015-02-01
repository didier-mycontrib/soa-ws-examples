package tp.miniBankWS.calcul;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/calculEmprunt/")
//@Produces("application/xml") //par defaut pour toutes les methodes de la classe
public class CalculEmpruntRestAdaptateur  {
	
	//serviceDevises (Spring) a injecter dans l'apadateur REST
	private CalculEmprunt calculEmprunt;

    //injection
	public void setCalculEmprunt(CalculEmprunt calculEmprunt) {
		this.calculEmprunt = calculEmprunt;
	}

	@GET
	@Path("/mensualite")
	// pour URL = http://localhost:8080/bankWS/services/rest/
                                //calculEmprunt/mensualite?montant=50000&nb_mois=240&taux_mens_pct=0.5
	@Produces("text/plain")
	public double getMensualite(@QueryParam("montant")double montant,
			                    @QueryParam("nb_mois") int nb_mois,
			                    @QueryParam("taux_mens_pct")double taux_mens_pct) {		
		return calculEmprunt.getMensualite(montant, nb_mois, taux_mens_pct);
	}

}
