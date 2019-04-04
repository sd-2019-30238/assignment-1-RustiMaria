package assignment.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment.beans.Product;
import assignment.connection.ConnectionUtils;
import assignment.utils.DiscountDAO;
import assignment.utils.ProductDAO;

@WebServlet("/tasks")
public class ProductManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductManager() {
		super();
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminTaskView.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;

		if(request.getParameter("addProduct") != null) {
			String name = request.getParameter("productName");
			String priceS = request.getParameter("productPrice");
			String quantityS = request.getParameter("productQuantity");
			String discount = request.getParameter("discount");

			float price = Float.parseFloat(priceS);
			int quantity = Integer.parseInt(quantityS);
			int code = 0;
			try {
				if(!discount.equals("none")){
					code = DiscountDAO.getCodeByType(discount);
				}
				Product product = new Product(name, price, quantity, code);
				ProductDAO.insertProduct(product);

			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}

		if(request.getParameter("updateProduct") != null) {
			String idS = request.getParameter("idProduct");
			String field = request.getParameter("field");
			String newValue = request.getParameter("newValue");

			int id = Integer.parseInt(idS);

			Product product = null;

			try {
				product = ProductDAO.findProduct(id);			
				if(product==null) {
					dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/invalidData.jsp");
				}
				else {
					if(field.equals("name")) {
						product.setName(newValue);
					}
					if(field.equals("price")) {
						float price = Float.parseFloat(newValue);
						product.setPrice(price);
					}
					if(field.equals("quantity")) {
						int quantity = Integer.parseInt(newValue);
						product.setQuantity(quantity);
					}
					if(field.equals("discountId")) {
						int discount = Integer.parseInt(newValue);
						product.setDiscountId(discount);
					}
					ProductDAO.updateProduct(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(request.getParameter("deleteProduct") != null) {
			String idS = request.getParameter("idProduct");

			try {
				int id = Integer.parseInt(idS);
				ProductDAO.deleteProduct(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}

		this.doGet(request, response);
	}

}
