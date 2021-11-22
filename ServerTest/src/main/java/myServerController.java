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
	// Gui objects
	@FXML
	public TextField portNumber;
	@FXML
	public Button enterButton;
	@FXML
	private ListView<String> gameHistory = new ListView<String>();
	@FXML
	private Button toggleServer;
	// Gui
	private Stage stage;
	private Scene scene;
	private Parent newRoot;
	static Server serverConnection;
	
	public void displayTerminal() {
		System.out.println("The button was clicked!");
	}
	
	public void openPort(int portInput) {
		System.out.println("You hit the submit button");
		// Setting up the server
		System.out.println(portInput);
		gameHistory =new ListView<String>();
		serverConnection = new Server(data -> {
			Platform.runLater(()->{
				//System.out.println(data + " Was recieved");
				System.out.println(data.toString());
				gameHistory.getItems().add("test");
				//addToList(data.toString());
			});
		}, portInput);
		
		
	}
	public void switchScene(ActionEvent event) throws IOException {
		// setting up the gui
		String portInput = portNumber.getText();
		System.out.println("Switched to the second setup scene");
		
		 
		// opens the new fxml window
		newRoot = FXMLLoader.load(getClass().getResource("secondScreen.fxml"));
		scene = new Scene(newRoot, 840,545);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		openPort(Integer.parseInt(portInput));
		
		
	}
	
	public void addToList(String string){
		System.out.println("We are about to print to the listview" + string);
		if (string != null) {
			gameHistory = new ListView<String>();
			gameHistory.getItems().add(string);
		} else {
			
		}
	}

}
