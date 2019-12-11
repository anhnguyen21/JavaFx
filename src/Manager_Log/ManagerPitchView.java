package Manager_Log;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import ManagerPitch.PitchDetail;
import ManagerPitch.UpdatePitchl;
import Model.ManagerPitch;
import Productdao.ProductDao;
import Productdao.ProductImlp;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;;

public class ManagerPitchView extends VBox {

	ICustomer pro = new Custormerlmpl();

	public ManagerPitchView() {
		// ----------------------------
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

		// ----------------------------

		TableView<ManagerPitch> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);

		TableColumn<ManagerPitch, Integer> idCus = new TableColumn<>("STT");
		idCus.setCellValueFactory(new PropertyValueFactory<>("id"));
		idCus.setVisible(true);

		TableColumn<ManagerPitch, String> nameCus = new TableColumn<>("Name Customer");
		nameCus.setCellValueFactory(new PropertyValueFactory<>("nameCus"));

		TableColumn<ManagerPitch, String> phone = new TableColumn<>("Address");
		phone.setCellValueFactory(new PropertyValueFactory<>("address"));

		TableColumn<ManagerPitch, String> address = new TableColumn<>("Phone");
		address.setCellValueFactory(new PropertyValueFactory<>("phone"));

		TableColumn<ManagerPitch, String> name = new TableColumn<>("Name Pitch");
		name.setCellValueFactory(new PropertyValueFactory<>("namePitch"));

		TableColumn<ManagerPitch, String> dates = new TableColumn<>("Date Start");
		dates.setCellValueFactory(new PropertyValueFactory<>("dateStart"));

		TableColumn<ManagerPitch, String> Time_Start = new TableColumn<>("Time Start");
		Time_Start.setCellValueFactory(new PropertyValueFactory<>("timeStart"));

		TableColumn<ManagerPitch, String> Time_Finish = new TableColumn<>("Time Finish");
		Time_Finish.setCellValueFactory(new PropertyValueFactory<>("timeFinish"));

		TableColumn<ManagerPitch, Integer> quantity = new TableColumn<>("Quantity");
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		TableColumn<ManagerPitch, Double> total = new TableColumn<>("Total");
		total.setCellValueFactory(new PropertyValueFactory<>("total"));

		table.getColumns().addAll(idCus, nameCus, phone, address, name, dates, Time_Start, Time_Finish, quantity,
				total);

		ObservableList<ManagerPitch> data = FXCollections.observableArrayList(pro.getAllPitch());
		table.setItems(data);

		detail.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ManagerPitch customer = table.getSelectionModel().getSelectedItem();
				if (customer == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Employee Update");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else {
					Stage detail = new PitchDetail(customer);
					detail.initModality(Modality.WINDOW_MODAL);
//					detail.initOwner(stage);
					detail.showAndWait();
				}
			}
		});

		update.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			

				ManagerPitch customertb = table.getSelectionModel().getSelectedItem();
			

				if (customertb == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Employee Update");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else
				{

					new UpdatePitchl(customertb);
					
				}
			}
		});
		
		delete.setOnAction(event -> {
			ProductDao cus = new ProductImlp();
			ObservableList<ManagerPitch> allStrings;
			ObservableList<ManagerPitch> stringSelected;
			allStrings = table.getItems();

			stringSelected = table.getSelectionModel().getSelectedItems();
			ManagerPitch customer = table.getSelectionModel().getSelectedItem();

			if (stringSelected.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Please choose the row");
				alert.showAndWait();
			} else {
				
				stringSelected.forEach(allStrings::remove);
				cus.deletePitch(customer.getId());
				System.out.println(customer.getId().toString()+"abcc");
			}

		});

		refresh.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				ObservableList<ManagerPitch> data = FXCollections.observableArrayList(pro.getAllPitch());
				table.setItems(data);
			}
		});

		this.getStylesheets().add("table.css");
		this.setPadding(new Insets(0, 20, 0, 20));
		this.getChildren().addAll(grid, table);

	}
}
