package assignment.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import assignment.beans.Product;
import assignment.command.DeleteProductCommand;
import assignment.command.ICommand;
import assignment.command.InsertProductCommand;
import assignment.command.UpdateProductCommand;
import assignment.mediator.Mediator;
import assignment.query.ProductQuery;

public class ProductsOperationsTest {

	private static Product product1;
	private static Product product2;
	private static int noOfTests = 0;
	private static int noOfSuccessfulTests = 0;
	private Mediator mediator = new Mediator();
	
	public ProductsOperationsTest() {}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		product1 = new Product("testProduct1", 21, 3, 1);
		product2 = new Product("testProduct2", 123.6f, 12, 2);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println(noOfTests + " tests have been executed; " + noOfSuccessfulTests + " have been successful");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("A new test begins!");
		noOfTests++;
	 }
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Current test finished!");
	 } 
	
	@Test
	public void testAddProduct(){
		try {
			int noOfProducts = ProductQuery.queryProduct().size();
			ICommand command1 = new InsertProductCommand(product1);
			mediator.mediate(command1);
			int newNoOfProducts = ProductQuery.queryProduct().size();
			assertTrue(noOfProducts == (newNoOfProducts - 1));
			noOfSuccessfulTests++;
			Product p = ProductQuery.findProductByName(product1.getName());
			ICommand command2 = new DeleteProductCommand(p.getId());
			mediator.mediate(command2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateProduct(){
		try {
			ICommand command1 = new InsertProductCommand(product2);
			mediator.mediate(command1);
			Product p = ProductQuery.findProductByName(product2.getName());			
			p.setName("newName");
			ICommand command2 = new UpdateProductCommand(p);
			mediator.mediate(command2);
			p = ProductQuery.findProduct(p.getId());
			assertTrue(p.getName().equals("newName"));
			noOfSuccessfulTests++;
			ICommand command3 = new DeleteProductCommand(p.getId());
			mediator.mediate(command3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteProduct(){
		try {
			ICommand command1 = new InsertProductCommand(product2);
			mediator.mediate(command1);
			int noOfProducts = ProductQuery.queryProduct().size();
			Product p = ProductQuery.findProductByName(product2.getName());
			ICommand command2 = new DeleteProductCommand(p.getId());
			mediator.mediate(command2);
			int newNoOfProducts = ProductQuery.queryProduct().size();
			assertTrue(noOfProducts == (newNoOfProducts + 1));
			noOfSuccessfulTests++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
