package tp.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.data.Product;


/* java service  (with or without spring/jpa) */
public class ProductService {
	
private Map<Long,Product> mapProducts = new HashMap<Long,Product>();
private Long maxId;
	
	public ProductService(){
		mapProducts.put(1L,new Product(1L,"iphone 5C","very good smartphone (Apple)",600.0f));
		mapProducts.put(2L,new Product(2L,"galaxy S4 mini","good Android smartphone of Samsung with medium screen",280.0f));
		mapProducts.put(3L,new Product(3L,"ultym 5","cheap and good Android smartphone by Bougues-Telecom",115.0f));
		maxId=3L;
	}
	

	
	public List<Product> getAllProducts(){
		return new ArrayList<Product>( mapProducts.values());
	}
	
	public List<Product> getCheapProducts(Float maxPrice){
		List<Product> cheapProds  = new ArrayList<Product>();
		for(Product p : mapProducts.values())
			if( p.getPrice() <= maxPrice)
				cheapProds.add(p);
		return cheapProds;
	}
	
	
	public Product getProductById(Long id){
		return mapProducts.get(id);
	}
	

	public void updateProduct(Product p){
		mapProducts.put(p.getId(), p);
	}

	public Long addNewProduct(Product p){
		this.maxId++;//simulate auto_incr
		p.setId(this.maxId);
		mapProducts.put(p.getId(), p);
		return this.maxId;
	}
	

	public void deleteProduct(Long id){
		mapProducts.remove(id);
	}
	
	

	
}
