package warehouse;

import java.util.ArrayList;

public class CriteriaIsReserved implements Criteria{

	@Override
	public ArrayList<Order> meetCriteria(ArrayList<Order> orders) {
		return null;
	}

	@Override
	public ArrayList<Product> meetCriteria2(ArrayList<Product> products) {
		ArrayList<Product> isReservedList = new ArrayList<Product>();

		for (Product p : products) {

			if (p.getReserved() == true) {
				isReservedList.add(p);
			}

		}
		return isReservedList;
	}
	
	

}
