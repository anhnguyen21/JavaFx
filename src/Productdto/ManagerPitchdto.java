package Productdto;

import java.sql.Date;
import java.sql.Time;

public class ManagerPitchdto{
	protected int id;
	protected String nameCus;
	protected String address;
	protected String phone;
	protected String namePitch;
	protected Date dateStart;
	protected java.sql.Time timeStart;
	protected java.sql.Time timeFinish;
	protected int quantity;
	protected Double total;
	public ManagerPitchdto() {
		super();
	}
	
	public ManagerPitchdto(int id, String nameCus, String address, String phone, String namePitch, Date dateStart,
			Time timeStart, Time timeFinish, int quantity, Double total) {
		super();
		this.id = id;
		this.nameCus = nameCus;
		this.address = address;
		this.phone = phone;
		this.namePitch = namePitch;
		this.dateStart = dateStart;
		this.timeStart = timeStart;
		this.timeFinish = timeFinish;
		this.quantity = quantity;
		this.total = total;
	}
	

	public ManagerPitchdto(String nameCus, String address, String phone, String namePitch, Date dateStart,
			Time timeStart, Time timeFinish, int quantity, Double total) {
		super();
		this.nameCus = nameCus;
		this.address = address;
		this.phone = phone;
		this.namePitch = namePitch;
		this.dateStart = dateStart;
		this.timeStart = timeStart;
		this.timeFinish = timeFinish;
		this.quantity = quantity;
		this.total = total;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNamePitch() {
		return namePitch;
	}
	public void setNamePitch(String namePitch) {
		this.namePitch = namePitch;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public java.sql.Time getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(java.sql.Time timeStart) {
		this.timeStart = timeStart;
	}
	public java.sql.Time getTimeFinish() {
		return timeFinish;
	}
	public void setTimeFinish(java.sql.Time timeFinish) {
		this.timeFinish = timeFinish;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
