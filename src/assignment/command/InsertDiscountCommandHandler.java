package assignment.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import assignment.beans.factory.Discount;
import assignment.connection.ConnectionUtils;

public class InsertDiscountCommandHandler implements ICommandHandler {

	@Override
	public void execute(ICommand command) throws SQLException {

		Discount discount = ((InsertDiscountCommand)command).getDiscount();
		
		String sql = "insert into discount(type, percent) values (?,?)";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, discount.getType());
		pstm.setFloat(2, discount.getPercent());

		pstm.executeUpdate();
		conn.close();
		
	}
	
}
