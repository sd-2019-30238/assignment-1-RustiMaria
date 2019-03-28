package assignment.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment.beans.Product;
import assignment.connection.ConnectionUtils;
import assignment.utils.ProductDAO;

@WebServlet("/listProducts")
public class ListProductsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection connection;
	
	public ListProductsServlet() {
		super();
		try {
			connection = ConnectionUtils.getConnection();
		} catch(Exception e) {}
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

List<Product> products = new ArrayList<Product>();
		
		try {
			products = ProductDAO.queryProduct(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("products", products);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/listProductsView.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Product> products = new ArrayList<Product>();
		
		try {
			products = ProductDAO.queryProduct(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("products", products);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/listProductsView.jsp");

		dispatcher.forward(request, response);

	}

}
