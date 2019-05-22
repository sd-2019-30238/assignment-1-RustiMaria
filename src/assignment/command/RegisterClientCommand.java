package assignment.command;

import assignment.beans.Client;

public class RegisterClientCommand implements ICommand {

	private Client client;

	public RegisterClientCommand(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
	
	public String getCommandName() {
		return "registerClient";
	}
	
}
