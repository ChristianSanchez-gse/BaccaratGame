import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondScreenController implements Initializable{
	public int port;
	// Gui objects

	@FXML
	public Button enterButton;
	@FXML
	private ListView<String> gameHistory;
	@FXML
	private Button toggleServer;
	@FXML
	private Button testButton;
	// Gui

	static Server serverConnection;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	// sets up the server
	public void startServer() {
		serverConnection = new Server(data -> {
			Platform.runLater(()->{
				//System.out.println(data + " Was received");
				//System.out.println(data.toString());
				gameHistory.getItems().add(data.toString());
			});
		}, port);
		
		
	}
	public void stopServer() {
		gameHistory.getItems().add("----Shutting down server----");
		serverConnection = null;
	}
}
