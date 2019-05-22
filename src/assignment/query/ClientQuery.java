package assignment.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assignment.beans.Client;
import assignment.connection.ConnectionUtils;

public class ClientQuery implements IQuery {
	
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

	
}
