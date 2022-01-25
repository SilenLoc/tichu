package model;



public abstract class SpecialCard extends Card {
	public SpecialCard( Rank rank, int value, int credits ) {
		super( Suit.Special, rank );
		setValue(value);
		setCredits(credits);
	}
}
