package warehouse;

import java.util.ArrayList;

public interface Criteria {
	
	public ArrayList<Order> meetCriteria(ArrayList<Order> orders);
	
	public ArrayList<Product> meetCriteria2(ArrayList<Product> products);

}
