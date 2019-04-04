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

import assignment.beans.Order;
import assignment.beans.OrderInfo;
import assignment.beans.Product;
import assignment.beans.User;
import assignment.utils.AppUtils;
import assignment.utils.OrderDAO;
import assignment.utils.OrderInfoDAO;

@WebServlet("/order")
public class CheckOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckOrderServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher;
		User user = AppUtils.getLoggedInUser(request.getSession());
		try {
			List<Product> products = user.getProducts();
			float total = 0;
			for(Product p: products) {
				total += p.getPrice();
			}
			Order order = new Order(user.getId(), total);
			OrderDAO.insertOrder(order);
			Order o = OrderDAO.findOrderByTotal(total);
			for(Product p: products) {
				OrderInfo info = new OrderInfo(o.getId(), p.getId(), 1);
				OrderInfoDAO.insertOrder(info);
			}
			products.clear();
			user.setProducts(products);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/orderSuccess.jsp");
		dispatcher.forward(request, response);
	}

}
