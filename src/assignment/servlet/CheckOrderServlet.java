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
import assignment.beans.OrderInfo;
import assignment.beans.Product;
import assignment.beans.User;
import assignment.command.ICommand;
import assignment.command.InsertOrderCommand;
import assignment.command.InsertOrderInfoCommand;
import assignment.decorator.IShoppingCart;
import assignment.decorator.ManyProductsDecorator;
import assignment.decorator.ShoppingCart;
import assignment.mediator.IMediator;
import assignment.mediator.Mediator;
import assignment.query.OrderQuery;
import assignment.utils.AppUtils;

@WebServlet("/order")
public class CheckOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMediator mediator = new Mediator();

    public CheckOrderServlet() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

    //finalize the order and store it in the database
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		User user = AppUtils.getLoggedInUser(request.getSession());
		boolean decoratorApplied = false;
		
		try {
			List<Product> products = user.getProducts();
			float total = 0;
			for(Product p: products) {
				total += p.getPrice();
			}
			
			if(products.size() >= 3) {
				IShoppingCart cart = new ShoppingCart(products);
				IShoppingCart newCart = new ManyProductsDecorator(cart);
				total = newCart.getTotal();
				decoratorApplied = true;
			}
			
			Order order = new Order(user.getId(), total);
			ICommand command = new InsertOrderCommand(order);
			mediator.mediate(command);
			Order o = OrderQuery.findOrderByTotal(total);
			//System.out.println("Registered");
			for(Product p: products) {
				OrderInfo info = new OrderInfo(o.getId(), p.getId(), 1);
				ICommand command1 = new InsertOrderInfoCommand(info);
				mediator.mediate(command1);
			}
			
			products.clear();
			user.setProducts(products);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(decoratorApplied == false) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/orderSuccess.jsp");
		}
		else {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/manyProductsDecorated.jsp");
		}
		
		dispatcher.forward(request, response);
	}

}
