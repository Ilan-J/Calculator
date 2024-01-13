package app;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
	
	public TextField expField;
	public TextField resField;
	
	private Calculator calculator;
	
	public Controller() {
		calculator = new Calculator();
				
	}
	
	@FXML
	public void initialize() {
//		this.expField.accessibleTextProperty().bind(this.calculator.getExpression());
	}
	
	@FXML
	public void clacKeyPressed(Event evt) {
		Button key = (Button) evt.getSource();
		System.out.println("key " + key.getText() + " pressed");
		
		this.calculator.modifyExpression(key.getText());
		
		this.expField.setText(this.calculator.getExpression());
		this.resField.setText(this.calculator.getResult());
	}
}
