package cs.homework1;

/**
 * Stores all SongRecord objects that belong to a particular PlayList.
 * SongRecord objects stored in an array
 * 
 * Author Albert Cheng
 * AuthorID 113332562
 * Recitation R30
 *
 */
public class PlayList implements Cloneable {
	private SongRecord songs[];
	private final int MAX = 50; // MAX IS 50
	private int count;

	/**
	 * Creates an instance of songs with a max length of 50
	 */
	public PlayList() { // constructor
		songs = new SongRecord[MAX];
	}

	/**
	 * Generates a copy of this PlayList
	 * 
	 * @return 
	 * 		A copy of this PlayList
	 */
	public Object clone() {
		PlayList copyplaylist = new PlayList();
		for (int i = 0; i < songs.length; i++) {
			try {
				copyplaylist.addSong(songs[i], i);
			} catch (Exception e) {
				throw new RuntimeException("", e);
			}
		}
		return copyplaylist;
	}

	/**
	 * Compare this PlayList to another object for equality
	 * 
	 * @param obj 
	 * 		an object in which the PlayList is compared
	 * @return 
	 * 		Returns true if it equals to obj
	 */
	public boolean equals(Object obj) { // could be wrong
		if (obj != null && obj instanceof PlayList) {
			PlayList anotherPlaylist = (PlayList) obj;

			for (int i = 0; i < songs.length; i++) {
				SongRecord mySong = getSong(i + 1);
				SongRecord yourSong = anotherPlaylist.getSong(i + 1);

				if (!mySong.equals(yourSong)) { // equal method in songRecord
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determines the number of SongRecords currently in this PlayList
	 * @return count The number of SongRecords in PlayList
	 */
	public int size() {
		return count;
	}

	/**
	 * Adds a SongRecord at the desired position in the PlayList
	 * @param song     
	 * 		New SongRecord object to add to PlayList
	 * @param position 
	 * 		Position of the PlayList where the song will be inserted
	 * @throws IllegalArgumentException 
	 * 		when position is greater than MAX or is not within the valid range
	 * @throws FullPlaylistException    
	 * 		No more room inside the PlayList to store new SongRecord objects.
	 */
	public void addSong(SongRecord song, int position) throws IllegalArgumentException, FullPlaylistException {
		if (count >= MAX) {
			throw new FullPlaylistException();
		}
		if (position > MAX) {
			throw new IllegalArgumentException("Position is not within valid range");
		}
		if (position >= 1 && position <= this.size() + 1) { // does this.size =
			for (int i = this.size() - 1; i >= position - 1; i--) {
				songs[i + 1] = songs[i]; // how are we accessing songs if its private

			}
			songs[position - 1] = song;
			count = count + 1;
			System.out.println("Song Added: " + song.getTitle() + " by " + song.getArtist());

		} else {
			System.out.println("Invalid position for adding the new song");
		}
	}

	/**
	 * Removes a song at a given position in the PlayList
	 * @param position 
	 * 		The position in the PlayList where the song will be removed
	 * @throws IllegalArgumentException 
	 * 		Indicates that the position is not within valid range
	 */
	public void removeSong(int position) throws IllegalArgumentException {
		if (position > MAX) {
			throw new IllegalArgumentException("Position is not within valid range");

		}
		if (position >= 1 && position <= this.size()) {
			for (int i = position - 1; i < this.size() - 1; i++) {
				songs[i] = songs[i + 1];
			}
			songs[count - 1] = null;

			count = count - 1;
			System.out.println("Song removed at position " + position);
		} else {
			System.out.println("No song at position " + position + " to remove");
		}
	}

	/**
	 * Get the SongRecord at the given position in this PlayList object
	 * @param position 
	 * 		The position of the SongRecord to retrieve
	 * @return 
	 * 		Returns the SongRecord at the specific position in this PlayList object
	 * @throws IllegalArgumentException 
	 * 		Position is not within valid range
	 */
	public SongRecord getSong(int position) throws IllegalArgumentException {

		if (position >= 1 && position <= this.size() && position <= MAX) {
			SongRecord song = songs[position - 1];
			// System.out.println(String.format("%-10d%-10s%-10s%d:%02d", position,
			// song.getTitle(), song.getArtist(), song.getMinutes(), song.getSeconds()));
			return song;

		} else {

			throw new IllegalArgumentException("Position is not within valid range");
		}
	}

	/**
	 * A method thats prints a formatted table of each SongRecord in the PlayList on
	 * its own line with its position number
	 */
	public void printAllSongs() {
		printHeader();
		for (int i = 0; i < songs.length; i++) {
			SongRecord song = songs[i];
			if (song != null) {
				System.out.println(String.format("%-25d%s", i + 1, song.toString()));

			}
		}
		System.out.println("");
	}

	/**
	 * Generates a new PlayList containing all SongRecords in the original PlayList
	 * performed by a special artist
	 * @param originalList 
	 * 		The original PlayList
	 * @param artist       
	 * 		The name of the artist
	 * @return 
	 * 		A new PlayList object containing all SongRecord in the original
	 *      PlayList performed by the special artist
	 */
	public static PlayList getSongsByArtist(PlayList originalList, String artist) {
		PlayList newList = new PlayList();
		for (int i = 1; i <= originalList.size(); i++) {
			SongRecord songInQuestion = originalList.getSong(i);
			if (songInQuestion.getArtist().equals(artist)) {
				newList.addSong(songInQuestion, newList.size() + 1);
			}
		}
		return newList;
	}

	/**
	 * Gets the string representation of this PlayList object
	 * @return 
	 * 		The string representation of this PlayList object
	 */
	private String dump() {
		String s = "";
		for (int i = 0; i < songs.length; i++) {
			SongRecord song = songs[i];
			if (song != null) {
				s = s + song.toString() + "\n";

			}
		}

		return s;
	}

	/**
	 * Gets the string representation of this PlayList object
	 * @return 
	 * 		The string representation of this PlayList object
	 */
	public String toString() {
		return dump();
	}

	/**
	 * Prints out the header for the table format
	 * 
	 */
	public void printHeader() {
		System.out.println("");
		System.out.println(String.format("%-25s%-26s%-26s%25s", "Song#", "Title", "Artist", "Length"));
		for (int i = 0; i <= 102 ; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
}