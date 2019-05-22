package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.beans.OrderInfo;
import assignment.connection.ConnectionUtils;

public class DeleteOrderInfoCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		
		OrderInfo order = ((InsertOrderInfoCommand)command).getOrderInfo();
		
		String sql = "delete from orderinfo where idOrder=? and idProduct=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, order.getIdOrder());
		pstm.setInt(2, order.getIdProduct());

		pstm.executeUpdate();
		conn.close();
		
	}
	
}
