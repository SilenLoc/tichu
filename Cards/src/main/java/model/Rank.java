package model;


public enum Rank {
	Dog(0), MahJong(0), two(0), three(0), four(0), five(5), six(0), seven(0), eight(0), nine(0), ten(10), Jack(0),
	Queen(0), King(10), Ace(0), Phoenix(-25), Dragon(25);

	private static int credit;

	Rank(int credit) {
		credit = credit;
	};

	public static int getCredit() {
		return credit;
	}

	public String toString() {
		String str = "dragon";

		int ordinal = this.ordinal();
		if (ordinal >= 2 && ordinal <= 10) {
			str = Integer.toString(ordinal);
		} else if (ordinal == 0) {
			str = "dog";
		} else if (ordinal == 1) {
			str = "mahjong";
		} else if (ordinal == 11) {
			str = "jack";
		} else if (ordinal == 12) {
			str = "queen";
		} else if (ordinal == 13) {
			str = "king";
		} else if (ordinal == 14) {
			str = "ace";
		} else if (ordinal == 15) {
			str = "phoenix";
		}
		return str;
	}

	public int getOrdinal() {
		return this.ordinal();
	}
}
