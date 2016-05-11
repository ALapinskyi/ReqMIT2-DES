package bw.khpi.reqmit.des;
	
import java.util.LinkedList;
import java.util.List;

import bw.khpi.reqmit.des.model.Event;
import bw.khpi.reqmit.des.model.EventList;
import bw.khpi.reqmit.des.utils.XMLUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
