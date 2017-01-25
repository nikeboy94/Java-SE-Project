package warehouseTests;

import static org.junit.Assert.*;
import warehouse.Accounting;
import warehouse.CustomerOrder;
import warehouse.PurchaseOrder;

import org.junit.Test;

public class AccountingTest {

	@Test
	public void accountingDispatchedTest() {
	
		Accounting a = new Accounting();
		assertNotNull(a.getDispatched().size());
		
	}
	
	@Test
	public void accountingReceivedTest() {
	
		Accounting a = new Accounting();
		assertNotNull(a.getReceived().size());
		
	}
	
	@Test
	public void addToDispatchedTest(){
		
		Accounting a = new Accounting();
		a.addTo(new CustomerOrder(1, 123));
		assertEquals(1, a.getDispatched().size());
		
	}
	
	@Test
	public void addToReceivedTest(){
		
		Accounting a = new Accounting();
		a.addTo(new PurchaseOrder(true));
		assertEquals(1, a.getReceived().size());
		
	}
}
