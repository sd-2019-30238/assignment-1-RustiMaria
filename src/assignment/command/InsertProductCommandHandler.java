package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.beans.Product;
import assignment.connection.ConnectionUtils;

public class InsertProductCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {
		
		Product product = ((InsertProductCommand)command).getProduct();
		
		String sql = "insert into product(id, name, price, quantity, discountid) values (?,?,?,?,?)";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, product.getId());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());
		pstm.setInt(4, product.getQuantity());
		pstm.setInt(5, product.getDiscountId());
		
		pstm.executeUpdate();
	
	}
	
}
