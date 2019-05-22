package assignment.decorator;

import java.util.List;

import assignment.beans.Product;

public class ShoppingCart implements IShoppingCart{

	private List<Product> products;
	private String color;
	
	public ShoppingCart(List<Product> products) {
		this.products = products;
	}
	
	public List<Product> getProducts(){
		return this.products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public float getTotal() {
		float total = 0.0f;
		for(Product p: products) {
			total += p.getPrice();
		}
		return total;
	}
	
}
