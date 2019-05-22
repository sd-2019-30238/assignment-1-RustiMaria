package assignment.command;

import assignment.beans.OrderInfo;

public class InsertOrderInfoCommand implements ICommand {

	private OrderInfo order;
	
	public InsertOrderInfoCommand(OrderInfo order) {
		this.order = order;
	}
	
	public OrderInfo getOrderInfo() {
		return this.order;
	}
	
	public String getCommandName() {
		return "insertOrderInfo";
	}
	
}