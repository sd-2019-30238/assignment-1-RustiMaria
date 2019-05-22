package assignment.command;

import assignment.beans.User;

public class InsertUserCommand implements ICommand {

	private User user;
	
	public InsertUserCommand(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public String getCommandName() {
		return "insertUser";
	}
	
}
