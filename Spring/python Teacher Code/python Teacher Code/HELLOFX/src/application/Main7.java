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



public class Main7 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("main7.fxml"));
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
					if(rnd>0.66) {
						com = "가위";
					} else if(rnd>0.33) {
						com = "바위";
					} else {
						com = "보";
					} 
					
					if(mine.equals("가위")&&com.equals("가위")) {
						result = "비김";
					} else if(mine.equals("가위")&&com.equals("바위")) {
						result = "짐";
					} else if(mine.equals("가위")&&com.equals("보")) {
						result = "이김";
						
					} else if(mine.equals("바위")&&com.equals("가위")) {
						result = "이김";
					} else if(mine.equals("바위")&&com.equals("바위")) {
						result = "비김";
					} else if(mine.equals("바위")&&com.equals("보")) {
						result = "짐";
						
					} else if(mine.equals("보")&&com.equals("가위")) {
						result = "짐";
					} else if(mine.equals("보")&&com.equals("바위")) {
						result = "이김";
					} else if(mine.equals("보")&&com.equals("보")) {
						result = "비김";
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
