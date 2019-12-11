package PersonDto;

import java.sql.Date;
import java.util.Scanner;

public class ManagerDto extends Person {

	Scanner input = new Scanner(System.in);	

	public ManagerDto() {
		super();
	}

	public ManagerDto(int id,String account,String password, String name, String address, String gender,Date date,String phone) {
		super(id,account,password, name, address, gender,date, phone);
		
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
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setId(int i) {
		// TODO Auto-generated method stub
		this.id=i;
	}

	@Override
	public void setName(String n) {
		// TODO Auto-generated method stub
		this.name=n;
	}

	@Override
	public void setPhone(String p) {
		// TODO Auto-generated method stub
		this.phone=p;
	}

	public void setAddress(String string) {
		// TODO Auto-generated method stub
		this.address=string;
	}

	@Override
	public void setGender(String gender) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return this.birthday;
	}

	@Override
	public void setBirthday(Date date) {
		// TODO Auto-generated method stub
		this.birthday=date;
	}
	
}
