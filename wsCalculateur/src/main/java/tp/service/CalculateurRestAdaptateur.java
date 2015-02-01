package tp.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/calculateur/")
//@Produces("application/xml") //par defaut pour toutes les methodes de la classe
public class CalculateurRestAdaptateur  {
	
	//serviceDevises (Spring) a injecter dans l'apadateur REST
	private Calculateur calculateur;


	public void setCalculateur(Calculateur calculateur) {
		this.calculateur = calculateur;
	}

	@GET
	@Path("/addition")
	// pour URL = http://localhost:8080/tpWS/services/rest/
                                //calculateur/addition?a=5&b=6
	@Produces("text/plain")
	public double addition(@QueryParam("a")double a,@QueryParam("b") double b) {		
		return calculateur.addition(a, b);
	}

	@GET
	@Path("/multiplication")
	// pour URL = http://localhost:8080/tpWS/services/rest/
                    //calculateur/multiplication?a=5&b=6
	@Produces("text/plain")
	public double multiplication(@QueryParam("a")double a,@QueryParam("b") double b) {		
		return calculateur.multiplication(a, b);
	}

}
