package Customer;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Productdao.ProductDao;
import Productdao.ProductImlp;
import Productdto.Pitchdto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChoiceTime extends Stage {
	ProductDao product = new ProductImlp();

	public ChoiceTime(int id, String string) {
		// TODO Auto-generated method stub
		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setPadding(new Insets(10, 10, 10, 10));

		Text tTitle = new Text("ADD");
		tTitle.setFont(new Font("Times New Roman", 30));
		GridPane.setConstraints(tTitle, 0, 0, 2, 1,HPos.CENTER,VPos.CENTER);
		g.add(tTitle, 0, 0);

		Text txdate = new Text("Date");
		GridPane.setConstraints(txdate, 0, 1, 2, 1);
		g.add(txdate, 0, 1);

		DatePicker datepick = new DatePicker();
		g.add(datepick, 0, 2);

		Text txhead = new Text("Select the time frame");
		GridPane.setConstraints(txhead, 0, 2, 2, 1);
		g.add(txhead, 0, 3);

		Text tStart = new Text("Start time");
		g.add(tStart, 0, 4);

		Text txStartHour = new Text();
		final Integer[] txhour = new Integer[] { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };

		ChoiceBox<Integer> hour = new ChoiceBox<>(
				FXCollections.observableArrayList(8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));
		hour.setPrefWidth(50);
		hour.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				txStartHour.setText(txhour[(int) newValue].toString());
			}
		});
		/*--------------------------------------------------------*/
		Text txStartMinutes = new Text();
		final Integer[] txminutes = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
				20, 21, 22, 23, 24, 25, 25, 27, 28, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 41, 43, 44, 45, 46,
				47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 };
		ChoiceBox<Integer> minutes = new ChoiceBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 25, 27, 28, 30, 31, 32, 33, 34, 35, 36, 37,
				38, 39, 40, 41, 41, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60));
		minutes.setPrefWidth(50);

		minutes.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				txStartMinutes.setText(txminutes[(int) newValue].toString());
			}
		});

		/*--------------------------------------------------------*/
		Text txEndHour = new Text();
		final Integer[] txhourF = new Integer[] { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };

		ChoiceBox<Integer> hourF = new ChoiceBox<>(
				FXCollections.observableArrayList(8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));
		hourF.setPrefWidth(50);

		hourF.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				txEndHour.setText(txhourF[(int) newValue].toString());
			}
		});
		/*--------------------------------------------------------*/
		Text txEndMinutes = new Text();
		final Integer[] txminutesF = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
				20, 21, 22, 23, 24, 25, 25, 27, 28, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 41, 43, 44, 45, 46,
				47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 };

		ChoiceBox<Integer> minutesF = new ChoiceBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 25, 27, 28, 30, 31, 32, 33, 34, 35, 36, 37,
				38, 39, 40, 41, 41, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60));

		minutesF.setPrefWidth(50);

		minutesF.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				txEndMinutes.setText(txminutesF[(int) newValue].toString());
			}
		});

		HBox b1 = new HBox();

		b1.getChildren().addAll(hourF, minutesF);
		g.add(b1, 1, 5);

		HBox b = new HBox();
		b.getChildren().addAll(hour, minutes);
		g.add(b, 0, 5);

		Text tEnd = new Text("End time");
		g.add(tEnd, 1, 4);

		Button Add = new Button("Add");
		Add.setPrefSize(100, 35);
		Add.getStyleClass().add("blue");
		g.add(Add, 0, 6, 2, 1);

		TextField price = new TextField();
		price.setEditable(false);
		Add.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (Integer.parseInt(txEndHour.getText()) >= Integer.parseInt(txStartHour.getText())
						&& Integer.parseInt(txEndMinutes.getText()) >= Integer.parseInt(txStartMinutes.getText())) {
					if (string.equals("Pitch A")) {
						DateFormat format = new SimpleDateFormat("HH:mm");
						try {
							Pitchdto pit = new Pitchdto(1, Date.valueOf(datepick.getValue()),
									new java.sql.Time(format
											.parse(txStartHour.getText() + ":" + txStartMinutes.getText()).getTime()),
									new java.sql.Time(format.parse(txEndHour.getText() + ":" + txEndMinutes.getText())
											.getTime()));
							product.insertOderPitch(pit, id);
							Alert alear = new Alert(AlertType.INFORMATION);
							alear.setHeaderText(null);
							alear.setContentText("Added to the cart");
							alear.showAndWait();
							close();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (string.equals("Pitch B")) {
						DateFormat format = new SimpleDateFormat("HH:mm");
						try {
							Pitchdto pit1 = new Pitchdto(2, Date.valueOf(datepick.getValue()),
									new java.sql.Time(format
											.parse(txStartHour.getText() + ":" + txStartMinutes.getText()).getTime()),
									new java.sql.Time(format.parse(txEndHour.getText() + ":" + txEndMinutes.getText())
											.getTime()));
							product.insertOderPitch(pit1, id);
							Alert alear = new Alert(AlertType.INFORMATION);
							alear.setHeaderText(null);
							alear.setContentText("Added to the cart");
							alear.showAndWait();
							close();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (string.equals("Pitch C")) {
						DateFormat format = new SimpleDateFormat("HH:mm");
						try {
							Pitchdto pit3 = new Pitchdto(3, Date.valueOf(datepick.getValue()),
									new java.sql.Time(format
											.parse(txStartHour.getText() + ":" + txStartMinutes.getText()).getTime()),
									new java.sql.Time(format.parse(txEndHour.getText() + ":" + txEndMinutes.getText())
											.getTime()));
							product.insertOderPitch(pit3, id);
							Alert alear = new Alert(AlertType.INFORMATION);
							alear.setHeaderText(null);
							alear.setContentText("Added to the cart");
							alear.showAndWait();
							close();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (string.equals("Pitch D")) {
						DateFormat format = new SimpleDateFormat("HH:mm");
						try {
							Pitchdto pit4 = new Pitchdto(4, Date.valueOf(datepick.getValue()),
									new java.sql.Time(format
											.parse(txStartHour.getText() + ":" + txStartMinutes.getText()).getTime()),
									new java.sql.Time(format.parse(txEndHour.getText() + ":" + txEndMinutes.getText())
											.getTime()));
							product.insertOderPitch(pit4, id);
							Alert alear = new Alert(AlertType.INFORMATION);
							alear.setHeaderText(null);
							alear.setContentText("Added to the cart");
							alear.showAndWait();
							close();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Please re-enter");
					alert.showAndWait();
					new ChoiceTime(id,string);
				}
			}
		});

		Scene s = new Scene(g);
		s.getStylesheets().add("test.css");
		this.setTitle("Add Pitch");
		this.setScene(s);
		this.show();

	}

}
