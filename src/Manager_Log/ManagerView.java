package Manager_Log;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import Model.Customer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ManagerView extends VBox {

	ICustomer customer = new Custormerlmpl();

	public ManagerView() {
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(10);
		grid.setPadding(new Insets(12, 12, 12, 12));

		Label lbCode = new Label("Code:");
		grid.add(lbCode, 0, 0);

		TextField txCode = new TextField();
		txCode.setPrefWidth(230);
		grid.add(txCode, 1, 0);

		Label lbFirstName = new Label("First Name:");
		grid.add(lbFirstName, 2, 0);

		TextField txFirstName = new TextField();
		txFirstName.setPrefWidth(230);
		grid.add(txFirstName, 3, 0);

		Label lbLastName = new Label("Last Name");
		grid.add(lbLastName, 0, 1);

		TextField txLastName = new TextField();
		grid.add(txLastName, 1, 1);

		Label lbDateOfBirth = new Label("Date Of Birth");
		grid.add(lbDateOfBirth, 2, 1);

		DatePicker dateOfBirth = new DatePicker();
		dateOfBirth.setPrefWidth(txFirstName.getPrefWidth());
		grid.add(dateOfBirth, 3, 1);

		Label lbPhone = new Label("Phone Number");
		grid.add(lbPhone, 0, 2);

		TextField txPhone = new TextField();
		grid.add(txPhone, 1, 2);

		Label lbGender = new Label("Gender");
		grid.add(lbGender, 2, 2);

		ToggleGroup toggle = new ToggleGroup();

		RadioButton rdMale = new RadioButton("Male");
		rdMale.setToggleGroup(toggle);

		RadioButton rdFemale = new RadioButton("Female");
		rdFemale.setToggleGroup(toggle);

		HBox genderHBox = new HBox();
		genderHBox.setSpacing(15);
		genderHBox.getChildren().addAll(rdMale, rdFemale);
		grid.add(genderHBox, 3, 2);

		Label lbSalary = new Label("Salary");
		grid.add(lbSalary, 0, 3);

		TextField txSalary = new TextField();
		grid.add(txSalary, 1, 3);

		Label lbAddress = new Label("Address");
		grid.add(lbAddress, 2, 3);

		TextField txAddress = new TextField();
		grid.add(txAddress, 3, 3);

	//	Image imgSearch = new Image(getClass().getResourceAsStream("/search.png"));
	//	Image imgAdd = new Image(getClass().getResourceAsStream("/add.png"));
	//	Image imgUpdate = new Image(getClass().getResourceAsStream("/update.png"));
	//	Image imgDetail = new Image(getClass().getResourceAsStream("/detail.png"));

		Button search = new Button("Search");
	//	search.setGraphic(new ImageView(imgSearch));

		Button insert = new Button("Insert");
	//	insert.setGraphic(new ImageView(imgAdd));

		Button update = new Button("Update");
	//	update.setGraphic(new ImageView(imgUpdate));

		Button detail = new Button("Detail");
	//	detail.setGraphic(new ImageView(imgDetail));

		HBox hbox = new HBox();
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(10, 0, 10, 0));
		hbox.getChildren().addAll(search, insert, update, detail);
		hbox.setAlignment(Pos.CENTER);
		grid.add(hbox, 0, 5, 4, 1);

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
		passCus.setCellValueFactory(new PropertyValueFactory<>("password"));
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

		TableColumn<Customer, String> genderCus = new TableColumn<>("Gender");
		genderCus.setCellValueFactory(new PropertyValueFactory<>("gender"));
		genderCus.setCellFactory(TextFieldTableCell.forTableColumn());
		genderCus.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setGender(newValue);
			}

		});
		
		TableColumn<Customer, String> dateOfBirthCus = new TableColumn<>("Date of Birth");
		dateOfBirthCus.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		// dateOfBirthCol.setCellFactory(TextFieldTableCell.forTableColumn());
		dateOfBirthCus.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setBirthday(newValue);
			}

		});
		//super(id,account, password, name, address,gender,birthday, phone);
		TableColumn<Customer, String> phoneCus = new TableColumn<>("Phone");
		phoneCus.setCellValueFactory(new PropertyValueFactory<>("phone"));
		// salary.setCellFactory(TextFieldTableCell.forTableColumn());
		phoneCus.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setPhone(newValue);
			}

		});

		table.getColumns().addAll(idCus,accountCus, passCus, nameCus, address, genderCus,dateOfBirthCus,phoneCus);

		// ObservableList<Employee> data = FXCollections.observableArrayList(new
		// Employee(1, "001", "Jacob Smith",
		// "0987656872", "jacob.smith@example.com", "Da Nang", LocalDate.now(), 9.8,
		// LocalDate.now()));
		
		this.setPadding(new Insets(0, 20, 0, 20));
		this.getChildren().addAll(grid, table);

	}

}
