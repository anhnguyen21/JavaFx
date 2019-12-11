package Productdto;

public class Productsdto{
	protected int id;
	protected String name;
	protected double price;
	protected int quantity;
	protected double total;
	public Productsdto() {
		super();
	}
	public Productsdto(String name, double price,int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity=quantity;
	}
	public Productsdto(int id, String name, double price,int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity=quantity;
	}
	public Productsdto(String name, double price,int quantity,double total) {
		super();
		this.name = name;
		this.price = price;
		this.quantity=quantity;
		this.total=total;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Productsdto(int id,int quantity) {
		super();
		this.id = id;
		this.quantity=quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	
}
