package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.beans.OrderInfo;
import assignment.connection.ConnectionUtils;

public class InsertOrderInfoCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		
		OrderInfo order = ((InsertOrderInfoCommand)command).getOrderInfo();
		
		String sql = "insert into orderinfo(idOrder, idProduct, quantity) values (?,?,?)";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, order.getIdOrder());
		pstm.setFloat(2, order.getIdProduct());
		pstm.setInt(3, order.getQuantity());

		pstm.executeUpdate();
		conn.close();
		
	}
	
}
