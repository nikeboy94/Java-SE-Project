package warehouse;

import java.util.ArrayList;

public abstract class Order implements EditList {
	
	private ArrayList<Product> contents;
	private int orderID;
	private static int count = 1;
	
	public Order(){
		this.orderID = count;
		count++;
		contents = new ArrayList<>();
	}
	
	public ArrayList<Product> getContents() {
		return contents;
	}

	public int getOrderID() {
		return orderID;
	}
	
	@Override
	public void addTo(Order order) {
		
	}
	
	/** Adds a given product to the contents of the order.**/
	@Override
	public void addTo(Product product) {
		contents.add(product);
		System.out.println("Product " + product.getName() +" has been added to order");
	}
	
	/** Removes a product from the order contents using its ProductID**/
	@Override
	public void removeFrom(int productID) {
		
		for(Product product : contents) {
			
			if(product.getProductID() == productID) {
				contents.remove(product);
				System.out.println("Product " + product.getName() +" has been removed from the order");
				break;
			}
			
		}
	}
}

