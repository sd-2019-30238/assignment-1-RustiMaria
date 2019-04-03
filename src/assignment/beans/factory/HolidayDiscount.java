package assignment.beans.factory;

public class HolidayDiscount extends Discount {

	private static final String TYPE = "holiday";
	private static final float PERCENT = 15;
	
	public HolidayDiscount() {
		super(TYPE, PERCENT);
	}
	
}
