package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleDoubleProperty price;
	private SimpleIntegerProperty quantity;
	private SimpleDoubleProperty total;
	
	public Product(Integer id,String name,Double price,Integer quantity)
	{
		this.id = new SimpleIntegerProperty(id);
		this.name =new SimpleStringProperty(name);
		this.price =new SimpleDoubleProperty(price);
		this.quantity =new SimpleIntegerProperty(quantity);
	}
	public Product(String name,Double price,Integer quantity)
	{
		this.name =new SimpleStringProperty(name);
		this.price =new SimpleDoubleProperty(price);
		this.quantity =new SimpleIntegerProperty(quantity);
	}
	public Product(String name,Double price,Integer quantity,Double total)
	{
		this.name =new SimpleStringProperty(name);
		this.price =new SimpleDoubleProperty(price);
		this.quantity =new SimpleIntegerProperty(quantity);
		this.total=new SimpleDoubleProperty(total);
	}
	
	public Product() {
		
		this.id = new SimpleIntegerProperty();
		this.name =new SimpleStringProperty();
		this.price =new SimpleDoubleProperty();
		this.quantity =new SimpleIntegerProperty();
		this.total=new SimpleDoubleProperty();
	}
	public Integer getId() {
		return this.id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}
	public String getName() {
		return this.name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public Double getPrice() {
		return this.price.get();
	}

	public void setPrice(Double price) {
		this.price.set(price);
	}
	public Integer getQuantity() {
		return this.quantity.get();
	}

	public void setQuantity(Integer price) {
		this.quantity.set(price);
	}
	public Double getTotal() {
		return this.total.get();
	}

	public void setTotal(Double total) {
		this.total.set(total);
	}
}
