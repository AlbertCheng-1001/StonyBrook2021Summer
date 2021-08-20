package cs.homework4;

/**
 * Creates the tree node with given properties of label message and prompt 
 * 
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */

public class TreeNode {
	private TreeNode left;
	private TreeNode middle;
	private TreeNode right;
	private String label;
	private String message;
	private String prompt;
	//private TreeNode []array = new TreeNode [] {left, middle, right};
	
	/**
	 * Default constructor 
	 * @param label
	 * 		Label but trimmed with no spaces info for treenode
	 * @param message
	 * 		message but trimmed with no spaces info for treenode
	 * @param prompt
	 * 		prompt but trimmed with no spaces info for treenode
	 */
	public TreeNode(String label, String message, String prompt) {
		
		setLabel(label.trim());
		setMessage(message.trim());
		setPrompt(prompt.trim());
	}
	
	/**
	 * Retrieves the label of treenode
	 * @return
	 * 		Label of treenode
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Sets the label of treenode
	 * @param label
	 * 		sets label of treenode
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Retrieves the message of treenode
	 * @return
	 * 		message of treenode
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message of treenode
	 * @param message
	 * 		sets message of treenode
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Retrieves the prompt of treenode
	 * @return
	 * 		prompt of treenode
	 */
	public String getPrompt() {
		return prompt;
	}
	
	/**
	 * Sets the prompt of treenode
	 * @param prompt
	 * 		sets prompt of treenode
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	/**
	 * Retrieves the left position of treenode
	 * @return
	 * 		left position of treenode
	 */
	public TreeNode getLeft() {
		return left;
	}
	
	/**
	 * Sets the left position of treenode
	 * @param left
	 * 		Sets left position of treenode
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	/**
	 * Retrieves the middle position of treenode
	 * @return
	 * 		middle position of treenode
	 */
	public TreeNode getMiddle() {
		return middle;
	}
	
	/**
	 * Sets the middle position of treenode
	 * @param middle
	 * 		sets middle position of treenode
	 */
	public void setMiddle(TreeNode middle) {
		this.middle = middle;
	}
	
	/**
	 * Retrieves the right position of treenode
	 * @return
	 * 		right position of treenode
	 */
	public TreeNode getRight() {
		return right;
	}
	
	/**
	 * Sets the right position of treenode
	 * @param right
	 * 		sets right position of treenode
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	/**
	 * Checks if a node has childrens or if its a leaf
	 * @return
	 * 		returns true if its a leaf and has no childrens
	 */
	public boolean isLeaf() {
		if(left == null && middle == null && right == null) {
			return true;
		}
		else {
			return false;
		}	
	}
	/**
	 * Gets the node reference
	 * @param otherLabel
	 * 		Takes in a string of the label
	 * @return
	 * 		the parent of the node
	 */
	public TreeNode getNodeReference(String otherLabel) {
	    if(otherLabel.equals(this.label)) { // "middle" != "root" 
	        return this;
	    }
	    if (this.left != null) {
	        TreeNode reference = this.left.getNodeReference(otherLabel); //<- call with "middle" 
	        if (reference != null) {
	            return reference;
	        }
	    }
	    if (this.middle != null) {
	        TreeNode reference = this.middle.getNodeReference(otherLabel);
	        if (reference != null) {
	            return reference;
	        }
	    }
	    if (this.right != null) {
	        TreeNode reference = this.right.getNodeReference(otherLabel);
	        if (reference != null) {
	            return reference;
	        }
	    }
	    return null;
	}	
	/**
	 * toString method for testing
	 */
	public String toString() {
		return "Label: " + label + "\n" + "Prompt: " + prompt + "\n" + "Message: " + message + "\n";
	}
}
