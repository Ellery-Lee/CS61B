/* Date.java */
import java.io.*;

class Date {

  /* Put your private data fields here. */
  private int day, month, year;

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
	  if(isValidDate(month,day,year) == true){
		  this.month = month;
		  this.day = day;
		  this.year = year;
	  }else{
		  System.exit(0);
	  }
  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
	  if(s.matches("\\d{1,2}\\/\\d{1,2}\\/\\d{1,4}")){          //判断字符串表达式和正则表达式是否匹配,\\表示\,之后\d{1,2}表示1到2个数字（0-9）
		  String[] d = s.split("/");                      //字符串分割赋值给数组
		  month = Integer.parseInt(d[0]);
		  day = Integer.parseInt(d[1]);
		  year = Integer.parseInt(d[2]);
		  }else{
			  System.exit(0);
		  }
  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
  /*if (year % 4 == 0){
		if(year % 100 == 0){
			if(year % 400 == 0){
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}else{
		return false;
	}*/
	if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){              
		return true;															//这也太强了
	}else{
		return false;
	}
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
	  switch(month){
		  case 2:
			  if(isLeapYear(year)){
				  return 29;
			  }else{
				  return 28;
			  }
		  case 4:
		  case 6:
		  case 9:
		  case 11:
			  return 30;
		  default:
		  return 31;
	  }                         
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
	  if(year < 1){
		  return false;
	  }else if(month > 12 || month < 1){
		  return false;
	  }else if(day > daysInMonth(month,year) || day < 1){
		  return false;
	  }else{
		  return true;
	  }
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
    return (month + "/" + day + "/" + year);                     // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
    if(this.year < d.year){
		return true;
	}else if(this.year > d.year){
		return false;
	}else{
		if(this.month < d.month){
			return true;
		}else if(this.month > d.month){
			return false;
		}else{
			if(this.day < d.day){
				return true;
			}else{
				return false;
			}
		}
	}
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
  /*if(this.isBefore(d)){
		return false;
	}else if(this.day == d.day && this.month == d.month && this.year == d.year){
		return false;
	}else{
		return true;
	}*/
	return d.isBefore(this);                   //这个太强了！机智
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
	int sum = 0;  
	for(int i = 1; i < month; i++){
		switch(i){
		  case 2:
			  if(isLeapYear(year)){
				  sum += 29;
				  break;
			  }else{
				  sum += 28;
				  break;
			  }
		  case 4:
		  case 6:
		  case 9:
		  case 11:
			  sum += 30;
			  break;
		  default:
		  sum +=31;
		  break;
		}
	}
	sum += day;
	return sum;
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
	  int this_Day = 0; 
	  int D_Day = 0;
    if(this.isBefore(d)){
		if(isLeapYear(year)){						//先算this year剩下天数
			this_Day = 366 - this.dayInYear();
		}else{
			this_Day = 365 - this.dayInYear();
		}
		
		for(int i = year + 1; i < d.year; i++){		//计算相差年的天数
			if(isLeapYear(i)){
				this_Day += 366;
			}else{
				this_Day += 365;
			}
		}
		D_Day = d.dayInYear();						
		this_Day = (this_Day + D_Day);				
		return -this_Day;
	}else if(this.isAfter(d)){
		if(isLeapYear(d.year)){
			D_Day = 366 - d.dayInYear();
		}else{
			D_Day = 365 - d.dayInYear();
		}
		
		for(int i = d.year + 1; i < year; i++){		//计算相差年的天数
			if(isLeapYear(i)){
				D_Day += 366;
			}else{
				D_Day += 365;
			}
		}
		this_Day = this.dayInYear();
		D_Day = (D_Day + this_Day);
		return D_Day;
	}else{
		return 0;
	}
  }

  public static void main(String[] argv) throws Exception{
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */
	System.out.println("\nTesting isLeapYear.");
	
	String inputLine;
	int NumOfYear;
	BufferedReader keyboard;
	keyboard = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Please enter the number of a year (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
	inputLine = keyboard.readLine();
	NumOfYear = Integer.parseInt(inputLine);
	boolean result_isLeapYear = isLeapYear(NumOfYear);
	System.out.println( + NumOfYear + " is a leap year " + result_isLeapYear);     //如果是单引号会转换成整形，双引号是字符串功能
	

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
