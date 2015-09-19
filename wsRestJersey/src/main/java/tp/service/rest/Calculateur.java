package tp.service.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


/**
 * 
 * @author formation
 * Services REST basic (calculateur)
 *
 */
@Api(value = "/calculateur")
@Path("/calculateur/")
//@Produces("application/xml") //par defaut pour toutes les methodes de la classe
public class Calculateur {

	@ApiOperation(value = "addition(a,b) with end of url like addition?a=5&b=6",
			 notes = "Returns result of addition",
			 response = Double.class)
	@GET
	@Path("/addition")
	// pour URL = http://localhost:8080/wsRestJersey/services/rest/
                                //calculateur/addition?a=5&b=6
	@Produces("text/plain")
	public double addition(@QueryParam("a")double a,@QueryParam("b") double b) {		
		return a+b;
	}

	@GET
	@Path("/multiplication")
	// pour URL = http://localhost:8080/wsRestJersey/services/rest/
                    //calculateur/multiplication?a=5&b=6
	@Produces("text/plain")
	public double multiplication(@QueryParam("a")double a,@QueryParam("b") double b) {		
		return a*b;
	}
	
	//******************************************

		@GET
		@Path("/euroToFranc/{montant}")
		// pour URL = http://localhost:8080/wsRestJersey/services/rest/
	                                //calculateur/euroToFranc/15
		@Produces("text/plain")
		public double euroToFranc(@PathParam("montant")double montant){
			return montant * 6.55957;
		}
		
		@GET
		@Path("/francToEuro/{montant}")
		// pour URL = http://localhost:8080/wsRestJersey/services/rest/
	                                //calculateur/euroToFranc/15
		@Produces("text/plain")
		public double francToEuro(@PathParam("montant")double montant){
			return montant / 6.55957;
		}

	
}
