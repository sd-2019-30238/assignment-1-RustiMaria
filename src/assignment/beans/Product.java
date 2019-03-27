package assignment.beans;

public class Product {

	private int id;
	private String name;
	private float price;
	private int quantity;
	private int discountId;
	
	public Product(int id, String name, float price, int quantity, int discount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.discountId = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	
}
