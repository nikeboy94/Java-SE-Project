package warehouse;

import java.util.ArrayList;

public class CriteriaIsNotProtected implements Criteria{
	
	@Override
	public ArrayList<Order> meetCriteria(ArrayList<Order> orders) {
		return orders;
	}

	/** Given a list of product, will sort through and return a sublist of products
	 * that have isProtected = false.**/
	@Override
	public ArrayList<Product> meetCriteria2(ArrayList<Product> products) {
		ArrayList<Product> isProtectedList = new ArrayList<Product>();

		for (Product product : products) {

			if (product.getProtected() == false) {
				isProtectedList.add(product);
			}

		}
		return isProtectedList;
	}

}
