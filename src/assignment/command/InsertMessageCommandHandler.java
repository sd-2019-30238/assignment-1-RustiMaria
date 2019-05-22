package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.beans.Message;
import assignment.connection.ConnectionUtils;

public class InsertMessageCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		
		Message message = ((InsertMessageCommand)command).getMessage();
		
		String sql = "insert into message(userId, message) values (?,?)";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, message.getUserId());
		pstm.setString(2, message.getMessage());
		
		pstm.executeUpdate();
		
	}

}
