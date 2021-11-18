import java.io.Serializable;

public class BaccaratInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Betting stats that is sent from client
	// to server
	private double playerBid;
	private double bankerBid;
	private double tieBid;
	private double totalBid;
	//
	
	// Game stats that is sent from server to
	// the client 
	
	
	BaccaratInfo(double pbid, double bbid,  double tbid) {
		this.playerBid = pbid;
		this.bankerBid = bbid;
		this.tieBid = tbid;
		this.totalBid = pbid + bbid + tbid;
	}
	
	public void setplayerBid(double val) {
		this.playerBid = val;
	}
	
	public void setbankerBid(double val) {
		this.tieBid = val;
	}
	
	public void settieBid(double val) {
		this.tieBid = val;
	}
	
	public double getTotalBid() {
		return this.totalBid;
	}
	
	public double getplayerBid() {
		return this.playerBid;
	}
	
	public double getbankerBid() {
		return this.bankerBid;
	}
	
	public double gettieBid() {
		return this.tieBid;
	}
	
	public void resetBids() {
		this.playerBid = 0;
		this.bankerBid = 0;
		this.tieBid = 0;
		this.totalBid = 0;
	}
	
	
	

}
