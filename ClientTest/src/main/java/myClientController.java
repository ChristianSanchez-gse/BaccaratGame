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

public class myClientController {
	@FXML
	private Button enterButton;
	@FXML
	private TextField ipText;
	@FXML
	private TextField portText;
	
	public Client clientConnection;
	private Stage stage;
	private Scene scene;
	private Parent newRoot;
	
	public void startClient(ActionEvent event) throws IOException{
				System.out.println("It should switch the scene now");
				newRoot = FXMLLoader.load(getClass().getResource("inGameGui.fxml"));
				 scene = new Scene(newRoot, 840,545);
				 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				 stage.setScene(scene);
				 stage.show();
				 
				 System.out.println("Starting the client....");
					int portNumber = Integer.parseInt(portText.getText());
					String ip = ipText.getText();
					clientConnection = new Client(data->{
					Platform.runLater(()->{
						});
					}, portNumber, ip);
					clientConnection.start();
	}
	
	public void sendTestObject() {
		BaccaratInfo obj = new BaccaratInfo(20,30,45, "chris");
		System.out.println("sending to server now...");
		clientConnection.send("yoyoyo");
	}

}
