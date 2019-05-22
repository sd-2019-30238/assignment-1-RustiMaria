package assignment.mediator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignment.command.ICommand;
import assignment.command.*;

public class Mediator implements IMediator {

	private List<ICommandHandler> handlers;
	private Map<String, ICommandHandler> ch;
	
	public Mediator() {
		handlers = new ArrayList<ICommandHandler>();
		ch = new HashMap<String, ICommandHandler>();
		ch.put("registerClient", new RegisterClientCommandHandler());
		ch.put("insertUser", new InsertUserCommandHandler());
		ch.put("insertDiscount", new InsertDiscountCommandHandler());
		ch.put("deleteDiscount", new DeleteDiscountCommandHandler());
		ch.put("insertMessage", new InsertMessageCommandHandler());
		ch.put("insertOrder", new InsertOrderCommandHandler());
		ch.put("deleteOrder", new DeleteOrderCommandHandler());
		ch.put("updateOrderStatus", new UpdateOrderStatusCommandHandler());
		ch.put("insertOrderInfo", new InsertOrderInfoCommandHandler());
		ch.put("deleteOrderInfo", new DeleteOrderInfoCommandHandler());
		ch.put("insertProduct", new InsertProductCommandHandler());
		ch.put("deleteProduct", new DeleteProductCommandHandler());
		ch.put("updateProduct", new UpdateProductCommandHandler());
	}
	
	@Override
	public void addHandler(ICommandHandler handler) {
		handlers.add(handler);
	}	
	
	@Override
	public void mediate(ICommand command) {
		ICommandHandler handler = ch.get(command.getCommandName());
		try {
			handler.execute(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
