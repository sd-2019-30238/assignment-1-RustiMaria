package assignment.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment.beans.Order;
import assignment.beans.Product;
import assignment.beans.User;
import assignment.command.DeleteProductCommand;
import assignment.command.ICommand;
import assignment.command.InsertProductCommand;
import assignment.command.UpdateOrderStatusCommand;
import assignment.command.UpdateProductCommand;
import assignment.mediator.Mediator;
import assignment.query.DiscountQuery;
import assignment.query.OrderQuery;
import assignment.query.ProductQuery;
import assignment.query.UserQuery;

@WebServlet("/tasks")
public class ProductManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Mediator mediator = new Mediator();

	public ProductManager() {
		super();
	}	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminTaskView.jsp");
		dispatcher.forward(request, response);

	}

	//implement the tasks available for admin
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("addProduct") != null) {
			String name = request.getParameter("productName");
			String priceS = request.getParameter("productPrice");
			String quantityS = request.getParameter("productQuantity");
			String discount = request.getParameter("discount");

			float price = Float.parseFloat(priceS);
			int quantity = Integer.parseInt(quantityS);
			int code = 0;
			try {
				if(!discount.equals("none")){
					code = DiscountQuery.getCodeByType(discount);
				}
				Product product = new Product(name, price, quantity, code);
				ICommand command = new InsertProductCommand(product);	
				mediator.mediate(command);

			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}

		if(request.getParameter("updateProduct") != null) {
			String idS = request.getParameter("idProduct");
			String field = request.getParameter("field");
			String newValue = request.getParameter("newValue");

			int id = Integer.parseInt(idS);

			Product product = null;

			try {
				product = ProductQuery.findProduct(id);			
				if(product==null) {
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/invalidData.jsp");
					dispatcher.forward(request, response);
				}
				else {
					if(field.equals("name")) {
						product.setName(newValue);
					}
					if(field.equals("price")) {
						float price = Float.parseFloat(newValue);
						product.setPrice(price);
					}
					if(field.equals("quantity")) {
						int quantity = Integer.parseInt(newValue);
						product.setQuantity(quantity);
					}
					if(field.equals("discountId")) {
						int discount = Integer.parseInt(newValue);
						product.setDiscountId(discount);
					}
					ICommand command1 = new UpdateProductCommand(product);
					mediator.mediate(command1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(request.getParameter("deleteProduct") != null) {
			String idS = request.getParameter("idProduct");

			try {
				int id = Integer.parseInt(idS);
				ICommand command2 = new DeleteProductCommand(id);
				mediator.mediate(command2);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		if(request.getParameter("orderStatus") != null) {
			String idS = request.getParameter("idOrder");
			String status = request.getParameter("status");
			try {
				int id = Integer.parseInt(idS);	
				Order order = OrderQuery.findOrderById(id);
				int clientId = order.getIdClient();
				User user = UserQuery.findUserById(clientId);
				user.addOrder(order);
				order.registerObserver(user);
				order.setStatus(status);
				ICommand command3 = new UpdateOrderStatusCommand(id, status);
				mediator.mediate(command3);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}

		this.doGet(request, response);
	}

}
