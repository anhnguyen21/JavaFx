package Manager_Log;


import Model.Customer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CustomerDetail extends Stage {

	public CustomerDetail(Customer customer) {

		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(12, 10, 15, 10));

		Label employeeDetail = new Label("Employee Detail");
		employeeDetail.setFont(new Font("Times new roman", 23));
		grid.add(employeeDetail, 0, 0, 2, 1);

		Label lbFirstName = new Label("Full Name");
		grid.add(lbFirstName, 0, 3);

		TextField txFirstName = new TextField(customer.getName());
		txFirstName.setDisable(true);
		grid.add(txFirstName, 1, 3);

		Label lbBirthday = new Label("Bithday");
		grid.add(lbBirthday, 0, 4);

		TextField txBirthday = new TextField(customer.getBirthday());
		txBirthday.setDisable(true);
		grid.add(txBirthday, 1, 4);

		Label lbPhone = new Label("Phone Number");
		grid.add(lbPhone, 0, 5);

		TextField txPhone = new TextField(customer.getPhone());
		txPhone.setDisable(true);
		grid.add(txPhone, 1, 5);

		Label lbGender = new Label("Gender");
		grid.add(lbGender, 0, 6);

		TextField txGender = new TextField(customer.getGender());
		txGender.setDisable(true);
		grid.add(txGender, 1, 6);

		Label lbAddress = new Label("Address");
		grid.add(lbAddress, 0, 7);

		TextField txAddress = new TextField(customer.getAddress());
		txAddress.setDisable(true);
		grid.add(txAddress, 1, 7);

		Scene scene = new Scene(grid);

		this.setTitle("Customer Detail");
		this.setScene(scene);
	}
}
