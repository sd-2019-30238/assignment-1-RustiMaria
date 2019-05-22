package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.connection.ConnectionUtils;

public class DeleteOrderCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		
		int id = ((DeleteOrderCommand)command).getId();
		
		String sql = "delete from orders where id=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
		conn.close();
		
	}

}
