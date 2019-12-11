package qlsb;

import Bll.Sign_up;
import Bll.sign_upCutormer;
import Customer.CustomerDisplay;
import Manager_Log.ManagerDisplay;
import PersonDto.CustomerDto;
import PersonDto.ManagerDto;
import dao.CustomerDao;
import dao.CustormerImpl;
import dao.ManagerDao;
import dao.ManagerImpl;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;;

public class Login extends Stage {
	CustomerDao cus = new CustormerImpl();
	ManagerDao mana = new ManagerImpl();

	public Login() {
		Sign_up customer = new sign_upCutormer();
		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setPadding(new Insets(20, 40, 20, 40));

		Image image = new Image("/ronadol.jpg");
		ImageView view = new ImageView(image);
		view.setFitHeight(200);
		view.setFitWidth(200);
		GridPane.setConstraints(view, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
		g.getChildren().add(view);

		Text titel = new Text("San Bong MINI");
		titel.setFont(new Font("Times New Roman", 50));
		GridPane.setConstraints(titel, 0, 0, 2, 1);
		g.add(titel, 0, 0);

		Text tUsername = new Text("Username");
		tUsername.setFont(new Font("Times New Roman", 15));
		g.add(tUsername, 0, 1);

		TextField txUser = new TextField();
		txUser.setPromptText("Username");
		txUser.setPrefHeight(35);
		GridPane.setConstraints(txUser, 0, 2, 2, 1);
		g.add(txUser, 0, 2);

		Text tPassword = new Text("Password");
		tPassword.setFont(new Font("Times New Roman", 15));
		g.add(tPassword, 0, 3);

		PasswordField txPassword = new PasswordField();
		txPassword.setPromptText("Password");
		txPassword.setPrefHeight(35);
		GridPane.setConstraints(txPassword, 0, 4, 2, 1);
		g.add(txPassword, 0, 4);

		Button login = new Button("Log In");
		login.setPrefWidth(200);
		login.setPrefHeight(35);
		login.setFont(new Font("Times New Roman", 15));
		login.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		GridPane.setConstraints(login, 0, 5, 2, 1, HPos.CENTER, VPos.CENTER);
		g.add(login, 0, 5);

		txPassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.ENTER) {
					if (txUser.getText().isEmpty() || txPassword.getText().isEmpty()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Enter all infomation");
						alert.showAndWait();
					} else {
						if (customer.checkLogin(txUser.getText(), txPassword.getText())) {

							Alert alert1 = new Alert(AlertType.INFORMATION);
							alert1.setHeaderText(null);
							alert1.setContentText("Logged in successfully");
							alert1.showAndWait();
							close();

							CustomerDto customer = cus.getPersonBySignUp(txUser.getText(), txPassword.getText());
							new CustomerDisplay(txUser.getText(), customer.getPassword(), customer.getId());
						} else if (customer.checkLoginManger(txUser.getText(), txPassword.getText())) {
							Alert alert1 = new Alert(AlertType.INFORMATION);
							alert1.setHeaderText(null);
							alert1.setContentText("Logged in successfully");
							alert1.showAndWait();
							close();
							ManagerDto manager = mana.getPersonBySignUp(txUser.getText(), txPassword.getText());
							new ManagerDisplay(txUser.getText(), txPassword.getText(),manager.getId());
						} else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("Username or password is incorrect");
							alert.showAndWait();
						}
					}
				}
			}
		});
		login.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				if (customer.checkLogin(txUser.getText(), txPassword.getText())) {
					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setHeaderText(null);
					alert1.setContentText("Logged in successfully");
					alert1.showAndWait();
					close();
					CustomerDto customer = cus.getPersonBySignUp(txUser.getText(), txPassword.getText());
					new CustomerDisplay(txUser.getText(), customer.getPassword(), customer.getId());

				} else if (customer.checkLoginManger(txUser.getText(), txPassword.getText())) {

					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setHeaderText(null);
					alert1.setContentText("Logged in successfully");
					alert1.showAndWait();
					close();
					ManagerDto manager = mana.getPersonBySignUp(txUser.getText(), txPassword.getText());
					new ManagerDisplay(txUser.getText(), txPassword.getText(),manager.getId());
				} else {
					// TODO Auto-generated catch block
					Alert alert1 = new Alert(AlertType.ERROR);
					alert1.setHeaderText(null);
					alert1.setContentText("Username or password is incorrect");
					alert1.showAndWait();
				}
			}

		});

		Button forgot = new Button("Forgot Password?");
		forgot.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		forgot.setFont(new Font("Times New Roman", 15));
		forgot.setPrefHeight(35);
		forgot.setPrefWidth(200);
		GridPane.setConstraints(forgot, 0, 6, 2, 1, HPos.CENTER, VPos.CENTER);
		g.add(forgot, 0, 6);

		forgot.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				close();
				new ForgotPass();

			}
		});

		Text or = new Text("________________OR________________");
		GridPane.setConstraints(or, 0, 8, 2, 1, HPos.CENTER, VPos.CENTER);
		g.add(or, 0, 8);

		Button register = new Button("Create New Account");
		register.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		register.setFont(new Font("Times New Roman", 15));
		register.setPrefWidth(200);
		register.setPrefHeight(35);
		GridPane.setConstraints(register, 0, 10, 2, 1, HPos.CENTER, VPos.CENTER);
		g.add(register, 0, 10);
		register.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				close();
				new Register();
			};
		});
		Image backimg = new Image("left-arrow.png");
		Button back = new Button();
		back.setGraphic(new ImageView(backimg));
		GridPane.setConstraints(back, 0, 11, 2, 1, HPos.CENTER, VPos.CENTER);

		
		g.add(back, 0, 11);
		back.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				close();
				new Interface();
			}
		});
		
		

		Scene s = new Scene(g);
		this.setScene(s);
		this.show();
	}

}
