package warehouseTests;

import static org.junit.Assert.*;
import warehouse.DogStatue;
import org.junit.Test;

public class DogStatueTest {

	@Test
	public void testMeme() {
		DogStatue dog = new DogStatue(1, 12, "DogeShiba", "Very Java");
		assertEquals("Very Java", dog.getMeme());
	}
	
	@Test
	public void testSetID() {
		DogStatue d = new DogStatue("dog", "mem", false);
		d.setID(1);
		assertEquals(1, d.getProductID());
	}


}
