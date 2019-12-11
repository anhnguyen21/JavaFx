package Productdto;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;;

public class ProductView extends VBox{
	
	
	public ProductView(int i)
	{
		TableView<Product> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);
		

		TableColumn<Product, String> name = new TableColumn<>("Name");
		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<Product, Integer> quantity = new TableColumn<>("Quantity");
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		TableColumn<Product, Double> price = new TableColumn<>("Price");
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		TableColumn<Product, Double> total = new TableColumn<>("Total");
		total.setCellValueFactory(new PropertyValueFactory<>("total"));
		
		name.setPrefWidth(100);
		quantity.setPrefWidth(100);
		price.setPrefWidth(100);
		total.setPrefWidth(105);
		
		table.getColumns().addAll(name,quantity,price,total);
		ICustomer pro=new Custormerlmpl();
		
		ObservableList<Product> data = FXCollections.observableArrayList(pro.getAllProduct(i));
		table.setItems(data);
		
		
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		
		Image imgDelete = new Image(getClass().getResourceAsStream("/delete.png"));
		Button delete = new Button();
		delete.setGraphic(new ImageView(imgDelete));

		
		hbox.getChildren().addAll(table,delete);
		
		this.setPadding(new Insets(0, 20, 0, 20));
		this.getChildren().add(hbox);

	}	
}
