public class notReplace {
    /*
Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not". The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count. (Note: Character.isLetter(char) tests if a char is a letter.)


notReplace("is test") → "is not test"
notReplace("is-is") → "is not-is not"
notReplace("This is right") → "This is not right" */

public String notReplace(String str) {
  
  //" This is is merhaba "
  // 01234567890123456789
  
  int count = 0 ;
  str  = " " + str + " " ;
  int prev = 0 ;
  
  String toplam = "" ;
  int index = str.indexOf("is") ;
  while (index != -1 ) {
    
    if (!Character.isLetter(str.charAt(index - 1 ))  &&  
    !Character.isLetter(str.charAt(index + 2 ))) {
      
      toplam += str.substring(prev, index) ;
      toplam += "is not" ;
          index += 2 ;
      prev = index;

    }
    index = str.indexOf("is" , index + 1 ) ;
  }
  
  toplam += str.substring(prev) ;
  toplam = toplam.trim() ;
  return toplam ;
  
  
}

}
