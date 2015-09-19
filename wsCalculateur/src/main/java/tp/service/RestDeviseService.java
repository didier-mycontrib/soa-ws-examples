package tp.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tp.data.Devise;

/**
 * 
 * @author formation
 * Services REST pour gérer des devises (monnaie avec taux de change)
 *
 * NB: cette classe mélange un peu tout (xml , json , text/plain) pour techniquement montrer un peu de tout
 * sur un vrai projet d'entreprise ---> plusieurs classes plus homogènes .
 *
 */
@Api(value = "/devises/")
@Path("/devises/")
//@Produces("application/xml") //par defaut pour toutes les methodes de la classe
public class RestDeviseService {
	
	private Map<String,Devise> mapDevises = new HashMap<String,Devise>();
	
	public RestDeviseService(){
		mapDevises.put("dollar",new Devise("dollar",1.0));
		mapDevises.put("euro",new Devise("euro",0.8));
		mapDevises.put("livre",new Devise("livre",0.7));
		mapDevises.put("yen",new Devise("yen",125));
	}
	
	@GET
	@Path("/all")
	// pour URL = http://localhost:8080/wsCalculateur/services/rest/devises/all
	@Produces("application/xml")
	public Collection<Devise> getAllDevises(){
		Collection<Devise> listeDev = mapDevises.values();
		System.out.println("RestDeviseService.getAllDevises() retun " + listeDev);
		return listeDev;
	}
	
	@GET
	@Path("/allJson")
	// pour URL = http://localhost:8080/wsCalculateur/services/rest/devises/allJson
	@Produces("application/json")
	public List<Devise> GlobalJsonResponse(){
		return new ArrayList<Devise>(mapDevises.values());
	}
	
	@GET
	@Path("/byName/{name}")
	// pour URL = http://localhost:8080/wsCalculateur/services/rest/devises/byName/euro
	@Produces("application/xml")
	@ApiOperation(value = "Find Devise by name",
	 notes = "Returns a Devise",
	 response = Devise.class)
	public Devise getDeviseByName(@PathParam("name")String name){
		return mapDevises.get(name);
	}
	
	@GET
	@Path("/byNameJson/{name}")
	// pour URL = http://localhost:8080/wsCalculateur/services/rest/devises/byNameJson/euro
	@Produces("application/json")
	public Devise getDeviseByNameJson(@PathParam("name")String name){
		return mapDevises.get(name);
	}
	
	@PUT
	@Path("/update")
	public Response updateDeviseChange(@FormParam("name")String name,@FormParam("change")double newChange){
		Devise devise = mapDevises.get(name);
		if(devise!=null){
			devise.setChange(newChange);
			return Response.status(Status.OK).entity("mise a jour effectuee").build();
		}
		else return Response.status(Status.NOT_FOUND).build();
	}
	
	@PUT
	@Path("/updateFromJson")
	@Consumes("application/json")
	public Response updateDeviseChangeFromJson(Devise d){
		Devise existingDevise = mapDevises.get(d.getName());
		if(existingDevise!=null){
			existingDevise.setChange(d.getChange());
			String result="devise " + d.getName() + "update with new change: " + existingDevise.getChange();
			return Response.status(Status.OK).entity(result).build();
		}
		else return Response.status(Status.NOT_FOUND).build();
	}
	
	@POST
	@Path("/create")
	public Response addNewDevise(@FormParam("name")String name,@FormParam("change")double change){
		if(mapDevises.get(name)==null){
			mapDevises.put(name,new Devise(name,change));
			return Response.status(Status.OK).entity("ajout enregistre").build();
		}
		else return Response.status(Status.CONFLICT).build();
	}
	
	@POST
	@Path("/createFromJson")
	@Consumes("application/json")
	public Response addNewDeviseFromJson(Devise devise){
		
		if(mapDevises.get(devise.getName())==null){
			mapDevises.put(devise.getName(),devise);
			String result="devise " + devise.getName() + "saved";
			return Response.status(Status.OK).entity(result).build();
		}
		else return Response.status(Status.CONFLICT).build();
	}
	
	@DELETE
	@Path("/delete/{name}")
	public Response deleteDevise(@PathParam("name")String name){
		if(mapDevises.get(name)!=null){
		    mapDevises.remove(name);
		    return Response.status(Status.OK).entity("suppresion effectuee").build();
		}
		else return Response.status(Status.NOT_FOUND).build();
	}
	
	//******************************************

	@GET
	@Path("/euroToFranc/{montant}")
	// pour URL = http://localhost:8080/wsCalculateur/services/rest/
                                //devises/euroToFranc/15
	@Produces("text/plain")
	public double euroToFranc(@PathParam("montant")double montant){
		return montant * 6.55957;
	}
	
	@GET
	@Path("/francToEuro/{montant}")
	// pour URL = http://localhost:8080/wsCalculateur/services/rest/
                                //devises/euroToFranc/15
	@Produces("text/plain")
	public double francToEuro(@PathParam("montant")double montant){
		return montant / 6.55957;
	}
}
