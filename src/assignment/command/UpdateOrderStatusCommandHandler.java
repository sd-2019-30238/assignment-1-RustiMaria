package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.connection.ConnectionUtils;

public class UpdateOrderStatusCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		int id = ((UpdateOrderStatusCommand)command).getId();
		String status = ((UpdateOrderStatusCommand)command).getStatus();
		
		String sql = "update orders set orderStatus=? where id=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, status);
		pstm.setInt(2, id);

		pstm.executeUpdate();
		conn.close();
	}
	
}
