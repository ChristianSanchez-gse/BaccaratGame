import java.util.ArrayList;

public class BaccaratGame {
	// What gets passed in
	private double bet;
	private String choice;
	
	// What we return
	private ArrayList<Card> playerHand;
	private ArrayList<Card> bankerHand;
	private BaccaratDealer theDealer;
	private double totalWinnings;
	private BaccaratDealer dealer;
	private String winner;
	
	
	
	// getting the starting values passed so we can play the game.
	// Creating a new dealer object in order to get the randomized cards.
	BaccaratGame(double bet, String choice){
		this.bet = bet;
		this.choice = choice;
		dealer = new BaccaratDealer();
	}
	
	
	public void evaluateWinnings() {
		ArrayList<Card> playerHand = dealer.dealHand();
		ArrayList<Card> bankerHand = dealer.dealHand();
		if (BaccaratGameLogic.evaluatePlayerDraw(playerHand) == true) {
			playerHand.add(dealer.drawOne());
		} 
		
		if (BaccaratGameLogic.evaluateBankerDraw(bankerHand, playerHand.get(playerHand.size()))) {
			
		}
		
		winner = BaccaratGameLogic.whoWon(bankerHand, playerHand);
		
	}
	
	

}
