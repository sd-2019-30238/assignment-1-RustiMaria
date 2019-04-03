package assignment.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.beans.Product;
import assignment.connection.ConnectionUtils;

public class ProductDAO {

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

	public static void updateProduct(Product product) throws SQLException {
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

	public static void insertProduct(Product product) throws SQLException {
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

	public static void deleteProduct(int id) throws SQLException {
		String sql = "delete from product where id=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
	}
	
}
