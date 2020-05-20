package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//Note:Everything inside TextField and label is in String format, therefore we are converting them into usable format.

public class Calculator {
	@FXML
	Button calSI;
	@FXML
	Button clear;
	@FXML
	Label lOutput;
	@FXML
	TextField tp;
	@FXML
	TextField tr;
	@FXML
	TextField tt;
	public void simpleInterest() {    //calculating simple interest
		float p=Float.parseFloat(tp.getText());
		float r=Float.parseFloat(tr.getText());
		float t=Float.parseFloat(tt.getText());
		float SI=p*r*t/100;
		lOutput.setText(Float.toString(SI));
	}
	public void clear() {            //clearing inputs to 0
		tp.setText("");
		tr.setText("");
		tt.setText("");
		lOutput.setText("0");
	}
	public void changeScene() {
		Main m=new Main();
		m.changeScene("Test.fxml", "Working",400,400);
	}
}
