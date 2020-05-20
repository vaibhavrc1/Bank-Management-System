package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpForm {
	@FXML
	TextField firstName;
	@FXML
	TextField lastName;
	@FXML
	TextField username;
	@FXML
	TextField password;
	@FXML
	DatePicker dob;
	@FXML
	Button submit;
	@FXML
	Button clear;
	@FXML
	RadioButton male;
	@FXML
	RadioButton female;
	
	//display successful window on clicking submit.
	@FXML
    private void onSubmit(ActionEvent event)throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("Success.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = new Stage();
        window.setScene(scene2);
        window.show();
    }

	//Form clear function.
	public void clear() {
		firstName.setText("");
		lastName.setText("");
		username.setText("");
		password.setText("");		
	}
}
