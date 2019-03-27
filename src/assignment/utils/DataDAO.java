package assignment.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignment.beans.Product;
import assignment.beans.User;
import assignment.configuration.SecurityConfiguration;

public class DataDAO {



	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "select p.id, p.name, p.price, p.quantity, p.discountid from product p ";

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

	public static Product findProduct(Connection conn, int id) throws SQLException {
		String sql = "select p.id, p.name, p.price, p.quantity, p.discountid from product p where p.id=?";

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

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "update product set name =?, price=?, quantity=?, discountid=? where id=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setInt(3, product.getQuantity());
		pstm.setInt(3, product.getDiscountId());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "insert into product(id, name, price, quantity, dicountid) values (?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, product.getId());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());
		pstm.setInt(1, product.getQuantity());
		pstm.setInt(1, product.getDiscountId());
		
		pstm.executeUpdate();
	}

	public static void deleteProduct(Connection conn, int id) throws SQLException {
		String sql = "delete from product where id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
	}

}
