package assignment.command;

public class DeleteDiscountCommand implements ICommand {

	private int code;
	
	public DeleteDiscountCommand(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}

	public String getCommandName() {
		return "deleteDiscount";
	}
	
}
