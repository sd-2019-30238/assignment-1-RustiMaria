package assignment.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assignment.beans.User;
import assignment.configuration.SecurityConfiguration;
import assignment.connection.ConnectionUtils;

public class UserQuery implements IQuery {

	public static User findUser(String username, String password) throws SQLException {

		String sql = "select u.id, u.username from user u " //
				+ " where u.username = ? and u.password= ?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		User user = new User();
		
		if (rs.next()) {
			int id = rs.getInt("id");
			if(!username.equals("admin") && !password.equals("admin")) {
				user = new User(id, username, password, SecurityConfiguration.ROLE_USER);
			}
			else {
				user = new User(id, username, password, SecurityConfiguration.ROLE_ADMIN);
			}
			return user;
		}
		return null;
	}

	public static User findUser(String username) throws SQLException {

		String sql ="select u.id, u.username, u.password from user u " //
				+ " where u.username = ?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			int id = rs.getInt("id");
			String password = rs.getString("password");
			User user = new User(id, username, password, "");
			return user;
		}
		return null;
	}
	
	public static User findUserById(int id) throws SQLException {

		String sql ="select u.username, u.password from user u where u.id = ?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String username = rs.getString("username");
			String password = rs.getString("password");
			User user = new User(id, username, password, "");
			return user;
		}
		return null;
	}
	
}
