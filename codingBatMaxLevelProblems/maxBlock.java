public class maxBlock {
    /*Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.


maxBlock("hoopla") → 2
maxBlock("abbCCCddBBBxx") → 3
maxBlock("") → 0 */

public int maxBlock(String str) {
  
  int length = str.length() ;
  int count = 1 ;
  int longest = 0 ;
  int currentsequence = 1 ; // ÇOK GÜZEL SORU
  
  if (length > 0 ) {
    
    String prev = str.charAt(0) + "" ;
    
    while (count < length) {
      
      if (!(str.charAt(count) +   "" ).equals(prev) ) {
        
        if (currentsequence > longest) {
          longest = currentsequence ;
        }
        currentsequence = 1 ;
        
      }
      else {
        currentsequence++;
      }
      
      prev = str.charAt(count) + "" ;
      count++;
       
    }
    
    if (currentsequence > longest) {
          longest = currentsequence ;
        }
  }
  
  return longest ;
}

}
