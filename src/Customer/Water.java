package Customer;

import com.sun.prism.paint.Color;

import Productdao.ProductDao;
import Productdao.ProductImlp;
import Productdto.Productsdto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Water extends VBox {
	
	ProductDao product=new ProductImlp();

	public Water(int i) {
		// TODO Auto-generated method stub

		VBox vboxHead = new VBox();

		HBox hboxHead = new HBox();
		hboxHead.setPadding(new Insets(10, 10, 10, 10));

		Image image1 = new Image("sting.png");

		Image image2 = new Image("redbull.png");

		Image image3 = new Image("coca.jpg");

		Image image4 = new Image("aqua.png");

		// Sting
		ImageView viewA = new ImageView(image1);
		viewA.setFitHeight(128);
		viewA.setFitWidth(128);

		HBox hboxA = new HBox();

		VBox vboxA = new VBox();
		vboxA.setPadding(new Insets(10, 10, 10, 10));
		vboxA.setSpacing(10);
		Label txNameA = new Label("Sting");
		txNameA.getStyleClass().add("test2");

		final Spinner<Integer> spinnerA = new Spinner<Integer>();

		final int initialValueA = 1;

		// Value factory.
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000,
				initialValueA);

		spinnerA.setValueFactory(valueFactory);
		spinnerA.setPrefWidth(70);

		TextField txPriceA = new TextField();
		txPriceA.setPrefWidth(40);
		txPriceA.setEditable(false);
		txPriceA.getStyleClass().add("text1");
//		txPriceA.setStyle("-fx-text-inner-color: red;");
		
		txPriceA.setText("5000");
		
		spinnerA.valueProperty().addListener(new ChangeListener<Integer>() {
			int i=5000,t=1;
			@Override
			public void changed(ObservableValue<? extends Integer> observable, //
					Integer oldValue, Integer newValue) {
				t++;
				txPriceA.setText(""+(i)*t+"");	
			}
		});

		HBox hboxPriceA = new HBox();
		Label tPriceA = new Label("Price:");
		tPriceA.getStyleClass().add("test2");

		hboxPriceA.getChildren().addAll(tPriceA, txPriceA);

		Button addA = new Button("Add");
		addA.getStyleClass().add("blue");

		vboxA.getChildren().addAll(txNameA, hboxPriceA, spinnerA, addA);
		hboxA.getChildren().addAll(viewA, vboxA);

		addA.setOnMouseClicked(new EventHandler<Event>() {
			
			
			public void handle(Event event) {
				Integer priceInt = Integer.valueOf(spinnerA.getValue().toString());
				Productsdto pro=new Productsdto("Sting",10000,priceInt);
				Productsdto pro1=new Productsdto(1,priceInt);
				product.insertCustomer(pro);
				product.insertOderProduct(pro1, i);
				// TODO Auto-generated method stub
				Alert alear = new Alert(AlertType.INFORMATION);
				alear.setHeaderText(null);
				alear.setContentText("Added to the cart");
				alear.showAndWait();
				
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
						initialValueA);
				spinnerA.setValueFactory(valueFactory);
				txPriceA.setText("5000");
			}
		});

		// Red bull

		HBox hboxB = new HBox();

		VBox vboxB = new VBox();
		vboxB.setPadding(new Insets(10, 10, 10, 10));
		vboxB.setSpacing(10);

		Label txNameB = new Label("Red Bull");
		txNameB.getStyleClass().add("test2");
		Label tPriceB = new Label("Price:");
		tPriceB.getStyleClass().add("test2");
		Button addB = new Button("Add");
		addB.getStyleClass().add("blue");

		final Spinner<Integer> spinnerB = new Spinner<Integer>();

		final int initialValueB = 1;

		// Value factory.
		SpinnerValueFactory<Integer> valueFactoryB = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
				initialValueB);

		spinnerB.setValueFactory(valueFactoryB);
		spinnerB.setPrefWidth(70);

		TextField txPriceB = new TextField();
		txPriceB.setPrefWidth(40);
		txPriceB.setEditable(false);
		txPriceB.getStyleClass().add("text1");
		txPriceB.setText("5000");

		spinnerB.valueProperty().addListener(new ChangeListener<Integer>() {
			int i=5000,t=1;
			@Override
			public void changed(ObservableValue<? extends Integer> observable, //
					Integer oldValue, Integer newValue) {
				t++;
				txPriceB.setText(""+i*t+"");	
			}
		});
		HBox hboxPriceB = new HBox();
		hboxPriceB.getChildren().addAll(tPriceB, txPriceB);
		vboxB.getChildren().addAll(txNameB, hboxPriceB, spinnerB, addB);

		addB.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				Integer priceInt = Integer.valueOf(spinnerB.getValue().toString());
				Productsdto pro=new Productsdto("Red Bull",10000,priceInt);
				Productsdto pro1=new Productsdto(2,priceInt);
				product.insertCustomer(pro);
				product.insertOderProduct(pro1, i);
				// TODO Auto-generated method stub
				Alert alear = new Alert(AlertType.INFORMATION);
				alear.setHeaderText(null);
				alear.setContentText("Added to the cart");
				alear.showAndWait();
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
						initialValueA);
				spinnerB.setValueFactory(valueFactory);
				txPriceB.setText("5000");
			}
		});

		ImageView viewB = new ImageView(image2);
		viewB.setFitHeight(128);
		viewB.setFitWidth(128);

		hboxB.getChildren().addAll(viewB, vboxB);

		hboxHead.getChildren().addAll(hboxA, hboxB);
		HBox hboxSecond = new HBox();
		hboxSecond.setPadding(new Insets(10, 10, 10, 10));

		// Coca
		ImageView viewC = new ImageView(image3);
		viewC.setFitHeight(128);
		viewC.setFitWidth(128);

		HBox hboxC = new HBox();

		VBox vboxC = new VBox();
		vboxC.setPadding(new Insets(10, 10, 10, 10));
		vboxC.setSpacing(10);

		Label txNameC = new Label("Coca ");
		txNameC.getStyleClass().add("test2");
		Label tPriceC = new Label("Price:");
		tPriceC.getStyleClass().add("test2");
		Button addC = new Button("Add");
		addC.getStyleClass().add("blue");

		final Spinner<Integer> spinnerC = new Spinner<Integer>();

		final int initialValueC = 1;

		// Value factory.
		SpinnerValueFactory<Integer> valueFactoryC = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
				initialValueC);

		spinnerC.setValueFactory(valueFactoryC);
		spinnerC.setPrefWidth(70);

		TextField txPriceC = new TextField();
		txPriceC.setPrefWidth(40);
		txPriceC.setEditable(false);
		txPriceC.getStyleClass().add("text1");
		txPriceC.setText("1500");

		spinnerC.valueProperty().addListener(new ChangeListener<Integer>() {

			int i=1500,t=1;
			@Override
			public void changed(ObservableValue<? extends Integer> observable, //
					Integer oldValue, Integer newValue) {
				t++;
				txPriceC.setText(""+i*t+"");	
			}
		});
		HBox hboxPriceC = new HBox();
		hboxPriceC.getChildren().addAll(tPriceC, txPriceC);

		vboxC.getChildren().addAll(txNameC, hboxPriceC, spinnerC, addC);
		hboxC.getChildren().addAll(viewC, vboxC);
		addC.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				Integer priceInt = Integer.valueOf(spinnerC.getValue().toString());
				Productsdto pro=new Productsdto("Coca",10000,priceInt);
				Productsdto pro1=new Productsdto(3,priceInt);
				product.insertCustomer(pro);
				product.insertOderProduct(pro1, i);
				// TODO Auto-generated method stub
				Alert alear = new Alert(AlertType.INFORMATION);
				alear.setHeaderText(null);
				alear.setContentText("Added to the cart");
				alear.showAndWait();
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50,
						initialValueA);
				spinnerC.setValueFactory(valueFactory);
				txPriceC.setText("1500");
			}
		});

		// Water
		HBox hboxD = new HBox();

		VBox vboxD = new VBox();
		vboxD.setPadding(new Insets(10, 10, 10, 10));
		vboxD.setSpacing(10);

		Label txNameD = new Label("Water");
		txNameD.getStyleClass().add("test2");
		Label tPriceD = new Label("Price:");
		tPriceD.getStyleClass().add("test2");
		Button addD = new Button("Add");
		addD.getStyleClass().add("blue");

		final Spinner<Integer> spinnerD = new Spinner<Integer>();

		final int initialValueD = 1;

		// Value factory.
		SpinnerValueFactory<Integer> valueFactoryD = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50,
				initialValueD);

		spinnerD.setValueFactory(valueFactoryD);
		spinnerD.setPrefWidth(70);

		TextField txPriceD = new TextField();
		txPriceD.setPrefWidth(40);
		txPriceD.setEditable(false);
		txPriceD.getStyleClass().add("text1");
		txPriceD.setText("10000");

		spinnerD.valueProperty().addListener(new ChangeListener<Integer>() {

			int i=10000,t=1;
			@Override
			public void changed(ObservableValue<? extends Integer> observable, //
					Integer oldValue, Integer newValue) {
				t++;
				txPriceD.setText(""+i*t+"");	
			}
		});
		HBox hboxPriceD = new HBox();
		hboxPriceD.getChildren().addAll(tPriceD, txPriceD);

		vboxD.getChildren().addAll(txNameD, hboxPriceD, spinnerD, addD);

		addD.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				Integer priceInt = Integer.valueOf(spinnerC.getValue().toString());
				Productsdto pro=new Productsdto("Water",0.5,priceInt);
				Productsdto pro1=new Productsdto(4,priceInt);
				product.insertCustomer(pro);
				product.insertOderProduct(pro1, i);
				// TODO Auto-generated method stub
				Alert alear = new Alert(AlertType.INFORMATION);
				alear.setHeaderText(null);
				alear.setContentText("Added to the cart");
				alear.showAndWait();
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50,
						initialValueA);
				spinnerD.setValueFactory(valueFactory);
				txPriceD.setText("10000");
			}
		});

		ImageView viewD = new ImageView(image4);
		viewD.setFitHeight(128);
		viewD.setFitWidth(128);

		hboxD.getChildren().addAll(viewD, vboxD);

		hboxSecond.getChildren().addAll(hboxC, hboxD);

		vboxHead.getChildren().addAll(hboxHead, hboxSecond);

		getChildren().add(vboxHead);
	}

}
