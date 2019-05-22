package assignment.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment.beans.Product;
import assignment.beans.User;
import assignment.query.DiscountQuery;
import assignment.query.ProductQuery;
import assignment.utils.AppUtils;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = AppUtils.getLoggedInUser(request.getSession());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/cart.jsp");
		if(user == null) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginToBuy.jsp");
			dispatcher.forward(request, response);
		}
		List<Product> cart = user.getProducts();
		request.setAttribute("cart",cart);
		dispatcher.forward(request, response);
		this.doPost(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String idS = request.getParameter("id");
	int id = Integer.parseInt(idS);
	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/cart.jsp");
	User user = AppUtils.getLoggedInUser(request.getSession());
	
	if(user == null) {
		dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginToBuy.jsp");
		dispatcher.forward(request, response);
	}
	//store the products the logged in user puts in the shopping cart
	try {
		Product p = ProductQuery.findProduct(id);
		int discountId = p.getDiscountId();
		float discount = DiscountQuery.findDiscountByCode(discountId);
		discount /= 100;
		float price = p.getPrice();
		float finalPrice = price - discount * price;
		p.setPrice(finalPrice);
		
		List<Product> cart = user.getProducts();
		cart.add(p);
		user.setProducts(cart);
		request.setAttribute("cart",cart);
		dispatcher.forward(request, response);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}
