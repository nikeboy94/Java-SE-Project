package warehouse;

public interface EditList {

	void addTo(Order order);

	void addTo(Product product);
	
	void removeFrom(int ID);
	
}
