package assignment.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment.beans.Product;
import assignment.utils.DiscountDAO;
import assignment.utils.ProductDAO;

@WebServlet("/listProducts")
public class ListProductsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ListProductsServlet() {
		super();
	}

	//list all the products available at the moment
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Product> products = new ArrayList<Product>();

		try {
			products = ProductDAO.queryProduct();
			for(Product p: products) {
				int code = p.getDiscountId();
				float percent = DiscountDAO.findDiscountByCode(code);
				p.setDiscountId((int)percent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("products", products);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/listProductsView.jsp");

		dispatcher.forward(request, response);
	}

	//apply filter option
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("filter") != null) {

			List<Product> products = new ArrayList<Product>();
			String type = request.getParameter("type");
			try {
				switch(type) {
				case "priceUp": products = ProductDAO.orderedProductsByPrice();
								System.out.println("here");
								break;
				case "priceDown": products = ProductDAO.orderedProductsByPrice();
								  Collections.reverse(products);
								  System.out.println("here");
								  break;
				case "discount": products = ProductDAO.getProductsWithDiscount();
								 System.out.println("here");
								 break;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			for(Product p: products) {
				int code = p.getDiscountId();
				float percent;
				try {
					percent = DiscountDAO.findDiscountByCode(code);
					p.setDiscountId((int)percent);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			request.setAttribute("products", products);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/listProductsView.jsp");

			dispatcher.forward(request, response);
		}

	}

}
