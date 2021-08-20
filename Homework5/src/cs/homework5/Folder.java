package cs.homework5;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Folder creates an arraylist of emails including its name and the sorting
 * method
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */

public class Folder implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Email> emails;
	private String name;
	private String currentSortingMethod;
	public static final String DATE_DESC = "DD";
	public static final String DATE_ASCE = "DA";
	public static final String SUBJ_DESC = "SD";
	public static final String SUBJ_ASCE = "SA";

	public static class EmailCompareAscending implements Comparator<Email> {

		@Override
		public int compare(Email o1, Email o2) {
			return o1.getSubject().compareTo(o2.getSubject());

		}

	}

	public static class EmailCompareDescending implements Comparator<Email> {

		@Override
		public int compare(Email o1, Email o2) {
			return o1.getSubject().compareTo(o2.getSubject()) * -1;
		}
	}

	public static class EmailDateAscending implements Comparator<Email> {

		@Override
		public int compare(Email o1, Email o2) {
			return o1.getTimestamp().compareTo(o2.getTimestamp());
		}

	}

	public static class EmailDateDescending implements Comparator<Email> {

		@Override
		public int compare(Email o1, Email o2) {
			return o1.getTimestamp().compareTo(o2.getTimestamp()) * -1;
		}

	}

	/**
	 * Default constructor sets up the Folder
	 * 
	 * @param name Name of folder
	 */
	public Folder(String name) {
		setName(name);
		setCurrentsortingmethod(DATE_DESC);
		emails = new ArrayList<>();
	}

	/**
	 * Retrieves the name of the folder
	 * 
	 * @return Name of folder
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the folder
	 * 
	 * @param name Sets name of folder
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the current sorting method
	 * 
	 * @return Gets currentSortingMethod
	 */
	public String getCurrentsortingmethod() {
		return currentSortingMethod;
	}

	/**
	 * Sets currentSortingmethod of the folder
	 * 
	 * @param currentSortingMethod The currentSortingmethod of folder
	 */
	public void setCurrentsortingmethod(String currentSortingMethod) {
		this.currentSortingMethod = currentSortingMethod;
	}

	/**
	 * Adds email to a folder
	 * 
	 * @param email Adds an email to the folder according to the current sorting
	 *              method.
	 */
	public void addEmail(Email email) {
		emails.add(email);
		if (currentSortingMethod.equals(SUBJ_ASCE)) {
			sortBySubjectAscending();
		}
		if (currentSortingMethod.equals(SUBJ_DESC)) {
			sortBySubjectDescending();
		}
		if (currentSortingMethod.equals(DATE_ASCE)) {
			sortByDateAscending();
		}
		if (currentSortingMethod.equals(DATE_DESC)) {
			sortByDateDescending();
		}

	}

	/**
	 * Removes an email from the folder by index.
	 * 
	 * @param index Where in the arraylist will email be removed
	 * @return removes email from arraylist
	 */
	public Email removeEmail(int index) {
		return emails.remove(index);
	}

	/**
	 * Removes all email in a folder
	 */
	public void removeAllEmail() {
		emails.clear();
	}

	/**
	 * Sorts the emails alphabetically by subject in ascending order.
	 */
	public void sortBySubjectAscending() {
		EmailCompareAscending compare = new EmailCompareAscending();
		emails.sort(compare);
		setCurrentsortingmethod(SUBJ_ASCE);
	}

	/**
	 * Sorts the emails alphabetically by subject in descending order.
	 */
	public void sortBySubjectDescending() {
		EmailCompareDescending compare = new EmailCompareDescending();
		emails.sort(compare);
		setCurrentsortingmethod(SUBJ_DESC);
	}

	/**
	 * Sorts the emails by date in ascending order.
	 */
	public void sortByDateAscending() {
		EmailDateAscending compare = new EmailDateAscending();
		emails.sort(compare);
		setCurrentsortingmethod(DATE_ASCE);
	}

	/**
	 * Sorts the emails by date in descending order.
	 */
	public void sortByDateDescending() {
		EmailDateDescending compare = new EmailDateDescending();
		emails.sort(compare);
		setCurrentsortingmethod(DATE_DESC);
	}

	/**
	 * Prints emails from a folder
	 */
	public void printEmails() {
		if (emails.size() == 0) {
			System.out.println(name + " is empty.");
			return;
		}
		System.out.printf("%20S %20S %15S", "Index |", "Time", "| Subject \n");
		for (int i = 0; i < 40; i++) {
			System.out.print("-");
		}
		System.out.println("");
		for (int i = 0; i < emails.size(); i++) {
			Email email = emails.get(i);
			System.out.printf("%20S| %20S| %15S", i + 1, email.getTimestamp(), email.getSubject());
			System.out.println("");
		}

	}

	/**
	 * Prints the email name
	 */
	public void print() {
		System.out.println(name);
		printEmails();
	}

	/**
	 * Gets the email according to index
	 * 
	 * @param index What index the get email
	 * @return The email at position index
	 */
	public Email getEmail(int index) {
		return emails.get(index);
	}

}
