package warehouseTests;

import static org.junit.Assert.*;
import warehouse.Customer;
import org.junit.Test;

public class CustomerTest {

	@Test
	public void IDTest() {
		Customer c = new Customer(1, "Nik", "Somewhere", "lol@lol.com", "02045654323");
		assertEquals(1, c.getCustomerID());
	}

	@Test
	public void NameTest() {
		Customer c = new Customer(1, "Nik", "Somewhere", "lol@lol.com", "02045654323");
		assertEquals("Nik", c.getName());
	}

	@Test
	public void AddressTest() {
		Customer c = new Customer(1, "Nik", "Somewhere", "lol@lol.com", "02045654323");
		assertEquals("Somewhere", c.getAddress());
	}
}
