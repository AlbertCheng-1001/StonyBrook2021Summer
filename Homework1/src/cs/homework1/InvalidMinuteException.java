package cs.homework1;

/**
 * 
 * Exception indicates minutes is below 0 and is a negative number.
 * 
 * Author Albert Cheng
 * AuthorID 113332562
 * Recitation R30
 */
public class InvalidMinuteException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidMinuteException() {

		super("Can not be less than 0 (negative)");
	}

}
