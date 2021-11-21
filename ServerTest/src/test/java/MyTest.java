import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	static Card card1;
	
	static BaccaratDealer theDealer;
	static BaccaratGame game1;
	static BaccaratGame game2;
	static BaccaratGame game3;
	//static private int iter, iter2;
	
	@BeforeAll
	static void setup() {
		card1 = new Card("Spade", 8);
		
    	theDealer = new BaccaratDealer();
    	game1 = new BaccaratGame(5, "Banker", 20, "Andrew");
    	game2 = new BaccaratGame(5, "Player", 20, "Andrew");
    	game3 = new BaccaratGame(5, "Tie", 20, "Andrew");
		
	}
	
	@Test
	void cardvaltest() {///
		assertEquals(8,card1.getValue(), "wrong value");
	}
	@Test
	void cardSuiteTest() {///
		assertEquals("Spade",card1.getSuite(), "wrong value");
	}
	
	@Test
	void dealersizeTest1() {///
		BaccaratDealer theDealer= new BaccaratDealer();
		assertEquals(52,theDealer.deckSize(), "wrong value");
	}
	
	@Test
	void dealersizeTest2() {///
		BaccaratDealer theDealer= new BaccaratDealer();
		theDealer.drawOne();
		assertEquals(51,theDealer.deckSize(), "wrong value");
	}
	
	@Test
	void dealerDealHandTest() {///
		BaccaratDealer theDealer2 = new BaccaratDealer();
		ArrayList<Card> aHand = theDealer2.dealHand();
		assertEquals(2,aHand.size(), "wrong value");
	}
	
	@Test
	void dealerDealHandTest2() {///
		BaccaratDealer theDealer2 = new BaccaratDealer();
		ArrayList<Card> aHand = theDealer2.dealHand();
		assertEquals(50,theDealer2.deckSize(), "wrong value");
	}
	
	@Test
	void dealerDealHandTest3() {
		ArrayList<Card> aHand = theDealer.dealHand();
		ArrayList<Card> aHand2 = theDealer.dealHand();
		assertEquals(45,theDealer.deckSize(), "wrong value");
	}
	@Test
	void dealerDrawOneTest1() {
		Card aHand = theDealer.drawOne();
		
		assertEquals(51,theDealer.deckSize(), "wrong value");
	}
	
	@Test
	void dealerDrawOneTest2() {
		Card aHand = theDealer.drawOne();
		aHand = theDealer.drawOne();
		assertEquals(49,theDealer.deckSize(), "wrong value");
	}
	
	@Test
	void BaccaratRoundPayOutTest1a() {
		//game1.evaluateWinnings();
		if (game1.getRoundPayout() > 0) {
			assertEquals(10, game1.getRoundPayout(), "wrong value");
		} else {
			assertEquals(0, game1.getRoundPayout(), "wrong value");
		}
	}
	
	@Test
	void BaccaratRoundPayOutTest1b() {
		//game2.evaluateWinnings();
		if (game2.getRoundPayout() > 0) {
			assertEquals(10, game2.getRoundPayout(), "wrong value");
		} else {
			assertEquals(0, game2.getRoundPayout(), "wrong value");
		}
	}
	
	@Test
	void BaccaratchoiceTest() {
		//game3.evaluateWinnings();
		assertEquals("Tie", game3.getChoice(), "wrong value");
	}
	
	@Test
	void BaccaratchoiceTest2() {
		//game3.evaluateWinnings();
		assertEquals("Banker", game1.getChoice(), "wrong value");
	}
	
	@Test
	void BaccaratGameWinner() {
		//game3.evaluateWinnings();
		if (game1.getWinner() == "Banker" && game1.getChoice() == "Banker") {
			assertEquals("Banker", game1.getWinner(), "wrong value");
		} else if (game1.getWinner() == "Tie" && game1.getChoice() == "Tie") {
			assertEquals("Tie", game1.getWinner(), "wrong value");
		} else if (game1.getWinner() == "Player" && game1.getChoice() == "Player") {
			assertEquals("Player", game1.getWinner(), "wrong value");
		}
	}
	
	
	
}
