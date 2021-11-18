import java.util.ArrayList;

public class BaccaratGame {
	ArrayList<Card> playerHand;
	ArrayList<Card> bankerHand;
	BaccaratDealer theDealer;
	public double currentBet;
	public double totalWinnings;
	
	theDealer = new BaccaratDealer();
	theDealer.generateDeck();
	theDealer.shuffleDeck();
	
	playerHand = theDealer.dealHand();
	
	
	
	
	
	
	
	
	
	
	
	
	
	public double evaluateWinnings() {
		return 0;
	}
	

}
