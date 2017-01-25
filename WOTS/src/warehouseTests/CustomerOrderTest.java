package warehouseTests;

import static org.junit.Assert.*;
import org.junit.Test;
import warehouse.CustomerOrder;
import warehouse.Gnome;
import warehouse.InventorySystem;

public class CustomerOrderTest {

	@Test
	public void orderTest() {
		CustomerOrder co = new CustomerOrder(1,1);
		assertEquals(3, co.getOrderID());
	}

	@Test
	public void customerTest() {
		CustomerOrder co = new CustomerOrder(1,1);
		assertEquals(1, co.getCustomerID());
	}
	
	@Test
	public void addOrderTest() {
		CustomerOrder co = new CustomerOrder(1, 12);
		InventorySystem IS = new InventorySystem();
		IS.addTo(co);
		assertEquals(true, IS.checkOrd(co.getOrderID()));
	}
	
	@Test
	public void addToTest() {
		
		CustomerOrder co = new CustomerOrder(1,1);
		co.addTo(new Gnome(1, 123, "Paddy", "green"));
		assertEquals(1, co.getContents().size());
	}
	
	@Test
	public void removeFromCTest() {
		CustomerOrder co = new CustomerOrder(1,1);
		co.addTo(new Gnome(1, 123, "Paddy Mcguniess", "Green"));
		co.removeFrom(1);
		assertEquals(0, co.getContents().size());
	}
	
	@Test
	public void setInProgressTest() {
		CustomerOrder co = new CustomerOrder(1,1);
		co.setInProgress(true);
		assertEquals(true, co.getInProgress());
	}
	
	
}
