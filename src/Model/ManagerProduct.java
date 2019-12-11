package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ManagerProduct {
	private SimpleIntegerProperty id;
	private SimpleStringProperty nameCus;
	private SimpleStringProperty address;
	private SimpleStringProperty phone;
	private SimpleStringProperty namePro;
	private SimpleDoubleProperty price;
	private SimpleStringProperty birthday;
	private SimpleIntegerProperty quantity;
	private SimpleDoubleProperty total;
	public ManagerProduct(Integer id, String nameCus, String address,
			String phone, String namePro, Double price,
			String birthday,Integer quantity, Double total) {
		this.id = new SimpleIntegerProperty(id);
		this.nameCus =new SimpleStringProperty(nameCus);
		this.address =new SimpleStringProperty(address);
		this.phone =new SimpleStringProperty(phone);
		this.namePro =new SimpleStringProperty(namePro);
		this.price = new SimpleDoubleProperty(price);
		this.birthday =new SimpleStringProperty(birthday);
		this.total = new SimpleDoubleProperty(total);
		this.quantity = new SimpleIntegerProperty(quantity);
	}

	public ManagerProduct(String nameCus, String address,
			String phone, String namePro, Double price,
			String birthday,Integer quantity, Double total) {
		this.nameCus =new SimpleStringProperty(nameCus);
		this.address =new SimpleStringProperty(address);
		this.phone =new SimpleStringProperty(phone);
		this.namePro =new SimpleStringProperty(namePro);
		this.price = new SimpleDoubleProperty(price);
		this.birthday =new SimpleStringProperty(birthday);
		this.total = new SimpleDoubleProperty(total);
		this.quantity = new SimpleIntegerProperty(quantity);
	}
	
//	pro1.setNameCus(pro.getNameCus());
//	pro1.setPhone(pro.getPhone());
//	pro1.setAddress(pro.getAddress());
//	pro1.setNamePro(pro.getName());
//	pro1.setPrice(pro.getPrice());
//	pro1.setQuantity(pro.getQuantity());
//	pro1.setTotal(pro.getTotal());
	
	public ManagerProduct(String nameCus, String address,
			String phone, String namePro, Double price,
			Integer quantity, Double total) {
		this.nameCus =new SimpleStringProperty(nameCus);
		this.address =new SimpleStringProperty(address);
		this.phone =new SimpleStringProperty(phone);
		this.namePro =new SimpleStringProperty(namePro);
		this.price = new SimpleDoubleProperty(price);
		this.total = new SimpleDoubleProperty(total);
		this.quantity = new SimpleIntegerProperty(quantity);
	}

	public ManagerProduct() {
		this.id = new SimpleIntegerProperty();
		this.nameCus =new SimpleStringProperty();
		this.address =new SimpleStringProperty();
		this.phone =new SimpleStringProperty();
		this.namePro =new SimpleStringProperty();
		this.price = new SimpleDoubleProperty();
		this.birthday =new SimpleStringProperty();
		this.total = new SimpleDoubleProperty();
		this.quantity = new SimpleIntegerProperty();
	}

	public Integer getId() {
		return this.id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	

	public String getNameCus() {
		return this.nameCus.get();
	}

	public void setNameCus(String nameCus) {
		this.nameCus.set(nameCus);
	}

	public String getAddress() {
		return this.address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	public String getNamePro() {
		return this.namePro.get();
	}

	public void setNamePro(String namePro) {
		this.namePro.set(namePro);
	}

	public Double getPrice() {
		return this.price.get();
	}

	public void setPrice(Double price) {
		this.price.set(price);
	}

	public String getBirthday() {
		return this.birthday.get();
	}

	public void setBirthday(String birthday) {
		this.birthday.set(birthday);
	}

	public Double getTotal() {
		return this.total.get();
	}

	public void setTotal(Double total) {
		this.total.set(total);
	}

	public String getPhone() {
		return this.phone.get();
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	public Integer getQuantity() {
		return this.quantity.get();
	}

	public void setQuantity(Integer id) {
		this.quantity.set(id);
	}
	
}
