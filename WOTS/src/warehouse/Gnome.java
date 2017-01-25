package warehouse;

public class Gnome extends Product{
	
	private String colour;
	
	// constructor for products in warehouse
	public Gnome(int productID, int location, String name, String colour){
		super(productID, location, name);
		this.colour = colour;
	}
	
	// constructor for products requested by customer
	public Gnome(String name, String colour, boolean isProtected) {
		super(name, isProtected);
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

}
