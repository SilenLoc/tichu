package model;



public class Phoenix extends SpecialCard{
	private final static int VALUE = 55;
	private Rank aquiredCard;
	
	public Phoenix() {
		super(Rank.Phoenix, VALUE,  Rank.getCredit());
	}
	
	public void setAquiredCard (Rank rank) {
		this.aquiredCard = rank;
	}
	
	public String toString() {
		return "Phoenix";
	}
}
