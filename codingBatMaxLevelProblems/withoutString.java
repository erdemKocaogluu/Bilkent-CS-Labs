public class withoutString {
    /*
Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".


withoutString("Hello there", "llo") → "He there"
withoutString("Hello there", "e") → "Hllo thr"
withoutString("Hello there", "x") → "Hello there" */

public String withoutString(String base, String remove) {
  
  // count = 0 dan başlayıp <= lengthstr - lengthremove a kadar gidip counttan 
  //oraya
  // kadar equalsIgnoreCase ile bakacak aynıysa subs yeni word yap count = 0;
  // yeni wordun lengthini tekrar al sürekli önemli olanlar yenilenecek mi 
  // bakman lazım
  
  int count = 0 ;
  int lengthBase = base.length() ;
  int lengthRemove = remove.length() ;
  
  while (count <= lengthBase - lengthRemove ) {
    

    if ( base.substring(count , count + lengthRemove).equalsIgnoreCase (remove) ) {
      base = base.substring (0 , count ) + base.substring(count + lengthRemove) ;
      lengthBase = base.length() ;
     count = -1;
    }
    
    count ++;

  }
  
  return base ;
  
  
  
}

}
