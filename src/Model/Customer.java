package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private SimpleIntegerProperty id;
	private SimpleStringProperty account;
	private SimpleStringProperty pass;
	private SimpleStringProperty name;
	private SimpleStringProperty address;
	private SimpleStringProperty gender;
	private SimpleStringProperty birthday;
	private SimpleStringProperty phone;
	
	public Customer(Integer id, String account, String pass,
			String name, String address, String gender,
			String birthday, String phone) {
		this.id = new SimpleIntegerProperty(id);
		this.account =new SimpleStringProperty(account);
		this.pass =new SimpleStringProperty(pass);
		this.name =new SimpleStringProperty(name);
		this.address =new SimpleStringProperty(address);
		this.gender = new SimpleStringProperty(gender);
		this.birthday =new SimpleStringProperty(birthday);
		this.phone = new SimpleStringProperty(phone);
	}

	public Customer(String account, String pass, String name,
			String address, String gender, String birthday,
			String phone) {
	
		this.account =new SimpleStringProperty(account);
		this.pass =new SimpleStringProperty(pass);
		this.name =new SimpleStringProperty(name);
		this.address =new SimpleStringProperty(address);
		this.gender = new SimpleStringProperty(gender);
		this.birthday =new SimpleStringProperty(birthday);
		this.phone = new SimpleStringProperty(phone);
	}

	public Customer() {
		this.id = new SimpleIntegerProperty();
		this.account =new SimpleStringProperty();
		this.pass =new SimpleStringProperty();
		this.name =new SimpleStringProperty();
		this.address =new SimpleStringProperty();
		this.gender = new SimpleStringProperty();
		this.birthday =new SimpleStringProperty();
		this.phone = new SimpleStringProperty();
	}

	public Integer getId() {
		return this.id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public String getAccount() {
		return this.account.get();
	}

	public void setAccount(String account) {
		this.account.set(account);
	}

	public String getPass() {
		return this.pass.get();
	}

	public void setPass(String pass) {
		this.pass.set(pass);
	}

	public String getName() {
		return this.name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getAddress() {
		return this.address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);;
	}

	public String getGender() {
		return this.gender.get();
	}

	public void setGender(String gender) {
		this.gender.set(gender);
	}

	public String getBirthday() {
		return this.birthday.get();
	}

	public void setBirthday(String birthday) {
		this.birthday.set(birthday);;
	}

	public String getPhone() {
		return this.phone.get();
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}
}
