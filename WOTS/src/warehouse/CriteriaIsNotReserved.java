package warehouse;

import java.util.ArrayList;

public class CriteriaIsNotReserved implements Criteria{

	@Override
	public ArrayList<Order> meetCriteria(ArrayList<Order> orders) {
		return null;
	}

	/** Given a list of products, will sort through and return a sublist of products
	 * that fit the criteria of isReserved = false.**/
	@Override
	public ArrayList<Product> meetCriteria2(ArrayList<Product> products) {
		ArrayList<Product> isReservedList = new ArrayList<Product>();

		for (Product product : products) {

			if (product.getReserved() == false) {
				isReservedList.add(product);
			}

		}
		return isReservedList;
	}

}
