package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;



public class Main5 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("main5.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			TextField tfMine	= (TextField) scene.lookup("#tfMine");
			TextField tfCom		= (TextField) scene.lookup("#tfCom");
			TextField tfResult	= (TextField) scene.lookup("#tfResult");
			
			Button btn = (Button) scene.lookup("#btn");
			btn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					String mine = tfMine.getText();
					String com = "";
					String result = "";
					
					double rnd = Math.random();
					if(rnd>0.5) {
						com = "È¦";
					} else {
						com = "Â¦";
					}
					
					if(mine.equals(com)) {
						result = "ÀÌ±è";
					} else {
						result = "Áü";
					}
					
					tfCom.setText(com);
					tfResult.setText(result);

					
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
