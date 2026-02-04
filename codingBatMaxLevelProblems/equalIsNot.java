public class equalIsNot {
    /*
Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive).


equalIsNot("This is not") → false
equalIsNot("This is notnot") → true
equalIsNot("noisxxnotyynotxisi") → true */


public boolean equalIsNot(String str) {
  
  int length = str.length() ;
  int count = 0 ;
  int is = 0 ;
  int not = 0 ;
  
  while ( count < length - 1) {
    
    if (str.charAt(count) == 'i' && str.charAt(count + 1) == 's' ) {
      is++ ;
    }
    
    if (count != length - 2) {
      
      if (str.charAt(count) == 'n' && str.charAt(count + 1) == 'o' && str.charAt(count + 2) == 't') {
      not++;
      }
      
    }
    
    count++;
  }
  
  if (is == not) {
    return true ;
  }
  return false ;
  
  
  
}

}
