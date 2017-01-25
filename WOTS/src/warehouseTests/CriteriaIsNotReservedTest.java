package warehouseTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import warehouse.Criteria;
import warehouse.CriteriaIsNotReserved;
import warehouse.DogStatue;
import warehouse.Gnome;
import warehouse.Product;
import warehouse.PurchaseOrder;

public class CriteriaIsNotReservedTest {

	@Test
	public void meetCriteria2Test() {
		PurchaseOrder po2 = new PurchaseOrder(true);
		
		DogStatue dOG = new DogStatue(1,1,"TheNextOne","Much Meme1");
		Gnome g = new Gnome(2,24,"Darth Gnome", "Midnight Black");
		DogStatue d = new DogStatue(3,12,"AnotherOne", "Very Meme2");
		
		dOG.setReserved(true);
		g.setReserved(true);
		
		po2.addTo(d);
		po2.addTo(dOG);
		po2.addTo(g);
		
		Criteria isNotReserved = new CriteriaIsNotReserved();
		
		ArrayList<Product> starlistwars = new ArrayList<Product>();
		starlistwars.add(d);
		
		assertEquals(starlistwars, isNotReserved.meetCriteria2(po2.getContents()));
		
	}

}
