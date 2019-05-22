package assignment.command;

import assignment.beans.OrderInfo;

public class DeleteOrderInfoCommand implements ICommand {

private OrderInfo order;
	
	public DeleteOrderInfoCommand(OrderInfo order) {
		this.order = order;
	}
	
	public OrderInfo getOrderInfo() {
		return this.order;
	}
	
	public String getCommandName() {
		return "deleteOrderInfo";
	}
	
}
