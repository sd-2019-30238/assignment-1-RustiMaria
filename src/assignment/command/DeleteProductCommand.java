package assignment.command;

public class DeleteProductCommand implements ICommand {

	private int id;
	
	public DeleteProductCommand(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getCommandName() {
		return "deleteProduct";
	}
	
}
