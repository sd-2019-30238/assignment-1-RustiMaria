package assignment.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Order extends Observable implements Serializable {

	private static final long serialVersionUID = 5693763666054318643L;
	
	private int id;
	private int idClient;
	private float total;
	private String status;
	private List<Observer> observers = new ArrayList<Observer>();
	
	public Order() {}

	public Order(int id, int idClient, float total) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.total = total;
		this.status = "placed";
	}

	public Order(int id, int idClient, float total, String status) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.total = total;
		this.status = status;
	}
	
	public Order(int idClient, float total) {
		super();
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String orderStatus) {
		this.notifyObservers("The status for order with id  " + this.id + " changed from " + this.status + " to " + orderStatus + " on " + LocalDate.now() + " at " + LocalTime.now());
		this.status = orderStatus;
	}

	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}
	
	public void registerObserver(Observer observer) {
		 observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		 observers.remove(observer);
	}

	public void notifyObservers(String message) {
		for(Observer obs: observers) {
			obs.update(this, message);
		}
	}
}
