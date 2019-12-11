package PersonDto;

import java.sql.Date;

public class CustomerDto extends Person {

	public CustomerDto() {
	
	}

	public CustomerDto(int id,String account, String password, String name, String address,String gender,Date birthday, String phone) {
		super(id,account, password, name, address,gender,birthday, phone);

	}
	public CustomerDto(String name, String phone, String address, String gender, Date birthday,String account, String password) {
		super( name, phone, address,gender,birthday,account, password);

	}
	
	public void setId(int i)
	{
		this.id=i;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}
	public void setName(String n)
	{
		this.name=n;
	}
	public void setAddress(String a)
	{
		this.address=a;
	}
	public  void setPhone(String p)
	{
		this.phone=p;
	}

	@Override
	public void setGender(String gender) {
		this.gender=gender;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setBirthday(Date date) {
		// TODO Auto-generated method stub
		this.birthday=date;
	}

	@Override
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return this.birthday;
	}

}