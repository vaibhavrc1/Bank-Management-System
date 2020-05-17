package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
	public void simpleInterest() {
		float p=Float.parseFloat(tp.getText());
		float r=Float.parseFloat(tr.getText());
		float t=Float.parseFloat(tt.getText());
		float SI=p*r*t/100;
		lOutput.setText(Float.toString(SI));
	}
	public void clear() {
		tp.setText("");
		tr.setText("");
		tt.setText("");
		lOutput.setText("0");
	}
}
