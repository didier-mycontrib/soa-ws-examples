package tp.rest;


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


@Path("/product")
@Produces("application/json")
public class ProductRestJsonService {
	
	/* attention , Jersey ne semble pas gérer automatiquement de singleton sur cette classe (via config simple du servlet)
	 * ---> besoin de déclarer prodService en static dans cette simulation
	 */
	
    private static ProductService prodService = new ProductService();//may be injected with framework (cdi, ...)
	

		
	@GET
	@Path("/{id}")
	// pour URL = http://localhost:8080/apiRestJersey/my-rest-api/product/1
	public Product getProductById(@PathParam("id")Long id){
		//System.out.println("getProductById() , id:"+id );
		return prodService.getProductById(id);
	}
	
	@GET
	@Path("/")
	// pour URL = http://localhost:8080/apiRestJersey/my-rest-api/product
	// ou bien http://localhost:8080/apiRestJersey/my-rest-api/product?maxPrice=300 (maxPrice may be null)
	public List<Product> getProductsByCriteria(@QueryParam(value="maxPrice")Double maxPrice){
		System.out.println("getProductsByCriteria() , maxPrice:"+maxPrice );
		if(maxPrice==null)
			return prodService.getAllProducts();
		else
		     return prodService.getCheapProducts(maxPrice);
	}
	
	
	
	
	@POST
	@Path("/")
	// pour URL = http://localhost:8080/apiRestJersey/my-rest-api/product
	//par défaut , l'objet p est passé comme un seul bloc (en mode json) dans le corps/body de la requete
	//exemple:  { id: 1 , name='xxx' , label='yyy' , ...} 
	//POST --> save
	public Product saveProduct(Product p){
		System.out.println("saveProduct() with and p = " + p );
		Long newId= prodService.addNewProduct(p);
		p.setId(newId);
		return p;
	}
	
	
		@PUT
		@Path("/{id}")
		// pour URL = http://localhost:8080/apiRestJersey/my-rest-api/product/3
		public Product updateProduct(@PathParam("id")Long id,Product p){
			if(p.getId()==null) {
				p.setId(id);
			}
			System.out.println("updateProduct()with id="+ id+" and p = " + p);
			prodService.updateProduct(p);
			return p; //or return status ?
		}
	
	@DELETE
	@Path("/{id}")
    // pour URL = http://localhost:8080/apiRestJersey/my-rest-api/product/1
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
