package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	//important to extend Main class with Application for using GUI.
	static Stage pstage;
	@Override
	public void start(Stage primaryStage) {   //compulsory to use this method after extending class "Application" 
		pstage=primaryStage;
		changeScene("SI GUI.fxml","Simple Interest Calculator",500,400);
	}
	
	public void changeScene(String gui,String title,int width,int height) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource(gui));//loading FXML file
			Scene scene = new Scene(root,width,height);  //setting width and height of the window 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //loading CSS file if used
			pstage.setScene(scene);  // scene=content inside window
			pstage.setTitle(title); //Title of the window
			pstage.show();  //Showing window to user
		} catch(Exception e) {
			e.printStackTrace();  //Printing Exception
		}
	}
	
	public static void main(String[] args) {
		launch(args);  //Starting GUI
	}
}
