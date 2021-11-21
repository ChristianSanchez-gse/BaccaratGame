import java.io.Serializable;

public class BaccaratInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double playerBid = 0;
	private double bankerBid = 0;
	private double tieBid = 0;
	private double totalBid = 0;
	private String name;
	
	BaccaratInfo(double pbid, double bbid,  double tbid, String name) {
		this.playerBid = pbid;
		this.bankerBid = bbid;
		this.tieBid = tbid;
		this.totalBid = pbid + bbid + tbid;
		this.name = name;
	}
	
	public void setplayerBid(double val) {
		this.playerBid = val;
	}
	
	public void setbankerBid(double val) {
		this.bankerBid = val;
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
