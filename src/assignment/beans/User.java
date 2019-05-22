package assignment.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import assignment.command.ICommand;
import assignment.command.InsertMessageCommand;
import assignment.mediator.Mediator;

public class User implements Observer, Serializable{

	private static final long serialVersionUID = 6715642356876679530L;
	private int id;
	private String username;
	private String password;
	private String role;
	
	private List<Product> products;
	private List<Order> orders;
	
	public User() {}	

	public User(int id, String username, String password, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		products = new ArrayList<Product>();
		orders = new ArrayList<Order>();
	}

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
		products = new ArrayList<Product>();
		orders = new ArrayList<Order>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}

	public List<Order> getOrders(){
		return this.orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public void update(Observable o, Object arg) {
		Message message = new Message(this.id, (String) arg);
		Mediator mediator = new Mediator();
		ICommand command = new InsertMessageCommand(message);
		mediator.mediate(command);
	}
	
}
