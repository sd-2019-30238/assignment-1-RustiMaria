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

import assignment.beans.Client;
import assignment.beans.User;
import assignment.connection.ConnectionUtils;
import assignment.utils.AppUtils;
import assignment.utils.ClientDAO;
import assignment.utils.UserDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public RegisterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerView.jsp");
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		Client newClient = new Client(firstName, lastName, address, email);
		User newUser = new User(username, password, "USER");
		
		try {
			UserDAO.insertUser(newUser);
			User user = UserDAO.findUser(newUser.getUsername(), newUser.getPassword());
			newClient.setId(user.getId());
			ClientDAO.insertClient(newClient);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerSuccess.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//AppUtils.storeLogedInUser(request.getSession(), newUser);
	}
	
}
