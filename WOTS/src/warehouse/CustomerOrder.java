package warehouse;

public class CustomerOrder extends Order{

	private int workerID;
	private int customerID;
	private int orderFormID;
	private boolean inProgress = false;
	private boolean completed = false;
	private boolean dispatched = false;

	public CustomerOrder(int customerID, int orderFormID) {
		super();
		this.customerID = customerID;
		this.orderFormID = orderFormID;
	}
	
	public int getWorkerID() {
		return workerID;
	}
	
	public int getCustomerID(){
		return customerID;
	}
	
	public int getOrderFormID() {
		return orderFormID;
	}
	
	public boolean getInProgress() {
		return inProgress;
	}
	
	public boolean getCompleted() {
		return completed;
	}
	
	public boolean getDispatched() {
		return dispatched;
	}
	
	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}
	
	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public void setDispatched(boolean dispatched) {
		if (inProgress && completed) {
			this.dispatched = dispatched;
		}
	}
	
}
