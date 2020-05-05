package be.belfius.zoo.domain.enums;

public enum VisitorType {
	ADULT(20),
	RETIRED(10),
	KID(5);
	
	private int price;

	private VisitorType(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

}
