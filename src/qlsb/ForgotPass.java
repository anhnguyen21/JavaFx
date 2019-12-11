package qlsb;


import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ForgotPass extends Stage{


	public ForgotPass() {
		
		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setPadding(new Insets(20, 40, 20, 40));
		
		Text tTitle = new Text("Forgot your password?");
		tTitle.setFont(new Font("Times New Roman", 30));
		GridPane.setConstraints(tTitle, 0, 0, 2, 1);
		g.add(tTitle, 0, 0);
		
		
		
		Label note = new Label("Don't worry. Resetting your password very easy, just tell us the username and the phone number you registered");
		note.setFont(new Font("Times New Roman", 15));
		note.setWrapText(true);
		GridPane.setConstraints(note, 0, 1, 2, 1);
		g.add(note, 0, 1);
		
		TextField txUsername = new  TextField();
		txUsername.setPromptText("Username");
		txUsername.setPrefHeight(35);
		GridPane.setConstraints(txUsername, 0, 2, 2, 1);
		g.add(txUsername, 0, 2);
		
		
		TextField txPhone = new  TextField();
		txPhone.setPromptText("Phone number");
		txPhone.setPrefHeight(35);
		GridPane.setConstraints(txPhone, 0, 3, 2, 1);
		g.add(txPhone, 0, 3);
		
		Button send = new Button("Send");
		send.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		send.setFont(new Font("Times New Roman", 15));
		send.setPrefWidth(200);
		send.setPrefHeight(35);
		GridPane.setConstraints(send, 0, 4, 2, 1, HPos.LEFT, VPos.CENTER);
		g.add(send, 0, 4);
		
		send.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode()==KeyCode.ENTER) {
					CustomerDao cus=new CustormerImpl();
					CustomerDto dtoSearch = new CustomerDto();
					dtoSearch.setAccount(txUsername.getText());
					dtoSearch.setPhone(txPhone.getText());
					List<CustomerDto> list = new ArrayList<>();
					list = cus.search(dtoSearch);
					
					if(txPhone.getText().isEmpty()||txUsername.getText().isEmpty())
					{
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Enter all infomation");
						alert.showAndWait();
					}
					else if(list != null)
					{
						close();
						new newPass(list.get(0).getId());
					}
					else 
					{
						System.out.println("Khong dung");
					}
				}
			}
			
		});

		send.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				CustomerDao cus=new CustormerImpl();
				CustomerDto dtoSearch = new CustomerDto();
				dtoSearch.setAccount(txUsername.getText());
				dtoSearch.setPhone(txPhone.getText());
				List<CustomerDto> list = new ArrayList<>();
				list = cus.search(dtoSearch);
				
				if(txPhone.getText().isEmpty()||txUsername.getText().isEmpty())
				{
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Enter all infomation");
					alert.showAndWait();
				}
				else if(list != null)
				{
					close();
					new newPass(list.get(0).getId());
				}
				else 
				{
					System.out.println("Khong dung");
				}
			
				
			}
		});
	
		Scene s = new Scene(g,500,300);
		this.setScene(s);
		this.setTitle("Fotgot password");
		this.show();
	
		
	}
	
	
	
}
