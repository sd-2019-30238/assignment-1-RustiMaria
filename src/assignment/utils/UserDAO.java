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

	private static final Map<String, User> mapUsers = new HashMap<String, User>();

	static {
		initUsers();
	}

	private static void initUsers() {

		// This user has a role as ADMIN.
		User admin = new User(1, "admin", "admin", "", "", "", SecurityConfiguration.ROLE_ADMIN);

		mapUsers.put(admin.getUsername(), admin);

	}

	public static User findUser(Connection conn, String username, String password) throws SQLException {

		String sql = "select u.id, u.username, u.email, u.address, u.phone from user u " //
				+ " where u.username = ? and u.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			int id = rs.getInt("id");
			String email = rs.getString("email");
			String address = rs.getString("address");
			String phone = rs.getString("phone");
			User user = new User(id, username, password, email, address, phone, "");
			return user;
		}
		return null;
	}

	public static User findUser(Connection conn, String username) throws SQLException {

		String sql ="select u.id, u.username, u.password, u.email, u.address, u.phone from user u " //
				+ " where u.username = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			int id = rs.getInt("id");
			String email = rs.getString("email");
			String address = rs.getString("address");
			String password = rs.getString("password");
			String phone = rs.getString("phone");
			User user = new User(id, username, password, email, address, phone, "");
			return user;
		}
		return null;
	}
	
	public static void insertUser(Connection conn, User user) throws SQLException {

		String sql ="insert into user(id, username, password, email, address, phone, role) values (?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, user.getId());
		pstm.setString(2, user.getUsername());
		pstm.setString(3, user.getPassword());
		pstm.setString(4, user.getEmail());
		pstm.setString(5, user.getAddress());
		pstm.setString(6, user.getPhone());
		pstm.setString(7, user.getRole());

		pstm.executeQuery();

	}
	
}
