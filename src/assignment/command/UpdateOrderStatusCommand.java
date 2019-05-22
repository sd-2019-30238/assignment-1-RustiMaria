package assignment.command;

public class UpdateOrderStatusCommand implements ICommand {

	private int id;
	private String status;

	public UpdateOrderStatusCommand(int id, String status) {
		this.id = id;
		this.status = status;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public String getCommandName() {
		return "updateOrderStatus";
	}
	
}
