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

public class myClientController {
	@FXML
	private Button enterButton;
	@FXML
	private TextField ipText;
	@FXML
	private TextField portText;
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

	
	private static Client clientConnection;
	private Stage stage;
	private Scene inGameScene;
	private Parent newRoot;
	
	public void startClient(ActionEvent event) throws IOException{
				System.out.println("It should switch the scene now");
				
				 
				 System.out.println("Starting the client....");
					int portNumber = Integer.parseInt(portText.getText());
					String ip = ipText.getText();
					clientConnection = new Client(data->{
					Platform.runLater(()->{
						System.out.println(data);
						});
					}, portNumber, ip);
					clientConnection.start();
					
					
					
					 newRoot = FXMLLoader.load(getClass().getResource("inGameGui.fxml"));
					 inGameScene = new Scene(newRoot, 840,545);
					 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					 stage.setScene(inGameScene);
					 stage.show();
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
	
//	public void sendTestObject() {
//		//BaccaratInfo obj = new BaccaratInfo(20,30,45, "chris");
//		System.out.println("sending to server now...");
//		try{
//			if (clientConnection == null) {
//				System.out.println("This shi is null too");
//			}
//			clientConnection.send("yoyoyo");
//		} catch (Exception e){
//			System.out.println("There was a problem sending the info");
//			e.printStackTrace();
//		}
//	}

}
