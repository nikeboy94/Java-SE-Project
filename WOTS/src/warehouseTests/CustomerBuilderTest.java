package warehouseTests;

import static org.junit.Assert.*;
import warehouse.Customer;
import warehouse.CustomerBuilder;
import org.junit.Test;

public class CustomerBuilderTest {

	@Test
	public void buildCustomerTest(){
		Customer c = new CustomerBuilder().buildCustomer();
		assertEquals(0, c.getCustomerID());		
	}
	
	@Test
	public void buildCustomerTest2(){
		Customer c = new CustomerBuilder().buildCustomer();
		assertEquals("", c.getName());		
	}
	
	@Test
	public void buildCustomerTest3(){
		Customer c = new CustomerBuilder().buildCustomer();
		assertEquals("", c.getAddress());	
	}
	
	@Test
	public void buildCustomerTest4(){
		Customer c = new CustomerBuilder().buildCustomer();
		assertEquals("", c.getEmail());	
	}

	@Test
	public void buildCustomerTest5(){
		Customer c = new CustomerBuilder().buildCustomer();
		assertEquals("", c.getPhone());	
	}
	
}







