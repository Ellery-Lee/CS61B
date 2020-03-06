package list;

/**
 *  A lockDList is a mutable doubly-linked list ADT.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list.Also, it contains lcoked nodes
 *
 *  DO NOT CHANGE ANY METHOD PROTOTYPES IN THIS FILE.
 */


public class LockDList extends DList {

	/**
	 * protected DListNode head;
	 * protected int size;
	 */
	
	
	protected DListNode newNode(Object item, DListNode prev, DListNode next) {
		DListNode node = new LockDListNode(item, prev, next);
		lockNode(node);
		return node;
	}
	
	public LockDList() {
	  super();
	}
	
	public void lockNode(DListNode node) {
		((LockDListNode)node).islocked = true;
	}
	
	public void remove(DListNode node) {
		if(!((LockDListNode)node).islocked) {
			super.remove(node);
		}
	}

}
