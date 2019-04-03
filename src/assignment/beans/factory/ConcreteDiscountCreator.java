package assignment.beans.factory;

public class ConcreteDiscountCreator extends DiscountCreator {

	@Override
	public Discount createDiscount(String type) {
		
		switch(type) {
		case "season": return new SeasonDiscount();
		case "holiday": return new HolidayDiscount();
		case "percent": return new TenPercentDiscount();
		default: return null;
		}
		
	}
}
