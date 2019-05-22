package assignment.command;

import assignment.beans.Product;

public class InsertProductCommand implements ICommand {

	private Product product;
	
	public InsertProductCommand(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public String getCommandName() {
		return "insertProduct";
	}
	
}
