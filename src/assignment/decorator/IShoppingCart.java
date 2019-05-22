package assignment.decorator;

import java.util.List;

import assignment.beans.Product;

public interface IShoppingCart {

	public float getTotal();
	public List<Product> getProducts();
	
}
