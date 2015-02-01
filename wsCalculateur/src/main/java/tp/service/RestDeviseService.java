package tp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return mapDevises.values();
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
			return Response.status(Status.OK).build();
		}
		else return Response.status(Status.NOT_FOUND).build();
	}
	
	@POST
	@Path("/create")
	public Response addNewDevise(@FormParam("name")String name,@FormParam("change")double change){
		if(mapDevises.get(name)==null){
			mapDevises.put(name,new Devise(name,change));
			return Response.status(Status.OK).build();
		}
		else return Response.status(Status.CONFLICT).build();
	}
	
	@DELETE
	@Path("/delete/{name}")
	public Response deleteDevise(@PathParam("name")String name){
		if(mapDevises.get(name)!=null){
		    mapDevises.remove(name);
		    return Response.status(Status.OK).build();
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
