package assignment.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.beans.factory.Discount;
import assignment.connection.ConnectionUtils;

public class DiscountDAO {

	public static List<Discount> queryDiscount() throws SQLException {
		String sql = "select d.code, d.type, d.percent from discount d ";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Discount> list = new ArrayList<Discount>();
		while (rs.next()) {
			int code = rs.getInt("code");
			String type = rs.getString("type");
			float percent = rs.getFloat("percent");
			Discount discount = new Discount(code,type,percent);
			list.add(discount);
		}
		conn.close();
		return list;
	}

	public static int getCodeByType(String type) throws SQLException {
		String sql = "select d.code from discount d where d.type=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, type);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("code");		
			return id;
		}
		conn.close();
		return -1;
	}

	public static void insertDiscount(Discount discount) throws SQLException {
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

	public static void deleteDiscount(int code) throws SQLException {
		String sql = "delete from discount where code=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, code);

		pstm.executeUpdate();
		conn.close();
	}

	public static float findDiscountByCode(int code) throws SQLException {
		String sql = "select * from discount where code=?";

		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, code);

		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Float percent = rs.getFloat("percent");		
			return percent;
		}
		conn.close();
		return -1;
	}
	
}
