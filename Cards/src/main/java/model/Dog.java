package model;


public class Dog extends SpecialCard {
	private final static int VALUE = 54;

	public Dog() {
		super(Rank.Dog, VALUE, Rank.getCredit());
	}

	public String toString() {
		return "Dog";
	}

}
