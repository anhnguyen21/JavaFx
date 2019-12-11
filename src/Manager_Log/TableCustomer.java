package Manager_Log;

import java.util.ArrayList;
import java.util.List;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import Model.Customer;
import PersonDto.CustomerDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableCustomer extends TableView<Customer> {

	ICustomer customer = new Custormerlmpl();
	List<CustomerDto> cus = new ArrayList<CustomerDto>();

	public TableCustomer() {
		

//		TableView<Customer> table = new TableView<>();
		this.setEditable(true);
		this.setPrefHeight(250);

		TableColumn<Customer, Integer> idCus = new TableColumn<>("Id");
		idCus.setCellValueFactory(new PropertyValueFactory<>("id"));
		idCus.setVisible(false);
		idCus.getStyleClass().add("tableview");

		TableColumn<Customer, String> accountCus = new TableColumn<>("Account");
		accountCus.setCellValueFactory(new PropertyValueFactory<>("account"));

		TableColumn<Customer, String> passCus = new TableColumn<>("Password");
		passCus.setCellValueFactory(new PropertyValueFactory<>("pass"));

		TableColumn<Customer, String> nameCus = new TableColumn<>("Full Name");
		nameCus.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Customer, String> address = new TableColumn<>("Address");
		address.setCellValueFactory(new PropertyValueFactory<>("address"));

		TableColumn<Customer, String> genderCol = new TableColumn<>("Gender");
		genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

		TableColumn<Customer, String> dateOfBirthCol = new TableColumn<>("Date of Birth");
		dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));

		TableColumn<Customer, String> phoneCus = new TableColumn<>("Phone");
		phoneCus.setCellValueFactory(new PropertyValueFactory<>("phone"));

		this.getColumns().addAll(idCus, accountCus, passCus, nameCus, address, genderCol, dateOfBirthCol, phoneCus);

		ObservableList<Customer> data = FXCollections.observableArrayList(customer.getAllCustomer());
		this.setItems(data);
		this.setPadding(new Insets(20, 20, 20, 20));
		
		
	}

}
