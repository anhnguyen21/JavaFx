package Customer;

import java.util.Optional;

import Manager_Log.CusProfile;
import Productdto.PitchView;
import Productdto.ProductView;
import dao.CustomerDao;
import dao.CustormerImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import qlsb.Interface;

public class CustomerDisplay extends Stage {
	CustomerDao mana = new CustormerImpl();

	public CustomerDisplay(String a, String b, int id) {
		BorderPane bor = new BorderPane();
		bor.setPadding(new Insets(20, 20, 20, 0));

		HBox hbox2 = new HBox();
		hbox2.setPadding(new Insets(10, 10, 10, 180));
		hbox2.setSpacing(50);

		Label Title = new Label("Mini Football Stadium");
		Title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50.0));
		Title.setAlignment(Pos.CENTER);
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		Title.setEffect(ds);

		Title.setWrapText(true);

		Title.setStyle("-fx-text-fill: white;");
		Title.setAlignment(Pos.BOTTOM_CENTER);

		Image image1 = new Image("pitch.png");
		Image image2 = new Image("water.png");
		Image image3 = new Image("football-shirt.png");
		Image image4 = new Image("user.png");
		Image image5 = new Image("cart.png");
		Image image6 = new Image("pay.png");

		HBox hbox = new HBox();

		ImageView view = new ImageView(image4);
		view.setFitHeight(50);
		view.setFitWidth(50);
		hbox.getChildren().add(view);
		hbox.setAlignment(Pos.TOP_RIGHT);

		ChoiceBox<String> list = new ChoiceBox<>();
		list.setPrefWidth(100);
		list.setPrefHeight(20);
		ObservableList<String> items = FXCollections.observableArrayList("Profile", "Feedback", "ChangePass", "Logout");
		list.setItems(items);
		bor.setRight(list);
		list.setPrefWidth(70);
		list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> object, Object oldValue, Object newValue) {
				if ("0".equals(newValue.toString())) {
					CustomerDao mana = new CustormerImpl();
					new CusProfile(mana.getIDBySignUp(id));

				}

				if ("1".equals(newValue.toString())) {

					new Feedback();
				}

				if ("2".equals(newValue.toString())) {
					new ChangePass(b, id);
				}

				if ("3".equals(newValue.toString())) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setHeaderText(null);
					alert.setContentText("Are you sure?");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						close();
						new Interface();
					}
				}
			}

		});

//		hbox2.setSpacing(200);
		hbox2.getChildren().addAll(Title, hbox);

		bor.setTop(hbox2);

		VBox vbox = new VBox();
		vbox.setSpacing(20);
		vbox.setPadding(new Insets(10, 10, 10, 0));

		VBox vboxPitch = new Pitch(id);
		bor.setCenter(vboxPitch);

		vboxPitch.setPadding(new Insets(10, 10, 10, 50));
		Button pitch = new Button("Pitch ", new ImageView(image1));
		pitch.setAlignment(Pos.CENTER_LEFT);
		pitch.setPrefWidth(150);
		pitch.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				bor.setCenter(vboxPitch);
			}
		});

		Button water = new Button("Water ", new ImageView(image2));
		water.setAlignment(Pos.CENTER_LEFT);
		water.setPrefWidth(150);

		VBox vboxwater = new Water(id);
		vboxwater.setPadding(new Insets(10,10,10,50));
		water.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				bor.setCenter(vboxwater);
			}
		});

		VBox vboxShirt = new Shirt(id);
		vboxShirt.setPadding(new Insets(10,10,10,50));
		Button shirt = new Button("Mesh shirt ", new ImageView(image3));
		shirt.setAlignment(Pos.CENTER_LEFT);
		shirt.setPrefWidth(150);
		shirt.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				bor.setCenter(vboxShirt);
			}
		});
		
//		VBox vboxPay = new VBox(); 
//		vboxPay.setPadding(new Insets(20, 20, 20, 600));
		
		Button pay=new Button("Pay Now",new ImageView(image6));
		pay.setAlignment(Pos.CENTER_LEFT);
		pay.setPrefWidth(150);
		
		
		pay.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				new Payment(id);
				
			}
		});
		
		Button cart = new Button("Cart", new ImageView(image5));
		cart.setAlignment(Pos.CENTER_LEFT);
		cart.setPrefWidth(150);
		cart.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				VBox pro = new PitchView(id);
				VBox pro1 = new ProductView(id);
				VBox p=new VBox();
				
				p.setPadding(new Insets(10, 10, 50, 50));
				
				p.getChildren().addAll(pro,pro1);
				bor.setCenter(p);
				
				vbox.getChildren().add(pay);
			}
		});

		cart.getStyleClass().add("button1");
		pitch.getStyleClass().add("button1");
		water.getStyleClass().add("button1");
		shirt.getStyleClass().add("button1");
		pay.getStyleClass().add("button1");

		vbox.getChildren().addAll(pitch, water, shirt, cart);

		bor.setLeft(vbox);

		bor.getStyleClass().add("back1");
		Scene s = new Scene(bor, 800, 500);
		s.getStylesheets().add("test.css");
		this.setScene(s);
		this.setTitle("Customer");
		this.show();

	}

}