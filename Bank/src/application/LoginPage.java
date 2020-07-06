package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginPage {
	static int id;
	@FXML
	TextField username;
	@FXML
	TextField password;
	public void signIn(){
		try {
		String query1="Select id,password from bank.login where username='"+username.getText()+"';";
		Statement st=Main.con.createStatement();
		ResultSet rs=st.executeQuery(query1);
		rs.next();
		String dbpassword=rs.getString(2);
		
		if(dbpassword.contentEquals(password.getText())) {
			System.out.println("Right password");
			id=rs.getInt(1);
			new Main().changeScene("OptionMenu.fxml", "Option Menu", 720, 530);
			
		}
		}
		catch(SQLException sqlException) {
			System.out.println("Check username and password");
		}
	}
	
	public void back() {
		new Main().changeScene("Start screen.fxml","Start Screen",759,483);
	}
	
	static public Customer downloadObj(int id) throws SQLException{
		String query2="Select * from bank.information where id='"+id+"';";
		Statement st=Main.con.createStatement();
		st.executeQuery(query2);
		ResultSet rs=st.executeQuery(query2);
		rs.next();
		String username=rs.getString(2);
		String fname=rs.getString(3);
		String mname=rs.getString(4);
		String lname=rs.getString(5);
		String phoneno=rs.getString(6);
		String email=rs.getString(7);
		String dob=rs.getString(8);
		String gender=rs.getString(9);
		Float balance=rs.getFloat(10);
		Customer c=new Customer(username, fname, mname, lname, phoneno, email, dob, gender,balance);
		return c;
	}
	
}
