package cs.homework1;

import java.util.Scanner;

/**
 * Creates the menu prompt and allows user to select many operation for their
 * PlayList
 * 
 * Author Albert Cheng
 * AuthorID 113332562
 * Recitation R30
 * 
 */
public class PlaylistOperations {

	/**
	 * Help method that reads integers from standard input
	 * 
	 * @param text 
	 * 		Menu prompt
	 * @param scan 
	 * 		Scanner reads from standard input
	 * @return 
	 * 		returns user input integer
	 */
	public static int readInt(String text, Scanner scan) {
		boolean tryAgain = true;
		int a = -1;
		
		while (tryAgain) {
			System.out.print(text);
			try {
				a = scan.nextInt();
				tryAgain = false;
			}
			catch (Exception e) {
				System.out.println("Must input integer");
			}
			finally {
				scan.nextLine();				
			}
		}
		return a;
	}

	/**
	 * Print menu, reads user input, perform all operations.
	 * 
	 * @param args 
	 * 		not used
	 */
	public static void main(String[] args) {
		PlayList list = new PlayList();
		Scanner scan = new Scanner(System.in);
		boolean keepRun = true;
		while (keepRun) {
			System.out.println("A) Add Song");
			System.out.println("B) Pring Songs by Artist");
			System.out.println("G) Get Song");
			System.out.println("R) Remove Song");
			System.out.println("P) Print All Songs");
			System.out.println("S) Size");
			System.out.println("Q) Quit");
			System.out.println("");

			System.out.print("Select a menu option:");
			String menuInput = scan.nextLine();

			if (menuInput.equals("A") || menuInput.equals("a")) {
				System.out.print("Enter the song title:");
				String title = scan.nextLine();
				System.out.print("Enter the song artist:");
				String artist = scan.nextLine();
				int minutes = readInt("Enter the song length (minutes):", scan);
				int seconds = readInt("Enter the song length (seconds):", scan);
				int position = readInt("Enter the position:", scan);

				try {
					SongRecord songAdded = new SongRecord(title, artist, minutes, seconds);
					list.addSong(songAdded, position);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				System.out.println("");

			} else if (menuInput.equals("B") || menuInput.equals("b")) {
				System.out.print("Enter the artist:");
				String artist = scan.nextLine();
				PlayList.getSongsByArtist(list, artist);
				PlayList newplaylist = PlayList.getSongsByArtist(list, artist);
				newplaylist.printAllSongs();

			} else if (menuInput.equals("G") || menuInput.equals("g")) {
				int position = readInt("Enter the position:", scan);

				try {
					SongRecord song = list.getSong(position);
					list.printHeader();
					System.out.println(String.format("%-26d%s", position, song.toString()));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				System.out.println("");

			} else if (menuInput.equals("R") || menuInput.equals("r")) {
				int position = readInt("Enter the position:", scan);

				try {
					list.removeSong(position);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				System.out.println("");
			} else if (menuInput.equals("P") || menuInput.equals("p")) {
				list.printAllSongs();
			} else if (menuInput.equals("S") || menuInput.equals("s")) {
				list.size();
				System.out.println("There are " + list.size() + "(s) in the current playlist.");
				System.out.println("");
			} else if (menuInput.equals("Q") || menuInput.equals("q")) {
				keepRun = false;
				System.out.println("Program terminating normally...");
			}

		}
	}
}