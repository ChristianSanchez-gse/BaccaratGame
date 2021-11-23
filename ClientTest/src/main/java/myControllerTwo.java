import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;



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
	@FXML
	private Text endGameText, roundEarnings;
	@FXML
	private Label walletTotal;
	
	@FXML Label playerCard1, playerCard2, playerCard3, playerTotal, bankerCard1,bankerCard2, bankerCard3, bankerTotal;
	
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
				//System.out.println(data);
				//title.setText(data.toString());
				System.out.println(data);
				processIncomingData(data);
				//walletTotal.setText(data.toString());


				
				});
			}, port, ip);
			clientConnection.start();
			

	}
	
private void processIncomingData(Serializable data) {
		// TODO Auto-generated method stub
		BaccaratInfo obj = (BaccaratInfo) data;
		//System.out.println(obj.getWinner());
		endGameText.setText("The winner is: " + obj.getWinner());
		endGameText.setFill(Color.GREEN);
		roundEarnings.setText("Round earnings: $" + obj.getRoundPayout());
		walletTotal.setText("" + obj.getWalletTotal());
		
		/*
		if( obj.getChoice().equals(obj.getWinner())){
			endGameText.setText("The winner is: " + obj.getWinner() + "... congratulations, you won");
		} else {
			endGameText.setText("The winner is: " + obj.getWinner()+ "... sorry, you lost :(");
		}
		*/
		
	}
public void sendPlayer(ActionEvent event) throws IOException{
		
		String bid = playerBidField.getText();
		String wallet = walletTotal.getText();
		System.out.println("THE WALLET SENDING FROM CLIENT IS: " + Double.parseDouble(wallet));
		BaccaratInfo obj = new BaccaratInfo("Player", Double.parseDouble(bid), Double.parseDouble(wallet));
		bankerBidField.setDisable(true);
		tieBidField.setDisable(true);
		bankerBidButton.setDisable(true);
		tieBidButton.setDisable(true);
		clientConnection.send(obj);
	}
	public void sendBanker(ActionEvent event) throws IOException{
		String bid = bankerBidField.getText();
		String wallet = walletTotal.getText();
		BaccaratInfo obj = new BaccaratInfo("Banker", Double.parseDouble(bid), Double.parseDouble(wallet));
		playerBidField.setDisable(true);
		tieBidField.setDisable(true);
		playerBidButton.setDisable(true);
		tieBidButton.setDisable(true);
		clientConnection.send(obj);
	}
	public void sendTie(ActionEvent event) throws IOException{
		String bid = tieBidField.getText();
		String wallet = walletTotal.getText();
		BaccaratInfo obj = new BaccaratInfo("Draw", Double.parseDouble(bid), Double.parseDouble(wallet));
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
		roundEarnings.setText(null);
		endGameText.setText(null);
		
	}
	
	public void printCards(ArrayList<Integer> playerHand, ArrayList<Integer> bankerHand) {
        PauseTransition pause = new PauseTransition(Duration.millis(3000));
        String pCard1 = playerHand.get(0).toString();
        String pCard2 = playerHand.get(1).toString();
        String bCard1 = playerHand.get(0).toString();
        String bCard2 = playerHand.get(1).toString();
        String pCard3, bCard3;

        int pTotal = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            pTotal += playerHand.get(i);
            if(pTotal > 9) {
                pTotal = pTotal - 10;
            }
        }

        int bTotal = 0;
        for (int i = 0; i < bankerHand.size(); i++) {
            bTotal += bankerHand.get(i);
            if(bTotal > 9) {
                bTotal = bTotal - 10;
            }
        }
        if (playerHand.size() == 3) {
            pCard3 = playerHand.get(2).toString(); // 6
        }else {
            pCard3 = null;
        }
        if (bankerHand.size() == 3) {
            bCard3 = bankerHand.get(2).toString();
        }else {
            bCard3 = null;
        }
//        System.out.println("players first two " + first2player);
//        System.out.println("bankers first two "  + first2banker);
        playerCard1.setText(pCard1);
        playerCard2.setText(pCard2);
        bankerCard1.setText(bCard1);
        bankerCard2.setText(bCard2);
        pause.play(); // pause for a few
        if (playerHand.size() == 3) {
//            System.out.println("players third " + player3);
            playerCard3.setText(pCard3);
            pause.play(); // pause for a few

        }
        if (bankerHand.size() == 3) {
//            System.out.println("bankers third " + banker3);
            bankerCard3.setText(bCard3);
            pause.play();// pause for a few

        }

        playerTotal.setText(String.valueOf(pTotal));
        bankerTotal.setText(String.valueOf(bTotal));

    }
    
}
