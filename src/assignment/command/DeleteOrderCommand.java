package assignment.command;

public class DeleteOrderCommand implements ICommand {

	private int id;
	
	public DeleteOrderCommand(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getCommandName() {
		return "deleteOrder";
	}
	
}
