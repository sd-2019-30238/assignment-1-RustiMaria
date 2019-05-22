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
import assignment.beans.User;
import assignment.query.OrderQuery;
import assignment.utils.AppUtils;

@WebServlet("/orderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderHistory() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response); 

	}

	//list the orders for the current logged in user
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/orderHistory.jsp");

		User user = AppUtils.getLoggedInUser(request.getSession());
		if(user == null) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginToBuy.jsp");
			dispatcher.forward(request, response);
		}

		try {
			List<Order> orders = OrderQuery.queryOrdersByClientId(user.getId());
			request.setAttribute("orders", orders);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
	}

}
