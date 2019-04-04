package assignment.beans;

public class Order {

	private int id;
	private int idClient;
	private float total;
	private String orderStatus;
	
	public Order() {}

	public Order(int id, int idClient, float total) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.total = total;
		this.orderStatus = "placed";
	}

	public Order(int id, int idClient, float total, String status) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.total = total;
		this.orderStatus = status;
	}
	
	public Order(int idClient, float total) {
		super();
		this.idClient = idClient;
		this.total = total;
		this.orderStatus = "placed";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getStatus() {
		return orderStatus;
	}

	public void setStatus(String status) {
		this.orderStatus = status;
	}
	
}
