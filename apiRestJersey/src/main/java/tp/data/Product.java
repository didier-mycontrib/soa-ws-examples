package tp.data;


public class Product {
	
	private Long id;
	private String name;
	private String label;
	private Double price;
	
	

	public Product(Long id, String name, String label) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.price = 1.0;
	}
	
	public Product(Long id, String name, String label,Double price) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.price = price;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", label=" + label
				+ ", price=" + price + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
