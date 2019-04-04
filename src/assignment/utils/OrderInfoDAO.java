package assignment.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.beans.OrderInfo;
import assignment.connection.ConnectionUtils;

public class OrderInfoDAO {

	public static void insertOrder(OrderInfo order) throws SQLException {
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

	public static void deleteOrder(OrderInfo order) throws SQLException {
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
