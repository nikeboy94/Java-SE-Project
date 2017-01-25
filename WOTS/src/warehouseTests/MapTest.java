package warehouseTests;

import static org.junit.Assert.*;
import warehouse.CustomerOrder;
import warehouse.DogStatue;
import warehouse.Gnome;
import warehouse.Map;
import warehouse.Product;
import java.util.ArrayList;
import org.junit.Test;

public class MapTest {

	@Test
	public void testConvertLocation() {
		Map bruce = new Map();
		int[] stupid = { 4, 3 };
		System.out.println(bruce.convertLocation(14));
		System.out.println(stupid);
		assertEquals(stupid[0], bruce.convertLocation(14)[0]);

	}

	@Test
	public void testConvertCoordinate() {
		Map peter = new Map();
		int[] newYork = { 1, 1 };
		System.out.println(peter.convertCoordinate(newYork));
		System.out.println(newYork);
		assertEquals(1, peter.convertCoordinate(newYork));

	}

	@Test
	public void testDistanceCalc() {
		Gnome g = new Gnome(1, 1, "Richy Rich Joe", "Blue coz I like blue");
		DogStatue d = new DogStatue(2, 7, "Not Mike Myers", "Kinda Green");
		Map qA = new Map();
		int[] loc1 = qA.convertLocation(g.getLocation());
		int[] loc2 = qA.convertLocation(d.getLocation());

		assertEquals(2, qA.distanceCalc(loc1, loc2));

	}

	@Test
	public void testMinD() {

		Map aMap = new Map();

		int[] intArr = { 5, 2, 8, 3, 2 };
		assertEquals(1, aMap.minDIndex(intArr));

	}

	@Test
	public void shortestPathTest() {
		CustomerOrder co = new CustomerOrder(1, 1);
		Gnome g = new Gnome(1, 4, "Richy Rich Joe", "Blue coz I like blue");
		Gnome g2 = new Gnome(2, 7, "Not as Richy Rich Joe",
				"Not Blue coz I like blue");
		DogStatue d = new DogStatue(3, 12, "Not Mike Myers", "Kinda Greenish");
		Map m = new Map();
		ArrayList<Product> pTest = new ArrayList<Product>();

		pTest.add(g2);
		pTest.add(d);
		pTest.add(g);
		co.addTo(g);
		co.addTo(g2);
		co.addTo(d);

		assertEquals(pTest, m.shortestPath(co.getContents()));

	}

}
