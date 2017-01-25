package warehouse;

public class Customer {
	
	private int customerID;
	private String name;
	private String address;
	private String email;
	private String phone;

	public Customer(int customerID, String name, String address, String email, String phone) {
		this.customerID = customerID;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
