package warehouse;

import java.util.ArrayList;

public class CriteriaInProgress implements Criteria {

	/** Given a list of orders, will sort through and return a sublist of products 
	 * that fit the criteria, InProgress = true**/
	@Override
	public ArrayList<Order> meetCriteria(ArrayList<Order> orders) {
		ArrayList<Order> inProgressList = new ArrayList<Order>();

		for (Order order : orders) {
			if (order instanceof CustomerOrder) {
				if (((CustomerOrder) order).getInProgress() == true) {
					inProgressList.add(order);
				}
			}
		}
		return inProgressList;
	}
	
	@Override
	public ArrayList<Product> meetCriteria2(ArrayList<Product> products) {
		return products;
		}
}
