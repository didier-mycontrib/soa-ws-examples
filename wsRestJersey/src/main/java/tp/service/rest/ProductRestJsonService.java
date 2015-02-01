package tp.service.rest;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tp.data.Product;
import tp.service.ProductService;


@Path("/json/products")
@Produces("application/json")
public class ProductRestJsonService {
	
	/* attention , Jersey ne semble pas gérer automatiquement de singleton sur cette classe (via config simple du servlet)
	 * ---> besoin de déclarer prodService en static dans cette simulation
	 */
	
    private static ProductService prodService = new ProductService();//may be injected by spring
	
	/*
	@GET
	@Path("/")
	// pour URL = http://localhost:8080/wsRestJersey/services/rest/json/products/
	public List<Product> getAllProductsJson(){
		System.out.println("getAllProductsJson()");
		return prodService.getAllProducts();
	}
	====> now replaced by getProductsByCriteria() with null or non null @QueryParam() criteria
	*/
	
	
	@GET
	@Path("/{id}")
	// pour URL = http://localhost:8080/wsRestJersey/services/rest/json/products/1
	public Product getProductById(@PathParam("id")Long id){
		//System.out.println("getProductById() , id:"+id );
		return prodService.getProductById(id);
	}
	
	@GET
	//@Path("/withMaxPrice/{maxPrice}")
	//public List<Product> getCheapProducts(@PathParam("maxPrice")Float maxPrice){
	@Path("/")
	// pour URL = http://localhost:8080/wsRestJersey/services/rest/json/products
	// ou bien http://localhost:8080/wsRestJersey/services/rest/json/products?maxPrice=300 (maxPrice may be null)
	public List<Product> getProductsByCriteria(@QueryParam(value="maxPrice")Float maxPrice){
		System.out.println("getProductsByCriteria() , maxPrice:"+maxPrice );
		if(maxPrice==null)
			return prodService.getAllProducts();
		else
		return prodService.getCheapProducts(maxPrice);
	}
	@PUT
	@Path("/{id}")
	public Product updateProduct(@PathParam("id")Long id,Product p){
		System.out.println("updateProduct()with id="+ id+" and p = " + p);
		prodService.updateProduct(p);
		return p; //or return status ?
	}
	
	@POST
	@Path("/{id}")
	//par défaut , l'objet p est passé comme un seul bloc (en mode json) dans le corps/body de la requete
	//exemple:  { id: 1 , name='xxx' , label='yyy' , ...} 
	//POST --> save/create or saveOrUpdate
	public Product saveOrUpdateProduct(@PathParam("id")Long id,Product p){
		System.out.println("saveOrUpdateProduct() with id="+ id+" and p = " + p );
		if(id!=null && id.equals(p.getId())){
			if(!p.getId().equals(0L))
			   prodService.updateProduct(p);
		}
		else{
		Long newId= prodService.addNewProduct(p);
		p.setId(newId);
		}
		return p;
	}
	
	
	
	@DELETE
	@Path("/{id}")
	public Response deleteProduct(@PathParam("id")Long id){
		System.out.println("deleteProduct() with id="+ id);
		Product p = prodService.getProductById(id);
		if(p!=null){
			prodService.deleteProduct(id);		
		    return Response.status(Status.OK).build();
		}
		else return Response.status(Status.NOT_FOUND).build();
	}
	
	

	
}
