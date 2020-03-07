/*DList_Run.java */

/**
 *  A DList_Run is a mutable doubly-linked list.  (No sentinel, not
 *  circularly linked.)
 */

/**
 * @author Ellery Lee
 *
 * 2020年3月4日
 *  head references the first node.
 *  tail references the last node.
 */
public class DList_Run {
	
	  protected DListNode_Run head;
	  protected DListNode_Run tail;
	  protected long size;

	/**
     *  DList1() constructor for an empty DList1.
	 */
	public DList_Run() {
	    head = null;
	    tail = null;
	    size = 0;
	}

	/**
	 * @param length the length of each run
	 * @param red the red intensity
	 * @param green the green intensity
	 * @param blue the blue intensity
	 */
	public void insertEnd(DListNode_Run run) {
		if(tail == null) {
			tail = run;
			head = tail;
		}else if (run.red == tail.red && run.green == tail.green && run.blue == tail.blue) {
			tail.length++;
		}else {
			tail.next = run;
			run.prev = tail;
			tail = run;
		}
		size++;
	}

}
