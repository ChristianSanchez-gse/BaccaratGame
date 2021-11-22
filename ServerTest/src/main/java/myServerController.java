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
	private ListView<String> gameHistory;
	@FXML
	private Button toggleServer;
	@FXML
	private Button testButton;
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
		//gameHistory = new ListView<String>();
		
		System.out.println(portInput);
		//gameHistory = new ListView<String>();
		serverConnection = new Server(data -> {
			Platform.runLater(()->{
				//System.out.println(data + " Was received");
				//System.out.println(data.toString());
				addToList();
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
	
	public void addToList(){
		System.out.println("We are about to print to the listview");
			if(gameHistory == null) {
				gameHistory = new ListView<String>();
			} else {
			gameHistory.getItems().add("Test");
			}
	}

}
