package warehouseTests;

import static org.junit.Assert.*;
import org.junit.Test;
import warehouse.Worker;

public class WorkerTest {

	@Test
	public void IDTest() {
		Worker w = new Worker(1, "Nik");
		assertEquals(1, w.getWorkerID());
	}

	@Test
	public void NameTest() {
		Worker w = new Worker(1, "Nik");
		assertEquals("Nik", w.getWorkerName());
	}
}
