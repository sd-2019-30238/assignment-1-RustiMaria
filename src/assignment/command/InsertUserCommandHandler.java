package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.beans.User;
import assignment.connection.ConnectionUtils;

public class InsertUserCommandHandler implements ICommandHandler {

	public void execute(ICommand command) throws SQLException {
		
		User user = ((InsertUserCommand)command).getUser();
		String sql ="insert into user(username, password, role) values (?,?,\"USER\")";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPassword());

		pstm.executeUpdate();
	}
	
}
