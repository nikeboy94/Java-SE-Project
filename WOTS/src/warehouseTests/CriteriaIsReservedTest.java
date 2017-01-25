package warehouseTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import warehouse.Criteria;
import warehouse.CriteriaIsReserved;
import warehouse.DogStatue;
import warehouse.Gnome;
import warehouse.Product;
import warehouse.PurchaseOrder;

public class CriteriaIsReservedTest {

	@Test
	public void meetCriteria2Test() {
		PurchaseOrder po2 = new PurchaseOrder(true);
		po2.addTo(new DogStatue(1,1,"TheNextOne","Much Meme1"));
		po2.addTo(new Gnome(2,24,"Darth Gnome", "Midnight Black"));
		DogStatue d = new DogStatue(3,12,"AnotherOne", "Very Meme2");
		d.setReserved(true);
		
		po2.addTo(d);
		
		Criteria isReserved = new CriteriaIsReserved();
		
		ArrayList<Product> starlistwars = new ArrayList<Product>();
		starlistwars.add(d);
		
		assertEquals(starlistwars, isReserved.meetCriteria2(po2.getContents()));
		
	}
}
