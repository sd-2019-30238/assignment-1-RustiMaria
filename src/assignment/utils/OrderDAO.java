package assignment.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.beans.Order;
import assignment.connection.ConnectionUtils;

public class OrderDAO {

	public static List<Order> queryOrdersByClientId(int id) throws SQLException {
		String sql = "select o.id, o.total, o.orderStatus from orders o where o.idClient=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		List<Order> list = new ArrayList<Order>();
		while (rs.next()) {
			int idOrder = rs.getInt("id");
			float total = rs.getFloat("total");
			String status = rs.getString("orderStatus");
			Order order = new Order(idOrder, id, total, status);
			list.add(order);
		}
		conn.close();
		return list;
	}

	public static void insertOrder(Order order) throws SQLException {
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

	public static void deleteOrder(int id) throws SQLException {
		String sql = "delete from orders where id=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
		conn.close();
	}

	public static Order findOrderByClientId(int idClient) throws SQLException {
		String sql = "select id, total, orderStatus from orders where idClient=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, idClient);

		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			Float total = rs.getFloat("total");
			String status = rs.getString("orderStatus");
			return new Order(id, idClient, total, status);
		}
		conn.close();
		return null;
	}
	
	public static Order findOrderById(int id) throws SQLException {
		String sql = "select idClient, total, orderStatus from orders where id=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int idClient = rs.getInt("idClient");
			Float total = rs.getFloat("total");
			String status = rs.getString("orderStatus");
			return new Order(id, idClient, total, status);
		}
		conn.close();
		return null;
	}
	
	public static Order findOrderByTotal(float total) throws SQLException {
		String sql = "select id, idClient, orderStatus from orders where total < ? + 0.01 and total > ? - 0.01";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setFloat(1, total);
		pstm.setFloat(2, total);

		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			int idClient = rs.getInt("idClient");
			String status = rs.getString("orderStatus");
			return new Order(id, idClient, total, status);
		}
		conn.close();
		return null;
	}
	
	public static void updateStatus(int id, String status) throws SQLException {
		String sql = "update orders set orderStatus=? where id=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, status);
		pstm.setInt(2, id);

		pstm.executeUpdate();
		conn.close();
	}
	
}
