/* HashTableChained.java */

package dict;

import java.util.Random;

import list.*;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
	protected List[] bucketarray;
	protected int size;


  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    // Your solution here.
	  while (!isPrime(sizeEstimate)) {
		sizeEstimate++;
	}
	  size = 0;
	  bucketarray = new List[sizeEstimate];
	  for (int i = 0; i < sizeEstimate; i++) {
		bucketarray[i] = new DList();
	}
	}

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
	  size = 0;
	  bucketarray = new List[101];
	  for (int i = 0; i < 101; i++) {
		bucketarray[i] = new SList();
	}
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
	  int a = 3;
	  int b = 4;
	  int p = bucketarray.length + 1;
	  while (!isPrime(p)) {
		p++;
	}
	  int comp = ((Math.abs(a * code) + b) % p) % bucketarray.length;
    return comp;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return size == 0;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object k, Object v) {
    // Replace the following line with your solution.
	  int comp = compFunction(k.hashCode());
	  Entry entry = new Entry();
	  entry.key = k;
	  entry.value = v;
	  bucketarray[comp].insertBack(entry);
	  size++;
    return entry;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
	  int comp = compFunction(key.hashCode());
	  if (bucketarray[comp].isEmpty()) {
		return null;
	}else if (bucketarray[comp].length() == 1) {
		try {
			if (key.equals(((Entry)bucketarray[comp].front().item()).key)) {
				return (Entry)bucketarray[comp].front().item();
			}else {
				return null;
			}
			
		} catch (InvalidNodeException e) {
			// TODO: handle exception
			System.err.println(e);
			return null;
		}
	}else{
		try {
			if (key.equals(((Entry)bucketarray[comp].front().item()).key)) {
			Random rand = new Random();
			int a = rand.nextInt(bucketarray[comp].length());
			ListNode current = bucketarray[comp].front();
			for (int i = 0; i < a - 1; i++) {
				current = current.next();
			}
			return (Entry)current.item();
			}else {
				return null;
			}
		} catch (InvalidNodeException e) {
			// TODO: handle exception
			System.err.println(e);
			return null;
		}		
	}
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
	  int comp = compFunction(key.hashCode());
	  try {
	  if (bucketarray[comp].isEmpty()) {
		return null;
	}else if (bucketarray[comp].length() == 1) {
		if (key.equals(((Entry)bucketarray[comp].front().item()).key)) { 
		Entry entry = (Entry)bucketarray[comp].front().item();
		bucketarray[comp].front().remove();
		size--;
		return entry;
		}else {
			return null;
		}
	}else {
		Random rand =  new Random();
		int a = rand.nextInt(bucketarray[comp].length() - 1);
		ListNode current = bucketarray[comp].front();
		for (int i = 0; i <= a; i++) {
			current = current.next();
		}
		if (key.equals(((Entry)current.item()).key)) { 
			Entry entry = (Entry)current.item();
			current.remove();
			size--;
			return entry;
		}else {
			return null;
		}
	}
	  }catch (InvalidNodeException e) {
		// TODO: handle exception
		  System.err.println(e);
		  return null;
	}
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
	  bucketarray = new List[bucketarray.length];
	  for (int i = 0; i < bucketarray.length; i++) {
		bucketarray[i] = new DList();
	}
	  size = 0;
  }
  
  /**
   * Check whether the input number is a Prime number.
   * 
   *  @param n the input number
   *  @return a boolean value(true if n is Prime,otherwise false if n is not Prime)
   */
  public boolean isPrime(int n) {
	if (n > 1) {
		for (int i = 2; i * i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
  }
	return false;
  }

  /**
   * count the number of collisions of a HashTable.
   * 
   *  @param n the input number
   *  @return a boolean value(true if n is Prime,otherwise false if n is not Prime)
   */
  
  public void countCollision() {
	  int num = 0;
	  for (int i = 0; i < bucketarray.length; i++) {
		String s = "bucketarray[" + i + "]:";
		if (bucketarray[i].length() > 1) {
			s = s + bucketarray[i].length();
			num += bucketarray[i].length() - 1;
			System.out.println(s);
		}else {
			s += 0;
		}
	}
	  double expected = size() - bucketarray.length + bucketarray.length * Math.pow((1 - 1.0 / bucketarray.length),size());
      System.out.println("expected number:" + expected);
      System.out.println("number of collisions:" + num);
  }
  
  public String[] String() {
	  String[] s = new String[bucketarray.length];
	  for (int i = 0; i < bucketarray.length; i++) {
		  s[i]= " [" + bucketarray[i].length() + "] ";
	}
	  return s;
  }
  
  
  public static void main(String[] args) {
      HashTableChained table = new HashTableChained(4);
      System.out.println("=====================size, isEmpty=========================");
      System.out.println((int) Math.pow(2,40) * 2);
      System.out.println((int) Math.pow(2,41) + (int) Math.pow(2,40));
      System.out.println((int) Math.pow(2,41) + (int) Math.pow(2,40) + (int) Math.pow(2,39));
      //Test hashTable methods
      System.out.println("*************** size, isEmpty ***************");
      System.out.println("table's size is: " + table.size());
      System.out.println("table is Empty: " + table.isEmpty());

      System.out.println("*************** insert ***************");
      table.insert("1", "The first one");
      table.insert("2", "The second one");
      table.insert("3", "The third one");
      table.insert("4", "The fourth one");
      table.insert("5","The fifth one");
      System.out.println("table's size is: " + table.size());
      System.out.println("table is Empty: " + table.isEmpty());
      table.countCollision();

      System.out.println("*************** find, remove ***************");
      Entry e1 = table.find("1");
      if(e1 == null)
          System.err.println("find() has a problem.");
      else
          System.out.println("Found " + e1);

      Entry e2 = table.find("2");
      if(e2 == null)
          System.err.println("find() has a problem.");
      else
          System.out.println("Found " + e2);

      Entry e3 = table.find("10");
      if(e3 != null)
          System.err.println("find() has a problem.");
      else
          System.out.println("Cannot find 10");

      Entry e4 = table.remove("10");
      if(e4 != null)
          System.err.println("remove() has a problem.");
      else
          System.out.println("10 cannot be deleted.");

      Entry e5 = table.remove("4");
      if(e5 == null) {
          System.err.println("remove() has a problem");
      }
      else {
          System.out.println("Deleted is " + e5);
      }
      table.countCollision();

      System.out.println("*************** makeEmpty ***************");
      table.makeEmpty();
      table.countCollision();
  }

  
}