package Customer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Cart extends VBox {
		
	public Cart()
	{
		BorderPane bor = new BorderPane();
		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(70);
		g.setPadding(new Insets(20, 40, 20, 40));
		
		
		Text titel = new Text("Cart");
		titel.setFont(new Font("Times New Roman", 50));
		GridPane.setConstraints(titel, 0, 0, 2, 1);
		g.add(titel, 0, 0);
		
		Text tproduct = new Text("Product");
		g.add(tproduct, 0, 1);
		
		Text uPrice = new Text("Unit Price");
		g.add(uPrice, 1, 1);
		
		Text quantity = new Text("Quantity");
		g.add(quantity, 2, 1);
		
		Text tprice = new Text("Price");
		g.add(tprice, 3, 1);
		
		VBox spA = new VBox();
		Image imageA = new Image("sting.png");
		ImageView viewA = new ImageView(imageA);
		viewA.setFitHeight(50);
		viewA.setFitWidth(50);
		
		
		
		
		
		
		Label txNameA = new Label("   Sting");
		
		spA.getChildren().addAll(viewA,txNameA);
		g.add(spA, 0, 2);
		
		TextField txPriceAFix = new TextField();
		txPriceAFix.setPrefWidth(40);
		txPriceAFix.setDisable(true);
		txPriceAFix.setAlignment(Pos.CENTER);
		txPriceAFix.setStyle("-fx-text-fill: red;");
		txPriceAFix.setText("1$");
		g.add(txPriceAFix, 1, 2);
		
		
	
		final Spinner<Integer> spinnerA = new Spinner<Integer>();

		final int initialValueA = 1;
		
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
				initialValueA);

		spinnerA.setValueFactory(valueFactory);
		spinnerA.setPrefWidth(60);

//		final String[] number = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
//				"12", "13", "14", "15$", "16$", "17$", "18$", "19$", "20$", "21$", "22$", "23$", "24$", "25$", "26$",
//				"27$", "28$", "29$", "30$" };
		
		final Integer[] number = new Integer[] { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30 };
		
		TextField txPriceA = new TextField();
		txPriceA.setPrefWidth(40);
		txPriceA.setDisable(true);
		txPriceA.setAlignment(Pos.CENTER);
		txPriceA.setStyle("-fx-text-fill: red;");
		txPriceA.setText("1$");
		
		g.add(txPriceA, 3, 2);
		
		//thay sua
		spinnerA.valueProperty().addListener(new ChangeListener<Integer>() {
			
			@Override
			public void changed(ObservableValue<? extends Integer> observable, //
					Integer oldValue, Integer newValue) {
				
				
				txPriceA.setText(number[(int) newValue]+"$");
			
			
				
			}
		});
	
		
		g.add(spinnerA, 2, 2);
		
		Button delete = new Button("Delete");
		g.add(delete, 4, 2);
		delete.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
		
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setContentText("Do you want to delete ?");
				alert.showAndWait();
			}
		});
		
		
		VBox spB = new VBox();
		Image imageB = new Image("redbull.png");
		ImageView viewB = new ImageView(imageB);
		viewB.setFitHeight(50);
		viewB.setFitWidth(50);
		
		Label txNameB = new Label(" Red bull");
		
		spB.getChildren().addAll(viewB,txNameB);
		g.add(spB, 0, 3);
		
		TextField txPriceBFix = new TextField();
		txPriceBFix.setPrefWidth(40);
		txPriceBFix.setDisable(true);
		txPriceBFix.setAlignment(Pos.CENTER);
		txPriceBFix.setStyle("-fx-text-fill: red;");
		txPriceBFix.setText("1$");
		g.add(txPriceBFix, 1, 3);
		
		
		final Spinner<Integer> spinnerB = new Spinner<Integer>();

		final int initialValueB = 1;
		
		SpinnerValueFactory<Integer> valueFactoryB = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
				initialValueB);

		spinnerB.setValueFactory(valueFactoryB);
		spinnerB.setPrefWidth(60);

		final Integer[] numberB = new Integer[] { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30 };
		
		
		TextField txPriceB = new TextField();
		txPriceB.setPrefWidth(40);
		txPriceB.setDisable(true);
		txPriceB.setAlignment(Pos.CENTER);
		txPriceB.setStyle("-fx-text-fill: red;");
		txPriceB.setText("1$");
		
		g.add(txPriceB, 3, 3);
		
//		int totalB =0;
		spinnerB.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> observable, //
					Integer oldValue, Integer newValue) {

				txPriceB.setText(numberB[(int) newValue]+"$");
//				totalB = number[(int) newValue];
			}
		});
		
		g.add(spinnerB, 2, 3);
		
		
		Button deleteB = new Button("Delete");
		g.add(deleteB, 4, 3);
		deleteB.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setContentText("Do you want to delete ?");
				alert.showAndWait();
			}
		});
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(20, 20, 20, 200));
		hbox.setSpacing(50);
		
		
		Text total = new Text("Total Price:");
		
		TextField txTotal = new TextField();
		
		txTotal.setPrefWidth(100);
		txTotal.setDisable(true);
		txTotal.setAlignment(Pos.CENTER);
		txTotal.setStyle("-fx-text-fill: red;");
		txTotal.setText(txPriceA.getText());
		
		
 
		
		Button buynow = new Button("Buy Now");
		
		hbox.getChildren().addAll(total,txTotal,buynow);
		
		bor.setBottom(hbox);
		
		
		bor.setCenter(g);
	}
}
