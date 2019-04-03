package assignment.beans.factory;

public class Discount {

	private int code;
	private String type;
	private float percent;
	
	public Discount() {}

	public Discount(int code, String type, float percent) {
		super();
		this.code = code;
		this.type = type;
		this.percent = percent;
	}
	
	public Discount(String type, float percent) {
		super();
		this.type = type;
		this.percent = percent;
	}

	public int getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public float getPercent() {
		return percent;
	}
	
}
