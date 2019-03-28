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

@WebServlet("/tasks")
public class ProductManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connection;
	
    public ProductManager() {
        super();
        try {
			connection = ConnectionUtils.getConnection();
		} catch(Exception e) {}
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;
		
		if(request.getParameter("add") != null) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProduct.jsp");
			System.out.println("add");
			String name = request.getParameter("productName");
			System.out.println(name);
		}
		
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
