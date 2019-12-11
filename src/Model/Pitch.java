package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pitch {
	private SimpleIntegerProperty id;
	private SimpleStringProperty namePitch;
	private SimpleStringProperty dateStart;
	private SimpleStringProperty timeStart;
	private SimpleStringProperty timeFinish;
	private SimpleIntegerProperty quantity;
	private SimpleDoubleProperty total;
	public Pitch(Integer id,String namePitch,String dateStart,String timeStart,String timeFinish, int quantity, Double total)
	{
		this.id = new SimpleIntegerProperty(id);
		this.namePitch =new SimpleStringProperty(namePitch);
		this.dateStart =new SimpleStringProperty(dateStart);
		this.timeStart=new SimpleStringProperty(timeStart);
		this.timeFinish=new SimpleStringProperty(timeFinish);
		this.quantity =new SimpleIntegerProperty(quantity);
		this.total =new SimpleDoubleProperty(total);
	}
	public Pitch(String namePitch,String dateStart,String timeStart,String timeFinish, int quantity, Double total)
	{
		this.namePitch =new SimpleStringProperty(namePitch);
		this.dateStart =new SimpleStringProperty(dateStart);
		this.timeStart=new SimpleStringProperty(timeStart);
		this.timeFinish=new SimpleStringProperty(timeFinish);
		this.quantity =new SimpleIntegerProperty(quantity);
		this.total =new SimpleDoubleProperty(total);
	}
	public Pitch()
	{
		this.id = new SimpleIntegerProperty();
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
}
