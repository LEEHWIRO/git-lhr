package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;



public class Main9 extends Application {
	TextField tf;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("main9.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Button btn0 = (Button) scene.lookup("#btn0");
			Button btn1 = (Button) scene.lookup("#btn1");
			Button btn2 = (Button) scene.lookup("#btn2");
			Button btn3 = (Button) scene.lookup("#btn3");
			Button btn4 = (Button) scene.lookup("#btn4");
			
			Button btn5 = (Button) scene.lookup("#btn5");
			Button btn6 = (Button) scene.lookup("#btn6");
			Button btn7 = (Button) scene.lookup("#btn7");
			Button btn8 = (Button) scene.lookup("#btn8");
			Button btn9 = (Button) scene.lookup("#btn9");
			
			Button btnCall = (Button) scene.lookup("#btnCall");
			tf = (TextField) scene.lookup("#tf");
			
			btnCall.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					String a = tf.getText();
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Calling");
					alert.setContentText(a);

					alert.showAndWait();
				}
			});
			
			btn0.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("0");
				}
			});
			btn1.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("1");
				}
			});
			btn2.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("2");
				}
			});
			btn3.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("3");
				}
			});
			btn4.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("4");
				}
			});
			
			btn5.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("5");
				}
			});
			
			btn6.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("6");
				}
			});
			
			btn7.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("7");
				}
			});
			
			
			btn8.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("8");
				}
			});
			
			
			btn9.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					myclick("9");
				}
			});
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void myclick(String str_new) {
		
		String str_old = tf.getText();
		tf.setText(str_old+str_new);
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
