package graphicsInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import warehouse.*;

public class SwingAppGUI extends JFrame {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JPanel controlPanel;
	private JPanel ordersPanel;
	private JPanel stockPanel;
	private JPanel parentPanel;
	private JPanel addToStockPanel;
	private JPanel removeFromStockPanel;
	private JButton homeButton;
	private InventorySystem iMS;

	public SwingAppGUI() {

		prepareGUI();
		iMS = new InventorySystem();
		Gnome tails = new Gnome(1, 1, "Tails Miles Prower", "orange");
		Gnome eggman = new Gnome(2, 2, "Dr Ivo Robotnik", "red");
		DogStatue knuckles = new DogStatue(3, 3, "Knuckles the Dogechidna",
				"Such Master Emerald");
		DogStatue sonic = new DogStatue(4, 2, "Sonic the Hedgedoge", "Wow RINGS");
		iMS.addTo(tails);
		iMS.addTo(eggman);
		iMS.addTo(knuckles);
		iMS.addTo(sonic);
		iMS.addTo(new PurchaseOrder(true));
		iMS.addTo(new OrderForm(1, 1));

	}

	/** Sets up the frame and its contents, then displays it**/
	private void prepareGUI() {
		mainFrame = new JFrame("NB Main Menu Gardens");
		homeButton = new JButton("Home");

		mainFrame.setSize(1024, 768);
		mainFrame.setLayout(new GridBagLayout());
		GridBagConstraints constraints1 = new GridBagConstraints();
		GridBagConstraints constraints2 = new GridBagConstraints();

		headerLabel = new JLabel("", JLabel.CENTER);
		constraints1.fill = GridBagConstraints.HORIZONTAL;
		constraints1.weightx = 1;
		constraints1.weighty = 1;
		constraints1.gridx = 0;
		constraints1.gridy = 0;

		parentPanel = new JPanel();
		constraints2.fill = GridBagConstraints.BOTH;
		constraints2.weightx = 1;
		constraints2.weighty = 5;
		constraints2.gridx = 0;
		constraints2.gridy = 1;

		ordersPanel = new JPanel();
		stockPanel = new JPanel();

		mainFrame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}

		});

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel, constraints1);
		parentPanel.add(controlPanel);
		parentPanel.add(homeButton);
		mainFrame.add(new JScrollPane(parentPanel), constraints2);

		mainFrame.setVisible(true);

	}

	/** Returns to the home page **/
	private void homeGUI() {
		parentPanel.removeAll();
		parentPanel.add(controlPanel);
		parentPanel.add(homeButton);
		parentPanel.revalidate();

	}

	/** Sets up the panel used for the orders and adds to the frame **/
	private void ordersGUI() {
		ordersPanel = new JPanel();

		ordersPanel.setSize(1024, 768);
		ordersPanel.setLayout(new GridLayout(3, 3));

		//JButton display = new JButton("Display");

		parentPanel.remove(controlPanel);
		parentPanel.add(ordersPanel);
		parentPanel.revalidate();

	}

	/** Sets up the panel used for stock**/
	private void stockGUI() {
		stockPanel = new JPanel();

		stockPanel.setSize(1024, 768);
		stockPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		GridBagConstraints moreConstraints = new GridBagConstraints();

		JButton addButton = new JButton("Add");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weighty = 0;
		constraints.gridx = 0;
		constraints.gridy = 1;
		stockPanel.add(addButton, constraints);

		JButton removeButton = new JButton("Remove");
		moreConstraints.fill = GridBagConstraints.HORIZONTAL;
		moreConstraints.weighty = 0;
		moreConstraints.gridx = 1;
		moreConstraints.gridy = 1;
		stockPanel.add(removeButton, moreConstraints);

		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String command = ae.getActionCommand();
				switch (command) {
				case "Add":
					// go to AddToStock panel
					addToStockGUI();
					break;

				case "Remove":

					// go to Remove Panel
					removeFromStockGUI();
					break;

				}
			}
		};

		addButton.setActionCommand("Add");
		addButton.addActionListener(al);

		removeButton.setActionCommand("Remove");
		removeButton.addActionListener(al);

		parentPanel.remove(controlPanel);
		parentPanel.add(stockPanel);
		parentPanel.revalidate();

	}

	/** Constructs the panel which contains the form to add a product to inventory.**/
	private void addToStockGUI() {

		JButton ok = new JButton("OK");

		// labels and inputs for the form
		JLabel l1 = new JLabel("Product ID: ");
		JLabel l2 = new JLabel("Type: ");
		JLabel l3 = new JLabel("Location: ");
		JLabel l4 = new JLabel("Name: ");
		JLabel l5 = new JLabel("Colour: ");
		JLabel l6 = new JLabel("Meme: ");

		JTextField tf1 = new JTextField(20);
		JTextField tf2 = new JTextField(20);
		JTextField tf3 = new JTextField(20);
		JTextField tf4 = new JTextField(20);
		JTextField tf5 = new JTextField(20);
		JTextField tf6 = new JTextField(20);

		l1.setLabelFor(tf1);
		l2.setLabelFor(tf2);
		l3.setLabelFor(tf3);
		l4.setLabelFor(tf4);
		l5.setLabelFor(tf5);
		l6.setLabelFor(tf6);

		// add labels and text fields to the panel
		addToStockPanel = new JPanel();
		addToStockPanel.setSize(1024, 768);
		addToStockPanel.setLayout(new GridLayout(7, 2));

		addToStockPanel.add(l1);
		addToStockPanel.add(tf1);
		addToStockPanel.add(l2);
		addToStockPanel.add(tf2);
		addToStockPanel.add(l3);
		addToStockPanel.add(tf3);
		addToStockPanel.add(l4);
		addToStockPanel.add(tf4);
		addToStockPanel.add(l5);
		addToStockPanel.add(tf5);
		addToStockPanel.add(l6);
		addToStockPanel.add(tf6);

		// action listener for submitting the information and adding to the stock
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String command = ae.getActionCommand();
				switch (command) {
				case "OK":
					// Add the product to stock and return to previous panel
					if (tf2.getText().equals("Gnome")) {
						try {
							iMS.addTo(new Gnome(Integer.valueOf(tf1.getText()),
									Integer.valueOf(tf3.getText()), tf4
											.getText(), tf5.getText()));
						} catch (NumberFormatException e) {
							System.out.println("Please insert a number");
						}
					} else if (tf2.getText().equals("Doge")) {
						try {
							iMS.addTo(new DogStatue(Integer.valueOf(tf1.getText()),
									Integer.valueOf(tf3.getText()), tf4
											.getText(), tf6.getText()));
							System.out.println("Doge has been activated");
						} catch (NumberFormatException e) {
							System.out.println("please insert numerics");
						}
					} else {
						System.out.println("Type not right");
					}
					parentPanel.remove(addToStockPanel);
					homeGUI();
					stockGUI();
					displayStock(iMS.getStock());
					break;
				}
			}
		};

		addToStockPanel.add(ok);

		ok.setActionCommand("OK");
		ok.addActionListener(a);

		// add everything to panel and make visible
		parentPanel.remove(stockPanel);
		parentPanel.add(addToStockPanel);
		parentPanel.revalidate();

	}

	/** Construct the panel which contains a field for removing products via their ProductID.**/
	private void removeFromStockGUI() {

		JButton ok = new JButton("OK");

		JLabel l1 = new JLabel("Product ID: ");
		JTextField tf1 = new JTextField(20);

		l1.setLabelFor(tf1);

		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String command = ae.getActionCommand();
				switch (command) {
				case "OK":
					try {
						iMS.removeFrom(Integer.valueOf(tf1.getText()));
						parentPanel.remove(removeFromStockPanel);
						homeGUI();
						stockGUI();
						displayStock(iMS.getStock());
					} catch (NumberFormatException e) {
						System.out
								.println("Pls enter a number :'(, it hurts when you don't");

					}

					break;
				}
			}
		};

		removeFromStockPanel = new JPanel();
		removeFromStockPanel.setSize(1024, 768);
		removeFromStockPanel.setLayout(new GridLayout(3, 3));

		removeFromStockPanel.add(l1);
		removeFromStockPanel.add(tf1);
		removeFromStockPanel.add(ok);

		ok.setActionCommand("OK");
		ok.addActionListener(a);

		parentPanel.remove(stockPanel);
		parentPanel.add(removeFromStockPanel);
		parentPanel.revalidate();

	}

	/** Sets up the contents of the home page**/
	private void showEvent() {
		headerLabel.setText("NB Gardens System pls use responsibly, ok ty :)");

		JButton ordersButton = new JButton("Orders");
		JButton stockButton = new JButton("Stock");

		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String command = ae.getActionCommand();
				switch (command) {
				case "Orders":
					// go to orders panel
					ordersGUI();
					displayOrders(iMS.getOrders());
					break;

				case "Stock":
					// go to stock panel
					stockGUI();
					displayStock(iMS.getStock());
					break;

				case "Home":
					// go to home panel
					homeGUI();
					break;
				}
			}
		};

		ordersButton.setActionCommand("Orders");
		stockButton.setActionCommand("Stock");
		homeButton.setActionCommand("Home");

		ordersButton.addActionListener(a);
		stockButton.addActionListener(a);
		homeButton.addActionListener(a);

		controlPanel.add(ordersButton);
		controlPanel.add(stockButton);
		mainFrame.setVisible(true);
	}

	/** Creates a table that displays all of the stock information, and adds it to the relevant panel.**/
	public void displayStock(ArrayList<Product> aName) {

		DefaultTableModel m = new DefaultTableModel();
		JTable table = new JTable(m);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;

		stockPanel.add(new JScrollPane(table), constraints);

		m.addColumn("ProductID");
		m.addColumn("Product Type");
		m.addColumn("Location");
		m.addColumn("Name");
		m.addColumn("Colour");
		m.addColumn("Meme");

		for (Product p : aName) {

			String type = "Nothing so farrrrrrr";
			String colour = "N/A";
			String meme = "N/A";

			if (p instanceof Gnome) {
				type = "Gnome";
				colour = ((Gnome) p).getColour();
			} else {
				type = "Doge";
				meme = ((DogStatue) p).getMeme();
			}
			m.addRow(new String[] { String.valueOf(p.getProductID()), type,
					String.valueOf(p.getLocation()), p.getName(), colour, meme });
		}

	}

	/** Creates a table which displays all of the information on the orders and adds 
	 * it to the relevant panel.**/
	public void displayOrders(ArrayList<Order> orderList) {

		DefaultTableModel m = new DefaultTableModel();
		JTable rowOne = new JTable(m);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;

		ordersPanel.add(new JScrollPane(rowOne), constraints);

		m.addColumn("OrderID");
		m.addColumn("Order Type");
		m.addColumn("Received");
		m.addColumn("CustomerID");
		m.addColumn("OrderForm ID");
		m.addColumn("In Progress?");
		m.addColumn("Worker ID");
		m.addColumn("Completed?");
		m.addColumn("Dispatched");

		for (Order o : orderList) {

			String type = "";
			String received = "N/A";
			String customerID = "N/A";
			String orderFormID = "N/A";
			String inProgress = "N/A";
			String workerID = "N/A";
			String completed = "N/A";
			String dispatched = "N/A";

			if (o instanceof PurchaseOrder) {
				type = "Purchase";
				received = String.valueOf(((PurchaseOrder) o).getReceived());

			} else if (o instanceof OrderForm) {
				type = "OrderForm";
				customerID = String.valueOf(((OrderForm) o).getCustomerID());
				orderFormID = String.valueOf(((OrderForm) o).getOrderFormID());
			} else {
				type = "CustomerOrder";
				customerID = String.valueOf(((CustomerOrder) o).getCustomerID());
				orderFormID = String.valueOf(((CustomerOrder) o).getOrderFormID());
				inProgress = String.valueOf(((CustomerOrder) o).getInProgress());
				workerID = String.valueOf(((CustomerOrder) o).getWorkerID());
				completed = String.valueOf(((CustomerOrder) o).getCompleted());
				dispatched = String.valueOf(((CustomerOrder) o).getDispatched());
			}
			m.addRow(new String[] { String.valueOf(o.getOrderID()), type, received,
					customerID, orderFormID, inProgress, workerID, completed,
					dispatched });
		}

	}

	// temporarily added to quickly run the code, delete later
	public static void main(String[] args) {

		SwingAppGUI sD = new SwingAppGUI();
		sD.showEvent();

	}

}
