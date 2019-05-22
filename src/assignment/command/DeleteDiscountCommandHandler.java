package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.connection.ConnectionUtils;

public class DeleteDiscountCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		
		int code = ((DeleteDiscountCommand)command).getCode();
		
		String sql = "delete from discount where code=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, code);

		pstm.executeUpdate();
		conn.close();
		
	}
	
}
