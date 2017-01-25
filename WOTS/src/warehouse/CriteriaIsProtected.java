package warehouse;

import java.util.ArrayList;

public class CriteriaIsProtected implements Criteria {

	@Override
	public ArrayList<Order> meetCriteria(ArrayList<Order> orders) {
		return orders;
	}

	@Override
	public ArrayList<Product> meetCriteria2(ArrayList<Product> products) {
		ArrayList<Product> isProtectedList = new ArrayList<Product>();

		for (Product p : products) {

			if (p.getProtected() == true) {
				isProtectedList.add(p);
			}

		}
		return isProtectedList;
	}

}
