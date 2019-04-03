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
import assignment.utils.AppUtils;
import assignment.utils.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User userAccount = null;
		try {
			System.out.println("1");
			userAccount = UserDAO.findUser(username, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (userAccount == null) {
			String errorMessage = "Invalid username or password";
			request.setAttribute("errorMessage", errorMessage);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/failedLogin.jsp");

			dispatcher.forward(request, response);
			return;
		}

		AppUtils.storeLoggedInUser(request.getSession(), userAccount);

		int redirectId = -1;
		try {
			redirectId = Integer.parseInt(request.getParameter("redirectId"));
		} catch (Exception e) {
		}
		String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
		if (requestUri != null) {
			response.sendRedirect(requestUri);
		} else {
			// Default after successful login
			// redirect to /userInfo page
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}

	}

}
