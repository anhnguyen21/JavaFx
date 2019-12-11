package Productdto;

public class ManagerProductsdto{
	protected int id;
	protected String nameCus;
	protected String address;
	protected String phone;
	protected String name;
	protected double price;
	protected int quantity;
	protected double total;
	public ManagerProductsdto() {
		super();
	}
	public ManagerProductsdto(String nameCus, String address, String phone, String name, double price, int quantity,double total) {
		super();
		this.nameCus = nameCus;
		this.address = address;
		this.phone = phone;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public ManagerProductsdto(int id, String nameCus, String address, String phone, String name, double price,
			int quantity,double total) {
		super();
		this.id = id;
		this.nameCus = nameCus;
		this.address = address;
		this.phone = phone;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getNameCus() {
		return nameCus;
	}
	public void setNameCus(String nameCus) {
		this.nameCus = nameCus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
