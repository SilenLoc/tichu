package model;



public class MahJong extends SpecialCard {
	private int wishNumber;
	private final static int VALUE = 53;

	public MahJong() {
		super(Rank.MahJong, VALUE, Rank.getCredit());
	}

	public int getWishNumber() {
		return wishNumber;
	}

	public void setWishNumber(int wishNumber) {
		this.wishNumber = wishNumber;
	}

	public String toString() {
		return "Mahjong";
	}

	public boolean equals(Card c) {
		return false;
	}
}
