/**
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import model.Card;
import model.HandType;
import model.HandTypeEvaluator;
import model.Rank;
import model.SimpleCard;
import model.Suit;
import org.junit.jupiter.api.Test;

/**
 * @author David
 *
 */
public class HandTypeEvaluatorTest {
	HandTypeEvaluator testing = new HandTypeEvaluator();

	/**
	 * Test method for OnePair
	 */

	@Test
	public void testIsOnePair() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));

		assertEquals(testing.evaluateHand(hand), HandType.OnePair);
	}

	/**
	 * Test method for TwoPair, paare nur aufeinanderfolgend
	 */

	@Test
	public void testIsTwoPair() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand), HandType.TwoPair);
	}

	@Test
	public void testIsTwoPairFalse() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.nine, 0));

		assertEquals(testing.evaluateHand(hand), null);
	}

	/**
	 * Test method for Stair, paare nur aufeinanderfolgend
	 */

	@Test
	public void testIsTwoPairStair() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Queen, 0));

		assertEquals(testing.evaluateHand(hand), HandType.TwoPair);
	}

	@Test
	public void testIsTwoPairStairFalse() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand1.add(new SimpleCard(Suit.Moon, Rank.King, 0));
		hand1.add(new SimpleCard(Suit.House, Rank.King, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.TwoPair);
		assertNotEquals(testing.evaluateHand(hand1), HandType.TwoPair);
	}

	/**
	 * Test method for ThreeOfAKind
	 */

	@Test
	public void testIsThreeOfAKind() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.Ace, 0));

		assertEquals(testing.evaluateHand(hand), HandType.ThreeOfAKind);

	}

	/**
	 * Test method for Streets
	 */
	@Test
	public void testIsFullHouse() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.Ace, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand), HandType.FullHouse);

	}

	@Test
	public void testIsFiveStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));

		assertEquals(testing.evaluateHand(hand), HandType.FiveStreet);

	}

	@Test
	public void testIsSixStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();

		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));

		assertEquals(testing.evaluateHand(hand), HandType.SixStreet);

	}

	@Test
	public void testIsSevenStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.eight, 0));

		assertEquals(testing.evaluateHand(hand), HandType.SevenStreet);

	}

	@Test
	public void testIsEightStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.nine, 0));

		assertEquals(testing.evaluateHand(hand), HandType.EightStreet);

	}

	@Test
	public void testIsNineStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();
//		hand.add(new SimpleCard(Suit.Special, Rank.Dog, 0, 0)); 
//		hand.add(new SimpleCard(Suit.Special, Rank.MahJong, 0, 0)); 
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));

		assertEquals(testing.evaluateHand(hand), HandType.NineStreet);

	}

	@Test
	public void testIsTenStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));

		assertEquals(testing.evaluateHand(hand), HandType.TenStreet);

	}

	@Test
	public void testIsElevenStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.Queen, 0));

		assertEquals(testing.evaluateHand(hand), HandType.ElevenStreet);

	}

	@Test
	public void testIsTwelveStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand), HandType.TwelveStreet);

	}

	@Test
	public void testIsThirdteenStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));

		assertEquals(testing.evaluateHand(hand), HandType.ThirdteenStreet);

	}

	@Test
	public void testIsFourteenStreet() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.Special, Rank.MahJong, 0));
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.Ace, 0));

		assertEquals(testing.evaluateHand(hand), HandType.FourteenStreet);

	}

	/**
	 * Test method for Bombs
	 */

	@Test
	public void testIsFourOfAKindBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Sword, Rank.three, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));

		assertEquals(testing.evaluateHand(hand), HandType.FourOfAKindBomb);

	}

	@Test
	public void testFalseIsFourOfAKindBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Sword, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Moon, Rank.three, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.FourOfAKindBomb);

	}

	@Test
	public void testIsFiveBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.FiveStreet);
		assertEquals(testing.evaluateHand(hand), HandType.FiveBomb);
	}

	@Test
	public void testFalseIsFiveBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Sword, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));

		assertEquals(testing.evaluateHand(hand), HandType.FiveStreet);
		assertNotEquals(testing.evaluateHand(hand), HandType.FiveBomb);
	}

	@Test
	public void testIsSixBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.SixStreet);
		assertEquals(testing.evaluateHand(hand), HandType.SixBomb);
	}

	@Test
	public void testFalseIsSixBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.Sword, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));

		assertEquals(testing.evaluateHand(hand), HandType.SixStreet);
		assertNotEquals(testing.evaluateHand(hand), HandType.SixBomb);
	}

	@Test
	public void testIsSevenBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.SevenStreet);
		assertEquals(testing.evaluateHand(hand), HandType.SevenBomb);
	}

	@Test
	public void testFalseIsSevenBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Sword, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));

		assertEquals(testing.evaluateHand(hand), HandType.SevenStreet);
		assertNotEquals(testing.evaluateHand(hand), HandType.SevenBomb);
	}

	@Test
	public void testIsEightBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.EightStreet);
		assertEquals(testing.evaluateHand(hand), HandType.EightBomb);
	}

	@Test
	public void testFalseIsEightBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Sword, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));

		assertEquals(testing.evaluateHand(hand), HandType.EightStreet);
		assertNotEquals(testing.evaluateHand(hand), HandType.EightBomb);
	}

	@Test
	public void testIsNineBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.NineStreet);
		assertEquals(testing.evaluateHand(hand), HandType.NineBomb);
	}

	@Test
	public void testFalseIsNineBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Sword, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));

		assertEquals(testing.evaluateHand(hand), HandType.NineStreet);
		assertNotEquals(testing.evaluateHand(hand), HandType.NineBomb);
	}

	@Test
	public void testIsTenBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Jack, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.TenStreet);
		assertEquals(testing.evaluateHand(hand), HandType.TenBomb);
	}

	@Test
	public void testFalseIsTenBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Jack, 0));

		assertEquals(testing.evaluateHand(hand), HandType.TenStreet);
		assertNotEquals(testing.evaluateHand(hand), HandType.TenBomb);
	}

	@Test
	public void testIsElevenBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Queen, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.EightStreet);
		assertEquals(testing.evaluateHand(hand), HandType.ElevenBomb);
	}

	@Test
	public void testFalseIsElevenBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Queen, 0));

		assertEquals(testing.evaluateHand(hand), HandType.ElevenStreet);
		assertNotEquals(testing.evaluateHand(hand), HandType.ElevenBomb);
	}

	@Test
	public void testIsTwelveBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.TwelveStreet);
		assertEquals(testing.evaluateHand(hand), HandType.TwelveBomb);
	}

	@Test
	public void testFalseIsTwelveBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Sword, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));

		assertEquals(testing.evaluateHand(hand), HandType.TwelveStreet);
		assertNotEquals(testing.evaluateHand(hand), HandType.TwelveBomb);
	}

	@Test
	public void testIsThirteenBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.House, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Ace, 0));

		assertNotEquals(testing.evaluateHand(hand), HandType.ThirdteenStreet);
		assertEquals(testing.evaluateHand(hand), HandType.ThirteenBomb);
	}

	@Test
	public void testFalseIsThirteenBomb() {
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new SimpleCard(Suit.House, Rank.two, 0));
		hand.add(new SimpleCard(Suit.Star, Rank.three, 0));
		hand.add(new SimpleCard(Suit.House, Rank.four, 0));
		hand.add(new SimpleCard(Suit.House, Rank.five, 0));
		hand.add(new SimpleCard(Suit.House, Rank.six, 0));
		hand.add(new SimpleCard(Suit.House, Rank.seven, 0));
		hand.add(new SimpleCard(Suit.House, Rank.eight, 0));
		hand.add(new SimpleCard(Suit.House, Rank.nine, 0));
		hand.add(new SimpleCard(Suit.House, Rank.ten, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Jack, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Queen, 0));
		hand.add(new SimpleCard(Suit.House, Rank.King, 0));
		hand.add(new SimpleCard(Suit.House, Rank.Ace, 0));

		assertEquals(testing.evaluateHand(hand), HandType.ThirdteenStreet);
		assertNotEquals(testing.evaluateHand(hand), HandType.ThirteenBomb);
	}
}
