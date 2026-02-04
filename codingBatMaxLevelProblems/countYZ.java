public class countYZ {
    /*Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)


countYZ("fez day") → 2
countYZ("day fez") → 2
countYZ("day fyyyz") → 2 */


public int countYZ(String str) {
  int count = 0 ;
  str = "a" + str + " ";
  int length = str.length() ;
  int countYZ = 0 ;
  
  while ( count < length ) {
    
    if ( !Character.isLetter (str.charAt(count) ) && (  (str.charAt(count - 1 ) + "").equalsIgnoreCase("y") || (str.charAt(count - 1 ) + "").equalsIgnoreCase("z") ) ) {
      countYZ++ ;
      
    }
    
    count ++;
  }
  
  return countYZ ;
 }

}
