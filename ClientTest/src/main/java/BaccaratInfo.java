import java.io.Serializable;
import java.util.ArrayList;

public class BaccaratInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	// What gets passed in
	public double theBid;
	private String bidChoice;
	private String name;
	
	// What we return
	private ArrayList<Integer> playerHand;
	private ArrayList<Integer> bankerHand;
	private double roundPayout;
	public double walletTotal;
	private String winner;
	
	BaccaratInfo(ArrayList<Integer> playerHand, ArrayList<Integer> bankerHand, double roundPayout, double walletTotal, String winner, String name) {
		this.playerHand = playerHand;
		this.bankerHand = bankerHand;
		this.roundPayout = roundPayout;
		this.walletTotal = walletTotal;
		this.winner = winner;
		this.name = name;
	}
	

	
	public BaccaratInfo(String choice, double bid) {
		// TODO Auto-generated constructor stub
		this.theBid = bid;
		this.bidChoice = choice;
	}



	public ArrayList<Integer> getPlayerHand() {
		return this.playerHand;
	}
	public void setPlayerHand(ArrayList<Integer> list) {
		this.playerHand = list;
	}
	
	
	public ArrayList<Integer> getBankerHand() {
		return this.bankerHand;
	}
	public void setBankerHand(ArrayList<Integer> list) {
		this.bankerHand = list;
	}
	
	public double getRoundPayout() {
		return this.roundPayout;
	}
	public void setRoundPayout(double val) {
		this.roundPayout = val;
	}
	
	public double getWalletTotal() {
		return this.walletTotal;
	}
	public void setWalletTotal(double val) {
		this.walletTotal = val;
	}
	
	public String getWinner() {
		return this.getWinner();
	}
	public void setWinner(String win) {
		this.winner = win;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBid() {
		return this.theBid;
	}
	
	
	
	

}
