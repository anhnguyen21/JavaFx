package Manager_Log;

import java.util.Optional;

import dao.ManagerDao;
import dao.ManagerImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ManagerDisplay extends Stage {

	public ManagerDisplay(String a, String b,int id) {
		BorderPane bor = new BorderPane();
		bor.setPadding(new Insets(20, 20, 20, 0));

		HBox hbox2 = new HBox();
		hbox2.setPadding(new Insets(10, 10, 10, 180));
		hbox2.setSpacing(150);

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

		Image image1 = new Image("cus.png");
		Image image2 = new Image("product.png");
		Image image3 = new Image("pitch.png");
		Image image4 = new Image("user.png");

		HBox hbox = new HBox();

		ImageView view = new ImageView(image4);
		view.setFitHeight(50);
		view.setFitWidth(50);
		hbox.getChildren().add(view);
		hbox.setAlignment(Pos.TOP_RIGHT);

//		view.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				// TODO Auto-generated method stub
		ChoiceBox<String> list = new ChoiceBox<>();
		list.setPrefWidth(100);
		list.setPrefHeight(20);
		ObservableList<String> items = FXCollections.observableArrayList("Profile", "Logout");
		list.setItems(items);
		bor.setRight(list);
		list.setPrefWidth(70);
		list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> object, Object oldValue, Object newValue) {
				if ("0".equals(newValue.toString())) {
					ManagerDao mana = new ManagerImpl();
					new ManaProfile(mana.getIDBySignUp(id));

				}

				if ("1".equals(newValue.toString())) {

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
//			}
//		});

//	hbox2.setSpacing(200);
		hbox2.getChildren().addAll(Title, hbox);

		bor.setTop(hbox2);

		VBox vbox = new VBox();
		vbox.setSpacing(20);
		vbox.setPadding(new Insets(10, 10, 10, 0));

		VBox viewCus = new CustomerView();
		viewCus.getStyleClass().add("back2");
		bor.setCenter(viewCus);
		
		Button ManaCus = new Button("Customer ", new ImageView(image1));
		ManaCus.setAlignment(Pos.CENTER);
		ManaCus.setPrefWidth(150);
		ManaCus.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				bor.setCenter(viewCus);
			}
		});
		
		VBox viewPro = new ManagerProductView();
		viewPro.getStyleClass().add("back2");
		
		
		Button ManaPro = new Button("Product ", new ImageView(image2));
		ManaPro.setAlignment(Pos.CENTER);
		ManaPro.setPrefWidth(150);
		ManaPro.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				bor.setCenter(viewPro);
			}
		});
		
		VBox viewPit = new ManagerPitchView();
		viewPit.getStyleClass().add("back2");
		

		Button ManaPitch = new Button("Pitch ", new ImageView(image3));
		ManaPitch.setAlignment(Pos.CENTER);
		ManaPitch.setPrefWidth(150);
		ManaPitch.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				bor.setCenter(viewPit);
			}
		});

		ManaCus.getStyleClass().add("button1");
		ManaPro.getStyleClass().add("button1");
		ManaPitch.getStyleClass().add("button1");

		vbox.getChildren().addAll(ManaCus, ManaPro, ManaPitch);

		bor.setLeft(vbox);

		bor.getStyleClass().add("back1");
		Scene s = new Scene(bor, 900, 500);
		s.getStylesheets().add("test.css");
		this.setScene(s);
		this.setTitle("Customer");
		this.show();

	}

}