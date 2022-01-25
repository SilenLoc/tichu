package model;

public enum HandType {
	
	
	HighCard, OnePair, TwoPair, 
	ThreeOfAKind, FullHouse, FiveStreet, 
	SixStreet, SevenStreet, EightStreet, 
	NineStreet, TenStreet, ElevenStreet, 
	TwelveStreet, ThirdteenStreet, FourteenStreet,
	FourOfAKindBomb, FiveBomb, SixBomb, SevenBomb,
	EightBomb, NineBomb, TenBomb, ElevenBomb,
	TwelveBomb, ThirteenBomb, FourteenBomb;
	
	public int getOrdinal() {
		return this.ordinal();
	}
}
