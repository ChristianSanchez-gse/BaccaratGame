import java.util.ArrayList;

public class BaccaratGame {
	private BaccaratDealer dealer;
	// What gets passed in
	public double theBid;
	public String bidChoice;

	
	// What we return
	private ArrayList<Card> playerHand;
	private ArrayList<Card> bankerHand;
	private double roundPayout;
	private double walletTotal;
	private String winner;
	private BaccaratInfo theInfo;
	//ArrayList<Card> deck;
	//
	ArrayList<Integer> phand, bhand;
	

	
	
	
	// getting the starting values passed so we can play the game.
	// Creating a new dealer object in order to get the randomized cards.
	BaccaratGame(double theBid,  String choice, double walletTotal){
//		this.playerHand = new ArrayList<Card>();
//		this.bankerHand = new ArrayList<Card>();
		
		dealer = new BaccaratDealer();
		this.phand = new ArrayList<Integer>();
		this.bhand = new ArrayList<Integer>();
		this.theBid = theBid;
		this.bidChoice = choice;
		this.walletTotal = walletTotal;


	}
	
	public void playGame() {
		// TODO Auto-generated method stub
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
		
		for (int i = 0; i < bankerHand.size(); i++) {
			bhand.add(bankerHand.get(i).getValue());
		}
		
		winner = BaccaratGameLogic.whoWon(playerHand, bankerHand);
		System.out.println("The winner is supposed to be: " + winner + " And the choice is: " + bidChoice);
		if(winner == bidChoice) {
			System.out.println("They are the same!");
		}
		if (winner.equals("Player") && bidChoice.equals("Player")) {
			roundPayout = theBid;
		} else if (winner.equals("Banker") && bidChoice.equals("Banker")) {
			roundPayout = theBid;
		} else if (winner.equals("Draw") && bidChoice.equals("Draw")) {
			roundPayout = theBid * 8;
		} else {
			System.out.println("zero payout");
			roundPayout = 0;
		}
		
		System.out.println("The payout is: " + roundPayout);
		System.out.println("The current wallet is: " + walletTotal);
		System.out.println("The bid is: " + theBid);
		if (roundPayout == 0) {
			walletTotal = walletTotal - theBid;
		} else {
			walletTotal = walletTotal + roundPayout;
		}
		System.out.println("The new wallet is: " + walletTotal);
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
		System.out.println("Something called getWalletTotal..... this is what we return: " + walletTotal);
		return this.walletTotal;
	}
	
	public BaccaratInfo getInfo() {
		return this.theInfo;
	}
	
	public String getChoice() {
		return this.bidChoice;
	}
	
	public ArrayList<Integer> playerHandInt(){
		return phand;
	}
	public ArrayList<Integer> bankerHandInt(){
		return bhand;
	}

	

}
