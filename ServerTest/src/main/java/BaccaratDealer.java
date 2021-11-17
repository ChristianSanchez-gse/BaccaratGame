import java.util.ArrayList;

public class BaccaratDealer {
	ArrayList<Card> deck;
	public void generateDeck() {
		for (int i=0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				if(i == 0) {
					deck.add(new Card("Diamond", j));
				} else if (i == 1) {
					deck.add(new Card("Spade", j));
				} else if (i == 2) {
					deck.add(new Card("Heart", j));
				} else if (i == 3) {
					deck.add(new Card("Club", j));
				}
				
			}
		}
		for (Card x: deck) {
			if( x.getValue() == 9 || x.getValue() == 10 || x.getValue() == 11|| x.getValue() == 12) {
				x.setValue(0);
			}
		}
		
	}
	
	public ArrayList<Card> dealHand() {
		return null;
	}
	public Card drawOne() {
		return null;
	}
	public void shuffleDeck() {
	}
	public int deckSize() {
		return 0;
	}

}
