public class sumNumbers {
    /*
Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)


sumNumbers("abc123xyz") → 123
sumNumbers("aa11b33") → 44
sumNumbers("7 11") → 18 */
public int sumNumbers(String str) {
  int count = 0 ;
  int length = str.length() ;
  String number = "0" ;
  int numberInt = 0 ;
  int total = 0 ;
  while ( count < length ) {
    if (Character.isDigit(str.charAt(count))) {
      number += str.charAt( count ) ;
    }
    else {
      numberInt = Integer.parseInt(number) ;
      total += numberInt ;
      number = "0" ;
    }
    
    
    count++;
  }
   
  total += Integer.parseInt(number ) ; 

  
  
  
  return total ;
  
  
}

}
