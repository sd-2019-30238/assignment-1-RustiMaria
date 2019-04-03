package assignment.beans.factory;

public class SeasonDiscount extends Discount {

	private static final String TYPE = "season";
	private static final float PERCENT = 23;
	
	public SeasonDiscount() {
		super(TYPE, PERCENT);
	}
	
}
