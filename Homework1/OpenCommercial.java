/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;
	String[] load = new String[5];

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();
	inputLine = "http://www." + inputLine + ".com";
	System.out.println(inputLine);
	URL u = new URL(inputLine);
	InputStream ins = u.openStream();
	InputStreamReader isr = new InputStreamReader(ins);
	BufferedReader point3acres = new BufferedReader(isr);
	for(int i = 0; i < 5; i++){
		load[i] = point3acres.readLine();
	}
	for(int i = 4; i >= 0; i--){
		System.out.println(load[i]);
	}
	
	
	keyboard = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Please enter the name of a company (without spaces): ");
	inputLine = keyboard.readLine();
	StringBuilder fixed_String = new StringBuilder(inputLine);
	fixed_String.delete(1,2);
	System.out.println("The word without the second character is " + fixed_String);
	
  }

}
