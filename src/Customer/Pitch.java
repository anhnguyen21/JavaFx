package Customer;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Pitch extends VBox {

	public Pitch(int id) {
		// TODO Auto-generated method stub

		VBox vboxHead = new VBox();
		
		HBox hboxHead = new HBox();
		hboxHead.setPadding(new Insets(10, 10, 10, 10));

		Image image = new Image("football A.png");

		Image image1 = new Image("football B.png");

		// san A
		ImageView viewA = new ImageView(image);

		HBox hboxA = new HBox();

		VBox vboxA = new VBox();
		Label txNameA = new Label("Pitch A");
		
		
		Label txPriceA = new Label("Price : 100000/ 1h");
		txPriceA.getStyleClass().add("test2");
		txNameA.getStyleClass().add("test2");
		Button addA = new Button("Add");
		addA.getStyleClass().add("blue");
		vboxA.setSpacing(20);
		vboxA.getChildren().addAll(txNameA, txPriceA, addA);
		hboxA.getChildren().addAll(viewA, vboxA);
		
		addA.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				new ChoiceTime(id,txNameA.getText());
			}
		});
		//San B
		HBox hboxB = new HBox();

		VBox vboxB = new VBox();
		Label txNameB = new Label("Pitch B");
		Label txPriceB = new Label("Price : 100000/ 1h");
		txPriceB.getStyleClass().add("test2");
		txNameB.getStyleClass().add("test2");
		Button addB = new Button("Add");
		addB.getStyleClass().add("blue");
		vboxB.setSpacing(20);
		vboxB.getChildren().addAll(txNameB, txPriceB, addB);
		
		addB.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				new ChoiceTime(id,txNameB.getText());
			}
		});
		
		ImageView viewB = new ImageView(image1);
		hboxB.getChildren().addAll(viewB, vboxB);
		
		
		hboxHead.getChildren().addAll(hboxA,hboxB);
		HBox hboxSecond = new HBox();
		hboxSecond.setPadding(new Insets(10, 10, 10, 10));

		
		//San C
		ImageView viewC = new ImageView(image);

		HBox hboxC = new HBox();

		VBox vboxC = new VBox();
		Label txNameC = new Label("Pitch C");
		Label txPriceC = new Label("Price : 100000/1h");
		txPriceC.getStyleClass().add("test2");
		txNameC.getStyleClass().add("test2");
		vboxC.setSpacing(20);
		
		Button addC = new Button("Add");
		addC.getStyleClass().add("blue");
		vboxC.getChildren().addAll(txNameC, txPriceC, addC);
		hboxC.getChildren().addAll(viewC, vboxC);
		addC.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				new ChoiceTime(id,txNameC.getText());
			}
		});
		
		//San D
		HBox hboxD = new HBox();

		VBox vboxD = new VBox();
		Label txNameD = new Label("Pitch D");
		Label txPriceD = new Label("Price : 100000/1h");
		txPriceD.getStyleClass().add("test2");
		txNameD.getStyleClass().add("test2");
		vboxD.setSpacing(20);
		Button addD = new Button("Add");
		addD.getStyleClass().add("blue");
		vboxD.getChildren().addAll(txNameD, txPriceD, addD);
		
		addD.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				new ChoiceTime(id,txNameD.getText());
			}
		});
		
		ImageView viewD = new ImageView(image1);
		hboxD.getChildren().addAll(viewD, vboxD);

		
		
		hboxSecond.getChildren().addAll(hboxC, hboxD);
		
		
		vboxHead.getChildren().addAll(hboxHead,hboxSecond);
		
		getChildren().add(vboxHead);
		getStylesheets().add("test.css");
	}
	
}
