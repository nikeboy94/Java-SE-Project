package warehouse;

import java.util.ArrayList;

//Map is a 5x5 grid

public class Map {

	public Map() {
		
	}

	//converts a location number into a coordinate
	public int[] convertLocation(int location) {

		int x = 0;
		int y = 0;
		int[] array;
		x = location % 5;
		
		for (int c = 0; c <= 5; c++) {
			
			if (location > c * 5 && location <= (c + 1) * 5) {
				y = c + 1;
			}
		}
		
		array = new int[2];
		array[0] = x;
		array[1] = y;
		
		return array;
	}

	//converts a coordinate to a location number
	public int convertCoordinate(int[] coordinate) {

		int location = 0;
		location = coordinate[0] + (coordinate[1] - 1) * 5;
		
		return location;

	}

	//calculates the distance between two locations
	public int distanceCalc(int[] loc1, int[] loc2) {

		int xDistance = Math.abs(loc2[0] - loc1[0]);
		int yDistance = Math.abs(loc2[1] - loc1[1]);
		int totalDistance = xDistance + yDistance;

		return totalDistance;

	}

	//returns the index of closest product to the worker
	public int minDIndex(int[] locationDistance) {

		int minimum = 1000000000;
		int index = 0;

		for (int i = 0; i < locationDistance.length; i++) {

			if (locationDistance[i] < minimum) {

				minimum = locationDistance[i];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Worker location starts at (1,1) then finds shortest distance
	 * to next product. When worker moves to that location, their location
	 * is set to that item location and the item is removed from tempList.
	 * Then the system finds the next shortest item distance from the new
	 * worker location until there are no items on the list
	 */
	public ArrayList<Product> shortestPath(ArrayList<Product> customerOrder) {

		ArrayList<Product> tempList = customerOrder;
		ArrayList<Product> workerPath = new ArrayList<Product>();
		int[] workerLocation = { 1, 1 };


		while (tempList.size() > 0) {

			int[] locationDistances = new int[tempList.size()];
			int[] correspondingItems = new int[tempList.size()];
			int count = 0;
			int index;

			for (Product product : tempList) {
				locationDistances[count] = distanceCalc(workerLocation,
						convertLocation(product.getLocation()));
				correspondingItems[count] = product.getProductID();
				count++;
			}

			index = minDIndex(locationDistances);

			for (Product product : tempList) {
				if (product.getProductID() == correspondingItems[index]) {
					workerLocation = convertLocation(product.getLocation());
					workerPath.add(product);
					tempList.remove(product);
					break;
				}
			}
		}
		
		return workerPath;
	}

}
