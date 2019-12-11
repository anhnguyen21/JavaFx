package Manager_Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import Model.Customer;
import PersonDto.CustomerDto;
import dao.CustomerDao;
import dao.CustormerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerView extends VBox {

	ICustomer customer = new Custormerlmpl();
	List<CustomerDto> cus = new ArrayList<CustomerDto>();

	public CustomerView() {

		BorderPane bor = new BorderPane();
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(10);
		grid.setPadding(new Insets(12, 12, 12, 12));

		HBox hboxHead = new HBox();
		hboxHead.setSpacing(20);
		hboxHead.setPadding(new Insets(10, 10, 10, 150));
		TextField txSearch = new TextField();
		txSearch.setPrefWidth(200);
		txSearch.setPromptText("Infomation you need search");

		
		Image imgAdd = new Image(getClass().getResourceAsStream("/add.png"));
		Image imgUpdate = new Image(getClass().getResourceAsStream("/update.png"));
		Image imgSearch = new Image(getClass().getResourceAsStream("/search.png"));
		Image imgDetail = new Image(getClass().getResourceAsStream("/detail.png"));
		Image imgDelete = new Image(getClass().getResourceAsStream("/delete.png"));
		Image imgRefresh = new Image(getClass().getResourceAsStream("/refresh.png"));

		Button search = new Button("Search");
		search.setGraphic(new ImageView(imgSearch));

		hboxHead.getChildren().addAll(txSearch, search);

		grid.add(hboxHead, 0, 0);

		Button insert = new Button("Insert");
		insert.setGraphic(new ImageView(imgAdd));

		Button update = new Button("Update");
		update.setGraphic(new ImageView(imgUpdate));

		Button detail = new Button("Detail");
		detail.setGraphic(new ImageView(imgDetail));

		Button delete = new Button("Delete");
		delete.setGraphic(new ImageView(imgDelete));

		Button refresh = new Button("Refresh");
		refresh.setGraphic(new ImageView(imgRefresh));

		HBox hbox = new HBox();
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(10, 0, 10, 50));
		hbox.getChildren().addAll(insert, update, detail, delete, refresh);
		hbox.setAlignment(Pos.CENTER);
		grid.add(hbox, 0, 3);

		TableView<Customer> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);

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

		table.getColumns().addAll(idCus, accountCus, passCus, nameCus, address, genderCol, dateOfBirthCol, phoneCus);

		ObservableList<Customer> data = FXCollections.observableArrayList(customer.getAllCustomer());
		table.setItems(data);
		table.setPadding(new Insets(20, 20, 20, 20));
		// table.getStyleClass().add("tableview");

		insert.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				new CustomerAdd();

			}
		});

		update.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				CustomerDao cus = new CustormerImpl();

				Customer customertb = table.getSelectionModel().getSelectedItem();

				if (customertb == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Employee Update");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else {
					new CustomerUpdate(customertb);
					cus.updateCustomer(customertb);
				}
			}
		});

		detail.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Customer customer = table.getSelectionModel().getSelectedItem();
				if (customer == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Employee Update");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else {
					Stage detail = new CustomerDetail(customer);
					detail.initModality(Modality.WINDOW_MODAL);
//					detail.initOwner(stage);
					detail.showAndWait();
				}
			}
		});

		// delete
		delete.setOnAction(event -> {
			CustomerDao cus = new CustormerImpl();
			ObservableList<Customer> allStrings;
			ObservableList<Customer> stringSelected;
			allStrings = table.getItems();

			stringSelected = table.getSelectionModel().getSelectedItems();
			Customer customer = table.getSelectionModel().getSelectedItem();

			if (stringSelected.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Please choose the row");
				alert.showAndWait();
			} else {
				stringSelected.forEach(allStrings::remove);
				cus.deleteCustomer(customer.getId());
			}

		});

		search.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				// TODO Auto-generated method stub
				CustomerDao cus = new CustormerImpl();
				CustomerDto cusDto = new CustomerDto();

				if (txSearch.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Please enter name");
					alert.showAndWait();
				}
				cusDto.setName(txSearch.getText());
				cus.search(cusDto);
				new CustomerSearch(cusDto);


			}
		});

		txSearch.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
//				DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
					// TODO Auto-generated method stub
					CustomerDao cus = new CustormerImpl();
					CustomerDto cusDto = new CustomerDto();

					cusDto.setName(txSearch.getText());
					cus.search(cusDto);
					new CustomerSearch(cusDto);
				}
			}
		});

		refresh.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				ObservableList<Customer> data = FXCollections.observableArrayList(customer.getAllCustomer());
				//table.setItems(null);
				table.setItems(data);
			}
		});
		bor.setTop(grid);
		bor.setCenter(table);

		this.setPadding(new Insets(0, 20, 0, 20));
		this.getChildren().add(bor);
		this.getStylesheets().add("table.css");

	}

}
