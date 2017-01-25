package warehouse;

public class CustomerBuilder {

	private int customerID = 0;
	private String name = "";
	private String address = "";
	private String email = "";
	private String phone = "";
	
	public CustomerBuilder() {}
	
	public Customer buildCustomer() {
		return new Customer(customerID, name, address, email, phone);
	}
	
	public CustomerBuilder customerID(int _customerID) {
		this.customerID = _customerID;
		return this;
	}
	
	public CustomerBuilder name(String _name) {
		this.name = _name;
		return this;
	}
	
	public CustomerBuilder address(String _address) {
		this.address = _address;
		return this;
	}
	
	public CustomerBuilder email(String _email) {
		this.email = _email;
		return this;
	}
	
	public CustomerBuilder phone(String _phone) {
		this.phone = _phone;
		return this;
	}
	
}

