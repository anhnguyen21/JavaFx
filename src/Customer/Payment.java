package Customer;

import PersonDto.CustomerDto;
import Productdao.ProductDao;
import Productdao.ProductImlp;
import Productdto.Pitchdto;
import Productdto.Productsdto;
import dao.CustomerDao;
import dao.CustormerImpl;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Payment extends Stage {
	ProductDao product = new ProductImlp();

	public Payment(int i) {
		CustomerDao cus = new CustormerImpl();
		CustomerDto cu = cus.getCustomerById(i);
		GridPane grid1 = new GridPane();
		grid1.setHgap(20);
		grid1.setVgap(20);
		grid1.setPadding(new Insets(20,20,20,20));

		Label Payment = new Label("Payment");
		Payment.getStyleClass().add("text3");
		GridPane.setConstraints(Payment, 0, 0, 5, 1, HPos.CENTER, VPos.CENTER);
		grid1.add(Payment, 0, 0);

		HBox hbox = new HBox();
		hbox.setSpacing(20);

		Label lbFirstName = new Label("Name: ");

		TextField txFirstName = new TextField(cu.getName());
		txFirstName.setDisable(true);

		Label lbAddress = new Label("Address: ");

		TextField txAddress = new TextField(cu.getAddress());
		txAddress.setDisable(true);

		Label lbPhone = new Label("Phone Number: ");

		TextField txPhone = new TextField(cu.getPhone());
		txPhone.setDisable(true);
		
		hbox.getChildren().addAll(lbFirstName,txFirstName,lbAddress,txAddress,lbPhone,txPhone);
		grid1.add(hbox, 0, 3);
		
		HBox hbox1 = new HBox();
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(20);
		
		Label payPro = new Label("Payment Product: ");
		grid.add(payPro, 0, 4);

		Productsdto pro = product.getAllPryProduct(i);
		TextField txPayPro = new TextField(new Double(pro.getTotal()).toString());
		txPayPro.getStyleClass().add("text2");
		txPayPro.setDisable(true);
		grid.add(txPayPro, 1, 4);

		Label payPitch = new Label("Payment Pitch: ");
		grid.add(payPitch, 0, 5);

		Pitchdto pit = product.getAllPryPitch(i);
		TextField txpayPitch = new TextField(new Double(pit.getTotal()).toString());
		txpayPitch.getStyleClass().add("text2");
		txpayPitch.setDisable(true);
		grid.add(txpayPitch, 1, 5);

		Label pay = new Label("Total Payment:");
		grid.add(pay, 0, 6);

		TextField txpay = new TextField(new Double(pit.getTotal() + pro.getTotal()).toString());
		txpay.setDisable(true);
		txpay.getStyleClass().add("text2");
		grid.add(txpay, 1, 6);
		
		Button payNow = new Button("Pay Now");
		payNow.getStyleClass().add("yellow");
		GridPane.setConstraints(payNow, 0, 7, 2, 1, HPos.CENTER, VPos.CENTER);
		payNow.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("You have successfully paid\r\n" + 
						"Thank you "+cu.getName());
				alert.showAndWait();
				close();
			}
		});
		
		grid.add(payNow, 0, 7);
		hbox1.getChildren().add(grid);
		hbox1.setAlignment(Pos.CENTER);
		grid1.add(hbox1, 0, 4);
//		grid1.getStyleClass().add("background3");
		

		Scene scene = new Scene(grid1);
		scene.getStylesheets().add("test.css");
		this.setTitle("Payment");
		this.setScene(scene);

		this.show();
	}
}
