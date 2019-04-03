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

import assignment.beans.User;
import assignment.connection.ConnectionUtils;
import assignment.utils.UserDAO;

@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AdminLoginServlet() {
		super();
	}	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminLoginView.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User userAccount = null;
		try {
			userAccount = UserDAO.findUser(username, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (userAccount == null || userAccount.getRole().equals("USER")) {
			String errorMessage = "Invalid admin credentials";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/accessDeniedView.jsp");

			dispatcher.forward(request, response);
			return;
		}

		assignment.utils.AppUtils.storeLoggedInUser(request.getSession(), userAccount);

		response.sendRedirect(request.getContextPath() + "/adminTask");

	}
}
