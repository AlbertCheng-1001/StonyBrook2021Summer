package cs.homework2;

import java.util.Scanner;

/**
 * Creates the menu prompt and allows user to select many operations for their
 * list
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class DepartmentStore {

	/**
	 * Help method that reads double from standard input
	 * 
	 * @param text 
	 * 		Menu prompt
	 * @param scan 
	 * 		Scanner reads from standard input
	 * @return 
	 * 		returns user input double
	 */
	public static double readDouble(String text, Scanner scan) {
		boolean tryAgain = true;
		double a = -1.0;

		while (tryAgain) {
			System.out.print(text);
			try {
				a = scan.nextDouble();
				tryAgain = false;
			} catch (Exception e) {
				System.out.println("Must input double");
			} finally {
				scan.nextLine();
			}
		}
		return a;
	}


	/**
	 * Print menu, reads user input, performs all operations
	 * @param args
	 * 		not used
	 * @throws Exception
	 * 		Multiple Exception used to prevent other methods
	 */
	public static void main(String[] args) throws Exception {
		ItemList list = new ItemList();
		Scanner scan = new Scanner(System.in);
		boolean keepRun = true;
		System.out.println("Welcome!");

		while (keepRun) {
			System.out.println("");
			System.out.println("C - Clean store");
			System.out.println("I - Insert an item into the list");
			System.out.println("L - List by location");
			System.out.println("M - Move an item in the store");
			System.out.println("O - Checkout");
			System.out.println("P - Print all items in store");
			System.out.println("R - Print by RFID tag number");
			System.out.println("U - Update inventory system");
			System.out.println("Q - Exit the program.");
			System.out.println("");
			System.out.println("");
			System.out.print("Please select an option: ");
			String menuInput = scan.nextLine();
			if (menuInput.equals("C")) {
				System.out.println("");
				System.out.println("The following item(s) have been moved back to their original locations:");
				System.out.println("");
				list.printHeader();
				list.cleanStore();
				// list.cleanstore
			} else if (menuInput.equals("I")) {
				System.out.print("Enter the name: ");
				String name = scan.nextLine();
				System.out.print("Enter the RFID: ");
				String rfid = scan.nextLine();
				System.out.print("Enter the original location: ");
				String originalLocation = scan.nextLine();
				Double price = readDouble("Enter the price: ", scan);
				list.insertInfo(name, rfid, price, originalLocation);
			}

			else if (menuInput.equals("L")) {
				System.out.print("Enter the location: ");
				System.out.println("");
				System.out.println("");
				list.printHeader();
				String location = scan.nextLine();
				list.printByLocation(location);
				// get all songs with the same current location
			} else if (menuInput.equals("M")) {
				System.out.print("Enter the RFID: ");
				String rfid = scan.nextLine();
				System.out.print("Enter the original Location: ");
				String originalLocation = scan.nextLine();
				System.out.print("Enter the new location");
				String newLocation = scan.nextLine();
				list.moveItem(rfid, originalLocation, newLocation);
				// call moveitem method
			} else if (menuInput.equals("O")) {
				System.out.print("Enter the cart number");
				String cartNumber = scan.nextLine();
				// print menu with item names with the same current location
				list.printHeader();
				double price = list.checkOut(cartNumber);
				System.out.println("The total cost for all merchandise in cart " + cartNumber + " was " + "$" + price);// +
																														// price);
			} else if (menuInput.equals("P")) {
				list.printAll();
			} else if (menuInput.equals("U")) {
				System.out.println("");
				System.out.println("The following item(s) have removed from the system:");
				System.out.println("");
				list.printHeader();
				list.removeAllPurchased();
			} else if (menuInput.equals("R")) {
				System.out.print("Enter the location: ");
				String tag = scan.nextLine();
				System.out.println("");
				list.printHeader();
				list.printByTagNumber(tag);
			} else if (menuInput.equals("Q")) {
				keepRun = false;
				System.out.println("Goodbye!");
			}

		}

	}

}
