package warehouseTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import warehouse.Criteria;
import warehouse.CriteriaInProgress;
import warehouse.CustomerOrder;
import warehouse.DogStatue;
import warehouse.Gnome;
import warehouse.InventorySystem;
import warehouse.Order;

public class CriteriaInProgressTest {

	@Test
	public void meetCriteriaTest() {
		CustomerOrder co = new CustomerOrder(1, 123);
		co.addTo(new Gnome(1, 123, "Pattrick", "Gray"));
		co.addTo(new DogStatue(2, 4123, "Hail Lee", "Wow Name"));
		co.setInProgress(true);
		CustomerOrder co2 = new CustomerOrder(2, 456);

		InventorySystem ISIS5 = new InventorySystem();
		ISIS5.addTo(co);
		ISIS5.addTo(co2);

		Criteria inProgress = new CriteriaInProgress();

		ArrayList<Order> arraylist = new ArrayList<Order>();
		arraylist.add(co);

		assertEquals(arraylist, inProgress.meetCriteria(ISIS5.getOrders()));
	}

}
