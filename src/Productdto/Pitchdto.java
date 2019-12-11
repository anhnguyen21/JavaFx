package Productdto;

import java.sql.Date;

public class Pitchdto{
	protected int id;
	protected String namePitch;
	protected Date dateStart;
	protected java.sql.Time timeStart;
	protected java.sql.Time timeFinish;
	protected int quantity;
	protected Double total;
	public Pitchdto() {
		super();
	}
	public Pitchdto(int id, String namePitch,Date dateStart, java.sql.Time timeStart, java.sql.Time timeFinish, int quantity, Double total) {
		super();
		this.id = id;
		this.namePitch = namePitch;
		this.dateStart=dateStart;
		this.timeStart = timeStart;
		this.timeFinish = timeFinish;
		this.quantity = quantity;
		this.total = total;
	}
	public Pitchdto(String namePitch,Date dateStart, java.sql.Time timeStart, java.sql.Time timeFinish, int quantity, Double total) {
		super();
		this.namePitch = namePitch;
		this.dateStart=dateStart;
		this.timeStart = timeStart;
		this.timeFinish = timeFinish;
		this.quantity = quantity;
		this.total = total;
	}
	public Pitchdto(int id,Date dateStart, java.sql.Time timeStart, java.sql.Time timeFinish) {
		super();
		this.id = id;
		this.dateStart=dateStart;
		this.timeStart = timeStart;
		this.timeFinish = timeFinish;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamePitch() {
		return namePitch;
	}
	public void setNamePitch(String namePitch) {
		this.namePitch = namePitch;
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
