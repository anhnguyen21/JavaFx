package Productdto;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import Model.Pitch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;;

public class PitchView extends VBox{
	
	
	public PitchView(int i)
	{
				
		
		
		TableView<Pitch> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);
		

		TableColumn<Pitch, String> name = new TableColumn<>("Name Pitch");
		name.setCellValueFactory(new PropertyValueFactory<>("namePitch"));
		
		TableColumn<Pitch, String> dates = new TableColumn<>("Date Start");
		dates.setCellValueFactory(new PropertyValueFactory<>("dateStart"));
		
		TableColumn<Pitch, String> Time_Start = new TableColumn<>("Time Start");
		Time_Start.setCellValueFactory(new PropertyValueFactory<>("timeStart"));
		

		TableColumn<Pitch, String> Time_Finish = new TableColumn<>("Time Finish");
		Time_Finish.setCellValueFactory(new PropertyValueFactory<>("timeFinish"));
		
		TableColumn<Pitch, Integer> quantity = new TableColumn<>("Quantity");
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		TableColumn<Pitch, Double> total = new TableColumn<>("Total");
		total.setCellValueFactory(new PropertyValueFactory<>("total"));
		table.getColumns().addAll(name,dates,Time_Start,Time_Finish,quantity,total);
		ICustomer pro=new Custormerlmpl();
		ObservableList<Pitch> data = FXCollections.observableArrayList(pro.getAllPitch(i));
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
