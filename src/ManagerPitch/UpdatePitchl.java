package ManagerPitch;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Model.ManagerPitch;
import Productdao.ProductDao;
import Productdao.ProductImlp;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UpdatePitchl extends Stage {
	ProductDao cus = new ProductImlp() ;

	public UpdatePitchl(ManagerPitch manaproduct) {

		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(12, 10, 15, 10));

		Label employeeDetail = new Label("Pitch Detail");
		employeeDetail.setFont(new Font("Times new roman", 23));
		grid.add(employeeDetail, 0, 0, 2, 1);
		
		Label stt = new Label("STT");
		grid.add(stt, 0, 2);

		TextField txStt = new TextField(manaproduct.getId().toString());
		txStt.setDisable(true);
		grid.add(txStt, 1, 2);

		Label lbFirstName = new Label(" Name");
		grid.add(lbFirstName, 0, 3);

		TextField txFirstName = new TextField(manaproduct.getNameCus());
		txFirstName.setDisable(true);
		grid.add(txFirstName, 1, 3);

		Label lbBirthday = new Label("Address");
		grid.add(lbBirthday, 0, 4);

		TextField txBirthday = new TextField(manaproduct.getAddress());
		txBirthday.setDisable(true);
		grid.add(txBirthday, 1, 4);

		Label lbPhone = new Label("Phone Number");
		grid.add(lbPhone, 0, 5);

		TextField txPhone = new TextField(manaproduct.getPhone());
		txPhone.setDisable(true);
		grid.add(txPhone, 1, 5);

		Label lbGender = new Label("Name pitch");
		grid.add(lbGender, 0, 6);

		TextField txGender = new TextField(manaproduct.getNamePitch());
		txGender.setDisable(true);
		grid.add(txGender, 1, 6);

		Label lbAddress = new Label("Date Start");
		grid.add(lbAddress, 0, 7);

		DatePicker datepick = new DatePicker();
		grid.add(datepick, 1, 7);
		
		Label price = new Label("Time Start");
		grid.add(price, 0, 8);

		TextField txPrice = new TextField(manaproduct.getTimeStart());
		txPrice.setDisable(true);
		grid.add(txPrice, 1, 8);
		
		Label total = new Label("Time Finish");
		grid.add(total, 0, 9);

		TextField txTotal = new TextField(manaproduct.getTimeFinish());
		txTotal.setDisable(true);
		grid.add(txTotal, 1, 9);
		
		Button update = new Button("Update");
		grid.add(update, 0, 10);
		update.setOnAction(event -> {

			cus.updatePitch(Date.valueOf(datepick.getValue()),Integer.parseInt(txStt.getText()));

			Alert e = new Alert(AlertType.INFORMATION);
			e.setHeaderText(null);
			e.setContentText("Update successful");
			e.showAndWait();
			close();
		});
		

		Scene scene = new Scene(grid);

		this.setTitle("Product Detail");
		this.setScene(scene);
		this.show();
	}
}
