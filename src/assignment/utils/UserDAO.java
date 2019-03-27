package assignment.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import assignment.beans.User;
import assignment.configuration.SecurityConfiguration;

public class UserDAO {

	public static User findUser(Connection conn, String username, String password) throws SQLException {

		String sql = "select u.id, u.username from user u " //
				+ " where u.username = ? and u.password= ?";

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

	public static User findUser(Connection conn, String username) throws SQLException {

		String sql ="select u.id, u.username, u.password from user u " //
				+ " where u.username = ?";

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
	
	public static void insertUser(Connection conn, User user) throws SQLException {

		String sql ="insert into user(username, password, role) values (?,?,\"USER\")";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPassword());

		pstm.executeUpdate();

	}
	
}
