package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.beans.Product;
import assignment.connection.ConnectionUtils;

public class UpdateProductCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		
		Product product = ((UpdateProductCommand)command).getProduct();
		
		String sql = "update product set name=?, price=?, quantity=?, discountid=? where id=? ";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setInt(3, product.getQuantity());
		pstm.setInt(4, product.getDiscountId());
		pstm.setInt(5, product.getId());
		pstm.executeUpdate();
		
	}
	
}
