package qlsb;

import java.sql.Date;
import java.util.Optional;

import PersonDto.CustomerDto;
import dao.CustomerDao;
import dao.CustormerImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Register extends Stage {
	CustomerDao cus = new CustormerImpl();
	public Register() {
		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setPadding(new Insets(20, 40, 20, 40));

		Text tTitle = new Text("Sign Up");
		tTitle.setFont(new Font("Times New Roman", 20));
		GridPane.setConstraints(tTitle, 0, 0, 2, 1);
		g.add(tTitle, 0, 0);

		Text fname = new Text("Full Name");
		g.add(fname, 0, 1);

		TextField txfname = new TextField();
		txfname.setPrefWidth(300);
		g.add(txfname, 0, 2);

		Text tPhone = new Text("Phone number");
		g.add(tPhone, 0, 3);

		TextField txPhone = new TextField();
		GridPane.setConstraints(txPhone, 0, 4, 2, 1);
		g.add(txPhone, 0, 4);

		Text tAddress = new Text("Address");
		g.add(tAddress, 0, 5);

		TextField txAddress = new TextField();
		GridPane.setConstraints(txAddress, 0, 6, 2, 1);
		g.add(txAddress, 0, 6);

		Text tDate = new Text("Date of Birth");
		g.add(tDate, 0, 7);

		DatePicker txDate = new DatePicker();
		txDate.setPrefWidth(200);
		GridPane.setConstraints(txDate, 0, 8, 2, 1);
		g.add(txDate, 0, 8);

		Text tGender = new Text("Gender");
		g.add(tGender, 0, 9);
		ToggleGroup group = new ToggleGroup();
		RadioButton male = new RadioButton("Male");
		male.setToggleGroup(group);
		RadioButton fmale = new RadioButton("Female");
		fmale.setToggleGroup(group);

		Text txGetGender = new Text();
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

				if (group.getSelectedToggle() != null) {
					RadioButton button = (RadioButton) group.getSelectedToggle();
					txGetGender.setText(button.getText());
				}
			}
		});

		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.getChildren().addAll(male, fmale);
		g.add(hbox, 0, 10);

		Text tUsername = new Text("Username");
		g.add(tUsername, 0, 11);

		TextField txUsername = new TextField();
		GridPane.setConstraints(txUsername, 0, 12, 2, 1);
		g.add(txUsername, 0, 12);

		Text tPassword = new Text("Password");
		g.add(tPassword, 0, 13);

		PasswordField txPassword = new PasswordField();
		GridPane.setConstraints(txPassword, 0, 12, 2, 1);
		g.add(txPassword, 0, 14);

		Text tRepassword = new Text("Re-enter Password");
		g.add(tRepassword, 0, 15);

		PasswordField txRepassword = new PasswordField();
		GridPane.setConstraints(txRepassword, 0, 12, 2, 1);
		g.add(txRepassword, 0, 16);
		
		
		Button register = new Button("Sign Up");
		register.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		register.setFont(new Font("Times New Roman", 15));
		register.setPrefWidth(200);
		
		HBox hboxback = new HBox();
		hboxback.setSpacing(20);
		
		Image backimg = new Image("left-arrow.png");
		Button back = new Button();
		back.setGraphic(new ImageView(backimg));
		GridPane.setConstraints(back, 0, 11, 2, 1, HPos.CENTER, VPos.CENTER);
		
		hboxback.getChildren().addAll(register,back);
		g.add(hboxback, 0, 17);
		back.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				close();
				new Interface();
			}
		});

		txRepassword.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
			
				if (event.getCode() == KeyCode.ENTER) {
					if (txfname.getText().isEmpty() || txPhone.getText().isEmpty() || txUsername.getText().isEmpty()
							|| txPassword.getText().isEmpty()
							|| txRepassword.getText().isEmpty() | txDate.getValue() == null
							|| txGetGender.getText().isEmpty()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Username already exists\r\n" + 
								"Please enter another username");
						alert.showAndWait();
					}else if(cus.getCustomerByUserName(txUsername.getText())!=null) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Enter all UserName");
						alert.showAndWait();
					} else 
						if (txPassword.getText().compareTo(txRepassword.getText())!=0)  {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("Your password is not the same\r\n" + "Please re-enter");
							alert.showAndWait();
						} else {
							CustomerDto customer = new CustomerDto(txfname.getText(), txPhone.getText(),
									txAddress.getText(), txGetGender.getText(), Date.valueOf(txDate.getValue()),
									txUsername.getText(), txPassword.getText());
							cus.insertCustomer(customer);

						Alert a = new Alert(AlertType.CONFIRMATION);
						a.setHeaderText(null);
						a.setContentText("Added success\r\n"+"Do you want to login ?");
						Optional<ButtonType> result = a.showAndWait();
						if (result.get() == ButtonType.OK) {
							close();
							new Login();
						}

						txfname.clear();
						txPhone.clear();
						txAddress.clear();
						txPassword.clear();
						txUsername.clear();
						txRepassword.clear();
						txDate.getEditor().clear();
						male.setSelected(false);
						fmale.setSelected(false);

					}
				}
			}

		});

		register.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
			
				if (txfname.getText().isEmpty() || txPhone.getText().isEmpty() || txUsername.getText().isEmpty()
						|| txPassword.getText().isEmpty()
						|| txRepassword.getText().isEmpty() | txDate.getValue() == null
						|| txGetGender.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Enter all infomation");
					alert.showAndWait();
				} 
				else if(cus.getCustomerByUserName(txUsername.getText())!=null) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Username already exists\r\n" + 
							"Please enter another username");
					alert.showAndWait();}
				else if (txPassword.getText().compareTo(txRepassword.getText())!=0)  {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Your password is not the same\r\n" + "Please re-enter");
					alert.showAndWait();
				} else {
					CustomerDto customer = new CustomerDto(txfname.getText(), txPhone.getText(),
							txAddress.getText(), txGetGender.getText(), Date.valueOf(txDate.getValue()),
							txUsername.getText(), txPassword.getText());
					cus.insertCustomer(customer);

				Alert a = new Alert(AlertType.CONFIRMATION);
				a.setHeaderText(null);
				a.setContentText("Added success\r\n"+"Do you want to login ?");
				Optional<ButtonType> result = a.showAndWait();
				if (result.get() == ButtonType.OK) {
					close();
					new Login();
				}
				
					txfname.clear();
					txPhone.clear();
					txAddress.clear();
					txPassword.clear();
					txUsername.clear();
					txRepassword.clear();
					txDate.getEditor().clear();
					male.setSelected(false);
					fmale.setSelected(false);

				}

			};
		});

		Scene scene = new Scene(g);
		this.setScene(scene);
		this.show();
	}

}
