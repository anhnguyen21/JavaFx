package Customer;

import Bll.Custormerlmpl;
import Bll.ICustomer;
import Model.Customer;
import PersonDto.CustomerDto;
import dao.CustomerDao;
import dao.CustormerImpl;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangePass extends Stage {

	public ChangePass(String b, int id) {
		CustomerDao cu= new CustormerImpl();
		CustomerDto cus=cu.getCustomerById(id);
		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setPadding(new Insets(20, 40, 20, 40));

		Text tTitle = new Text("Change password");
		tTitle.setFont(new Font("Times New Roman", 30));
		GridPane.setConstraints(tTitle, 0, 0, 2, 1);
		g.add(tTitle, 0, 0);

		Label note = new Label("Please enter old password and new password");
		note.setFont(new Font("Times New Roman", 15));
		note.setWrapText(true);
		GridPane.setConstraints(note, 0, 1, 2, 1);
		g.add(note, 0, 1);

		HBox hbox = new HBox();
		hbox.setSpacing(20);

		PasswordField txOldpass = new PasswordField();
		txOldpass.setPromptText("Enter old password");
		txOldpass.setPrefHeight(35);
		GridPane.setConstraints(txOldpass, 0, 2, 2, 1);

		PasswordField txNewpass = new PasswordField();
		txNewpass.setPromptText("Enter new password");
		txNewpass.setPrefHeight(35);
		GridPane.setConstraints(txNewpass, 0, 3, 2, 1);
		g.add(txNewpass, 0, 3);
		txNewpass.setDisable(true);

		PasswordField txRenewpass = new PasswordField();
		txRenewpass.setPromptText("Enter re-new password");
		txRenewpass.setPrefHeight(35);
		GridPane.setConstraints(txRenewpass, 0, 4, 2, 1);
		g.add(txRenewpass, 0, 4);
		txRenewpass.setDisable(true);

		Button check = new Button("Check");
		check.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		check.setFont(new Font("Times New Roman", 15));
		check.setPrefWidth(100);
		check.setPrefHeight(35);

		Button ok = new Button("OK");
		ok.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		ok.setFont(new Font("Times New Roman", 15));
		ok.setPrefWidth(200);
		ok.setPrefHeight(35);
		GridPane.setConstraints(ok, 0, 5, 2, 1, HPos.LEFT, VPos.CENTER);
		g.add(ok, 0, 5);
		ok.setDisable(true);

		hbox.getChildren().addAll(txOldpass, check);

		g.add(hbox, 0, 2);

		txOldpass.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.ENTER) {
					if (txOldpass.getText().isEmpty()) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setHeaderText(null);
						alert.setContentText("Please enter old password");
						alert.showAndWait();
					} else if (cus.getPassword().equals(txOldpass.getText())) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText(null);
						alert.setContentText("Correct password");
						alert.showAndWait();
						txNewpass.setDisable(false);
						txRenewpass.setDisable(false);
						ok.setDisable(false);

					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setHeaderText(null);
						alert.setContentText("Incorrect password");
						alert.showAndWait();
					}

				}
			}

		});

		check.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				if (txOldpass.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText(null);
					alert.setContentText("Please enter old password");
					alert.showAndWait();
				} else if (cus.getPassword().equals(txOldpass.getText())) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setContentText("Correct password");
					alert.showAndWait();
					txNewpass.setDisable(false);
					txRenewpass.setDisable(false);
					ok.setDisable(false);

				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText(null);
					alert.setContentText("Incorrect password");
					alert.showAndWait();
				}

			}
		});

		txRenewpass.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				CustomerDao cu= new CustormerImpl();
				CustomerDto user2 = cu.getCustomerById(id);
				if (event.getCode() == KeyCode.ENTER) {
					if (txNewpass.getText().isEmpty() || txRenewpass.getText().isEmpty()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Enter all infomation");
						alert.showAndWait();
					} else if (txNewpass.getText().equals(txRenewpass.getText())) {
						if (user2 != null) {
							user2.setPassword(txNewpass.getText());
							cu.updatePass(user2);
							
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setHeaderText(null);
							alert.setContentText("Your password has been successfully changed");
							alert.showAndWait();
							close();
						}

					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Your password is not the same");
						alert.showAndWait();
					}
				}
			}
		});

		ok.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				CustomerDao cu= new CustormerImpl();
				CustomerDto user2 = cu.getCustomerById(id);

				if (txNewpass.getText().isEmpty() || txRenewpass.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Enter all infomation");
					alert.showAndWait();
				} else if (txNewpass.getText().equals(txRenewpass.getText())) {
					
					if (user2 != null) {
						user2.setPassword(txNewpass.getText());
						cu.updatePass(user2);
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText(null);
						alert.setContentText("Your password has been successfully changed");
						alert.showAndWait();
						close();
					}

				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Your password is not the same");
					alert.showAndWait();
				}

			}
		});

		Scene scene = new Scene(g);
		setScene(scene);
		setTitle("Reset password");
		show();

	}
//	PUBLIC STATIC VOID MAIN(STRING [] ARGS)
//	{
//		LAUNCH(ARGS);
//	}
}
