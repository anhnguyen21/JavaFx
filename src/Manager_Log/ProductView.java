package Manager_Log;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import Model.Customer;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;;

public class ProductView extends VBox{
	
	
	public ProductView(int i)
	{
		
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(10);
		grid.setPadding(new Insets(12, 12, 12, 12));

		HBox hbox = new HBox();
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(10, 0, 10, 0));
//		hbox.getChildren().addAll(search, insert, update, detail);
		hbox.setAlignment(Pos.CENTER);
		grid.add(hbox, 0, 5, 4, 1);
		
		TableView<Product> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);
		
		TableColumn<Product, Integer> idCus = new TableColumn<>("Id");
		idCus.setCellValueFactory(new PropertyValueFactory<>("id"));
		idCus.setVisible(false);
		
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

		TableColumn<Product, String> name = new TableColumn<>("Name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setCellFactory(TextFieldTableCell.forTableColumn());
		name.setOnEditCommit(new EventHandler<CellEditEvent<Product, String>>() {
			@Override
			public void handle(CellEditEvent<Product, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setName(newValue);
			}

		});

		TableColumn<Product, Double> price = new TableColumn<>("Price");
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
//		passCus.setCellFactory(TextFieldTableCell.forTableColumn());
		price.setOnEditCommit(new EventHandler<CellEditEvent<Product, Double>>() {
			@Override
			public void handle(CellEditEvent<Product, Double> t) {
				Double newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setPrice(newValue);
			}

		});
		TableColumn<Product, Integer> quantity = new TableColumn<>("Quantity");
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//		passCus.setCellFactory(TextFieldTableCell.forTableColumn());
		quantity.setOnEditCommit(new EventHandler<CellEditEvent<Product, Integer>>() {
			@Override
			public void handle(CellEditEvent<Product, Integer> t) {
				Integer newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setQuantity(newValue);
			}

		});
//		table.getColumns(). addAll(idCus,nameCus,name,price,quantity);
		ICustomer pro=new Custormerlmpl();
		
		ObservableList<Product> data = FXCollections.observableArrayList(pro.getAllProduct(i));
		table.setItems(data);
		this.setPadding(new Insets(0, 20, 0, 20));
		this.getChildren().addAll(grid, table);

	}	
}
