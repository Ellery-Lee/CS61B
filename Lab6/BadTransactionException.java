/* BadTransactionException.java */

/**
 *  Implements an exception that should be thrown for nonexistent accounts.
 **/
public class BadTransactionException extends Exception {

  public int amountNumber;  // The invalid account number.

  /**
   *  Creates an exception object for bad withdraw amount "badAmount".
   **/
  public BadTransactionException(int badAmount) {
    super("Invalid account number: " + badAmount);

    amountNumber = badAmount;
  }
}