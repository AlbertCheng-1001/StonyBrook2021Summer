package cs.homework3;

/**
 * Contains various information about a specific request that will be added to the queue
 * 
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class Request {
	private int sourceFloor;
	private int destinationFloor;
	private int timeEntered;

	
	/**
	 * Generates a random request with a given sourceFloor and destinationFloor
	 * @param totalFloor
	 * 		Gives the range of a random floor to be given
	 */
	
	public Request(int totalFloor) {
		sourceFloor = (int)(Math.random() * totalFloor + 1);
		destinationFloor = (int)(Math.random() * totalFloor + 1);
		
	}
	
	/**
	 * Retrieves the sourceFloor of the request
	 * @return
	 * 		the sourceFloor of the request
	 */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Sets the sourceFloor of the request
     * @param sourceFloor
     * 		sets sourceFloor of request
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * Retrieves the destinationFloor of the request
     * @return
     * 		the destinationFloor of request
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }
    
    /**
     * Sets the destinationFloor of the request
     * @param destinationFloor
     * 		Sets destinationFloor of request
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * Retrieves the timeEntered of the request
     * @return
     * 		the timeEntered of request
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * Sets the timeEntered of the request
     * @param timeEntered
     * 		Sets timeEntered of request
     */		
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
    
    /**
     * toString method to return request
     */
    public String toString() {
    	return String.format("(%d,%d,%d)", sourceFloor, destinationFloor, timeEntered);
    	
    }
    
    
    
}



	
	
	
	
	
	
	
	
	
	
	
	

