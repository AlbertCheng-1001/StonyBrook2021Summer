package cs.homework3;
/**
 * A simulation class to create a simulator of single or multiple elevators reaching its source/destination floor
 * 
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class Simulator {
	/**
	 * Simulator which makes elevators and puts them in an array which then takes the request 
	 * and moves to the desired source/destination floor
	 * @param probability
	 * 		Probability set from user input to see the chances of request being added
	 * @param totalFloors
	 * 		totalFloors set from user input to see the total floors and gives the range of the destination/source floor
	 * @param totalElevators
	 * 		totalElevators the amount of elevators in a array 
	 * @param length
	 * 		The length of how long the simulator will run for
	 */
	public static void simulate(double probability, int totalFloors, int totalElevators, int length ) {
		int totalWaitTime = 0;
		int totalRequest = 0;
		double averwageWait = 0;
		
		RequestQueue queue = new RequestQueue();
		BooleanSource source = new BooleanSource(probability);
		Elevator[] elevators = new Elevator[totalElevators];
		
		for (int i = 0; i < elevators.length; i++) {
			elevators[i] = new Elevator();	
		}
		
		for (int current = 1; current <= length; current++) {

			if(source.requestArrived()) {
				Request request = new Request(totalFloors);
				request.setTimeEntered(current);
				//System.out.println("request added: " + request);
				queue.enqueue(request);	
			}
			
			for (int i = 0; i < totalElevators; i++) {
				if(elevators[i].getElevatorState() == Elevator.IDLE && !queue.isEmpty()) {		
					Request request = queue.dequeue();
					elevators[i].setRequest(request);
					elevators[i].setElevatorState(Elevator.TO_SOURCE);		
				}
				
				else if(elevators[i].getElevatorState() == Elevator.TO_SOURCE) {
					//GO_SOURCE
					if(elevators[i].getRequest().getSourceFloor() < elevators[i].getCurrentFloor()) {
						elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() - 1);
					}
					else if(elevators[i].getRequest().getSourceFloor() > elevators[i].getCurrentFloor())
					{
						elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() + 1);
					}
					
					else //(elevators[i].getRequest().getSourceFloor() == elevators[i].getCurrentFloor()) {
					{
						elevators[i].setElevatorState(Elevator.TO_DESTINATION);
						elevators[i].setCurrentFloor(elevators[i].getRequest().getSourceFloor());
						Request request = elevators[i].getRequest();
						
						int requestWaitTime = current - request.getTimeEntered();
						//System.out.println(request.toString());
						//System.out.println("Current: " + current);
						//System.out.println("Request time: " + request.getTimeEntered());
						//System.out.println(request);
						totalWaitTime += requestWaitTime;
						totalRequest += 1;
					
					} 
				}
				else if(elevators[i].getElevatorState() == Elevator.TO_DESTINATION) {
					if(elevators[i].getRequest().getDestinationFloor() < elevators[i].getCurrentFloor()) {
						elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() - 1);
					}
					else if(elevators[i].getRequest().getDestinationFloor() > elevators[i].getCurrentFloor()) {
						elevators[i].setCurrentFloor(elevators[i].getCurrentFloor() + 1);
					}
					else {
						elevators[i].setElevatorState(Elevator.IDLE);
						elevators[i].setRequest(null);
					}
				}
		}
	}
		System.out.println("Total Wait Time: " + totalWaitTime);
		System.out.println("Total Requests: " + totalRequest);
		double average = (double)totalWaitTime / totalRequest;
		String s = String.format("%.2f", average);
		System.out.println("Average Wait Time: " + s);
	}
}
