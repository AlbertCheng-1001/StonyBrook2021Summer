package cs.homework3;
/**
 * Runs the simulator and calls the methods. Takes in user input which is then taken to the simulator class
 * 
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
import java.util.Scanner;
public class Analyzer {

	public static void main(String args[]) {
		boolean keepGoing = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Elevator simulator!");

		System.out.println("");
		System.out.print("Please enter the probability of arrival for Requests: ");
		double probability = scan.nextDouble();
		while (keepGoing) {
			if (probability < 0 || probability > 1) {
				System.out.println("Probability must be between 0 and 1");
				System.out.print("Please enter the probability of arrival for Requests: ");
				probability = scan.nextDouble();
			} 
			else {
				keepGoing = false;
			}

		}
		boolean keepGoing1 = true;
		System.out.print("Please enter the number of floors: ");
		int totalFloors = scan.nextInt();
		while (keepGoing1) {
			if ( totalFloors <= 1) {
				System.out.println("total floors must be greater than 1");
				System.out.print("Please enter the number of floors: ");
				totalFloors = scan.nextInt();

			}
			else {
				keepGoing1 = false;
			}
		}
		
		boolean keepGoing2 = true;
		System.out.print("Please enter the number of elevators: ");
		int numElevators = scan.nextInt();
		while(keepGoing2) {
			if(numElevators <= 0) {
				System.out.println("number of elevators must be greater than 0 ");
				System.out.print("Please enter the number of elevators: ");
				numElevators = scan.nextInt();
			}
			else {
				keepGoing2 = false;
			}
		}

		boolean keepGoing3 = true;
		System.out.print("Please enter the length of the simulation (in time units): ");
		int length = scan.nextInt();
		while(keepGoing3) {
			if(length <= 0) {
				System.out.println("Length of simulation must be greater than 0 ");
				System.out.print("Please enter the length of the simulation (in time units): ");
				length = scan.nextInt();
			}
			else {
				keepGoing3 = false;
			}
		}
		Simulator.simulate(probability, totalFloors, numElevators, length);
	}
}
