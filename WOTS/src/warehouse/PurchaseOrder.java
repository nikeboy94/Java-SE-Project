package warehouse;

public class PurchaseOrder extends Order{
	
	private boolean received = false;
	
	public PurchaseOrder(boolean received) {
		super();
		this.received = received;		
	}
	
	public boolean getReceived(){
		return received;
	}
	
	public void setReceived(boolean received) {
		this.received = received;
	}
	
}
