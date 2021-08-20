package cs.homework3;
/**
 * Creates an array of elevators to arrive at the source and destination floor of request
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class Elevator {
	private int currentFloor;
	private int elevatorState;
	private Request request;
	public static final int IDLE = -1;
	public static final int TO_SOURCE = 0;
	public static final int TO_DESTINATION = 1;

	/**
	 * Sets elevatorState to idle, CurrentFloor to 1 and request to null
	 */
	public Elevator() {
		request = null;
		setElevatorState(IDLE);
		setCurrentFloor(1);
	}

	/**
	 * Retrieves the currentFloor of the elevator
	 * @return
	 * 		the currentFloor of elevator
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}

	/**
	 * Sets the currentFloor of the elevator
	 * @param currentFloor
	 * 		sets the currentFloor of elevator
	 */
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	/**
	 * Retrieves the elevatorState of the elevator
	 * @return
	 * 		the elevatorState of the elevator
	 */
	public int getElevatorState() {
		return elevatorState;
	}

	/**
	 * Sets the elevatorState of the elevator
	 * @param elevatorState
	 * 		sets the elevatorState of the elevator
	 */
	public void setElevatorState(int elevatorState) {
		this.elevatorState = elevatorState;
	}

	/**
	 * Retrieves the request of the request class
	 * @return
	 * 		the request of the request class
	 */
	public Request getRequest() {
		return request;
	}

	/**
	 * Sets the request of the request class
	 * @param request
	 * 		sets the request of the request class
	 */
	public void setRequest(Request request) {
		this.request = request;
	}
	
	/**
	 * toString method to display the state and floor of the elevator 
	 */
	public String toString() {
		if (request != null) {
			return String.format("[%d   %d   %s]", this.getCurrentFloor(),this.getElevatorState(), request.toString());
		}
		return String.format("%-10d%-10d", this.getCurrentFloor(),this.getElevatorState());
	}

}
