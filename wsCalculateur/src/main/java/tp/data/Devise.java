package tp.data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "devise")
@XmlType(propOrder={"name", "change"})
public class Devise {

	private String name; //ex: "euro" , "dollar , "yen" 
	private double change; //change pour 1 dollar
	
	public Devise() {
		super();
	}
	public Devise(String name, double change) {
		super();
		this.name = name;
		this.change = change;
	}
	@Override
	public String toString() {
		return "Devise [name=" + name + ", change=" + change + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	
	

}
