package model;


public enum Suit {

	Sword, Star, House, Moon, Special;

	public String toString() {
		String suit = "";
		switch (this) {
		case Sword:
			suit = "sword";
			break;
		case Star:
			suit = "star";
			break;
		case House:
			suit = "house";
			break;
		case Moon:
			suit = "moon";
			break;
		case Special:
			suit = "special";
			break;
		}
		return suit;
	}

	public int getOrdinal() {
		return this.ordinal();
	}
}
