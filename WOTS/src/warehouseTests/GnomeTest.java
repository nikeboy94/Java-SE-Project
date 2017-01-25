package warehouseTests;

import static org.junit.Assert.*;
import warehouse.Gnome;
import org.junit.Test;

public class GnomeTest {

	@Test
	public void testNotNull() {
		Gnome Sanic = new Gnome(1, 12, "Sanic", "Blue");
		assertNotNull(Sanic.getName());
	}
	
	@Test
	public void testName() {
		Gnome Sanic = new Gnome(1, 12, "Sanic", "Blue");
		assertEquals("Sanic", Sanic.getName());
	}
	
	@Test
	public void testID() {
		Gnome Sanic = new Gnome(1, 12, "Sanic", "Blue");
		assertEquals(1, Sanic.getProductID());
	}
	
	@Test
	public void testLocation() {
		Gnome Sanic = new Gnome(1, 12, "Sanic", "Blue");
		assertEquals(12, Sanic.getLocation());
	}
	
	@Test
	public void testColour() {
		Gnome Sanic = new Gnome(1, 12, "Sanic", "Blue");
		assertEquals("Blue", Sanic.getColour());
	}

	@Test
	public void testRes() {
		Gnome Sanic = new Gnome(1, 12, "Sanic", "Blue");
		Sanic.setReserved(true);
		assertEquals(true, Sanic.getReserved());
	}

	@Test
	public void testPro() {
		Gnome Sanic = new Gnome(1, 12, "Sanic", "Blue");
		Sanic.setProtected(true);
		assertEquals(true, Sanic.getProtected());
	}
	
	@Test
	public void testConstructor() {
		Gnome g = new Gnome("gnome", "colour", false);
		assertEquals("gnome", g.getName());
	}
	
	@Test
	public void testSetLocation() {
		Gnome g = new Gnome(1,12,"Nobby", "Festive Silver");
		g.setLocation(15);
		assertEquals(15, g.getLocation());
	}
	

}
