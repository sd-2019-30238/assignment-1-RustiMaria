package assignment.beans.factory;

public class TenPercentDiscount extends Discount {

	private static final String TYPE = "ten";
	private static final float PERCENT = 10;
	
	public TenPercentDiscount() {
		super(TYPE, PERCENT);
	}
	
}
