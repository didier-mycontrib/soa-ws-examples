package tp.service.rest;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import tp.data.Product;


@Path("/products/")
public class ProductRestService {
	
private Map<Long,Product> mapProducts = new HashMap<Long,Product>();
	
	public ProductRestService(){
		mapProducts.put(1L,new Product(1L,"iphone 5C","very good smartphone (Apple)"));
		mapProducts.put(2L,new Product(2L,"galaxy S4 mini","good Android smartphone of Samsung with medium screen"));
		mapProducts.put(3L,new Product(3L,"ultym 5","cheap and good Android smartphone by Bougues-Telecom"));
	}
	

	@GET
	@Path("/all")
	// pour URL = http://localhost:8080/wsRestJersey/services/rest/products/all
	@Produces("application/xml")
	public Collection<Product> getAllProducts(){
		return mapProducts.values();
	}
	
	@GET
	@Path("/allJson")
	// pour URL = http://localhost:8080/wsRestJersey/services/rest/products/allJson
	@Produces("application/json")
	public List<Product> getAllProductsJson(){
		return new ArrayList<Product>(mapProducts.values());
	}
	
	@GET
	@Path("/byId/{id}")
	// pour URL = http://localhost:8080/wsRestJersey/services/rest/products/byId/2
	@Produces("application/xml")
	public Product getDeviseById(@PathParam("id")Long id){
		return mapProducts.get(id);
	}
	
	@GET
	@Path("/byIdJson/{id}")
	// pour URL = http://localhost:8080/wsRestJersey/services/rest/products/byIdJson/1
	@Produces("application/json")
	public Product getDeviseByNameJson(@PathParam("id")Long id){
		return mapProducts.get(id);
	}
	
	/*
	@PUT
	@Path("/update")
	public Response updateDeviseChange(@FormParam("name")String name,@FormParam("change")double newChange){
		Product devise = mapDevises.get(name);
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
	*/
	

	
}
