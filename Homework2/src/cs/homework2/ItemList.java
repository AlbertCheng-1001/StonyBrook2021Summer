package cs.homework2;

import java.math.BigInteger;

/**
 * Contains references to the head and tail of a list of ItemInfoNode nodes
 * Contains multiple methods to modify the list
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class ItemList {
	private ItemInfoNode head = null;
	private ItemInfoNode tail = null;

	public ItemList() {

	}

	/**
	 * Inserts the info into the list in its correct position based on rfidTagNumber
	 * @param name
	 * 		name of the node to be added to the list
	 * @param rfidTag
	 * 		rfidTagNumber of the node to be added to the list
	 * @param price
	 * 		price of the node to be added to the list
	 * @param initPosition
	 * 		OriginalLocation and currentLocation of the node to be added to the list
	 * @throws Exception
	 * 		Checks if info of the node is valid
	 */
	public void insertInfo(String name, String rfidTag, double price, String initPosition) throws Exception {
		boolean keepGoing = true;
		ItemInfo tmp = new ItemInfo(name, price, rfidTag, initPosition);
		ItemInfoNode node = new ItemInfoNode(tmp, null, null);

		if (head == null) {
			head = node;
			tail = node;
			return;
		}
		ItemInfoNode currentNode = tail;
		while (keepGoing) {
			String current = currentNode.getInfo().getRfidTagNumber();
			String place = node.getInfo().getRfidTagNumber();
			BigInteger currentInt = new BigInteger(current, 16);
			BigInteger placeInt = new BigInteger(place, 16);
			int less = currentInt.compareTo(placeInt);

			if (less == -1 || less == 0) {
				node.setPrev(currentNode);
				node.setNext(currentNode.getNext());
				ItemInfoNode next = currentNode.getNext();
				if (next != null) {
					next.setPrev(node);
				}

				currentNode.setNext(node);
				if (currentNode == tail) {
					tail = node;
				}
				keepGoing = false;

			} else {
				if (currentNode.getPrev() == null) {
					node.setPrev(null);
					node.setNext(currentNode);
					currentNode.setPrev(node);
					head = node;
					keepGoing = false;
				}
				currentNode = currentNode.getPrev();

			}
		}

	}

	/**
	 * Prints a neatly formatted list of all items currently in the list
	 */
	public void printAll() {
		ItemInfoNode current = head;
		printHeader();
		while (current != null) {
			System.out.println(current.getInfo().toString());
			current = current.getNext();
		}
	}

	/**
	 * Prints a neatly formatted list of all items in a specific rfidTagNumber
	 * As the parameter 
	 * @param rfidTag
	 * 		To see which nodes has the same rfidTagNumber 
	 */
	public void printByTagNumber(String rfidTag) {
		ItemInfoNode node = head;
		boolean keepGoing = true;
		while (keepGoing) {
			if (node.getInfo().getRfidTagNumber().equals(rfidTag)) {
				System.out.println(node.getInfo().toString());
			}
			if (node.getNext() == null) {
				keepGoing = false;
			}

			node = node.getNext();
		}
	}

	/**
	 * Prints a neatly formatted list of all items in a specific current location
	 * @param location
	 * 		To see which nodes has the same location
	 */
	public void printByLocation(String location) {
		ItemInfoNode node = head;
		boolean keepGoing = true;
		while (keepGoing) {
			if (node.getInfo().getCurrentLocation().equals(location)) {
				System.out.println(node.getInfo().toString());

			}
			if (node.getNext() == null) {
				keepGoing = false;
			}
			node = node.getNext();
		}

	}

	/**
	 * Moves an item with a given rfidTagNumber from a source location to a dest location
	 * @param rfidTag
	 * 		To check which node contains this specific rfidTagNumber
	 * @param source
	 * 		To check which node contains this specific source
	 * @param dest
	 * 		To change the node currentLocation with the same speicifc source to dest
	 * @return
	 * 		Indicates weather or not an item of the given rfidTagnumber was found at the given source location
	 */
	public boolean moveItem(String rfidTag, String source, String dest) { // NEED TO THROW EXCEPTION AND STUFF
		boolean keepGoing = true;
		ItemInfoNode node = head;
		while (keepGoing) {
			if (node.getInfo().getRfidTagNumber().equals(rfidTag)
					&& node.getInfo().getCurrentLocation().equals(source)) {
				node.getInfo().setCurrentLocation(dest);
				return true;

			}
			node = node.getNext();

			if (node == null) {
				keepGoing = false;

			}

		}
		return false;
	}

	/**
	 * Removes all nodes in the list that have currentLocation listed as "out" and 
	 * displays a list of all items that have been removed in this fashion
	 */
	public void removeAllPurchased() {
		boolean keepGoing = true;
		ItemInfoNode node = head;
		while (keepGoing) {

			if (node.getInfo().getCurrentLocation().equals("out")) {
				if (node.getPrev() == null) {
					System.out.println(node.getInfo().toString());
					node.getNext().setPrev(null);
					head = node.getNext();
				} else if (node.getNext() == null) {
					System.out.println(node.getInfo().toString());
					node.getPrev().setNext(null);
					keepGoing = false;
					tail = node.getPrev();
				} else {
					System.out.println(node.getInfo().toString());
					node.getPrev().setNext(node.getNext());
					node.getNext().setPrev(node.getPrev());
				}
			}
			if (node.getNext() == null) {
				keepGoing = false;
			} else {
				node = node.getNext();
			}

		}

		
	}

	/**
	 * Goes through a given cart and checks out each item and changes the location to "out".
	 * prints a neatly formatted list of the items checked out and is sorted by rfidTagNumber
	 * @param cartNumber
	 * 		Checks which nodes currentLocation is equal to cartNumber to change to "out"
	 * @return
	 * 		is the total cost for the items that were in the cart
	 * @throws Exception
	 * 		Exception for invalid cart number
	 */
	public double checkOut(String cartNumber) throws Exception {
		double cost = 0.00;
		ItemInfoNode node = head;
		boolean keepGoing = true;
		while (keepGoing) {

			if (node.getInfo().getCurrentLocation().equals(cartNumber)) {
				System.out.println(node.getInfo().toString());
				node.getInfo().setCurrentLocation("out");
				cost += node.getInfo().getPrice();

			}

			if (node.getNext() == null) {
				keepGoing = false;
			}
			node = node.getNext();
		}
		if (cost == 0.00) {
			throw new Exception("Invalid cart number");
		}

		return cost;
	}

	/**
	 * Take every item that is currently in the store and on the wrong shelf and places it back where it 
	 * belongs originalLocation
	 * @throws Exception
	 * 		Check if valid
	 */
	public void cleanStore() throws Exception {
		ItemInfoNode node = head;
		boolean keepRun = true;
		while (keepRun) {
			ItemInfo item = node.getInfo();
			String current = item.getCurrentLocation();
			if ((current.charAt(0) == 's' && (!current.equals(item.getOriginalLocation())))) {
				if (current.charAt(0) != 'o' && current.charAt(0) != 'c') {
					System.out.println(node.getInfo().toString());
					item.setCurrentLocation(item.getOriginalLocation());
				}
			}
			node = node.getNext();

			if (node == null) {
				keepRun = false;
			}

		}

	}

	/**
	 * Prints a neat header for the table of lists
	 */
	public void printHeader() {
		System.out.println("");
		System.out.println(
				String.format("%-21s%-21s%-21s%-21s%-21s", "Item Name", "RFID", "Original", "Current", "Price"));
		for (int i = 0; i <= 102; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}

}
