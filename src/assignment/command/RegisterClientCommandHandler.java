package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.beans.Client;
import assignment.connection.ConnectionUtils;

public class RegisterClientCommandHandler implements ICommandHandler {

	public void execute(ICommand command) throws SQLException {

		Client client = ((RegisterClientCommand)command).getClient();
		
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
