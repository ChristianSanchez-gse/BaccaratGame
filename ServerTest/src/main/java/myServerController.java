import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class myServerController {
	private Stage stage;
	private Scene scene;
	private Parent newRoot;
	@FXML
	public TextField portNumber;
	
	public void displayTerminal() {
		System.out.println("The button was clicked!");
	}
	

	public void switchScene(ActionEvent event) throws IOException {
		// setting up the gui
		String portInput = portNumber.getText();
		System.out.println("Switched to the second setup scene");
		
		FXMLLoader a = new FXMLLoader(getClass().getResource("inGameGui.fxml"));
		 newRoot = a.load();
		 SecondScreenController b = a.getController();
		 b.port = Integer.parseInt(portInput);
		 b.startServer();
		// opens the new fxml window
		newRoot = FXMLLoader.load(getClass().getResource("secondScreen.fxml"));
		scene = new Scene(newRoot, 840,545);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		
	}

}
