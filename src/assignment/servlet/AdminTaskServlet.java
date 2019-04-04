package assignment.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminTask")
public class AdminTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminTaskServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminTaskView.jsp");

		if(request.getParameter("add") != null) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProduct.jsp");
		}

		if(request.getParameter("update") != null) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateProduct.jsp");
		}

		if(request.getParameter("delete") != null) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/deleteProduct.jsp");
		}

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}
