package cs.homework1;

/**
 * Comes up with the song to add in the PlayList. Including title, artist,
 * minutes, and seconds.
 * 
 * Author Albert Cheng
 * AuthorID 113332562
 * Recitation R30
 *
 */
public class SongRecord {

	private String title;
	private String artist;
	private int minutes;
	private int seconds;

	/**
	 * 
	 * @param title   
	 * 		Title of the SongRecord
	 * @param artist  
	 * 		Artist of the SongRecord
	 * @param minutes 
	 * 		Minutes of the SongRecord
	 * @param seconds 
	 * 		Seconds of the SongRecord
	 * @throws InvalidSecondException 
	 * 		Throws exception when seconds is greater than 60 or less than 0         
	 * @throws InvalidMinuteException 
	 * 		Throws exception when minutes is less than 0
	 */

	public SongRecord(String title, String artist, int minutes, int seconds) throws InvalidSecondException, InvalidMinuteException{
		setTitle(title);
		setArtist(artist);
		setMinutes(minutes);
		setSeconds(seconds);
	}

	/**
	 * Retrieves the title of the song
	 * 
	 * @return returns 
	 * 		the title of the song
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the song
	 * 
	 * @param title 
	 * 		title this song will be set to
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retrieves the artist of the song
	 * 
	 * @return 
	 * 		returns the artist of the song
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Sets the artist of the song
	 * 
	 * @param artist 
	 * 		artist this song will be set to
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Retrieves the seconds of the song
	 * 
	 * @return 
	 * 		returns the seconds of the song
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * Sets the seconds of the song
	 * 
	 * @param seconds 
	 * 		seconds this song will be set to
	 * @throws InvalidSecondException 
	 * 		Invalid song length. Seconds must be between 0 and 60 other throw INvalidSecondException
	 */
	public void setSeconds(int seconds) throws InvalidSecondException {
		if (seconds < 60 && seconds > 0) {
			this.seconds = seconds;
		} else {
			throw new InvalidSecondException();
		}

	}

	/**
	 * Retrieves the minutes of the song
	 * 
	 * @return 
	 * 		returns the minutes of the song
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * Sets the minutes of the song
	 * 
	 * @param minutes 
	 * 		minutes this song will be set to
	 * @throws InvalidMinuteException 
	 * 		Must be greater than 0 otherwise throw InvalidMinuteException
	 *                                throw InvalidMinuteException
	 */
	public void setMinutes(int minutes) throws InvalidMinuteException {
		if (minutes < 0) {
			throw new InvalidMinuteException();

		}
		this.minutes = minutes;
	}

	/**
	 * Returns the string representation of SongRecord
	 * 
	 * @return 
	 * 		Returns the string representation of SongRecord
	 */
	public String toString() {
		return String.format("%-26s%-26s%20d:%02d", this.getTitle(), this.getArtist(), this.getMinutes(),
				this.getSeconds());
	}

	/**
	 * Checks if 2 PlayList are equal to each other. Title, artist, minutes, and seconds.
	 * 
	 * @param obj
	 * 	Obj to be compared to 
	 * 
	 * @return
	 * Returns true if both SongRecord PlayList is equal
	 * Returns false if both PlayList are not equal.
	 */
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof SongRecord)) {
			return false;
		}
		
		SongRecord song = (SongRecord) obj;
		if (this.getTitle() == song.getTitle() && this.getArtist() == song.getArtist()
				&& this.getMinutes() == song.getMinutes() && this.getSeconds() == song.getSeconds()) {

			return true;

		} else {
			return false;
		}

	}

}