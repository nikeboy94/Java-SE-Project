package warehouseTests;

import static org.junit.Assert.*;
import warehouse.Gnome;
import warehouse.OrderForm;
import org.junit.Test;

public class OrderFormTest {

	@Test
	public void testRemove() {
		OrderForm o = new OrderForm(1, 1);
		Gnome g = new Gnome("name", "colour", false);
		o.addTo(g);
		o.removeProduct(g.getName(), g.getColour(), g.getProtected());
		assertEquals(0, o.getContents().size());
	}
	
	@Test
	public void testOrderID() {
		OrderForm o1 = new OrderForm(1, 1);
		OrderForm o2 = new OrderForm(1, 2);
		assertEquals(2, o2.getOrderID());
	}

}
