package warehouseTests;

import static org.junit.Assert.*;

import org.junit.Test;

import warehouse.Gnome;
import warehouse.InventorySystem;
import warehouse.PurchaseOrder;

public class PurchaseOrderTest {

	@Test
	public void orderTest() {
		PurchaseOrder po = new PurchaseOrder(true);
		assertEquals(4, po.getOrderID());
	}
	
	@Test
	public void receivedTest() {
		PurchaseOrder po = new PurchaseOrder(true);
		assertEquals(true, po.getReceived());
	}
	
	@Test
	public void addOrderTest() {
		PurchaseOrder po = new PurchaseOrder(false);
		InventorySystem IS = new InventorySystem();
		IS.addTo(po);
		assertEquals(true, IS.checkOrd(po.getOrderID()));
	}
	
	@Test
	public void addToTest() {
		
		PurchaseOrder po = new PurchaseOrder(false);
		po.addTo(new Gnome(1, 123, "Paddy", "green"));
		assertEquals(1, po.getContents().size());
	}
	
	@Test
	public void removeFromPTest() {
		PurchaseOrder po = new PurchaseOrder(false);
		po.addTo(new Gnome(1, 123, "Paddy Mcguniess", "Green"));
		System.out.println(po.getContents());
		po.removeFrom(1);
		assertEquals(0, po.getContents().size());
	}
	
	@Test
	public void setReceivedTest() {
		PurchaseOrder po = new PurchaseOrder(false);
		po.setReceived(true);
		
		assertEquals(true, po.getReceived());
	}
}
