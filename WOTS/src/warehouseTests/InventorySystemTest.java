package warehouseTests;

import static org.junit.Assert.*;
import org.junit.Test;
import warehouse.*;

public class InventorySystemTest {

	@Test
	public void checkProdTest() {
		Gnome sonic = new Gnome(1, 12, "Sonic", "Blue");
		InventorySystem IS = new InventorySystem();
		IS.addTo(sonic);
		assertEquals(true, IS.checkProd(1));
	}
	
	@Test
	public void checkOrdTest() {
		CustomerOrder knuckles = new CustomerOrder(1,1); 
		InventorySystem SEGA = new InventorySystem();
		SEGA.addTo(knuckles);
		assertEquals(true, SEGA.checkOrd(knuckles.getOrderID()));
	}
	
	@Test
	public void removeProductTest() {
		InventorySystem IMS = new InventorySystem();
		IMS.addTo(new Gnome(1, 123, "Pattrick McCormak", "Green"));
		IMS.removeFrom(1);
		assertEquals(0, IMS.getStock().size());
	}
	
	@Test
	public void removeOrderTest() {
		InventorySystem IMS = new InventorySystem();
		CustomerOrder co = new CustomerOrder(1, 1);
		System.out.println(co.getOrderID());
		IMS.addTo(co);
		IMS.removeOrder(co.getOrderID());
		assertEquals(0, IMS.getOrders().size());
	}
	
	@Test
	public void addOrderToStockTest() {
		InventorySystem IMS5000 = new InventorySystem();
		PurchaseOrder po = new PurchaseOrder(false);
		po.setReceived(true);
		Gnome g = new Gnome(1,1,"Luke GnomeWalker", "White");
		DogStatue d = new DogStatue(2,3,"DJDoge", "Much Cool");
		po.addTo(d);
		po.addTo(g);
		IMS5000.addOrderToStock(po);
		assertEquals(true, IMS5000.checkProd(1));
	}
	
	@Test
	public void addOrderToStockTest2() {
		InventorySystem IMS5000 = new InventorySystem();
		PurchaseOrder po = new PurchaseOrder(true);
		po.setReceived(true);
		Gnome g = new Gnome(1,1,"Luke GnomeWalker", "White");
		DogStatue d = new DogStatue(2 , 3,"DJDoge2", "Much Cool");
		po.addTo(d);
		po.addTo(g);
		IMS5000.addOrderToStock(po);
		assertEquals(true, IMS5000.checkProd(2));
	}
	
	@Test
	public void addOrderToStockTest3() {
		InventorySystem IMS5000 = new InventorySystem();
		PurchaseOrder po = new PurchaseOrder(false);
		po.setReceived(true);
		Gnome g = new Gnome(1,1,"Luke GnomeWalker", "White");
		DogStatue d = new DogStatue(2 , 3,"DJDoge2", "Much Cool");
		DogStatue d2 = new DogStatue(3, 5, "Sam Jackson", "Wow Sam");
		po.addTo(d);
		po.addTo(g);
		po.addTo(d2);
		IMS5000.addOrderToStock(po);
		assertEquals(true, IMS5000.checkProd(3));
	}
	
	@Test
	public void testGetOrder() {
		InventorySystem i = new InventorySystem();
		PurchaseOrder p = new PurchaseOrder(true);
		i.addTo(p);
		assertEquals(p, i.getOrder(p.getOrderID()));
	}
	
	@Test
	public void testReceiveOrder() {
		InventorySystem i = new InventorySystem();
		PurchaseOrder p = new PurchaseOrder(true);
		i.addTo(p);
		i.receiveOrder(p.getOrderID());
		assertEquals(true, p.getReceived());
	}
	
	@Test
	public void testReceiveOrder2() {
		InventorySystem i = new InventorySystem();
		PurchaseOrder p = new PurchaseOrder(true);
		i.addTo(p);
		i.receiveOrder(p.getOrderID());
		assertEquals(1, i.getAccounts().getReceived().size());
	}
	
	@Test
	public void testDispatchOrder() {
		InventorySystem i = new InventorySystem();
		OrderForm o = new OrderForm(1, 1);
		o.addTo(new Gnome("name", "colour", false));
		Gnome g = new Gnome(1, 1, "name", "colour");
		i.addTo(g);
		i.addTo(o);
		i.checkOrderForm(o.getOrderID());
		i.workerAssigned(o.getOrderID(), 1); 
		i.printOrders(i.getOrders());
		CustomerOrder co = i.retrieveCO(o.getOrderFormID());
		i.dispatchOrder(co.getOrderID());
		// need to check have stock, then check removed, check in accounting
		assertEquals(1, i.getAccounts().getDispatched().size());
	}
	
	@Test
	public void testCheckOrderForm() {
		InventorySystem i = new InventorySystem();
		OrderForm o = new OrderForm(1, 1);
		//CustomerOrder co = new CustomerOrder(1, 1);
		o.addTo(new Gnome("name", "colour", false));
		Gnome g = new Gnome(1, 1, "name", "colour");
		i.addTo(g);
		i.addTo(o);
		//i.addTo(co);
		i.checkOrderForm(o.getOrderID());
		assertEquals(0, o.getContents().size());
	}
	
	@Test
	public void testReserved() {
		InventorySystem i = new InventorySystem();
		OrderForm o = new OrderForm(1, 1);
		//CustomerOrder co = new CustomerOrder(1, 1);
		o.addTo(new Gnome("name", "colour", false));
		Gnome g = new Gnome(1, 1, "name", "colour");
		i.addTo(g);
		i.addTo(o);
		//i.addTo(co);
		i.checkOrderForm(o.getOrderID());
		assertEquals(true, g.getReserved());
	}
	
	@Test
	public void testAddToCustomerOrder() {
		InventorySystem i = new InventorySystem();
		OrderForm o = new OrderForm(1, 1);
		o.addTo(new Gnome("name", "colour", false));
		Gnome g = new Gnome(1, 1, "name", "colour");
		i.addTo(g);
		i.addTo(o);
		i.checkOrderForm(o.getOrderID());
		CustomerOrder co = (CustomerOrder) i.getOrders().get(0);
		assertEquals(1, co.getContents().size());
	}
	
	@Test
	public void testNewCustomerOrder() {
		InventorySystem i = new InventorySystem();
		OrderForm o = new OrderForm(1, 1);
		i.addTo(o);
		assertEquals(2, i.getOrders().size());
	}
	
	@Test
	public void testRemoveOrderForm() {
		InventorySystem i = new InventorySystem();
		OrderForm o = new OrderForm(1, 1);
		o.addTo(new Gnome("name", "colour", false));
		Gnome g = new Gnome(1, 1, "name", "colour");
		i.addTo(g);
		i.addTo(o);
		i.checkOrderForm(o.getOrderID());
		assertFalse(i.getOrders().contains(o));
	}
	
	@Test
	public void testRetrieveCo() {
		InventorySystem i = new InventorySystem();
		CustomerOrder co = new CustomerOrder(1, 1);
		i.addTo(co);
		assertEquals(co, i.retrieveCO(1));

	}
	
}


