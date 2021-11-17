
public class Card {
	String suite;
	int value;
	Card(String Suite, int theValue) {
		this.suite = Suite;
		this.value = theValue;
	}
	
	public String getSuite() {
		return this.suite;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setSuite(String s) {
		this.suite = s;
	}
	
	public void setValue(int v) {
		this.value = v;
	}
}
