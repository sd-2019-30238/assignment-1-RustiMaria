package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.beans.Order;
import assignment.connection.ConnectionUtils;

public class InsertOrderCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		
		Order order = ((InsertOrderCommand)command).getOrder();
		
		String sql = "insert into orders(idClient, total, orderStatus) values (?,?,?)";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, order.getIdClient());
		pstm.setFloat(2, order.getTotal());
		pstm.setString(3, order.getStatus());

		pstm.executeUpdate();
		conn.close();
		
	}

}
