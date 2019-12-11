
	package qlsb;



	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.scene.Scene;
	import javafx.scene.control.Label;
	import javafx.scene.effect.DropShadow;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.input.MouseEvent;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.paint.Color;
	import javafx.scene.text.Font;
	import javafx.scene.text.FontWeight;
	import javafx.stage.Stage;

	public class Interface extends Stage{

		public Interface() {
			// TODO Auto-generated method stub
			BorderPane bor = new BorderPane();
			DropShadow ds = new DropShadow();
			ds.setOffsetY(3.0f);
			ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

			HBox hbox = new HBox();
			hbox.setSpacing(20);
			hbox.setPadding(new Insets(10, 10, 10, 10));
			hbox.setAlignment(Pos.CENTER_RIGHT);
			Label login = new Label("Login");
			login.setStyle("-fx-text-fill: white;");
			login.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15.0));
			login.setEffect(ds);

			Label signup = new Label("Sign Up");
			signup.setStyle("-fx-text-fill: white;");
			signup.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15.0));
			signup.setEffect(ds);
			
//			hbox.getStyleClass().add("color");
			hbox.getChildren().addAll(login, signup);
			bor.setTop(hbox);

			Label welcome = new Label("           Welcome \r\n" + "to mini football stadium \r\n" + "         management");
			welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, 60.0));

			welcome.setEffect(ds);

			welcome.setWrapText(true);

			welcome.setStyle("-fx-text-fill: white;");
			welcome.setAlignment(Pos.BOTTOM_CENTER);
			bor.setCenter(welcome);
		
			login.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					close();
					new Login();
				}
			});
			signup.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					close();
					new Register();
				}
			});
			
			HBox hboxBottom = new HBox();
			hboxBottom.setSpacing(100);
			
			Image image = new Image("smartphone.png");
			Image image1 = new Image("placeholder.png");
			
			HBox hboxHott = new HBox();
			hboxHott.setSpacing(10);
			ImageView view = new ImageView(image);
			Label hottline  = new Label("Hottline: 0985582807 ");
			hottline.setStyle("-fx-text-fill: white;");
			hottline.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15.0));
			hottline.setEffect(ds);
			
			hboxHott.getChildren().addAll(view,hottline);
			
			
			HBox hboxLocation = new HBox();
			hboxLocation.setSpacing(10);
			ImageView view1 = new ImageView(image1);
			Label location  = new Label("Address: 101B Le Huu Trac, Son Tra, Da Nang");
			location.setStyle("-fx-text-fill: white;");
			location.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15.0));
			location.setEffect(ds);
			
			hboxLocation.getChildren().addAll(view1,location);
			
			hboxBottom.getChildren().addAll(hboxHott,hboxLocation);
			hboxBottom.setAlignment(Pos.CENTER_RIGHT);
			hboxBottom.setPadding(new Insets(10, 10, 10, 10));
			hboxBottom.getStyleClass().add("color");
			
			bor.setBottom(hboxBottom);
			
			
			Scene s = new Scene(bor, 1024, 548);
			bor.getStyleClass().add("test");
			setScene(s);
			s.getStylesheets().add("test.css");
			show();
			setTitle("Welcome");
		}
		
		
		
		
	}


