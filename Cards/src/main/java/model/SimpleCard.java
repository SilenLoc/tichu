package model;


public class SimpleCard extends Card {

	public SimpleCard(Suit suit, Rank rank, int value) {
		super( suit, rank );
		setValue(value);
	}

	public String toString() {
		return this.getSuit().name() + '_' + this.getRank().name();
	}
}
