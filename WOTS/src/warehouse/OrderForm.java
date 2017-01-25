package warehouse;

public class OrderForm extends Order {

	// order of what a customer wants

	private int customerID;
	private int orderFormID;

	public OrderForm(int customerID, int orderFormID) {
		super();
		this.customerID = customerID;
		this.orderFormID = orderFormID;
	}

	public int getCustomerID() {
		return customerID;
	}
	
	public int getOrderFormID() {
		return orderFormID;
	}

	/** Removes a product from the order contents using its name, isProtected status and 
	 * colour/meme depending on the product type.**/
	public boolean removeProduct(String name, String other, boolean isProtected) {
		
		boolean isRemoved = false;
		
		for (Product product : getContents()) {
			if (product.getName() == name && product.getProtected() == isProtected) {
				if (product instanceof Gnome) {
					
					if (((Gnome) product).getColour() == other) {
						removeFrom(product.getProductID());
						isRemoved = true;
					}
				} else {
					if (((DogStatue) product).getMeme() == other) {
						removeFrom(product.getProductID());
						isRemoved = true;
					}
				}
				break;
			}
		}
		return isRemoved;
	}

}
