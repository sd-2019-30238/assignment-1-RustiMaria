package assignment.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment.beans.User;
import assignment.utils.AppUtils;

@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public BuyProductServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/buyProduct.jsp");
		User user = AppUtils.getLoggedInUser(request.getSession());
		if(user == null) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginToBuy.jsp");
			dispatcher.forward(request, response);
		}
		System.out.println(user.getUsername());
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
