import java.util.ArrayList;
import java.util.Collections;

public class BaccaratDealer {
	private ArrayList<Card> deck;
	
	// Whenever a new object is created,
	// generate and shuffle the deck of cards.
	BaccaratDealer(){
		generateDeck();
		shuffleDeck();
	}
	public void generateDeck() {
		for (int i=0; i < 4; i++) {
			for(int j = 1; j < 14; j++) {
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
			if( x.getValue() == 10 || x.getValue() == 11 || x.getValue() == 12 || x.getValue() == 13) {
				x.setValue(0);
			}
		}
		
	}
	
	public ArrayList<Card> dealHand() {
		ArrayList<Card> twoHand = new ArrayList<Card>();
		
		Card one = deck.get(0);
		deck.remove(0);
		Card two = deck.get(1);
		deck.remove(1);
		
		twoHand.add(one);
		twoHand.add(two);
		return twoHand;
		
	}
	public Card drawOne() {
		Card one = deck.get(0);
		deck.remove(0);
		return one;
	}
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	public int deckSize() {
		return deck.size();
	}

}
