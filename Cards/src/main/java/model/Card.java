package model;

public abstract class Card implements Comparable<Card> {
	private int value;
	private int credits;
	private final Suit suit;
	private final Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	protected int getCredits() {
		return this.rank.getCredit();
	}

	public int getValue() {
		return this.value;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	protected void setValue(int value) {
		this.value = value;
	}

	public int compareTo(Card card) {
		if (suit != Suit.Special) {
			return this.rank.getOrdinal() - card.rank.getOrdinal();
		} else {
			if (this.rank == Rank.Dragon || this.rank == Rank.Phoenix) {
				return 1;
			} else if (card.rank == Rank.Dragon || card.rank == Rank.Phoenix) {
				return -1;
			}
			return 0;
		}
	}
}
