package assignment.command;

import assignment.beans.Product;

public class UpdateProductCommand implements ICommand {

private Product product;
	
	public UpdateProductCommand(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return this.product;
	}

	public String getCommandName() {
		return "updateProduct";
	}
	
}
