package assignment.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.connection.ConnectionUtils;

public class MessageQuery implements IQuery {

	public static List<String> queryMessages(int userId) throws SQLException {
		String sql = "select m.id, m.message from message m where userId = ?";
		
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, userId);

		ResultSet rs = pstm.executeQuery();
		List<String> messages = new ArrayList<String>();
		while (rs.next()) {
			String message = rs.getString("message");
			messages.add(message);
		}
		return messages;
	}
	
}
