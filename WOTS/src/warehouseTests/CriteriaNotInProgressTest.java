package warehouseTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import warehouse.Criteria;
import warehouse.CriteriaNotInProgress;
import warehouse.CustomerOrder;
import warehouse.DogStatue;
import warehouse.Gnome;
import warehouse.InventorySystem;
import warehouse.Order;

public class CriteriaNotInProgressTest {

	@Test
	public void meetCriteriaTest() {
		CustomerOrder co = new CustomerOrder(1,123);
		co.addTo(new Gnome(1, 123, "Pattrick", "Gray"));
		co.addTo(new DogStatue(2,4123, "Hail Lee", "Wow Name" ));
		co.setInProgress(true);
		CustomerOrder co2 = new CustomerOrder(2,456);
		
		InventorySystem iS5 = new InventorySystem();
		iS5.addTo(co);
		iS5.addTo(co2);
		
		Criteria notInProgress = new CriteriaNotInProgress();
		
		ArrayList<Order> arraylist = new ArrayList<Order>();
		arraylist.add(co2);
		
		assertEquals(arraylist, notInProgress.meetCriteria(iS5.getOrders()));
	}

}
