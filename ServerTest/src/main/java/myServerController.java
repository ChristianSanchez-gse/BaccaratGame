import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class myServerController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void displayTerminal() {
		System.out.println("The button was clicked!");
	}
	
	public void openPort() {
		System.out.println("You hit the submit button");
	}
	public void switchScene(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		 root = FXMLLoader.load(getClass().getResource("myGui2.fxml"));
		 stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		 scene = new Scene(root, 840,545);
		 stage.show();
	}

	public void dummy(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("myGui2.fxml"));
		 stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.show(); 
	}
}
