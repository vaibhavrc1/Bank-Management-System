package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartScreen
{
	@FXML 
	Label creators;
	@FXML
	TextField tUsername;
	@FXML
	PasswordField tPassword;
	@FXML
	TextField tEmail;
	static Customer customer;
	
	public void signUp() {
		customer=new Customer(tUsername.getText(),tPassword.getText(),tEmail.getText());
		new Main().changeScene("SignUpForm.fxml", "Sign Up", 600, 400);
	}
	
	public void signIn() {
		new Main().changeScene("SignIn.fxml", "Sign In", 711, 400);
	}
	
	public void about() {
		if(creators.getOpacity()==1)  creators.setOpacity(0);
		else creators.setOpacity(1);
	}

}
