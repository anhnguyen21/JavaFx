package ManagerProduct;

import Model.ManagerProduct;
import Productdao.ProductDao;
import Productdao.ProductImlp;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProductUpdate extends Stage {

	ProductDao cus = new ProductImlp() ;

	public ProductUpdate(ManagerProduct manaproduct) {
		
		
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(12, 10, 15, 10));

		Label employeeDetail = new Label("Product Update");
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

		Label lbGender = new Label("Name product");
		grid.add(lbGender, 0, 6);

		TextField txGender = new TextField(manaproduct.getNamePro());
		txGender.setDisable(true);
		grid.add(txGender, 1, 6);

		Label lbAddress = new Label("Quantity");
		grid.add(lbAddress, 0, 7);

		TextField txAddress = new TextField(manaproduct.getQuantity().toString());
		grid.add(txAddress, 1, 7);
		
		Label price = new Label("Price");
		grid.add(price, 0, 8);

		TextField txPrice = new TextField(manaproduct.getPrice().toString());
		txPrice.setDisable(true);
		grid.add(txPrice, 1, 8);
		
		Label total = new Label("Total");
		grid.add(total, 0, 9);

		TextField txTotal = new TextField(manaproduct.getTotal().toString());
		txTotal.setDisable(true);
		grid.add(txTotal, 1, 9);


		
	

		Button update = new Button("Update");
		update.setOnAction(event -> {

			

			cus.updateProduct(Integer.parseInt(txAddress.getText()),Integer.parseInt(txStt.getText()));

			Alert e = new Alert(AlertType.INFORMATION);
			e.setHeaderText(null);
			e.setContentText("Update successful");
			e.showAndWait();
			close();
		});


		grid.add(update, 1, 10);

		Scene scene = new Scene(grid);

		this.setTitle("Product Update");
		this.setScene(scene);
		this.show();
	}

}
