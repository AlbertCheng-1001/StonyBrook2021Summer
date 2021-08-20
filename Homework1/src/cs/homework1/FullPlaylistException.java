package cs.homework1;

/**
 * Exception indicates the PlayList is full and no songs could be added.
 * 
 * Author Albert Cheng
 * IDnumber 113332562
 * Recitation R30
 * 
 */
public class FullPlaylistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * returns an instance of FullPlaylistException
	 */
	public FullPlaylistException() {

		super("No more room inside the playlist to store new songrecord objects");
	}

}
