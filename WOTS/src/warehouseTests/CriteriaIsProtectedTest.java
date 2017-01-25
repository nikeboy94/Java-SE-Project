package warehouseTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import warehouse.Criteria;
import warehouse.CriteriaIsProtected;
import warehouse.DogStatue;
import warehouse.Gnome;
import warehouse.Product;
import warehouse.PurchaseOrder;
import org.junit.Test;

public class CriteriaIsProtectedTest {

	@Test
	public void meetCriteria2Test() {
		PurchaseOrder po2 = new PurchaseOrder(false);
		po2.addTo(new DogStatue(1,1,"TheNextOne","Much Meme1"));
		po2.addTo(new Gnome(2,24,"Darth Gnome", "Midnight Black"));
		DogStatue d = new DogStatue(3,12,"AnotherOne", "Very Meme2");
		d.setProtected(true);
		
		po2.addTo(d);
		
		Criteria isProtected = new CriteriaIsProtected();
		
		ArrayList<Product> starlistwars = new ArrayList<Product>();
		starlistwars.add(d);
		
		assertEquals(starlistwars, isProtected.meetCriteria2(po2.getContents()));
		
	}

}
