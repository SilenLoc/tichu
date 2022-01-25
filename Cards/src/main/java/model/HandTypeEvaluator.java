package model;

import java.util.ArrayList;
import java.util.List;


public class HandTypeEvaluator {
	// just to find out what HandType the Hand is
	public HandTypeEvaluator() {

	}

	public HandType evaluateHand(ArrayList<Card> chosenCard) {
		HandType returnValue = null;
		switch (chosenCard.size()) {
		case 1:
			returnValue = HandType.HighCard;
			break;
		case 2:
			if (isOnePair(chosenCard))
				returnValue = HandType.OnePair;
			break;
		case 3:
			if (isThreeOfAKind(chosenCard))
				returnValue = HandType.ThreeOfAKind;
			break;
		case 4:
			if (isTwoPair(chosenCard))
				returnValue = HandType.TwoPair;

			else if (isFourOfAKind(chosenCard))
				returnValue = HandType.FourOfAKindBomb;
			break;
		case 5:
			if (isFullHouse(chosenCard)) {
				returnValue = HandType.FullHouse;

			} else if (isFiveStreet(chosenCard)) {
				returnValue = HandType.FiveStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.FiveBomb;
			}
			break;
		case 6:
			if (isSixStreet(chosenCard)) {
				returnValue = HandType.SixStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.SixBomb;
			} else if (isTwoPair(chosenCard)) {
				returnValue = HandType.TwoPair;
			}
			break;
		case 7:
			if (isSevenStreet(chosenCard)) {
				returnValue = HandType.SevenStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.SevenBomb;
			}
			break;
		case 8:
			if (isEightStreet(chosenCard)) {
				returnValue = HandType.EightStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.EightBomb;
			} else if (isTwoPair(chosenCard)) {
				returnValue = HandType.TwoPair;
			}
			break;
		case 9:
			if (isNineStreet(chosenCard)) {
				returnValue = HandType.NineStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.NineBomb;
			}
			break;
		case 10:
			if (isTenStreet(chosenCard)) {
				returnValue = HandType.TenStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.TenBomb;
			} else if (isTwoPair(chosenCard))
				returnValue = HandType.TwoPair;
			break;
		case 11:
			if (isElevenStreet(chosenCard)) {
				returnValue = HandType.ElevenStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.ElevenBomb;
			}
			break;
		case 12:
			if (isTwelveStreet(chosenCard)) {
				returnValue = HandType.TwelveStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.TwelveBomb;
			} else if (isTwoPair(chosenCard))
				returnValue = HandType.TwoPair;
			break;
		case 13:
			if (isThirdteenStreet(chosenCard)) {
				returnValue = HandType.ThirdteenStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.ThirteenBomb;
			}
			break;
		case 14:
			if (isFourteenStreet(chosenCard)) {
				returnValue = HandType.FourteenStreet;
				if (isFlush(chosenCard))
					returnValue = HandType.FourteenBomb;
			} else if (isTwoPair(chosenCard))
				returnValue = HandType.TwoPair;
			break;
		}
		return returnValue;
	}

	private boolean isFlush(List<Card> chosenCard) {
		return chosenCard.stream().map(Card::getSuit).distinct().count() == 1;
	}

	// Methode to sort cardsInHand by rank
	public ArrayList<Card> sortHand(List<Card> chosenCard) {
		ArrayList<Card> sortedCards = new ArrayList<Card>();
		for (int j = 0; j < Rank.values().length; j++) {
			for (int i = 0; i < chosenCard.size(); i++) {
				if (chosenCard.get(i).getRank().getOrdinal() == j) {
					sortedCards.add(chosenCard.get(i));
				}
			}
		}
		return sortedCards;
	}

	private boolean isFourteenStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 14);
	}

	private boolean isFourteenBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 14);
	}

	private boolean isThirdteenStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 13);
	}

	private boolean isThirteenBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 13);
	}

	private boolean isTwelveStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 12);
	}

	private boolean isTwelveBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 12);
	}

	private boolean isElevenStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 11);
	}

	private boolean isElevenBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 11);
	}

	private boolean isTenStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 10);
	}

	private boolean isTenBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 10);
	}

	private boolean isNineStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 9);
	}

	private boolean isNineBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 9);
	}

	private boolean isEightStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 8);
	}

	private boolean isEightBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 8);
	}

	private boolean isSevenStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 7);
	}

	private boolean isSevenBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 7);
	}

	private boolean isSixStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 6);
	}

	private boolean isSixBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 6);
	}

	private boolean isFiveStreet(List<Card> chosenCard) {
		return isStreet(chosenCard, 5);
	}

	private boolean isFiveBomb(List<Card> chosenCard) {
		return isBomb(chosenCard, 5);
	}

	private boolean isBomb(List<Card> chosenCard, int length) {
		if (isFlush(chosenCard)) {
			return true;
		}
		return false;
	}

	private boolean isStreet(List<Card> chosenCard, int length) {
		if (chosenCard.size() != length) {
			return false;
		}
		for (Card c : chosenCard) {
			if (c.getRank().equals(Rank.Dog) || c.getRank().equals(Rank.Dragon)) {
				return false;
			}
		}
		List<Card> clonedCards;
		clonedCards = sortHand(chosenCard);

		for (int i = 0; i < chosenCard.size() - 1; i++) {
			if (clonedCards.get(i).getRank().getOrdinal() + 1 != clonedCards.get(i + 1).getRank().getOrdinal()) {
				return false;
			}
		}
		return true;
	}

	private boolean isFourOfAKind(List<Card> chosenCard) {
		return chosenCard.size() == 4 && chosenCard.stream().map(Card::getRank).distinct().count() == 1;
	}

	private boolean isFullHouse(List<Card> chosenCard) {
		if (chosenCard.size() != 5) {
			return false;
		}
		List<Card> clonedCards;
		clonedCards = sortHand(chosenCard);

		return isOnePair(clonedCards.subList(0, 2)) && isThreeOfAKind(clonedCards.subList(2, 5))
				|| isThreeOfAKind(clonedCards.subList(0, 3)) && isOnePair(clonedCards.subList(3, 5));
	}

	private boolean isThreeOfAKind(List<Card> chosenCard) {
		return chosenCard.size() == 3 && chosenCard.stream().map(Card::getRank).distinct().count() == 1;
	}

	private boolean isTwoPair(List<Card> chosenCard) {
		if (chosenCard.size() % 2 != 0 && chosenCard.size() <= 3) {
			return false;
		}
		List<Card> clonedCards;
		clonedCards = sortHand(chosenCard);

		List<Card> clonedCards2 = new ArrayList<>();

		for (int i = 0; i < clonedCards.size(); i++) {
			clonedCards2.add(clonedCards.get(i));
			clonedCards.remove(i);
		}

		for (int i = 0; i < clonedCards.size(); i++) {
			if (clonedCards.get(i).getRank().getOrdinal() != clonedCards2.get(i).getRank().getOrdinal()) {
				return false;
			}
		}

		for (int i = 0; i < clonedCards.size() - 1; i++) {
			if (clonedCards.get(i).getRank().getOrdinal() + 1 != clonedCards.get(i + 1).getRank().getOrdinal()) {
				return false;
			}
		}
		return true;
	}

	public boolean isOnePair(List<Card> chosenCard) {
		return chosenCard.size() == 2 && chosenCard.stream().map(Card::getRank).distinct().count() == 1;
	}

}
