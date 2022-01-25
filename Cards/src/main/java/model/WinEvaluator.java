package model;

import java.util.ArrayList;



public class WinEvaluator {
	private final HandTypeEvaluator hTE;


	private ArrayList<Card> lastCards = new ArrayList<>();
	private Thread t;

	public WinEvaluator() {
		this.hTE = new HandTypeEvaluator();

	}

	public boolean tieWinner(ArrayList<Card> choosenCards) {
		if (choosenCards.isEmpty() || hTE.evaluateHand(choosenCards) == null) {
			return false;
		} else {
			if (this.lastCards.isEmpty()) {
				return true;
			} else {
				HandTypeEvaluator handTypeEvaluator = new HandTypeEvaluator();

				// chosen cards get cloned and sorted
				ArrayList<Card> clonedCards = new ArrayList<>(choosenCards);

				clonedCards = handTypeEvaluator.sortHand(choosenCards);
				Card lastHandCard = lastCards.get(lastCards.size() - 1);
				Card myLastCard = clonedCards.get(clonedCards.size() - 1);

				if (lastHandCard.getRank() == Rank.Dog) {
					return true;
				}
				HandType lastHandType = handTypeEvaluator.evaluateHand((ArrayList<Card>) lastCards);
				HandType myHandType = handTypeEvaluator.evaluateHand((ArrayList<Card>) clonedCards);

				if (myHandType == null) {
					return false;
				}

				if (myHandType.getOrdinal() == lastHandType.getOrdinal()) {
					switch (myHandType) {
						case HighCard:
							if (myLastCard.getRank().getOrdinal() > lastHandCard.getRank().getOrdinal()) {
								return true;
								// Dragon is included, because its Rank is the highest
							} else if (myLastCard.getRank() == Rank.Dog) {
								return false;
							} else if (myLastCard.getRank() == Rank.MahJong) {
								return false;
							}
							break;
						case TwoPair:
							if (clonedCards.size() == lastCards.size()
									&& myLastCard.getRank().getOrdinal() > lastHandCard.getRank().getOrdinal()) {
								return true;
							}
							break;
						case FullHouse:
							Card lastHandTypeMiddleCard = lastCards.get(2);
							Card myHandTypeMiddleCard = clonedCards.get(2);
							if (myHandTypeMiddleCard.getRank().getOrdinal() > lastHandTypeMiddleCard.getRank()
																																											.getOrdinal()) {
								return true;
							}
							break;
						default:
							if (myLastCard.getRank().getOrdinal() > lastHandCard.getRank().getOrdinal()) {
								return true;
							}
							break;
					}
				}

				if (myHandType.getOrdinal() <= 14) {
					return false;
				} else if (myHandType == HandType.FourOfAKindBomb) {
					if (lastHandType.getOrdinal() < 15) {
						return true;
					} else {
						return false;
					}
				} else if (clonedCards.size() > lastCards.size()) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * @author Silen
	 */

	public void setLastHandCards(ArrayList<Card> lastHandCards) {

		this.lastCards = lastHandCards;
		this.hTE.sortHand(lastHandCards);
	}


}






