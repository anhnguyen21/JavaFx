package ManagerProduct;

import PersonDto.CustomerDto;
import Productdao.ProductDao;
import Productdao.ProductImlp;
import Productdto.Productsdto;
import dao.CustomerDao;
import dao.CustormerImpl;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductAdd extends Stage {
	CustomerDao cusdao=new CustormerImpl();
	CustomerDto cus=new CustomerDto();
	ProductDao pro=new ProductImlp();
	public ProductAdd() {
		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setPadding(new Insets(20, 40, 20, 40));

		Text tTitle = new Text("Add new product");
		tTitle.setFont(new Font("Times New Roman", 25));
		GridPane.setConstraints(tTitle, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);

		g.add(tTitle, 0, 0);

		Text fname = new Text("Name Customer");
		g.add(fname, 0, 1);

		TextField txfname = new TextField();
		txfname.setPrefWidth(300);
		g.add(txfname, 0, 2);
		cus.setName(txfname.getText());

		Text tPhone = new Text("Phone number");
		g.add(tPhone, 0, 3);

		TextField txPhone = new TextField();
		GridPane.setConstraints(txPhone, 0, 4, 2, 1);
		cus.setPhone(txPhone.getText());
		g.add(txPhone, 0, 4);

		Text tAddress = new Text("Address");
		g.add(tAddress, 0, 5);

		TextField txAddress = new TextField();
		GridPane.setConstraints(txAddress, 0, 6, 2, 1);
		cus.setAddress(txAddress.getText());
		g.add(txAddress, 0, 6);
		
		Text tProduct = new Text("Name Product");
		g.add(tProduct, 0, 7);
		
		Text txProduct = new Text();
		final String[] gretting = new String[] { "Sting","Redbull","Coca","Water","Red Shirt","Yellow Shirt","Blue Shirt","Green Shirt"};
		ChoiceBox<String> Nameproduct = new ChoiceBox<>(
				FXCollections.observableArrayList("Sting", "Redbull", "Coca","Water","Red Shirt","Yellow Shirt","Blue Shirt","Green Shirt"));
		
		
		
		
		Nameproduct.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
			
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				txProduct.setText(gretting[(int)newValue]);
			}
		});
		
		GridPane.setConstraints(Nameproduct, 0, 8, 2, 1);
		g.add(Nameproduct, 0, 8);
		
		Text tQuantity = new Text("Quantity");
		g.add(tQuantity, 0, 9);

		TextField txQuantity = new TextField();
		GridPane.setConstraints(txQuantity, 0, 10, 2, 1);
		g.add(txQuantity, 0, 10);

		Text tPrice = new Text("Price");
		g.add(tPrice, 0, 11);

		TextField txPrice = new TextField();
		txPrice.setDisable(true);
		GridPane.setConstraints(txPrice, 0, 12, 2, 1);
		g.add(txPrice, 0, 12);

		Text tTotal = new Text("Total");
		g.add(tTotal, 0, 13);

		TextField txTotal = new TextField();
		txTotal.setDisable(true);
		GridPane.setConstraints(txTotal, 0, 14, 2, 1);
		g.add(txTotal, 0, 14);
		Productsdto pro1= pro.getSearchProduct(txProduct.getText());
		txPrice.setText(Double.toString(pro1.getPrice()));
//		txTotal.setText(Double.toString(pro1.getTotal()));
		
		
		Button register = new Button("Add");
		register.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		register.setFont(new Font("Times New Roman", 15));
		register.setPrefWidth(200);
		GridPane.setConstraints(register, 0, 17, 2, 1, HPos.CENTER, VPos.CENTER);
		g.add(register, 0, 17);
		register.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (txfname.getText().isEmpty() || txPhone.getText().isEmpty() || txAddress.getText().isEmpty()
						||txProduct.getText().isEmpty() || txQuantity.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Enter all infomation");
					alert.showAndWait();
				}
				else {
					cusdao.insertAddCustomer(cus);
				}
			}
		});

		Scene scene = new Scene(g);
		this.setScene(scene);
		this.show();
		this.setTitle("Add");
	}

}
