import java.util.ArrayList;

public class BaccaratGame {
	private BaccaratDealer dealer;
	// What gets passed in
	public double theBid;
	private String bidChoice;
	private String name;
	
	// What we return
	private ArrayList<Card> playerHand;
	private ArrayList<Card> bankerHand;
	private double roundPayout;
	public double walletTotal;
	private String winner;
	private BaccaratInfo theInfo;
	
	//
	ArrayList<Integer> phand, bhand;
	

	
	
	
	// getting the starting values passed so we can play the game.
	// Creating a new dealer object in order to get the randomized cards.
	BaccaratGame(double theBid,  String choice, double walletTotal, String name){
		this.theBid = theBid;
		this.bidChoice = choice;
		this.walletTotal = walletTotal;
		dealer = new BaccaratDealer();
		theInfo = new BaccaratInfo(phand, bhand, roundPayout, walletTotal, winner, name);
	}
	
	
	public void evaluateWinnings() {
		
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
		
		for (int i = 0; i < playerHand.size(); i++) {
			phand.add(playerHand.get(i).getValue());
		}
		theInfo.setPlayerHand(phand);
		
		for (int i = 0; i < bankerHand.size(); i++) {
			phand.add(bankerHand.get(i).getValue());
		}
		theInfo.setBankerHand(bhand);
		
		winner = BaccaratGameLogic.whoWon(playerHand, bankerHand);
		if (winner == "Player" && bidChoice == "Player") {
			roundPayout = theBid;
		} else if (winner == "Banker" && bidChoice == "Banker") {
			roundPayout = theBid;
		} else if (winner == "Draw" && bidChoice == "Draw") {
			roundPayout = theBid * 8;
		} else {
			roundPayout = 0;
		}
		
		roundPayout = roundPayout + theBid;
		if (roundPayout == 0) {
			walletTotal = walletTotal - theBid;
		} else {
			walletTotal = walletTotal + theBid;
		}
		theInfo.setRoundPayout(this.roundPayout);
		theInfo.setWalletTotal(this.walletTotal);
		theInfo.setWinner(this.winner);
		
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
