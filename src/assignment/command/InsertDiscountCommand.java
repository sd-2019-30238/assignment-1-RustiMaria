package assignment.command;

import assignment.beans.factory.Discount;

public class InsertDiscountCommand implements ICommand {

	private Discount discount;
	
	public InsertDiscountCommand(Discount discount) {
		this.discount = discount;
	}
	
	public Discount getDiscount() {
		return this.discount;
	}
	
	public String getCommandName() {
		return "insertDiscount";
	}
	
}
