package assignment.command;

import assignment.beans.Order;

public class InsertOrderCommand implements ICommand {

	private Order order;
	
	public InsertOrderCommand(Order order) {
		this.order = order;
	}
	
	public Order getOrder() {
		return this.order;
	}
	
	public String getCommandName() {
		return "insertOrder";
	}
	
}
