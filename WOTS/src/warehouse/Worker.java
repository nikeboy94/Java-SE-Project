package warehouse;

public class Worker {
	
	private int workerID;
	private String name;

	public Worker(int workerID, String name) {
		this.workerID = workerID;
		this.name = name;
	}

	public int getWorkerID() {
		return workerID;
	}

	public String getWorkerName() {
		return name;
	}
}
