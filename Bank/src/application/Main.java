package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application { //important to extend Main class with Application for using GUI.
	@Override
	public void start(Stage primaryStage) {   //compulsory to use this method after extending class "Application" 
		try {
			Parent root=FXMLLoader.load(getClass().getResource("SI GUI.fxml"));//loading FXML file
			Scene scene = new Scene(root,500,400);  //setting width and height of the window 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //loading CSS file if used
			primaryStage.setScene(scene);  // scene=content inside window
			primaryStage.setTitle("Simple Interest Calculator"); //Title of the window
			primaryStage.show();  //Showing window to user
		} catch(Exception e) {
			e.printStackTrace();  //Printing Exception
		}
	}
	
	public static void main(String[] args) {
		launch(args);  //Starting GUI
	}
}
