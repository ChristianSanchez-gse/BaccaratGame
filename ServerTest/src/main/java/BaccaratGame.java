import java.util.ArrayList;

public class BaccaratGame {
	// What gets passed in
	public double tieBid;
	public double playerBid;
	public double bankerBid;
	
	// What we return
	private ArrayList<Card> playerHand;
	private ArrayList<Card> bankerHand;
	private double totalWinnings;
	public double currentStanding;
	private BaccaratDealer dealer;
	private String winner;
	
	
	
	// getting the starting values passed so we can play the game.
	// Creating a new dealer object in order to get the randomized cards.
	BaccaratGame(double tieBid, double playerBid, double bankerBid, double currentStanding){
		this.tieBid = tieBid;
		this.playerBid = playerBid;
		this.bankerBid = bankerBid;
		this.currentStanding = currentStanding;
		dealer = new BaccaratDealer();
	}
	
	
	public double evaluateWinnings() {
		double totalBid = tieBid + playerBid + bankerBid;  // total bid
		dealer = new BaccaratDealer();
		dealer.generateDeck();
		dealer.shuffleDeck();
		
		Card cardPointer = new Card("", -1);
		
		playerHand = dealer.dealHand();
		bankerHand = dealer.dealHand();
		if (BaccaratGameLogic.evaluatePlayerDraw(playerHand) == true) {
			cardPointer = dealer.drawOne();
			playerHand.add(cardPointer);
		} 
		
		if (BaccaratGameLogic.evaluateBankerDraw(bankerHand, cardPointer)) {
			bankerHand.add(dealer.drawOne());
		}
		
		winner = BaccaratGameLogic.whoWon(playerHand, bankerHand);
		if (winner == "Player") {
			totalWinnings = playerBid * 2;
		} else if (winner == "Banker") {
			totalWinnings = bankerBid * 2;
		} else if (winner == "Draw") {
			totalWinnings = tieBid * 8;
		}
		
		currentStanding = currentStanding - totalBid + totalWinnings;
		return totalWinnings;
	}
	
	

}
