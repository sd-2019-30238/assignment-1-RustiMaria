package assignment.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import assignment.beans.Client;
import assignment.beans.User;
import assignment.configuration.SecurityConfiguration;
import assignment.connection.ConnectionUtils;

public class ClientDAO {

	private static final Map<String, User> mapUsers = new HashMap<String, User>();

	static {
		initUsers();
	}

	private static void initUsers() {

		// This user has the role of ADMIN.
		User admin = new User(1, "admin", "admin", SecurityConfiguration.ROLE_ADMIN);

		mapUsers.put(admin.getUsername(), admin);

	}
	
	public static Client findClient(int id) throws SQLException {

		String sql = "select c.firstName, c.lastName, c.address, c.email from client c " 
				+ " where c.id = ?";

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
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String address = rs.getString("address");
			String email = rs.getString("email");
			Client client = new Client(id, firstName, lastName, address, email);
		
			return client;
		}
		return null;
	}

	public static void insertClient(Client client) throws SQLException {

		String sql ="insert into client(id, firstName, lastName, address, email) values (?,?,?,?,?)";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, client.getId());
		pstm.setString(2, client.getFirstName());
		pstm.setString(3, client.getLastName());
		pstm.setString(4, client.getAddress());
		pstm.setString(5, client.getEmail());
		
		pstm.executeUpdate();
			
	}
	
}
