package cs.homework2;

/**
 * Contains a reference to an ItemInfo object As well as two other ItemInfoNode
 * objects: prev and next
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class ItemInfoNode {
	private ItemInfo info;
	private ItemInfoNode prev;
	private ItemInfoNode next;

	/**
	 * 
	 * @param info 
	 * 		information about the node. (name, rfidTagNumber, price, OriginalLocation)
	 * @param prev 
	 * 		Previous node
	 * @param next 
	 * 		Next node
	 */

	public ItemInfoNode(ItemInfo info, ItemInfoNode prev, ItemInfoNode next) {
		this.info = info;
		this.prev = prev;
		this.next = next;

	}

	/**
	 * Retrieves the info of the node
	 * @return
	 * info of the node
	 */
	public ItemInfo getInfo() {
		return info;
	}
	
	/**
	 * Sets the info of the node
	 * @param info
	 * info of the node will be set to
	 */
	public void setInfo(ItemInfo info) {
		this.info = info;
	}

	/**
	 * Retrieves the next node
	 * @return
	 * 		next of the node
	 */
	public ItemInfoNode getNext() {
		return next;
	}

	/**
	 * Sets the next node
	 * @param node
	 * 		Next node will be set to
	 */		
	public void setNext(ItemInfoNode node) {
		next = node;
	}

	/**
	 * Retrieves the prev node
	 * @return
	 * 		Prev node
	 */
	public ItemInfoNode getPrev() {
		return prev;
	}

	/**
	 * Sets the prev node
	 * @param node
	 * 		prev node will be set to
	 */
	public void setPrev(ItemInfoNode node) {
		prev = node;
	}

}
