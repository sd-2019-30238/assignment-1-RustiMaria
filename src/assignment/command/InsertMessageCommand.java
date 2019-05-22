package assignment.command;

import assignment.beans.Message;

public class InsertMessageCommand implements ICommand {

	private Message message;
	
	public InsertMessageCommand(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return this.message;
	}
	
	public String getCommandName() {
		return "insertMessage";
	}
	
}
