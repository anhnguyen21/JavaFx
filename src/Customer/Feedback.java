package Customer;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Feedback extends Stage {

	public Feedback() {

		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setPadding(new Insets(20, 40, 20, 40));

		Text tTitle = new Text("Feedback");
		tTitle.setFont(new Font("Times New Roman", 30));
		GridPane.setConstraints(tTitle, 0, 0, 2, 1);
		g.add(tTitle, 0, 0);

		Label note = new Label("Please fill in the content that needs feedback below");
		note.setFont(new Font("Times New Roman", 15));
		note.setWrapText(true);
		GridPane.setConstraints(note, 0, 1, 2, 1);
		g.add(note, 0, 1);

		TextArea txFeedback = new TextArea();
		txFeedback.setPrefHeight(100);
		GridPane.setConstraints(txFeedback, 0, 3, 2, 1);
		g.add(txFeedback, 0, 3);

		
		

		HBox hbox = new HBox();
		hbox.setSpacing(50);
		Button send = new Button("Send");
		send.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		send.setFont(new Font("Times New Roman", 15));
		send.setPrefWidth(150);
		send.setPrefHeight(35);

		Button clear = new Button("Clear");
		clear.setStyle("-fx-background-color: #00baff;-fx-text-fill: white;");
		clear.setFont(new Font("Times New Roman", 15));
		clear.setPrefWidth(150);
		clear.setPrefHeight(35);

		hbox.getChildren().addAll(send, clear);
		g.add(hbox, 0, 4);

		send.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if (txFeedback.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Please enter feedback before sending");
					alert.showAndWait();

				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setContentText("Your feedback has been submitted successfully");
					alert.showAndWait();
					close();
				}

			}

		});

		Scene s = new Scene(g, 500, 300);
		this.setScene(s);
		this.setTitle("Feed back");
		this.show();

	}

}
