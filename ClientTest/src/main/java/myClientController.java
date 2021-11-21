import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class myClientController {
	@FXML
	private Button enterButton;
	@FXML
	private TextField ipText;
	@FXML
	private TextField portText;
	
	public Client clientConnection;
	
	public void startClient(ActionEvent event) throws IOException{
		System.out.println("Starting the client....");
			int portNumber = Integer.parseInt(portText.getText());
			String ip = ipText.getText();
			clientConnection = new Client(data->{
			Platform.runLater(()->{});
			}, portNumber, ip);
			clientConnection.start();
	}
}
