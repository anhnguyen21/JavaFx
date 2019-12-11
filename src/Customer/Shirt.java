package Customer;

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

public class Shirt extends VBox {
	ProductDao product=new ProductImlp();
	public Shirt(int i) {
		// TODO Auto-generated method stub

		VBox vboxHead = new VBox();

		HBox hboxHead = new HBox();
		hboxHead.setPadding(new Insets(10, 10, 10, 10));

		Image image1 = new Image("ao1.png");

		Image image2 = new Image("ao5.png");

		Image image3 = new Image("ao3.png");

		Image image4 = new Image("ao4.png");

		// Sting
		ImageView viewA = new ImageView(image1);
		viewA.setFitHeight(128);
		viewA.setFitWidth(128);

		HBox hboxA = new HBox();

		VBox vboxA = new VBox();
		vboxA.setPadding(new Insets(10, 10, 10, 10));
		vboxA.setSpacing(10);
		Label txNameA = new Label("Red Shirt");
		txNameA.getStyleClass().add("test2");

		final Spinner<Integer> spinnerA = new Spinner<Integer>();

		final int initialValueA = 1;

		// Value factory.
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50,
				initialValueA);

		spinnerA.setValueFactory(valueFactory);
		spinnerA.setPrefWidth(70);

		TextField txPriceA = new TextField();
		txPriceA.setPrefWidth(50);
		txPriceA.setEditable(false);
		txPriceA.getStyleClass().add("text1");;
		txPriceA.setText("10000");

		spinnerA.valueProperty().addListener(new ChangeListener<Integer>() {

			double i=10000,t;
			@Override
			public void changed(ObservableValue<? extends Integer> observable, //
					Integer oldValue, Integer newValue) {
				t++;
				txPriceA.setText(""+i*t+"");	
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

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				Integer priceInt = Integer.valueOf(spinnerA.getValue().toString());
				Productsdto pro=new Productsdto("Red Shirt",10000,priceInt);
				Productsdto pro1=new Productsdto(5,priceInt);
				product.insertCustomer(pro);
				product.insertOderProduct(pro1, i);
				Alert alear = new Alert(AlertType.INFORMATION);
				alear.setHeaderText(null);
				alear.setContentText("Added to the cart");
				alear.showAndWait();
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
						initialValueA);
				spinnerA.setValueFactory(valueFactory);
				txPriceA.setText("10000");
			}
		});

		// Red bull

		HBox hboxB = new HBox();

		VBox vboxB = new VBox();
		vboxB.setPadding(new Insets(10, 10, 10, 10));
		vboxB.setSpacing(10);

		Label txNameB = new Label("Yellow Shirt");
		Label tPriceB = new Label("Price:");
		txNameB.getStyleClass().add("test2");
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
		txPriceB.setPrefWidth(50);
		txPriceB.setEditable(false);
		txPriceB.getStyleClass().add("text1");
		txPriceB.setText("10000");

		spinnerB.valueProperty().addListener(new ChangeListener<Integer>() {

			double i=10000,t;
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
				// TODO Auto-generated method stub
				Integer priceInt = Integer.valueOf(spinnerB.getValue().toString());
				Productsdto pro=new Productsdto("Yellow Shirt",10000,priceInt);
				Productsdto pro1=new Productsdto(6,priceInt);
				product.insertCustomer(pro);
				product.insertOderProduct(pro1, i);
				Alert alear = new Alert(AlertType.INFORMATION);
				alear.setHeaderText(null);
				alear.setContentText("Added to the cart");
				alear.showAndWait();
				txPriceB.setText("10000");
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
						initialValueA);
				spinnerB.setValueFactory(valueFactory);

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

		Label txNameC = new Label("Blue Shirt ");
		Label tPriceC = new Label("Price:");
		txNameC.getStyleClass().add("test2");
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
		txPriceC.setText("10000");
	
		spinnerC.valueProperty().addListener(new ChangeListener<Integer>() {

			double i=10000,t;
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
				// TODO Auto-generated method stub
				Integer priceInt = Integer.valueOf(spinnerC.getValue().toString());
				Productsdto pro=new Productsdto("Blue Shirt",10000,priceInt);
				Productsdto pro1=new Productsdto(7,priceInt);
				product.insertCustomer(pro);
				product.insertOderProduct(pro1, i);
				Alert alear = new Alert(AlertType.INFORMATION);
				alear.setHeaderText(null);
				alear.setContentText("Added to the cart");
				alear.showAndWait();
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
						initialValueA);
				spinnerC.setValueFactory(valueFactory);
				txPriceC.setText("10000");
			}
		});

		// Water
		HBox hboxD = new HBox();

		VBox vboxD = new VBox();
		vboxD.setPadding(new Insets(10, 10, 10, 10));
		vboxD.setSpacing(10);

		Label txNameD = new Label("Green Shirt");
		Label tPriceD = new Label("Price:");
		txNameD.getStyleClass().add("test2");
		tPriceA.getStyleClass().add("test2");
		Button addD = new Button("Add");
		addD.getStyleClass().add("blue");

		final Spinner<Integer> spinnerD = new Spinner<Integer>();

		final int initialValueD = 1;

		// Value factory.
		SpinnerValueFactory<Integer> valueFactoryD = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
				initialValueD);

		spinnerD.setValueFactory(valueFactoryD);
		spinnerD.setPrefWidth(70);

		
		TextField txPriceD = new TextField();
		txPriceD.setPrefWidth(40);
		txPriceD.setEditable(false);
		txPriceD.getStyleClass().add("text1");
		txPriceD.setText("10000");

		spinnerD.valueProperty().addListener(new ChangeListener<Integer>() {

			double i=10000,t;
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
				// TODO Auto-generated method stub
				Integer priceInt = Integer.valueOf(spinnerC.getValue().toString());
				Productsdto pro=new Productsdto("Green Shirt",10000,priceInt);
				Productsdto pro1=new Productsdto(8,priceInt);
				product.insertCustomer(pro);
				product.insertOderProduct(pro1, i);
				Alert alear = new Alert(AlertType.INFORMATION);
				alear.setHeaderText(null);
				alear.setContentText("Added to the cart");
				alear.showAndWait();
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
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
		getStylesheets().add("test.css");
	}
}
