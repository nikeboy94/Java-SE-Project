package warehouse;

import java.util.ArrayList;

public class Accounting implements EditList {
	private ArrayList<Order> dispatched;
	private ArrayList<Order> received;

	public Accounting() {
		dispatched = new ArrayList<>();
		received = new ArrayList<>();
	} 
	
	public ArrayList<Order> getDispatched() {
		return dispatched;
	}
	
	public ArrayList<Order> getReceived() {
		return received;
	}
	
	/** Adds a given order to either the list of dispatched or received 
	 * based on the order type**/
	@Override
	public void addTo(Order order) {
		if(order instanceof CustomerOrder) {
			dispatched.add(order);
		}
		else{
			received.add(order);
		}
	}
	@Override
	public void addTo(Product product) {
		//do nothing
	}
	
	@Override
	public void removeFrom(int id) {
		
	}

}
