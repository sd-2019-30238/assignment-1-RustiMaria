package assignment.decorator;

public class ManyProductsDecorator extends ShoppingCartDecorator {

	private IShoppingCart cart;
	
	public ManyProductsDecorator(IShoppingCart cart) {
		super(cart);
		this.cart = cart;
	}
	
	public float getTotal() {
		float total = cart.getTotal();
		total -= (0.1 * total);
		((ShoppingCart) cart).setColor("Blue");
		return total;
	}
	
}
