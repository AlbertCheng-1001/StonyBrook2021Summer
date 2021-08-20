package cs.homework5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Folder creates an arraylist of emails including its name and the sorting
 * method
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class Mailbox implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Folder> folders;
	public static Mailbox mailbox;
	
	/**
	 * Default constructor which created inbox and 
	 * trash into a folder
	 */
	public Mailbox() {
		Folder inbox = new Folder("Inbox");
		Folder trash = new Folder("Trash");
		folders = new ArrayList<Folder>();
		folders.add(inbox);
		folders.add(trash);
	}

	/**
	 * Adds the given folder to the list of custom folders
	 * @param folder
	 * 		folder that wants to be added
	 */
	public void addFolder(Folder folder) {
		for (int i = 0; i < folders.size(); i++) {
			if (folders.get(i).getName().equals(folder.getName())) {
				System.out.println("Folder name already exist");
				return;
			}
		}
		folders.add(folder);
	}

	/**
	 * Removes the given folder from the list of custom folders
	 * @param name
	 * 		the name of the folder 
	 */
	public void deleteFolder(String name) {
		for (int i = 0; i < folders.size(); i++) {
			if (folders.get(i).getName().equals(name)) {
				folders.remove(i);
			}
		}
	}

	/**
	 * Gets user input on the contents of the email 
	 * and adds it to the inbox.
	 */
	public void composeEmail() { 
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter recipient (To): ");
		String to = scan.nextLine();
		System.out.println("");
		System.out.print("Enter carbon copy recipients (CC): ");
		String cc = scan.nextLine();
		System.out.println("");
		System.out.print("Enter blind carbon copy recipients (BCC): ");
		String bcc = scan.nextLine();
		System.out.println("");
		System.out.print("Enter subject line: ");
		String subject = scan.nextLine();
		System.out.println("");
		System.out.print("Enter body: ");
		String body = scan.nextLine();
		System.out.println("");
		System.out.println("Email successfully added to Inbox.");
		Email email = new Email(to, cc, bcc, subject, body);
		getInboxFolder().addEmail(email);
	}

	/**
	 * Moves the email to the trash
	 * @param email
	 * 		Which email to delete
	 */
	public void deleteEmail(Email email) {
		getTrashFolder().addEmail(email);
	}

	/**
	 * Removes all emails from the trash folder.
	 */
	public void clearTrash() {
		getTrashFolder().removeAllEmail();

	}

	/**
	 * Retrieves the trash folder
	 * @return
	 * 		the trash folder
	 */
	public Folder getTrashFolder() {
		return getFolder("Trash");
	}

	/**
	 * Retrieves the inbox folder
	 * @return
	 * 		the trash folder
	 */
	public Folder getInboxFolder() {
		return getFolder("Inbox");
	}

	/**
	 * Takes the given email and puts in in the given folder.
	 * @param email
	 * 		Moves an email to a folder
	 * @param target
	 * 		Which folder to be move the email to
	 */
	public void moveEmail(Email email, Folder target) {
		int check = 0;
		for (int i = 0; i < folders.size(); i++) {
			if (folders.get(i).getName().equals(target.getName())) {
				folders.get(i).addEmail(email);
				check = 1;
			}

		}
		if (check == 0) {
			getInboxFolder().addEmail(email);
		}
	}

	/**
	 * Takes the given email and puts in in the given 
	 * folder but in String.
	 * @param email
	 * 		Moves an email to a folder
	 * @param target
	 * 		String of the folders name
	 */
	public void moveEmail(Email email, String target) {
		Folder targetFolder = getFolder(target);
		if (targetFolder == null) {
			getInboxFolder().addEmail(email);
		} else {
			targetFolder.addEmail(email);
		}
	}

	/**
	 * Returns a folder by folder name.
	 * @param name
	 * 		Gets folder with the name
	 * @return
	 * 		Returns a folder by folder name.
	 */
	public Folder getFolder(String name) {
		for (int i = 0; i < folders.size(); i++) {
			if (folders.get(i).getName().equals(name)) {
				return folders.get(i);
			}
		}
		return null;
	}

	/**
	 * Prints folder that has the folderName
	 * @param folderName
	 * 		the folderName to print
	 */
	public void printFolder(String folderName) {
		Folder folder = getFolder(folderName);
		if (folder == null) {
			System.out.println("Folder does not exist");
			return;
		}
		folder.print();
	}

	/**
	 * Prints the subMenu for folders
	 */
	public static void printSubmenu() {
		System.out.println("");
		System.out.println("M – Move email");
		System.out.println("D – Delete email");
		System.out.println("V – View email contents");
		System.out.println("SA – Sort by subject line in ascending order");
		System.out.println("SD – Sort by subject line in descending order");
		System.out.println("DA – Sort by date in ascending order");
		System.out.println("DD – Sort by date in descending order");
		System.out.println("R – Return to mailbox");

	}

	/**
	 * Prints all the folders in the arraylist
	 */
	public void printAllFolders() {
		for (int i = 0; i < folders.size(); i++) {
			System.out.println(folders.get(i).getName());
		}
	}
	
	/**
	 * Reads the mailbox from file.
	 * @return
	 * 		Mailbox
	 */
	public static Mailbox readMailboxFromFile() {
		Mailbox box2 = null; 
		try {
		  FileInputStream   file = new FileInputStream("box1.obj");
		  ObjectInputStream fin  = new ObjectInputStream(file);
		  box2 = (Mailbox) fin.readObject();
		  file.close();

		} catch(IOException | ClassNotFoundException c){
			//c.printStackTrace();
		}
		return box2;
	}
	
	/**
	 * outputs the mailbox from file
	 * @param mailbox
	 * 		mailbox
	 */
	public static void writeMailboxtoFile(Mailbox mailbox) {
		try {
			  FileOutputStream   file = new FileOutputStream("mailbox.obj");
			  ObjectOutputStream fout = new ObjectOutputStream(file);
			  fout.writeObject(mailbox);
			  fout.close();
			} catch(IOException a) {
				a.printStackTrace();
			}
	}

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
			} catch (Exception e) {
				System.out.println("Must input integer");
			} finally {
				scan.nextLine();
			}
		}
		return a;
	}

	public static void main(String[] args) {
		mailbox = readMailboxFromFile();
		if (mailbox == null) {
			mailbox = new Mailbox();
		}
		Scanner scan = new Scanner(System.in);
		boolean keepRun = true;

		while (keepRun) {

			System.out.println("A – Add folder");
			System.out.println("R – Remove folder");
			System.out.println("C – Compose email");
			System.out.println("F – Open folder");
			System.out.println("I – Open Inbox");
			System.out.println("T – Open Trash");
			System.out.println("E - Empty Trash");
			System.out.println("Q - Quit");
			System.out.println("");
			System.out.print("Enter a user option: ");
			String menuInput = scan.nextLine();
			System.out.println("");
			if (menuInput.equals("A")) {
				System.out.print("Enter folder name: ");
				String folderName = scan.nextLine();
				System.out.println("");
				Folder newFolder = new Folder(folderName);
				mailbox.addFolder(newFolder);
			} else if (menuInput.equals("R")) {
				System.out.print("Enter a folder to remove");
				String folderRemove = scan.nextLine();
				System.out.println("");
				mailbox.deleteFolder(folderRemove);
			} else if (menuInput.equals("C")) {
				mailbox.composeEmail();

			} else if (menuInput.equals("F")) {
				System.out.print("Enter folder name: ");
				String folderName = scan.nextLine();
				System.out.println("");
				// PRINT ALL EMAILS IN THAT FOLDER

				mailbox.printFolder(folderName);
				boolean submenu = true;

				while (submenu) {
					Folder print = mailbox.getFolder(folderName);
					// print.printEmails();
					printSubmenu();
					System.out.println("");
					System.out.print("Enter a user option: ");
					String inputF = scan.nextLine();
					if (inputF.equals("M")) {
						System.out.println("");
						int index = readInt("Enter the index of the email to move: ", scan);
						Folder source = mailbox.getFolder(folderName);
						Email email = source.removeEmail(index);
						System.out.println("");
						System.out.println("Folders:");
						mailbox.printAllFolders();
						System.out.println("");
						System.out.print("Select a folder to move " + "\"" + email.getSubject() + "\"" + " to: ");
						String destination = scan.nextLine();
						System.out.println("");
						mailbox.moveEmail(email, destination);
						System.out.println("\"" + email.getSubject() + "\"" + " succesfully moved to " + destination);
						source.print();

					} else if (inputF.equals("D")) {
						System.out.println("");
						int index = readInt("Enter email index: ", scan);
						Folder source = mailbox.getFolder(folderName);
						Email email = source.removeEmail(index);
						System.out.println("");
						System.out.println(
								"\"" + email.getSubject() + "\"" + " has successfully been moved to the trash");
						System.out.println("");
						System.out.println(folderName);
						mailbox.moveEmail(email, mailbox.getTrashFolder());
						source.print();
					} else if (inputF.equals("V")) {
						System.out.println("");
						int index = readInt("Enter email index: ", scan);
						index -= 1;
						System.out.println("");
						Folder source = mailbox.getFolder(folderName);
						Email email = source.getEmail(index);
						System.out.println("To: " + email.getTo());
						System.out.println("CC: " + email.getCc());
						System.out.println("BCC: " + email.getBcc());
						System.out.println("Subject: " + email.getSubject());
						System.out.println("This is a test of the mailbox program!");
						System.out.println("");
						System.out.println(folderName);
						System.out.println("");
						source.printEmails();

					} else if (inputF.equals("SA")) {
						Folder source = mailbox.getFolder(folderName);
						source.sortBySubjectAscending();

					} else if (inputF.equals("SD")) {
						Folder source = mailbox.getFolder(folderName);
						source.sortBySubjectDescending();
					} else if (inputF.equals("DA")) {
						Folder source = mailbox.getFolder(folderName);
						source.sortByDateAscending();
					} else if (inputF.equals("DD")) {
						Folder source = mailbox.getFolder(folderName);
						source.sortByDateDescending();
					} else if (inputF.equals("R")) {
						submenu = false;
						System.out.println("");
						System.out.println("Mailbox");
						System.out.println("---------");
						mailbox.printAllFolders();
					}

				}

			} else if (menuInput.equals("I")) {
				System.out.println("");
				mailbox.printFolder("Inbox");
				boolean inboxSub = true;
				while (inboxSub) {
					Folder print = mailbox.getFolder("Inbox");
					// print.printEmails();

					printSubmenu();

					System.out.println("");
					System.out.print("Enter a user option: ");
					String inputF = scan.nextLine();
					if (inputF.equals("M")) {
						System.out.println("");
						int index = readInt("Enter the index of the email to move: ", scan);
						index -= 1;
						Folder source = mailbox.getFolder("Inbox");
						Email email = source.removeEmail(index);
						System.out.println("");
						System.out.println("Folders:");
						mailbox.printAllFolders();
						System.out.println("");
						System.out.print("Select a folder to move " + "\"" + email.getSubject() + "\"" + " to: ");
						String destination = scan.nextLine();
						System.out.println("");
						mailbox.moveEmail(email, destination);
						System.out.println("\"" + email.getSubject() + "\"" + " succesfully moved to " + destination);
						source.print();

					} else if (inputF.equals("D")) {
						System.out.println("");
						int index = readInt("Enter email index: ", scan);
						index -= 1;
						Folder source = mailbox.getFolder("Inbox");
						Email email = source.removeEmail(index);
						System.out.println("");
						System.out.println(
								"\"" + email.getSubject() + "\"" + " has successfully been moved to the trash");
						System.out.println("");
						mailbox.moveEmail(email, mailbox.getTrashFolder());
						source.print();
					} else if (inputF.equals("V")) {
						System.out.println("");
						int index = readInt("Enter email index: ", scan);
						index -= 1;
						System.out.println("");
						Folder source = mailbox.getFolder("Inbox");
						Email email = source.getEmail(index);
						System.out.println("To: " + email.getTo());
						System.out.println("CC: " + email.getCc());
						System.out.println("BCC: " + email.getBcc());
						System.out.println("Subject: " + email.getSubject());
						System.out.println("This is a test of the mailbox program!");
						System.out.println("");
						System.out.println("Inbox");
						System.out.println("");
						source.printEmails();

					} else if (inputF.equals("SA")) {
						Folder source = mailbox.getFolder("Inbox");
						source.sortBySubjectAscending();

					} else if (inputF.equals("SD")) {
						Folder source = mailbox.getFolder("Inbox");
						source.sortBySubjectDescending();
					} else if (inputF.equals("DA")) {
						Folder source = mailbox.getFolder("Inbox");
						source.sortByDateAscending();
					} else if (inputF.equals("DD")) {
						Folder source = mailbox.getFolder("Inbox");
						source.sortByDateDescending();
					} else if (inputF.equals("R")) {
						inboxSub = false;
						System.out.println("");
						System.out.println("Mailbox");
						System.out.println("---------");
						mailbox.printAllFolders();
					}
				}

			} else if (menuInput.equals("T")) {
				boolean trashMenu = true;
				System.out.println("");
				mailbox.printFolder("Trash");
				while (trashMenu) {
					Folder print = mailbox.getFolder("Trash");
					// print.printEmails();
					printSubmenu();
					System.out.println("");
					System.out.print("Enter a user option: ");
					String inputF = scan.nextLine();
					if (inputF.equals("M")) {
						System.out.println("");
						int index = readInt("Enter the index of the email to move: ", scan);
						index -= 1;
						Folder source = mailbox.getFolder("Trash");
						Email email = source.removeEmail(index);
						System.out.println("");
						System.out.println("Folders:");
						mailbox.printAllFolders();
						System.out.println("");
						System.out.print("Select a folder to move " + "\"" + email.getSubject() + "\"" + " to: ");
						String destination = scan.nextLine();
						System.out.println("");
						mailbox.moveEmail(email, destination);
						System.out.println("\"" + email.getSubject() + "\"" + " succesfully moved to " + destination);
						source.print();

					} else if (inputF.equals("D")) {
						System.out.println("");
						int index = readInt("Enter email index: ", scan);
						index -= 1;
						Folder source = mailbox.getFolder("Trash");
						Email email = source.removeEmail(index);
						System.out.println("");
						System.out.println(
								"\"" + email.getSubject() + "\"" + " has successfully been moved to the trash");
						System.out.println("");
						System.out.println("Trash");
						mailbox.moveEmail(email, mailbox.getTrashFolder());
						source.print();
					} else if (inputF.equals("V")) {
						System.out.println("");
						int index = readInt("Enter email index: ", scan);
						index -= 1;
						System.out.println("");
						Folder source = mailbox.getFolder("Trash");
						Email email = source.getEmail(index);
						System.out.println("To: " + email.getTo());
						System.out.println("CC: " + email.getCc());
						System.out.println("BCC: " + email.getBcc());
						System.out.println("Subject: " + email.getSubject());
						System.out.println("This is a test of the mailbox program!");
						System.out.println("");
						System.out.println("Trash");
						System.out.println("");
						source.printEmails();

					} else if (inputF.equals("SA")) {
						Folder source = mailbox.getFolder("Trash");
						source.sortBySubjectAscending();

					} else if (inputF.equals("SD")) {
						Folder source = mailbox.getFolder("Trash");
						source.sortBySubjectDescending();
					} else if (inputF.equals("DA")) {
						Folder source = mailbox.getFolder("Trash");
						source.sortByDateAscending();
					} else if (inputF.equals("DD")) {
						Folder source = mailbox.getFolder("Trash");
						source.sortByDateDescending();
					} else if (inputF.equals("R")) {
						trashMenu = false;
						System.out.println("");
						System.out.println("Mailbox");
						System.out.println("---------");
						mailbox.printAllFolders();
					}
				}

			} else if (menuInput.equals("E")) {
				Folder source = mailbox.getFolder("Trash");
				source.removeAllEmail();
				;

			} else if (menuInput.equals("Q")) {
				keepRun = false;
			}

		}
	}

}
