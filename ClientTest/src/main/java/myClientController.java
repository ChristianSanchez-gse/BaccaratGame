import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class myClientController {
	@FXML
	private TextField ipText;
	@FXML
	private TextField portText;

	
	private static Client clientConnection;
	private Stage stage;
	private Scene inGameScene;
	private Parent newRoot;
	
	public void startClient(ActionEvent event) throws IOException{
				System.out.println("It should switch the scene now");
				 
				 
				 System.out.println("Starting the client....");
					int portNumber = Integer.parseInt(portText.getText());
					String ip = ipText.getText();
					 FXMLLoader a = new FXMLLoader(getClass().getResource("inGameGui.fxml"));
					 newRoot = a.load();
					 myControllerTwo b = a.getController();
					 b.port = portNumber;
					 b.ip = ip;
					 b.startClient();
					 inGameScene = new Scene(newRoot, 650,400);
					 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					 stage.setScene(inGameScene);
					 stage.show();
	}

}
