package cs.homework4;

import java.util.Scanner;

/**
 * Creates the tree and has multiple methods to to receive or add properties to it
 * 
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class Tree {

	private TreeNode rootNode;
	
	/**
	 * Gets the rootNode of the tree
	 * @param rootNode
	 * 		the rootNode of the tree
	 */
	public Tree(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	
	/**
	 * Adds a treenode to the tree
	 * @param label
	 * 		label of the treenode
	 * @param prompt
	 * 		prompt of the treenode
	 * @param message
	 * 		message of the treenode
	 * @param parentLabel
	 * 		parentLabel of the treenode
	 * @return
	 * 		returns true if a treenode is added to the tree
	 */
	public boolean addNode(String label, String prompt, String message, String parentLabel) {
		TreeNode newNode = new TreeNode(label, prompt, message);
		//System.out.println(newNode);
		TreeNode parentNode = getNodeReference(parentLabel);
		if(parentNode == null) {
			return false;
		}
		if(parentNode.getLeft() == null) {
			parentNode.setLeft(newNode);
			return true;
		}
		else if(parentNode.getMiddle() == null) {
			parentNode.setMiddle(newNode);
			return true;
		}
		else if(parentNode.getRight() == null) {
			parentNode.setRight(newNode);
			return true;
		}
		else {
			return false;
		}			
	}
	
	/**
	 * calls in getnodereference method from the treenode class
	 * @param label
	 * 		Label of treenode 
	 * @return
	 * 		returns the parents of the node
	 */
	public TreeNode getNodeReference(String label) {
		return rootNode.getNodeReference(label);
	}

	/**
	 * Recursive method to print the tree in preorder traverse
	 */
	public void preOrder() {
		TreeNode cursor = rootNode;
		preOrder(cursor);
	}

	/**
	 * Prints out the tree in a preorder traversal
	 * @param cursor
	 * 		cursor is the rootNode where it print out that first
	 */
	public void preOrder(TreeNode cursor) {
		if(cursor == null) {
			return;	
		}
		System.out.println(cursor);
		if(cursor.getLeft() != null) {
			preOrder(cursor.getLeft());
		}
		if (cursor.getMiddle() != null) {
			preOrder(cursor.getMiddle());
		}
		if (cursor.getRight() != null) {
			preOrder(cursor.getRight());
		}	
		
	}
	
	public void inOrder() {
		TreeNode cursor = rootNode;
		inOrder(cursor);
	}
	
	public void inOrder(TreeNode cursor) {
		if(cursor == null) {
			return;
			
		}
		if(cursor.getLeft() != null) {
			inOrder(cursor.getLeft());
		}
		
		if (cursor.getMiddle() != null) {
			inOrder(cursor.getMiddle());
		}
		
		System.out.println(cursor);
		if (cursor.getRight() != null) {
			inOrder(cursor.getRight());
		}	
	}
	
	/**
	 * beginSession prints out nodes message/prompt given the userinput
	 */
	public void beginSession() {
		TreeNode head = rootNode;
		Boolean keepGoing = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("Help Session Starting...");
		if(head == null) {
			System.out.println("There is no tree setup");
			return;
		}
		else {
			System.out.println(head.getMessage());
		}
		while(keepGoing) {
			if(!head.isLeaf()) {
				if(head.getLeft() != null) {
					System.out.println("1 " + head.getLeft().getPrompt());
				}
				if(head.getMiddle() != null) {
					System.out.println("2 " + head.getMiddle().getPrompt());
				}
				if(head.getRight() != null) {
					System.out.println("3 " + head.getRight().getPrompt());
				}
				System.out.println("0 Exit Session.");
			}			
			else {
				System.out.println("There is no tree set up");
				return;
			}
			System.out.print("Choice> ");
			String userInput = scan.nextLine();
			System.out.println("");
			if(userInput.equals("1")) {
				if(!head.getLeft().isLeaf()) {
					System.out.println(head.getLeft().getMessage());
					head = head.getLeft();
				}
				else {
					System.out.println(head.getLeft().getMessage());
					System.out.println("");
					System.out.println("Thank you for using this automated help service!");
					System.out.println("");
					keepGoing = false;
				}		
			}
			if(userInput.equals("2")) {
				if(!head.getMiddle().isLeaf()) {
					System.out.println(head.getMiddle().getMessage());
					head = head.getMiddle();
				}
				else {
					System.out.println(head.getMiddle().getMessage());
					System.out.println("");
					System.out.println("Thank you for using this automated help service!");
					System.out.println("");
					keepGoing = false;
				}
			}
			if(userInput.equals("3")) {
				if(!head.getRight().isLeaf()) {
					System.out.println(head.getRight().getMessage());
					head = head.getRight();
				}
				else {
					System.out.println(head.getRight().getMessage());
					System.out.println("");
					System.out.println("Thank you for using this automated help service!");
					System.out.println("");
					keepGoing = false;
				}
			}
			if(userInput.equals("0")) {
				System.out.println("Exiting help session");
				System.out.println("");
				return;
			}
		}
	}
}
