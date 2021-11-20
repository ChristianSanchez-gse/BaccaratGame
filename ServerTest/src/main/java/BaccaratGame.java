import java.util.ArrayList;

public class BaccaratGame {
	private BaccaratDealer dealer;
	// What gets passed in
	public double tieBid;
	public double playerBid;
	public double bankerBid;
	
	// What we return
	private ArrayList<Card> playerHand;
	private ArrayList<Card> bankerHand;
	private double roundPayout;
	public double walletTotal;
	private String winner;
	private BaccaratInfo theInfo;

	
	
	
	// getting the starting values passed so we can play the game.
	// Creating a new dealer object in order to get the randomized cards.
	BaccaratGame(double tieBid, double playerBid, double bankerBid, double walletTotal, String name){
		this.tieBid = tieBid;
		this.playerBid = playerBid;
		this.bankerBid = bankerBid;
		this.walletTotal = walletTotal;
		theInfo = new BaccaratInfo(playerBid, bankerBid, tieBid, name);
		dealer = new BaccaratDealer();
	}
	
	
	public void evaluateWinnings() {
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
			roundPayout = playerBid * 2;
		} else if (winner == "Banker") {
			roundPayout = bankerBid * 2;
		} else if (winner == "Draw") {
			roundPayout = tieBid * 8;
		}
		
		roundPayout = roundPayout - totalBid;
		walletTotal = walletTotal - totalBid + roundPayout;
	}
	
	public double getRoundPayout() {
		return this.roundPayout;
	}
	
	public String getWinner() {
		return this.winner;
	}
	public ArrayList<Card> playerHand(){
		return this.playerHand;
	}
	public ArrayList<Card> bankerHand(){
		return this.bankerHand;
	}
	
	public double getWalletTotal() {
		return this.walletTotal;
	}
	
	public BaccaratInfo getInfo() {
		return this.theInfo;
	}

}
