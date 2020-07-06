package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpForm implements Initializable{
	@FXML
	TextField fname;
	@FXML
	TextField mname;
	@FXML
	TextField lname;
	@FXML
	TextField username;
	@FXML
	PasswordField password;
	@FXML
	TextField phoneno;
	@FXML
	TextField email;
	@FXML
	DatePicker dob;
	@FXML
	ComboBox<String> gender;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Customer c=StartScreen.customer;
		username.setText(c.getUsername());
		password.setText(c.getPassword());
		email.setText(c.getEmail());
		gender.setItems(FXCollections.observableArrayList("Male","Female"));
	}
	
	public void back() {
		new Main().changeScene("Start screen.fxml","Start Screen",759,483);
	}
	
	public void submit() throws SQLException {
		System.out.println(gender.getSelectionModel().getSelectedItem());
		Customer c=new Customer(username.getText(), password.getText(), email.getText(), fname.getText(), mname.getText(), lname.getText(), phoneno.getText(),dob.getValue().toString(), gender.getSelectionModel().getSelectedItem());
		objUpload(c);
		new Main().changeScene("SignIn.fxml", "Sign In", 711, 400);
	}
	
	public void objUpload(Customer c) throws SQLException {
		String query1 = " INSERT INTO `bank`.`information` VALUES (NULL,'"+c.getUsername()+"','"+c.getFname()+"','"+c.getMname()+"','"+c.getLname()+"','"+c.getPhoneno()+"','"+c.getEmail()+"','"+c.getDob()+"','"+c.getGender()+"',"+0+");";
		PreparedStatement ps=Main.con.prepareStatement(query1);
		int i=ps.executeUpdate();
			if(i==1)System.out.println("Success1");
			else System.out.println("Failure1");
		String query2=" INSERT INTO `bank`.`login` VALUES (NULL,'"+c.getUsername()+"','"+c.getPassword()+"');";
		ps=Main.con.prepareStatement(query2);
		int j=ps.executeUpdate();
			if(j==1)System.out.println("Success2");
			else System.out.println("Failure2");
	}
}
