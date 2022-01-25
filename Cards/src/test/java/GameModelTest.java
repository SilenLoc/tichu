import model.Card;
import model.HandType;
import model.HandTypeEvaluator;
import model.Rank;
import model.SimpleCard;
import model.Suit;
import model.WinEvaluator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameModelTest {

	WinEvaluator gameModel = new WinEvaluator();
	HandTypeEvaluator testing = new HandTypeEvaluator();

	/**
	 * Test method for HighCard, hand1>hand2
	 */
	@Test
	public void testHighCardTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.HighCard);
		assertEquals(testing.evaluateHand(hand2), HandType.HighCard);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for HighCard, hand1>hand2 dragon>phoenix dragon>ace phoenix>ace
	 */
	@Test
	public void testHighCardTieWinnerDragon() {
		ArrayList<Card> hand1 = new ArrayList<>();
		hand1.add(new SimpleCard(Suit.Special, Rank.Dragon, 0));

		ArrayList<Card> hand2 = new ArrayList<>();
		hand2.add(new SimpleCard(Suit.Special, Rank.Phoenix, 0));

		ArrayList<Card> hand3 = new ArrayList<>();
		hand3.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.HighCard);
		assertEquals(testing.evaluateHand(hand2), HandType.HighCard);
		assertEquals(testing.evaluateHand(hand3), HandType.HighCard);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));

		gameModel.setLastHandCards(hand3);
		assertTrue(gameModel.tieWinner(hand1));

		gameModel.setLastHandCards(hand3);
		assertTrue(gameModel.tieWinner(hand2));
	}

	/**
	 * Test method for OnePair, hand1>hand2
	 */

	@Test
	public void testOnePairTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.OnePair);
		assertEquals(testing.evaluateHand(hand2), HandType.OnePair);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));

	}

	/**
	 * Test method for ThreeOfAKind, hand1>hand2
	 */

	@Test
	public void testThreeOfAKindTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.Ace, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.ThreeOfAKind);
		assertEquals(testing.evaluateHand(hand2), HandType.ThreeOfAKind);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));

	}

	/**
	 * Test method for TwoPair, hand1>hand2
	 */

	@Test
	public void testTwoPairTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.King, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.Queen, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.TwoPair);
		assertEquals(testing.evaluateHand(hand2), HandType.TwoPair);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));

	}

	/**
	 * Test method for TwoPair, hand1>hand2
	 */

	@Test
	public void testTwoPairStairTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Queen, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.TwoPair);
		assertEquals(testing.evaluateHand(hand2), HandType.TwoPair);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));

	}

	/**
	 * Test method for TwoPair, hand1>hand2 false, because not the same amount of
	 * cards
	 */

	@Test
	public void testTwoPairStairTieWinnerComparedByHighCard() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.ten, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.TwoPair);
		assertEquals(testing.evaluateHand(hand2), HandType.TwoPair);

		gameModel.setLastHandCards(hand2);
		assertFalse(gameModel.tieWinner(hand1));

	}

	/**
	 * Test method for FullHouse, hand1>hand2
	 */

	@Test
	public void testFullHouseTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.King, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.Queen, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.FullHouse);
		assertEquals(testing.evaluateHand(hand2), HandType.FullHouse);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));

	}

	/**
	 * Test method for FiveStreet, hand1>hand2
	 */

	@Test
	public void testFifeStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.FiveStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.FiveStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for SixStreet, hand1>hand2
	 */

	@Test
	public void testSixStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.SixStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.SixStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for SevenStreet, hand1>hand2
	 */

	@Test
	public void testSevenStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.nine, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.SevenStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.SevenStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for SevenStreet, hand1>hand2
	 */

	@Test
	public void testSevenStreetVsSixStreet() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.nine, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
//		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0)); 
//		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0)); 
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.SevenStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.SixStreet);

		gameModel.setLastHandCards(hand2);
		assertFalse(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for EightStreet, hand1>hand2
	 */

	@Test
	public void testEightStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.ten, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.nine, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.EightStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.EightStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for NineStreet, hand1>hand2
	 */

	@Test
	public void testNineStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.NineStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.NineStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for TenStreet, hand1>hand2
	 */

	@Test
	public void testTenStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.Queen, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.Jack, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.TenStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.TenStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for ElevenStreet, hand1>hand2
	 */

	@Test
	public void testElevenStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.King, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.Jack, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.ElevenStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.ElevenStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for TwelveStreet, hand1>hand2
	 */

	@Test
	public void testTwelveStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.Ace, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.Jack, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.TwelveStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.TwelveStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for TwelveStreet, hand1>hand2
	 */

	@Test
	public void testThirdTeenStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Star, Rank.two, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.Ace, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.Special, Rank.MahJong, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.Jack, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.ThirdteenStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.ThirdteenStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for FourteenStreet, hand1>hand2
	 */

//	@Test
	public void testFourtteenStreetTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.Special, Rank.MahJong, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.two, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.Ace, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.Jack, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.FourteenStreet);
		assertEquals(testing.evaluateHand(hand2), HandType.FourteenStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for FourBomb, hand1>hand2
	 */
	@Test
	public void testIsFourBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Star, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.Sword, Rank.three, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.Sword, Rank.six, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.FourOfAKindBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.FiveStreet);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}
	
	/**
	 * Test method for FiveBomb, hand1>hand2
	 */
	@Test
	public void testIsFiveBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.FiveBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.FiveBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for SixBomb, hand1>hand2
	 */
	@Test
	public void testIsSixBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.eight, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.seven, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.SixBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.SixBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for SevenBomb, hand1>hand2
	 */

	@Test
	public void testIsSevenBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();

		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.nine, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.SevenBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.SevenBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for SevenBomb, hand1>hand2
	 */

	@Test
	public void testIsEigthBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.ten, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.nine, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.EightBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.EightBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for NineBomb, hand1>hand2
	 */

	@Test
	public void testIsNineBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.NineBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.NineBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for TenBomb, hand1>hand2
	 */

	@Test
	public void testIsTenBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Queen, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();

		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Jack, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.TenBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.TenBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for ElevenBomb, hand1>hand2
	 */

	@Test
	public void testIsElevenBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();

		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.King, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();

		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.ElevenBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.ElevenBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for ElevenBomb, hand1>hand2
	 */

	@Test
	public void testIsTwelveBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();

		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();

		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.TwelveBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.TwelveBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for NineBomb vs FiveBomb, hand1>hand2
	 */
	@Test
	public void testIsNineBombNineBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.NineBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.FiveBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}

	/**
	 * Test method for TwelveBomb vs ElevenBomb, hand1>hand2
	 */
	@Test
	public void testIsTwelveBombVsElevenBombTieWinner() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));

		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand2.add(new SimpleCard(Suit.House, Rank.Ace, 0));

		assertEquals(testing.evaluateHand(hand1), HandType.TwelveBomb);
		assertEquals(testing.evaluateHand(hand2), HandType.ElevenBomb);

		gameModel.setLastHandCards(hand2);
		assertTrue(gameModel.tieWinner(hand1));
	}
}
