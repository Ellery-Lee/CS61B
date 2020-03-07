/*DListNode_Run.java*/

/**
 * A DListNode_Run is a node in a DList1 (doubly-linked list).
 */

/**
 * @author Ellery Lee
 *
 */
public class DListNode_Run {

/**
  *  length references the length of this "run".
  *  red references the red intensity of this "run".
  *  green references the green intensity of this "run".
  *  blue references the blue intensity of this "run".
  *  prev references the previous node in the DList.
  *  next references the next node in the DList.
 */
	
  public int length;
  public int red;
  public int green;
  public int blue;
  public DListNode_Run prev;
  public DListNode_Run next;	
  
  
	public DListNode_Run() {
		length = 0;
		red = 0;
		green = 0;
		blue = 0;
		prev = null;
		next = null;
	}
	
	/**
	 * @param i
	 */
	public DListNode_Run(int red, int green, int blue, int length) {
		this.length = length;
		this.red = red;
		this.green = green;
		this.blue = blue;
		prev = null;
		next = null;
	}
}
