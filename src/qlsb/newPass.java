package qlsb;

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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class newPass extends Stage {
	

	public newPass(int i) {
		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setPadding(new Insets(20, 40, 20, 40));

		Text tTitle = new Text("Reset your password");
		tTitle.setFont(new Font("Times New Roman", 30));
		GridPane.setConstraints(tTitle, 0, 0, 2, 1);
		g.add(tTitle, 0, 0);

		Label note = new Label("You have successfully reset your password.\r\n" + "Please create a new password");
		note.setFont(new Font("Times New Roman", 15));
		note.setWrapText(true);
		GridPane.setConstraints(note, 0, 1, 2, 1);
		g.add(note, 0, 1);

		PasswordField txNewpass = new PasswordField();
		txNewpass.setPromptText("Enter new password");
		txNewpass.setPrefHeight(35);
		GridPane.setConstraints(txNewpass, 0, 2, 2, 1);
		g.add(txNewpass, 0, 2);

		PasswordField txRenewpass = new PasswordField();
		txRenewpass.setPromptText("Enter re-new password");
		txRenewpass.setPrefHeight(35);
		GridPane.setConstraints(txRenewpass, 0, 3, 2, 1);
		g.add(txRenewpass, 0, 3);

		Button ok = new Button("OK");
		ok.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		ok.setFont(new Font("Times New Roman", 15));
		ok.setPrefWidth(200);
		ok.setPrefHeight(35);
		GridPane.setConstraints(ok, 0, 4, 2, 1, HPos.LEFT, VPos.CENTER);
		g.add(ok, 0, 4);
		
		ok.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode()==KeyCode.ENTER) {
					CustomerDao cu=new CustormerImpl();
					CustomerDto user2 = cu.getCustomerById(i);
					if (txNewpass.getText().isEmpty() || txRenewpass.getText().isEmpty()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Enter all infomation");
						alert.showAndWait();
					} else if (txNewpass.getText().equals(txRenewpass.getText())) {
						if (user2 != null) {
							user2.setPassword(txNewpass.getText());
							cu.updateUser(user2);
						}
						close();
						new Login();
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
				CustomerDao cu=new CustormerImpl();
				CustomerDto user2 = cu.getCustomerById(i);
				if (txNewpass.getText().isEmpty() || txRenewpass.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Enter all infomation");
					alert.showAndWait();
				} else if (txNewpass.getText().equals(txRenewpass.getText())) {
					if (user2 != null) {
						user2.setPassword(txNewpass.getText());
						cu.updateUser(user2);
					}
					close();
					new Login();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Your password is not the same");
					alert.showAndWait();
				}
			}
		});

	
		Scene scene = new Scene(g);
		this.setScene(scene);
		this.setTitle("Reset password");
		this.show();

	}
}
