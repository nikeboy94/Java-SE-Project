package warehouse;

import java.util.ArrayList;

public class CriteriaNotInProgress implements Criteria {

	@Override
	public ArrayList<Order> meetCriteria(ArrayList<Order> orders) {
		ArrayList<Order> notInProgressList = new ArrayList<Order>();

		for (Order o : orders) {
			if (o instanceof CustomerOrder) {
				if (((CustomerOrder) o).getInProgress() == false) {
					notInProgressList.add(o);
				}
			}
		}
		return notInProgressList;
	}

	@Override
	public ArrayList<Product> meetCriteria2(ArrayList<Product> products) {
		return products;
	}

}
