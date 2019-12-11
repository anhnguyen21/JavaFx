package Manager_Log;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import ManagerProduct.ProductAdd;
import ManagerProduct.ProductDetail;
import ManagerProduct.ProductUpdate;
import Model.ManagerProduct;
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

public class ManagerProductView extends VBox{
	
	ICustomer pro=new Custormerlmpl();
	public ManagerProductView()
	{
		//----------------------------
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
		insert.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				new ProductAdd();

			}
		});

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
		//----------------------------
		
		
		
		TableView<ManagerProduct> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);
		

		
		TableColumn<ManagerProduct, Integer> idCus = new TableColumn<>("STT");
		idCus.setCellValueFactory(new PropertyValueFactory<>("id"));
		idCus.setVisible(true);
		
		TableColumn<ManagerProduct, String> nameCus = new TableColumn<>("Name Customer");
		nameCus.setCellValueFactory(new PropertyValueFactory<>("nameCus"));
		
		TableColumn<ManagerProduct, String> phone = new TableColumn<>("Address");
		phone.setCellValueFactory(new PropertyValueFactory<>("address"));
		
		TableColumn<ManagerProduct, String> address = new TableColumn<>("Phone");
		address.setCellValueFactory(new PropertyValueFactory<>("phone"));
		
		TableColumn<ManagerProduct, String> name = new TableColumn<>("Name Product");
		name.setCellValueFactory(new PropertyValueFactory<>("namePro"));
		
		TableColumn<ManagerProduct, Integer> quantity = new TableColumn<>("Quantity");
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		TableColumn<ManagerProduct, Double> price = new TableColumn<>("Price");
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<ManagerProduct, Double> total = new TableColumn<>("Total");
		total.setCellValueFactory(new PropertyValueFactory<>("total"));
		
		table.getColumns().addAll(idCus,nameCus,phone,address,name,quantity,price,total);

		
		ObservableList<ManagerProduct> data = FXCollections.observableArrayList(pro.getAllProduct());
		table.setItems(data);
		
		detail.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ManagerProduct customer = table.getSelectionModel().getSelectedItem();
				if (customer == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Employee Update");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else {
					Stage detail = new ProductDetail(customer);
					detail.initModality(Modality.WINDOW_MODAL);
//					detail.initOwner(stage);
					detail.showAndWait();
				}
			}
		});
		
		// delete
				delete.setOnAction(event -> {
				ProductDao cus = new ProductImlp() ;
					ObservableList<ManagerProduct> allStrings;
					ObservableList<ManagerProduct> stringSelected;
					allStrings = table.getItems();

					stringSelected = table.getSelectionModel().getSelectedItems();
					ManagerProduct customer = table.getSelectionModel().getSelectedItem();

					if (stringSelected.isEmpty()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Please choose the row");
						alert.showAndWait();
					} else {
						stringSelected.forEach(allStrings::remove);
						cus.deleteProduct(customer.getId());
						System.out.println(customer.getId().toString());
					}

				});
				
				
				refresh.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
				
						ObservableList<ManagerProduct> data = FXCollections.observableArrayList(pro.getAllProduct());
						table.setItems(data);
					}
				});
				
				update.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
					

						ManagerProduct customertb = table.getSelectionModel().getSelectedItem();
					

						if (customertb == null) {
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setHeaderText(null);
							alert.setTitle("Employee Update");
							alert.setContentText("Please select a row in the table");
							alert.showAndWait();
						} else
						{
	
							new ProductUpdate(customertb);
							
						}
					}
				});
		
		this.getStylesheets().add("table.css");
		this.setPadding(new Insets(0, 20, 0, 20));
		this.getChildren().addAll(grid, table);

	}	
}
