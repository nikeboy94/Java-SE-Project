package warehouseTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import warehouse.Criteria;
import warehouse.CriteriaIsNotProtected;
import warehouse.DogStatue;
import warehouse.Gnome;
import warehouse.Product;
import warehouse.PurchaseOrder;
import org.junit.Test;

public class CriteriaIsNotProtectedTest {

	@Test
	public void meetCriteria2Test() {
		PurchaseOrder po2 = new PurchaseOrder(false);
		
		DogStatue dOG = new DogStatue(1,1,"TheNextOne","Much Meme1");
		Gnome g = new Gnome(2,24,"Darth Gnome", "Midnight Black");
		DogStatue d = new DogStatue(3,12,"AnotherOne", "Very Meme2");
		
		dOG.setProtected(true);
		g.setProtected(true);
		
		po2.addTo(d);
		po2.addTo(dOG);
		po2.addTo(g);
		
		Criteria isNotProtected = new CriteriaIsNotProtected();
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(d);
		
		assertEquals(products, isNotProtected.meetCriteria2(po2.getContents()));
		
	}

}
