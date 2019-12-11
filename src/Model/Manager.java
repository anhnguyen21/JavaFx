package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Manager {
	//super(id,account, password, name, address,gender,birthday, phone);
	private SimpleIntegerProperty id;
	private SimpleStringProperty account;
	private SimpleStringProperty pass;
	private SimpleStringProperty name;
	private SimpleStringProperty address;
	private SimpleStringProperty gender;
	private SimpleStringProperty birthday;
	private SimpleStringProperty phone;
	
	public Manager(SimpleIntegerProperty id, SimpleStringProperty account, SimpleStringProperty pass,
			SimpleStringProperty name, SimpleStringProperty address, SimpleStringProperty gender,
			SimpleStringProperty birthday, SimpleStringProperty phone) {
		super();
		this.id = id;
		this.account = account;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
	}

	public Manager(SimpleStringProperty account, SimpleStringProperty pass, SimpleStringProperty name,
			SimpleStringProperty address, SimpleStringProperty gender, SimpleStringProperty birthday,
			SimpleStringProperty phone) {
		super();
		this.account = account;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
	}

	public int getId() {
		return this.id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public String getAccount() {
		return this.account.get();
	}

	public void setAccount(String account) {
		this.account.set(account);;
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
