package Manager_Log;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import Model.Customer;
import PersonDto.CustomerDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class CustomerSearch extends Stage {

	ICustomer customer = new Custormerlmpl();

	public CustomerSearch(CustomerDto cusDto) {

		TableView<Customer> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);

		TableColumn<Customer, Integer> idCus = new TableColumn<>("Id");
		idCus.setCellValueFactory(new PropertyValueFactory<>("id"));
		idCus.setVisible(false);

		TableColumn<Customer, String> accountCus = new TableColumn<>("Account");
		accountCus.setCellValueFactory(new PropertyValueFactory<>("account"));
		accountCus.setCellFactory(TextFieldTableCell.forTableColumn());
		accountCus.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setAccount(newValue);
			}

		});

		TableColumn<Customer, String> passCus = new TableColumn<>("Password");
		passCus.setCellValueFactory(new PropertyValueFactory<>("pass"));
		passCus.setCellFactory(TextFieldTableCell.forTableColumn());
		passCus.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setPass(newValue);
			}

		});

		TableColumn<Customer, String> nameCus = new TableColumn<>("Full Name");
		nameCus.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameCus.setCellFactory(TextFieldTableCell.forTableColumn());
		nameCus.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setName(newValue);
			}

		});

		TableColumn<Customer, String> address = new TableColumn<>("Address");
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		address.setCellFactory(TextFieldTableCell.forTableColumn());
		address.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setAddress(newValue);
			}

		});

		TableColumn<Customer, String> genderCol = new TableColumn<>("Gender");
		genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
		genderCol.setCellFactory(TextFieldTableCell.forTableColumn());
		genderCol.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setGender(newValue);
			}

		});

		TableColumn<Customer, String> dateOfBirthCol = new TableColumn<>("Date of Birth");
		dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		dateOfBirthCol.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setBirthday(newValue);
			}

		});

		TableColumn<Customer, String> phoneCus = new TableColumn<>("Phone");
		phoneCus.setCellValueFactory(new PropertyValueFactory<>("phone"));
		phoneCus.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setPhone(newValue);
			}

		});

		table.getColumns().addAll(idCus, accountCus, passCus, nameCus, address, genderCol, dateOfBirthCol, phoneCus);
		ObservableList<Customer> data = FXCollections.observableArrayList(customer.getAllCustomer(cusDto));

		table.setItems(data);
		table.setPadding(new Insets(20, 20, 20, 20));
		
		
		Scene s = new Scene(table);
		this.setScene(s);
		this.show();

	}

}