import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class myServerController {
	// Gui objects
	@FXML
	public TextField portNumber;
	@FXML
	public Button enterButton;
	// Gui
	private Stage stage;
	private Scene scene;
	private Parent newRoot;
	Server serverConnection;
	
	public void displayTerminal() {
		System.out.println("The button was clicked!");
	}
	
	public void openPort() {
		System.out.println("You hit the submit button");
	}
	public void switchScene(ActionEvent event) throws IOException {
		// setting up the gui
		String text = portNumber.getText();
		System.out.println("Switched to the second setup scene");
		 newRoot = FXMLLoader.load(getClass().getResource("myGui2.fxml"));
		 scene = new Scene(newRoot, 840,545);
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 stage.setScene(scene);
		 stage.show();
		 
		 
		 // Setting up the server
		 System.out.println(text);
		 int port = Integer.parseInt(text);
		 serverConnection = new Server(data -> {
				Platform.runLater(()->{
				// idk what goes here
					});
				}, port);
	}

	public void dummy(ActionEvent event) throws IOException {
		  
	}
}
