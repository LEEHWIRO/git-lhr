package application;
	


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;




public class Main8 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("main8.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			TextField tf = (TextField) scene.lookup("#tf");
			TextArea ta = (TextArea) scene.lookup("#ta");
			Button btn = (Button) scene.lookup("#btn");
			btn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					int dan = Integer.parseInt(tf.getText()) ;
					
					String txt = "";
					
					txt += dan+"*1="+(dan*1)+"\n";
					txt += dan+"*2="+(dan*2)+"\n";
					txt += dan+"*3="+(dan*3)+"\n";
					txt += dan+"*4="+(dan*4)+"\n";
					txt += dan+"*5="+(dan*5)+"\n";
					
					txt += dan+"*6="+(dan*6)+"\n";
					txt += dan+"*7="+(dan*7)+"\n";
					txt += dan+"*8="+(dan*8)+"\n";
					txt += dan+"*9="+(dan*9)+"\n";
					
					
					ta.setText(txt);
					
					
				}
			});
			

			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
