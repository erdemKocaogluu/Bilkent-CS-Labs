public class gHappy {
    /*
We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. Return true if all the g's in the given string are happy.


gHappy("xxggxx") → true
gHappy("xxgxx") → false
gHappy("xxggyygxx") → false */
public boolean gHappy(String str) {
  str =" " + str + " " ;
  int length = str.length() ;
  int count = 0 ; 
  boolean done = true ;
  String x = "" ;
  while ( count < length ) {
    x = str.charAt(count) + "" ;
    if ( x.equals("g") && !((str.charAt(count-1 ) + "" ).equals("g") || (str.charAt(count+1) + "" ).equals("g") ) ) {
      done = false ;
    }
    count ++;
  }
  if ( done ) {
    return true ;
  }
  else {
    return false ;
  }
  
}

}
