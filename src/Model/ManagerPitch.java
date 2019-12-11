package Model;

import java.sql.Date;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ManagerPitch {
	private SimpleIntegerProperty id;
	private SimpleStringProperty nameCus;
	private SimpleStringProperty address;
	private SimpleStringProperty phone;
	private SimpleStringProperty namePitch;
	private SimpleStringProperty dateStart;
	private SimpleStringProperty timeStart;
	private SimpleStringProperty timeFinish;
	private SimpleIntegerProperty quantity;
	private SimpleDoubleProperty total;
	public ManagerPitch(Integer id, String nameCus, String address,
			String phone,String namePitch,String dateStart,String timeStart,String timeFinish, String namePro, Double price,
			Integer quantity, Double total) {
		this.id = new SimpleIntegerProperty(id);
		this.nameCus =new SimpleStringProperty(nameCus);
		this.address =new SimpleStringProperty(address);
		this.phone =new SimpleStringProperty(phone);
		this.namePitch =new SimpleStringProperty(namePitch);
		this.dateStart =new SimpleStringProperty(dateStart);
		this.timeStart=new SimpleStringProperty(timeStart);
		this.timeFinish=new SimpleStringProperty(timeFinish);
		this.quantity =new SimpleIntegerProperty(quantity);
		this.total =new SimpleDoubleProperty(total);
	}

	public ManagerPitch(String nameCus, String address,
			String phone,String namePitch,String dateStart,String timeStart,String timeFinish, String namePro, Double price,
			Integer quantity, Double total) {
		this.nameCus =new SimpleStringProperty(nameCus);
		this.address =new SimpleStringProperty(address);
		this.phone =new SimpleStringProperty(phone);
		this.namePitch =new SimpleStringProperty(namePitch);
		this.dateStart =new SimpleStringProperty(dateStart);
		this.timeStart=new SimpleStringProperty(timeStart);
		this.timeFinish=new SimpleStringProperty(timeFinish);
		this.quantity =new SimpleIntegerProperty(quantity);
		this.total =new SimpleDoubleProperty(total);
	}
	
	public ManagerPitch() {
		this.id = new SimpleIntegerProperty();
		this.nameCus =new SimpleStringProperty();
		this.address =new SimpleStringProperty();
		this.phone =new SimpleStringProperty();
		this.namePitch =new SimpleStringProperty();
		this.dateStart =new SimpleStringProperty();
		this.timeStart=new SimpleStringProperty();
		this.timeFinish=new SimpleStringProperty();
		this.quantity =new SimpleIntegerProperty();
		this.total =new SimpleDoubleProperty();
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

	public String getNamePitch() {
		return this.namePitch.get();
	}
	public void setNamePitch(String namePitch) {
		this.namePitch.set(namePitch);
	}
	
	public String getDateStart() {
		return this.dateStart.get();
	}
	public void setDateStart(String dateStart) {
		this.dateStart.set(dateStart);
	}
	public String getTimeStart() {
		return this.timeStart.get();
	}
	public void setTimeStart(String timeStart) {
		this.timeStart.set(timeStart);
	}
	public String getTimeFinish() {
		return this.timeFinish.get();
	}
	public void setTimeFinish(String timeFinish) {
		this.timeFinish.set(timeFinish);
	}
	public Integer getQuantity() {
		return this.quantity.get();
	}
	public void setQuantity(Integer quantity) {
		this.quantity.set(quantity);
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
}
