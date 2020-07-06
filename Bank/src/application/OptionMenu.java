package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.sql.Statement;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OptionMenu implements Initializable{
	
	@FXML
	Label username;
	@FXML
	Label id;
	@FXML
	Label balance;
	@FXML
	TextField deposit;
	@FXML
	TextField withdraw;
	@FXML
	TextField fname;
	@FXML
	TextField mname;
	@FXML
	TextField lname;
	@FXML
	TextField phoneno;
	@FXML
	TextField email;
	@FXML
	DatePicker dob;
	@FXML
	ComboBox<String> gender;
	@FXML
	TextField tId;
	@FXML
	TextField tAmount;
	
	Customer c;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			c=LoginPage.downloadObj(LoginPage.id);
			username.setText(c.getUsername());
			id.setText(LoginPage.id+"");
			balance.setText(c.getBalance()+"");
			fname.setText(c.getFname());
			mname.setText(c.getMname());
			lname.setText(c.getLname());
			phoneno.setText(c.getPhoneno());
			email.setText(c.getEmail());
			dob.setValue(LocalDate.parse(c.getDob()));
			gender.setItems(FXCollections.observableArrayList("Male","Female"));
			gender.setValue(c.getGender());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Deposit
	public void dAdd(float rs) {
		deposit.setText(Float.toString(Float.parseFloat(deposit.getText())+rs));
	}
	
	public void dAdd100() {
		dAdd(100);
	}
	
	public void dAdd500() {
		dAdd(500);
	}

	public void dAdd1000() {
		dAdd(1000);
	}

	public void dAdd2000() {
		dAdd(2000);
	}
	
	public void dAdd5000() {
		dAdd(5000);
	}
	
	public void dAdd10000() {
		dAdd(10000);
	}
	
	public void reset() {
		deposit.setText(0+"");
		withdraw.setText(0+"");
	}
	
	public void dProceed() throws SQLException {
		float depositMoney=Float.parseFloat(deposit.getText());
		float total=c.getBalance()+depositMoney;
		String query="UPDATE `bank`.`information` SET `Balance` = '"+total+"' WHERE (`Id` = '"+LoginPage.id+"');";
		Statement st=Main.con.createStatement();
		int i=st.executeUpdate(query);
		if(i==1)
		{
			String getBalance="SELECT Balance FROM bank.information where id="+LoginPage.id+";";
			ResultSet rs=st.executeQuery(getBalance);
			rs.next();
			float dbBalance=rs.getFloat(1);
			System.out.println(dbBalance);
			balance.setText(dbBalance+"");
			System.out.println(balance.getText());
			c.setBalance(dbBalance);
			deposit.setText(0+"");
		}
		else {
			System.out.println("problem");
		}
	}
	
	
	//Withdraw
	public void wAdd(float rs) {
		withdraw.setText(Float.toString(Float.parseFloat(withdraw.getText())+rs));
		
	}
	
	public void wAdd100() {
		wAdd(100);
	}
	
	public void wAdd500() {
		wAdd(500);
	}

	public void wAdd1000() {
		wAdd(1000);
	}

	public void wAdd2000() {
		wAdd(2000);
	}
	
	public void wAdd5000() {
		wAdd(5000);
	}
	
	public void wAdd10000() {
		wAdd(10000);
	}
	
	public void wProceed() throws SQLException {
		float withdrawMoney=Float.parseFloat(withdraw.getText());
		float total=c.getBalance()-withdrawMoney;
		String query="UPDATE `bank`.`information` SET `Balance` = '"+total+"' WHERE (`Id` = '"+LoginPage.id+"');";
		Statement st=Main.con.createStatement();
		int i=st.executeUpdate(query);
		if(i==1)
		{
			String getBalance="SELECT Balance FROM bank.information where id="+LoginPage.id+";";
			ResultSet rs=st.executeQuery(getBalance);
			rs.next();
			float dbBalance=rs.getFloat(1);
			System.out.println(dbBalance);
			balance.setText(dbBalance+"");
			System.out.println(balance.getText());
			c.setBalance(dbBalance);
			withdraw.setText(0+"");
		}
		else {
			System.out.println("problem");
		}
		
	}
	//Money Transfer
	public void transferMoney() throws SQLException {
		int payeeId=Integer.parseInt(tId.getText());
		float amount=Float.parseFloat(tAmount.getText());
		String query1="UPDATE `bank`.`information` SET `Balance` = Balance-"+(amount)+" WHERE (`Id` = '"+LoginPage.id+"');";
		String query2="UPDATE `bank`.`information` SET `Balance` = Balance+"+amount+" WHERE (`Id` = '"+payeeId+"');";
		Statement st=Main.con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		int[] i=st.executeBatch();
		if(i[1]==1) {
			System.out.println("Payment done");
			String getBalance="SELECT Balance FROM bank.information where id="+LoginPage.id+";";
			ResultSet rs=st.executeQuery(getBalance);
			rs.next();
			float dbBalance=rs.getFloat(1);
			balance.setText(dbBalance+"");
			tId.clear();
			tAmount.clear();
		}
		else {
			System.out.println("Payment not done");
		}
		
	}
	//Change Details
			public void update() throws SQLException {
				Statement st=Main.con.createStatement();
				String query="UPDATE `bank`.`information` SET `First_name` = '"+fname.getText()+"', `Middle_name` = '"+mname.getText()+"', `Last_name` = '"+lname.getText()+"', `Phone_no` = '"+phoneno.getText()+"', `Email` = '"+email.getText()+"', `DOB` = '"+dob.getValue().toString()+"' WHERE (`Id` = '"+id.getText()+"');";
				int i=st.executeUpdate(query);
				if(i==1) System.out.println("Updated");
				else System.out.println("Not updated");
			}
	//sign out
			public void signOut() {
				new Main().changeScene("Start screen.fxml","Start Screen", 759, 484);
			}
}
