package warehouse;

import java.util.ArrayList;

public class InventorySystem implements EditList {

	private ArrayList<Order> orders;
	private ArrayList<Product> stock;
	private Accounting accounts;

	public InventorySystem() {
		orders = new ArrayList<>();
		stock = new ArrayList<>();
		accounts = new Accounting();
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public ArrayList<Product> getStock() {
		return stock;
	}

	public Accounting getAccounts() {
		return accounts;
	}

	/** Checks if a product has been added to (is in) the list of stock **/
	public boolean checkProd(int productID) {

		boolean added = false;

		for (Product product : stock) {
			if (product.getProductID() == productID) {
				added = true;
			}
		}
		return added;
	}

	/** Checks if an order has been added to or is in the list of orders **/
	public boolean checkOrd(int orderID) {

		boolean added = false;

		for (Order order : orders) {
			if (order.getOrderID() == orderID) {
				added = true;
			}
		}
		return added;
	}

	/** Adds an order to the list of orders **/
	@Override
	public void addTo(Order order) {

		orders.add(order);

		if (order instanceof OrderForm) {
			orders.add(new CustomerOrder(((OrderForm) order).getCustomerID(),
					((OrderForm) order).getOrderFormID()));
		}
	}

	/** Adds a single product to the stock **/
	@Override
	public void addTo(Product product) {
		stock.add(product);
		System.out.println("product has been added to stock");
	}

	/** Removes a product from the stock using its ProductID **/
	@Override
	public void removeFrom(int productID) {

		for (Product product : stock) {

			if (product.getProductID() == productID) {
				stock.remove(product);
				System.out.println("Product " + product.getName()
						+ " has been removed from Stock");
				break;
			}
		}
	}

	/**
	 * Takes in a Product Order and sets its received status to true. Then
	 * individually adds the stock listed in its contents
	 **/
	public void addOrderToStock(PurchaseOrder purchaseOrder) {

		if (purchaseOrder.getReceived() == true) {

			for (Product product : purchaseOrder.getContents()) {
				stock.add(product);
			}
		} else {
			System.out
					.println("Not received therefore cannot be added to Stock bruh");
		}
	}

	/** Removes an order from the list of orders using the OrderID **/
	public void removeOrder(int orderID) {

		for (Order order : orders) {

			if (order.getOrderID() == orderID) {
				orders.remove(order);
				System.out.println("Order with Order no. " + order.getOrderID()
						+ " has been removed from Orders");
				break;
			}
		}
	}

	/** Assigns a worker to an order and updates it's inProgress status **/
	public void workerAssigned(int orderID, int workerID) {

		for (Order order : orders) {

			if (order.getOrderID() == orderID) {
				((CustomerOrder) order).setWorkerID(workerID);
				((CustomerOrder) order).setInProgress(true);
			}

		}
	}

	/**
	 * Prints all orders in the list of orders to console, with different
	 * information based on the order type
	 **/
	public void printOrders(ArrayList<Order> ordersList) {

		for (Order order : ordersList) {

			if (order instanceof CustomerOrder) {
				System.out.println("Type: Customer Order, " + "Order no. "
						+ order.getOrderID() + ", Customer ID: "
						+ ((CustomerOrder) order).getCustomerID()
						+ ", Order Form ID: "
						+ ((CustomerOrder) order).getOrderFormID()
						+ ", Worker ID: "
						+ ((CustomerOrder) order).getWorkerID()
						+ ", In Progress?: "
						+ ((CustomerOrder) order).getInProgress()
						+ ", All Items Added?: "
						+ ((CustomerOrder) order).getCompleted()
						+ ", Dispatched?: "
						+ ((CustomerOrder) order).getDispatched());

			} else if (order instanceof PurchaseOrder) {
				System.out.println("Type: Purchase Order, " + "Order no. "
						+ order.getOrderID() + ", Received?: "
						+ ((PurchaseOrder) order).getReceived());

			} else {
				System.out.println("Type: Order Form, Order no. "
						+ order.getOrderID() + ", Order Form no. "
						+ ((OrderForm) order).getOrderFormID()
						+ ", Customer no. "
						+ ((OrderForm) order).getCustomerID());
			}

		}
	}

	/** Displays all of the products in a specified list of stock **/
	public void displayOrderInfo(int orderID, ArrayList<Order> orderList) {

		for (Order order : orderList) {

			if (order.getOrderID() == orderID) {

				for (Product product : order.getContents()) {

					String addtional;
					String productType;

					if (product instanceof Gnome) {
						addtional = " Colour: " + ((Gnome) product).getColour();
						productType = "Gnome";
					} else {
						addtional = " Meme: " + ((DogStatue) product).getMeme();
						productType = "Dog Statue";
					}

					System.out.println("Product Type: " + productType
							+ ", ProductID: " + product.getProductID()
							+ ", Name: " + product.getName() + ", Location: "
							+ product.getLocation() + "," + addtional
							+ ", Protected?: " + product.getProtected()
							+ ", Reserved?: " + product.getReserved());
				}
			}
		}
	}

	// not tested
	/**
	 * Using a given list of products, displays the product information based on
	 * the product type
	 **/
	public ArrayList<String> displayOrderInfo2(ArrayList<Product> product) {

		ArrayList<String> stringList = new ArrayList<String>();
		String info = "";

		for (Product p : product) {

			String addtional;
			String productType;

			if (p instanceof Gnome) {
				addtional = " Colour: " + ((Gnome) p).getColour();
				productType = "Gnome";
			} else {
				addtional = " Meme: " + ((DogStatue) p).getMeme();
				productType = "Dog Statue";
			}

			info = "Product Type: " + productType + ", ProductID: "
					+ p.getProductID() + ", Name: " + p.getName()
					+ ", Location: " + p.getLocation() + "," + addtional
					+ ", Protected?: " + p.getProtected() + ", Reserved?: "
					+ p.getReserved();

			stringList.add(info);

		}
		return stringList;
	}

	// not tested
	/**
	 * Using a given list of orders, finds a specific order based on a given
	 * OrderID, and returns it in an ArrayList
	 **/
	public ArrayList<Product> displayOrderInfoToArray(int orderID,
			ArrayList<Order> orderList) {

		ArrayList<Product> theReturn = new ArrayList<Product>();

		for (Order order : orderList) {

			if (order.getOrderID() == orderID) {

				for (Product product : order.getContents()) {
					theReturn.add(product);
				}
			}
		}
		return theReturn;
	}

	/**
	 * Displays the contents of an order on the console from a given list of
	 * products
	 **/
	public void displayContents(ArrayList<Product> productList) {

		for (Product product : productList) {
			String addtional;
			String productType;

			if (product instanceof Gnome) {
				addtional = " Colour: " + ((Gnome) product).getColour();
				productType = "Gnome";

			} else {
				addtional = " Meme: " + ((DogStatue) product).getMeme();
				productType = "Dog Statue";
			}

			System.out.println("Product Type: " + productType
					+ ", Location: " + product.getLocation()
					+ ", ProductID: " + product.getProductID() + ", Name: "
					+ product.getName() + ", " + addtional);
		}
	}

	/**
	 * This finds the location of an item i.e. returns the location number based
	 * on the ProductID
	 **/
	public int locateItem(int productID) {

		int location = 0;

		for (Product product : stock) {

			if (product.getProductID() == productID) {
				location = product.getLocation();
			}
		}
		System.out.println(location);
		return location;
	}

	/** Returns an order using the OrderID given **/
	public Order getOrder(int orderID) {

		Order purchaseOrder = null;

		for (Order order : orders) {

			if (order.getOrderID() == orderID) {
				purchaseOrder = order;
				break;
			}
		}
		return purchaseOrder;
	}

	/**
	 * Receive a purchase order and use the OrderID to send the order to
	 * Accounts, setting the received status to true
	 **/
	public void receiveOrder(int orderID) {

		PurchaseOrder purchaseOrder = (PurchaseOrder) getOrder(orderID);
		purchaseOrder.setReceived(true);
		addOrderToStock(purchaseOrder);
		accounts.addTo(purchaseOrder);
	}

	/**
	 * Goes through the contents of a given Order Form and checks whether any of
	 * the required products are in stock and not reserved. If so it adds those
	 * products to the matching Customer Order and sets the reserved status of
	 * the products to true.
	 **/
	public void checkOrderForm(int orderFormID) {

		OrderForm orderForm = (OrderForm) getOrder(orderFormID);

		// find matching customer order form
		CustomerOrder customerOrder = null;

		for (Order order : orders) {
			if (order instanceof CustomerOrder) {
				if (((CustomerOrder) order).getOrderFormID() == orderForm
						.getOrderFormID()) {
					customerOrder = (CustomerOrder) order;
				}
			}
		}

		Criteria notReserved = new CriteriaIsNotReserved();
		ArrayList<Product> available = notReserved.meetCriteria2(stock);

		// run through every product thats not reserved
		for (Product product : available) {

			if (product instanceof Gnome) {
				boolean removed = orderForm.removeProduct(product.getName(),
						((Gnome) product).getColour(), product.getProtected());
				if (removed) {
					product.setReserved(true);
					customerOrder.addTo(product);
				}

			} else {
				boolean removed = orderForm.removeProduct(product.getName(),
						((DogStatue) product).getMeme(), product.getProtected());
				if (removed) {
					product.setReserved(true);
					customerOrder.addTo(product);
				}
			}
		}

		// check if any items left on order form
		if (orderForm.getContents().isEmpty()) {
			customerOrder.setCompleted(true);
			orders.remove(orderForm);
		}
	}

	/**
	 * Dispatches an order when given the OrderID, setting the dispatched status
	 * to true and sending the order to Accounts.
	 **/
	public void dispatchOrder(int orderID) {
		CustomerOrder customerOrder = (CustomerOrder) getOrder(orderID);
		customerOrder.setDispatched(true);
		accounts.addTo(customerOrder);
		System.out.println("Order no." + orderID + " has been dispatched");
	}

	/** Retrieves and returns a Customer Order using the given OrderFormID **/
	public CustomerOrder retrieveCO(int orderFormId) {

		CustomerOrder retrieved = null;

		for (Order order : orders) {
			if (order instanceof CustomerOrder) {
				if (orderFormId == ((CustomerOrder) order).getOrderFormID()) {
					retrieved = (CustomerOrder) order;
					break;
				}
			}
		}
		return retrieved;
	}

}
