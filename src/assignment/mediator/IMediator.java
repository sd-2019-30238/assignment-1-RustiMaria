package assignment.mediator;

import assignment.command.ICommand;
import assignment.command.ICommandHandler;

public interface IMediator {

	public void mediate(ICommand command);
	
	public void addHandler(ICommandHandler handler);
}
