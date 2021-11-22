import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class myControllerTwo implements Initializable{
	Client clientConnection;
	String ip;
	int port;
	@FXML
	private Button enterButton;
	@FXML
	private TextField playerBidField;
	@FXML
	private TextField bankerBidField;
	@FXML
	private TextField tieBidField;
	@FXML
	private Button playerBidButton;
	@FXML
	private Button bankerBidButton;
	@FXML
	private Button tieBidButton;
	@FXML
	private Button newRound;
	@FXML
	private Label title;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void startClient() {
		 System.out.println("Starting the client....");
			//int portNumber = Integer.parseInt(portText.getText());
			//String ip = ipText.getText();
			//title = new Label();
			clientConnection = new Client(data->{
			Platform.runLater(()->{
				System.out.println(data);
				title.setText(data.toString());
				});
			}, port, ip);
			clientConnection.start();
	}
	
public void sendPlayer(ActionEvent event) throws IOException{
		
		String bid = playerBidField.getText();
		BaccaratInfo obj = new BaccaratInfo("Player", Integer.parseInt(bid));
		bankerBidField.setDisable(true);
		tieBidField.setDisable(true);
		bankerBidButton.setDisable(true);
		tieBidButton.setDisable(true);
		clientConnection.send(obj);
	}
	public void sendBanker(ActionEvent event) throws IOException{
		String bid = bankerBidField.getText();
		BaccaratInfo obj = new BaccaratInfo("Banker", Integer.parseInt(bid));
		playerBidField.setDisable(true);
		tieBidField.setDisable(true);
		playerBidButton.setDisable(true);
		tieBidButton.setDisable(true);
		clientConnection.send(obj);
	}
	public void sendTie(ActionEvent event) throws IOException{
		String bid = tieBidField.getText();
		BaccaratInfo obj = new BaccaratInfo("Draw", Integer.parseInt(bid));
		bankerBidField.setDisable(true);
		playerBidField.setDisable(true);
		bankerBidButton.setDisable(true);
		playerBidButton.setDisable(true);
		clientConnection.send(obj);
	}
	
	public void newRound(ActionEvent event) throws IOException{
		bankerBidField.setDisable(false);
		playerBidField.setDisable(false);
		bankerBidButton.setDisable(false);
		playerBidButton.setDisable(false);
		tieBidButton.setDisable(false);
		tieBidField.setDisable(false);
		bankerBidField.setText(null);
		playerBidField.setText(null);
		tieBidField.setText(null);
	}
	
}
