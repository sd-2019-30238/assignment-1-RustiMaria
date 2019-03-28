package assignment.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment.connection.ConnectionUtils;

@WebServlet("/tasks1")
public class ProductManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connection;
	
    public ProductManagement() {
        super();
        try {
			connection = ConnectionUtils.getConnection();
		} catch(Exception e) {}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = null;
		
		if(request.getParameter("add") != null) {
			System.out.println("add");
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProduct.jsp");
		}
		
		if(request.getParameter("update") != null) {
			System.out.println("update");
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateProduct.jsp");
		}
		
		System.out.println("none");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
