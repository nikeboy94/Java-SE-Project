package warehouse;

public abstract class Product {
	
	private int productID;
	private int location;
	private String name;
	private boolean isReserved = false;
	private boolean isProtected = false;
	
	public Product(int productID, int location, String name){
		this.productID = productID;
		this.location = location;
		this.name = name;
	}
	
	public Product(String name, boolean isProtected) {
		this.name = name;
		this.isProtected = isProtected;
	}
	
	public String getName(){
		return name;
	}
	
	public int getProductID(){
		return productID;
	}
	
	public int getLocation(){
		return location;
	}

	public boolean getReserved(){
		return isReserved;
	}
	
	public boolean getProtected(){
		return isProtected;
	}

	//setters to set reservation state and protection
	
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}


	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}
	
	// set id, not tested
	public void setID(int productID) {
		this.productID = productID;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	
}
