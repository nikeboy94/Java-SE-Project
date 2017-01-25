package warehouse;

import java.sql.*;
import java.util.Scanner;

public class Database {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/nbwots?autoReconnect=true&useSSL=false";
	static final String USER = "admin";
	static final String PASS = "password";
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	InventorySystem inventory = new InventorySystem();
	private Scanner scan = new Scanner(System.in);

	/** Connects to SQL database**/
	public void accessDB() {
		 conn = null;
		 stmt = null;

		try {
			
			Class.forName(JDBC_DRIVER);
			
			// sort out connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// use the database ...
			System.out.println("Creating stock table...");
			stmt = conn.createStatement();
			
			// create table
			String sql = "create table if not exists stock (product_id int not null auto_increment, "
					+ "location int(2), type varchar(20) not null, name varchar(30), is_reserved bool default 0, "
					+ "is_protected bool default 0, colour varchar(20), meme varchar(50), primary key (product_id))";
			stmt.executeUpdate(sql);

			System.out.println("Table created");
			
			
			
			// now set up orders
			String sql4 = "create table if not exists orders (order_id int not null auto_increment, type varchar(20), "
					+ "purchase_order_id int, customer_order_id int, order_form_id int, worker_id int, received bool default 0, "
					+ "in_progress bool default 0, completed bool default 0, dispatched bool default 0, primary key (order_id))";
			
			stmt.executeUpdate(sql4);
			
			addStock();
			updateInventoryStock();
			
			inventory.displayContents(inventory.getStock());
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Closing connection ...");
				if (stmt != null) {
					stmt.close();
				} if (rs != null) {
					rs.close();
				}
			} catch (SQLException se2) {}
			
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}
		System.out.println("Goodbye!");
	}
	
	/** Adds a new product to the stock in the database**/
	public void addStock() throws SQLException {
		
		// add some products to the table
		System.out.println("What type of product would you like to add, Gnome or Dog Statue? ");
		String type = scan.nextLine();
		
		String sql2;
		
		// takes inputs from the user
		if (type.toLowerCase().equals("gnome")) {
			System.out.println("Location: ");
			int location = scan.nextInt();
			System.out.println("Name: ");
			String name = scan.next();
			System.out.println("Colour   : ");
			String colour = scan.next();
			
			sql2 = "insert into stock (location, type, name, colour) values (" + location + ", '" + type + "', '" + name + "', '" + colour + "')";
			stmt.executeUpdate(sql2);
		} 
		
	}
	
	/** Adds all data from the stock in the database to the list of stock in the inventory system**/
	public void updateInventoryStock() throws SQLException {
		
		String sql3 = "select * from stock";
		
		System.out.println("All products in stock: ");
		
		// retrieve information on stock from query, display on console and add to inventory
		ResultSet rs = stmt.executeQuery(sql3);
		while (rs.next()) {
			
			int id = rs.getInt("product_id");
			int location = rs.getInt("location");
			String type = rs.getString("type");
			String name = rs.getString("name");
			boolean isReserved = rs.getBoolean("is_reserved");
			boolean isProtected = rs.getBoolean("is_protected");
			String colour = rs.getString("colour");
			String meme = rs.getString("meme");
			
			System.out.println("ProductID: " + id + ", Location: " + location
					+ ", Name: " + name + ", isReserved: " + isReserved
					+ ", isProtected: " + isProtected + ", Colour: " + colour
					+ ", Meme: " + meme);
					
			// add the data read in to the stock array list in the inventory system
			if (type.toLowerCase().equals("gnome")) {
				Gnome g = new Gnome(id, location, name, colour);
				g.setReserved(isReserved);
				g.setProtected(isProtected);
				inventory.addTo(g);
					
			} else {
				DogStatue d = new DogStatue(id, location, name, meme);
				d.setReserved(isReserved);
				d.setProtected(isProtected);
				inventory.addTo(d);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Database db = new Database();
		db.accessDB();
	}
}
