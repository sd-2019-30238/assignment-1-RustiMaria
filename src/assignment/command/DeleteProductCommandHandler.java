package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.connection.ConnectionUtils;

public class DeleteProductCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		
		int id = ((DeleteProductCommand)command).getId();
		
		String sql = "delete from product where id=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
		
	}
	
}
