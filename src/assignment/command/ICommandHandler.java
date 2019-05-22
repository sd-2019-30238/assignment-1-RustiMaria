package assignment.command;

import java.sql.SQLException;

public interface ICommandHandler {

	public void execute(ICommand command) throws SQLException;
	
}
