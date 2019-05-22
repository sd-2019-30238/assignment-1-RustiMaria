package assignment.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.beans.Message;
import assignment.beans.Product;
import assignment.connection.ConnectionUtils;

public class MessageDAO {

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
	
	public static void insertMessage(Message message) throws SQLException {
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
