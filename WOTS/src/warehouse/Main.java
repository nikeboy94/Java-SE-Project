package warehouse;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		/*CustomerOrder co = new CustomerOrder(1,123);
		co.addTo(new Gnome(1, 123, "Pattrick", "Gray"));
	//	co.removeFrom(1);
		co.addTo(new Doge(2,4123, "Hail Lee", "Wow Name" ));
		co.setInProgress(true);
		
		Criteria inProgress = new CriteriaInProgress();
		Criteria notInProgress = new CriteriaNotInProgress();
		
		Customer Jeff = new CustomerBuilder().customerID(1).name("Jeffery").buildCustomer();
		System.out.println("Hello " + Jeff.name + ", I have heard that you have an ID of " + Jeff.customerID );
		
		
		InventorySystem IMS = new InventorySystem();
		IMS.addTo(co);
		IMS.addTo(new PurchaseOrder(2));		
		IMS.addTo(new CustomerOrder(3,234));
	//	IMS.printOrders(IMS.orders);
	//	IMS.displayOrderInfo(1, IMS.orders);
		
		IMS.printOrders(inProgress.meetCriteria(IMS.orders));
		IMS.printOrders(notInProgress.meetCriteria(IMS.orders));
		*/
		
		// scenario to test customer order form
		
		InventorySystem i = new InventorySystem();
		Gnome g = new Gnome(1, 2, "Sanic", "Blue");
		g.setProtected(true);
		i.addTo(g);
		i.addTo(new DogStatue(2, 7, "Clifford", "Much big and red"));
		
		Worker tom = new Worker(1, "Thomas the Tank");
		
		PurchaseOrder po = new PurchaseOrder(false);
		po.addTo(new DogStatue(3, 19, "Jeremy", "Amazon has very money"));
		i.addTo(po);
		
		// customer calls in
		Customer Jeff = new CustomerBuilder().customerID(1).name("Jeffery").buildCustomer();
		OrderForm o = new OrderForm(1, 1);
		Gnome g2 = new Gnome("Sanic", "Blue", true);
		o.addTo(g2);
		o.addTo(new DogStatue("Jeremy", "Amazon has very money", false));
		System.out.println();
		
		//System process
		i.addTo(o);	
		i.checkOrderForm(o.getOrderID());
		//i.printOrders(i.orders);
		//i.displayOrderInfo(1, i.orders);
		//i.displayOrderInfo(2, i.orders);
		//i.displayOrderInfo(3, i.orders);
		System.out.println();
		
		//Worker Input - Delivery
		//po.setReceived(true);
		//i.addOrderToStock(po);
		i.receiveOrder(po.getOrderID());
		i.checkOrderForm(o.getOrderID());
		//i.displayOrderInfo(1, i.orders);
		//i.displayOrderInfo(2, i.orders);
		//i.displayOrderInfo(3, i.orders);
		System.out.println();
		
		//Workers look up orders and assigns themselves to dispatch a customer order
		Criteria notInProgress = new CriteriaNotInProgress();
		Criteria inProgress = new CriteriaInProgress();
		i.printOrders(notInProgress.meetCriteria(i.getOrders()));
		i.workerAssigned(3, 1);
		i.printOrders(inProgress.meetCriteria(i.getOrders()));
		System.out.println("Orders in Accounts:");
		i.printOrders(i.getAccounts().getReceived());
		
		//Worker finds the shortest path to retrieve all items on the order
		Map m = new Map();
		
		ArrayList<Product> newList = m.shortestPath(i.retrieveCO(1).getContents());
		System.out.println();
		i.displayContents(newList);
		System.out.println();

		
		
		i.dispatchOrder(3);
		i.printOrders(i.getAccounts().getDispatched());
		//Database dB = new Database();
		//dB.accessDB();
		
	}

}
