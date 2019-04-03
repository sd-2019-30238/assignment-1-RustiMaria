package assignment.beans;

public class Order {

	private int id;
	private int idClient;
	private float total;
	private String status;
	
	public Order() {}

	public Order(int id, int idClient, float total) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.total = total;
		this.status = "placed";
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
	
}
