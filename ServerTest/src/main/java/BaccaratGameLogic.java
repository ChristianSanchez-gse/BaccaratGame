import java.util.ArrayList;
/*
The method whoWon will evaluate two hands at the end of the game and return a string
depending on the winner: “Player”, “Banker”, “Draw”. The method handTotal will take a
hand and return how many points that hand is worth. The methods evaluateBankerDraw
and evaluatePlayerDraw will return true if either one should be dealt a third card,
otherwise return false.
*/
public class BaccaratGameLogic {
	public static String whoWon(ArrayList<Card> hand1, ArrayList<Card>hand2) {
		int val1= 0;
		int val2 = 0;
		
		for (int i = 0; i < hand1.size(); i++) {
			val1 += hand1.get(i).getValue();
			if (val1 > 9) {
				val1 = val1 - 10;
			}
		}
		
		
		for (int i = 0; i < hand2.size(); i++) {
			val2 += hand2.get(i).getValue();
			if (val2 > 9) {
				val2 = val2 - 10;
			}
		}
		
		if (val1 > val2) {
			return "Player";
		} else if (val1 < val2) {
			return "Dealer";
		} else{
			return "Draw";
		}
		
//		if ((val1 == 8 || val1 == 9) && (val2 == 8 || val2 == 9)) {
//			return "Draw";
//		} else if (val1 == 8 || val1 == 9) {
//			return "Player";
//		} else if(val2 == 8 || val2 == 9){
//			return "Dealer";
//		}
		
	}
	// value of the 2 cards added together
	public static int handTotal(ArrayList<Card> hand) {
		int val = 0;
		for (int i = 0; i < hand.size(); i++) {
			val += hand.get(0).getValue();
			if (val > 9) {
				val = val - 10;
			}
		}
		return val;
	}
	public static boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard) {
		int first2 = hand.get(0).getValue() + hand.get(1).getValue();
		
		if (first2 >= 7) {
			return false;
		}else if (first2 == 3) {
			if(playerCard.getValue() == 8) {
				return false;
			}
			return true;
		} else if (first2 == 4){
			if (playerCard.getValue() == 0 || playerCard.getValue() == 1 ||playerCard.getValue() == 8 ||playerCard.getValue() == 9) {
				return false;
			}
			return true;
		} else if (first2 == 5) {
			if (playerCard.getValue() == 0 || playerCard.getValue() == 1 ||playerCard.getValue() == 2 || playerCard.getValue() == 3 ||playerCard.getValue() == 8 ||playerCard.getValue() == 9) {
				return false;
			}
			return true;
		} else if (first2 == 6) {
			if (playerCard.getValue() == 6 || playerCard.getValue() == 7) {
				return true;
			}
			return false;
		}  else{
			return true;
		} 
		
		
	}
	public static boolean evaluatePlayerDraw(ArrayList<Card> hand) {
		int total = hand.get(0).getValue() + hand.get(1).getValue();
		if (total <= 5) {
			return true;
		} else {
			return false;
		}
	}
}
