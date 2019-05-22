package assignment.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.beans.Product;
import assignment.connection.ConnectionUtils;

public class ProductQuery implements IQuery {

	public static List<Product> queryProduct() throws SQLException {
		String sql = "select p.id, p.name, p.price, p.quantity, p.discountid from product p ";
		
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			int quantity = rs.getInt("quantity");
			int discountId = rs.getInt("discountid");
			Product product = new Product(id, name, price, quantity, discountId);
			list.add(product);
		}
		return list;
	}

	public static List<Product> orderedProductsByPrice() throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "select p.id, p.name, p.price, p.quantity, p.discountid from product p order by p.price ";
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			int quantity = rs.getInt("quantity");
			int discountId = rs.getInt("discountid");
			Product product = new Product(id, name, price, quantity, discountId);
			list.add(product);
		}
		return list;
	}
	
	public static List<Product> getProductsWithDiscount() throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "select p.id, p.name, p.price, p.quantity, p.discountid from product p where p.discountid <> 0 ";
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			int quantity = rs.getInt("quantity");
			int discountId = rs.getInt("discountid");
			Product product = new Product(id, name, price, quantity, discountId);
			list.add(product);
		}
		return list;
	}
	
	public static Product findProduct(int id) throws SQLException {
		String sql = "select p.id, p.name, p.price, p.quantity, p.discountid from product p where p.id=?";

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
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			int quantity = rs.getInt("quantity");
			int discountId = rs.getInt("discountid");
			Product product = new Product(id, name, price, quantity, discountId);
			return product;
		}
		return null;
	}
	
	public static Product findProductByName(String name) throws SQLException {
		String sql = "select p.id, p.price, p.quantity, p.discountid from product p where p.name=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, name);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			float price = rs.getFloat("price");
			int quantity = rs.getInt("quantity");
			int discountId = rs.getInt("discountid");
			Product product = new Product(id, name, price, quantity, discountId);
			return product;
		}
		return null;
	}
	
}
