package cs.homework1;

/**
 * Exception indicates seconds is not within range of 0 and 60.
 * 
 * Author Albert Cheng
 * AuthorID 113332562
 * Recitation R30
 *
 */
public class InvalidSecondException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidSecondException() {

		super("Invalid song length.");

	}

}
