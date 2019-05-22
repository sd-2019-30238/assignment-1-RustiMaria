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
import assignment.query.MessageQuery;
import assignment.utils.AppUtils;

@WebServlet("/messages")
public class Messages extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Messages() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response); 

	}

	//list the messages for the current logged in user
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/messages.jsp");

		User user = AppUtils.getLoggedInUser(request.getSession());
		if(user == null) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginToBuy.jsp");
			dispatcher.forward(request, response);
		}

		List<String> messages = null;
		try {
			messages = MessageQuery.queryMessages(user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("messages", messages);
		
		dispatcher.forward(request, response);
	}

	
}
