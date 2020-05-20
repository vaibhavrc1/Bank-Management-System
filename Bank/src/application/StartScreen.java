package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartScreen
{

	public void signUp() {
		new Main().changeScene("SignUpForm.fxml", "Sign Up", 600, 400);
	}

}
