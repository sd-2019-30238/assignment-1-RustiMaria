package assignment.decorator;

import java.util.List;

import assignment.beans.Product;

public abstract class ShoppingCartDecorator implements IShoppingCart {

	private IShoppingCart cart;
	
	public ShoppingCartDecorator(IShoppingCart cart) {
		this.cart = cart;
	}
	
	public List<Product> getProducts(){
		return cart.getProducts();
	}
	
	public float getTotal() {
		return cart.getTotal();
	}
	
}
