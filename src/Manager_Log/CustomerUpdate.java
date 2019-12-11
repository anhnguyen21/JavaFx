package Manager_Log;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Model.Customer;
import dao.CustomerDao;
import dao.CustormerImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerUpdate extends Stage {

	CustomerDao cus = new CustormerImpl();

	public CustomerUpdate(Customer customer) {
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(15, 15, 15, 15));

		Label lbInfo = new Label("Customer Update");
		lbInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20.0));
		lbInfo.setAlignment(Pos.CENTER);
		GridPane.setConstraints(lbInfo, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
		grid.add(lbInfo, 0, 0, 2, 1);

		Label fullname = new Label("Full Name");
		grid.add(fullname, 0, 3);

		TextField txFName = new TextField(customer.getName());
		txFName.setPrefWidth(230);
		grid.add(txFName, 1, 3);

		Label lbBirthday = new Label("Birthday");
		grid.add(lbBirthday, 0, 4);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(customer.getBirthday(), formatter);

		DatePicker dateOfBirth = new DatePicker(localDate);
		dateOfBirth.setPrefWidth(txFName.getPrefWidth());
		grid.add(dateOfBirth, 1, 4);

		Label lbPhone = new Label("Phone Number");
		grid.add(lbPhone, 0, 5);

		TextField txPhone = new TextField(customer.getPhone());
		grid.add(txPhone, 1, 5);

		Label lbGender = new Label("Gender");
		grid.add(lbGender, 0, 6);

		ToggleGroup toggleGroup = new ToggleGroup();

		RadioButton male = new RadioButton("Male");
		male.setToggleGroup(toggleGroup);

		RadioButton female = new RadioButton("Female");
		female.setToggleGroup(toggleGroup);
		Text txGetGender = new Text();
		if ("Male".equals(customer.getGender())) {
			male.setSelected(true);
			txGetGender.setText("Male");
		} else {
			female.setSelected(true);
			txGetGender.setText("Female");
		}

		
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

				if (toggleGroup.getSelectedToggle() != null) {
					RadioButton button = (RadioButton) toggleGroup.getSelectedToggle();
					txGetGender.setText(button.getText());
				}
			}
		});

		HBox hbGender = new HBox();
		hbGender.setSpacing(15);
		hbGender.getChildren().addAll(male, female);
		grid.add(hbGender, 1, 6);

		Label lbAddress = new Label("Address");
		grid.add(lbAddress, 0, 7);

		TextField txAddress = new TextField(customer.getAddress());
		grid.add(txAddress, 1, 7);

		Label lbSalary = new Label("Password");
		grid.add(lbSalary, 0, 8);

		TextField txPass = new TextField(customer.getPass());
		grid.add(txPass, 1, 8);

		Button update = new Button("Update");
		update.setOnAction(event -> {

			customer.setName(txFName.getText());
			customer.setBirthday(formatter.format(dateOfBirth.getValue()));
			customer.setAddress(txAddress.getText());
			customer.setGender(txGetGender.getText());
			customer.setPhone(txPhone.getText());
			customer.setPass(txPass.getText());

			cus.updateCustomer(customer);

			Alert e = new Alert(AlertType.INFORMATION);
			e.setHeaderText(null);
			e.setContentText("Update successful");
			e.showAndWait();
			close();
		});

		Button clear = new Button("Clear");
		clear.setOnAction(event -> {
			txFName.clear();
			txAddress.clear();
			txPass.clear();
			txPhone.clear();
			dateOfBirth.getEditor().clear();
			male.setSelected(false);
			female.setSelected(false);
		});

		HBox hbox = new HBox();
		hbox.setSpacing(25);
		hbox.getChildren().addAll(update, clear);
		grid.add(hbox, 1, 9);

		Scene scene = new Scene(grid);

		this.setTitle("Customer Update");
		this.setScene(scene);
		this.show();
	}

}
