package assignment.beans;

public class OrderInfo {

	private int idOrder;
	private int idProduct;
	private int quantity;
	
	public OrderInfo() {}

	public OrderInfo(int idOrder, int idProduct, int quantity) {
		super();
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.quantity = quantity;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
