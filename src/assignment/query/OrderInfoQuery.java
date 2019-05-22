package assignment.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.connection.ConnectionUtils;

public class OrderInfoQuery implements IQuery {

	public static List<Integer> findProducts(int idOrder) throws SQLException {
		String sql = "select idProduct from orderinfo where idOrder=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, idOrder);

		ResultSet rs = pstm.executeQuery();
		List<Integer> products = new ArrayList<Integer>();
		while (rs.next()) {
			int id = rs.getInt("idProduct");
			products.add(id);
		}
		conn.close();
		return products;
	}
	
}
