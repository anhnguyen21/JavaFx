package PersonDto;

import java.sql.Date;

public abstract class Person {

	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected String account;
	protected String gender;
	protected Date birthday;
	protected String password;
	public Person(int id, String name, String address, String phone, String account, String gender, Date birthday,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.account = account;
		this.gender = gender;
		this.birthday = birthday;
		this.password = password;
	}
	
	public Person() {

	}
	
	public Person(String name, String phone, String address, String gender,Date birthday,String account, String password) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.account = account;
		this.gender = gender;
		this.birthday = birthday;
		this.password = password;
	}
	public abstract void setId(int i);
	public abstract void setName(String n);
	public abstract void setAddress(String address);
	public abstract void setAccount(String ac);
	public abstract void setPhone(String p);
	public abstract void setGender(String gender);
	public abstract void setBirthday(Date date);
	public abstract void setPassword(String pa);
	
	public abstract int getId();
	public abstract String getName();
	public abstract String getAccount();
	public abstract String getAddress();
	public abstract String getPhone();
	public abstract String getGender();
	public abstract Date getBirthday();
	public abstract String getPassword();

	@Override
	public String toString() {
		return "\nID: " + id + "\nname: " + name + " ,address " + address + " ,phone " + phone;
	}
	
	
}
