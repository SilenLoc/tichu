package model;


public class Dragon extends SpecialCard {
	private final static int VALUE = 56;

	public Dragon() {
		super(Rank.Dragon, VALUE, Rank.getCredit());
	}

	public String toString() {
		return "Dragon";
	}
}
