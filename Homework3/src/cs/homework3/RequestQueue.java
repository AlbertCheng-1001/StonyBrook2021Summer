package cs.homework3;
/**
 * Contains request and adds it into the queue

 * 
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
import java.util.LinkedList;

public class RequestQueue extends LinkedList<Request> {

	/**
	 * Creates an empty linkedlist
	 */
	public RequestQueue() {
		super();
	}
	
	/**
	 * Adds request to the end of the list
	 * @param request
	 * 		Adds request to the end of the list
	 */
	public void enqueue(Request request) {
		this.add(request);

	}

	/**
	 * Removes the first request in the list
	 * @return
	 * 		Gets rid of the request thats first
	 */
	public Request dequeue() {
		return super.remove();
	}

	/**
	 * @return
	 * 		Returns the size of the list
	 */
	public int size() {
		return super.size();
	}

	/**
	 * @return
	 * Returns true or false if the list is empty or not
	 */
	public boolean isEmpty() {
		return super.isEmpty();
	}

}
