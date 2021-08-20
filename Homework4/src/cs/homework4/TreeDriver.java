package cs.homework4;

import java.io.File;
import java.util.Scanner;

/**
 * TreeDriver creates the menu and takes in userinput to initiate which method to be called
 * 
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */

public class TreeDriver {
	/**
	 * ignoreEmptyLine skips empty lines in txt file
	 * @param fr
	 * file that is inputted is tested
	 * @return
	 * 		Return a txt file without empty lines
	 */
	public static String ignoreEmptyLine(Scanner fr) {
		while(fr.hasNext()) {
			String line = fr.nextLine();
			if(!line.trim().isEmpty()) {
				return line;
			}
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		Tree newTree = null;
		Scanner scan = new Scanner(System.in);
		boolean keepRun = true;
		while(keepRun) {
			System.out.println("L - Load a Tree.");
			System.out.println("H - Begin a Help Session.");
			System.out.println("T - Traverse the Tree in preorder.");
			System.out.println("Q - Quit.");
			System.out.println("P - Inorder");
			System.out.print("Choice>");
			String menuInput = scan.nextLine();
			System.out.println("");
			if(menuInput.equals("L")) {
				System.out.print("Enter the file name>");
				String input = scan.nextLine();
				File file = new File(input);
				Scanner inFile = new Scanner(file);
				String label = "";
				if (inFile.hasNext()) {
					label = ignoreEmptyLine(inFile);
				}
				String message = "";
				if (inFile.hasNext()) {
					message = ignoreEmptyLine(inFile);
				}
				String prompt = "";
				if (inFile.hasNext()) {
					prompt = ignoreEmptyLine(inFile);
				}
				TreeNode rootNode = new TreeNode(label, prompt, message);
				newTree = new Tree(rootNode);
				String parent = "";
				if (inFile.hasNext()) {
					while (inFile.hasNext()) {		
						parent = ignoreEmptyLine(inFile);
						if(!parent.isEmpty()) {
							String[] arr = parent.split(" ");
							String parentLabel = arr[0];
							int numChilds = Integer.parseInt(arr[1]);
							for (int i = 0; i < numChilds; i++) {
								label = ignoreEmptyLine(inFile);
								message = ignoreEmptyLine(inFile);
								prompt = ignoreEmptyLine(inFile);
								newTree.addNode(label, prompt, message, parentLabel);
							}
						}
					}
				}
				System.out.println("");
			}
			else if(menuInput.equals("H")) {
				//CALL HELPER METHOD
				newTree.beginSession();
			}
			else if(menuInput.equals("T")) {
				newTree.preOrder();
			}
			else if(menuInput.equals("Q")) {
				keepRun = false;
				System.out.println("");
				System.out.println("thank you for using our automated help services!");	
			}
			else if(menuInput.equals("P")) {
				newTree.inOrder();
			}
				
		}
	}
}
