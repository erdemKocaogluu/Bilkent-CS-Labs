public class countClumps {
    /*Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. Return the number of clumps in the given array.


countClumps([1, 2, 2, 3, 4, 4]) → 2
countClumps([1, 1, 2, 1, 1]) → 2
countClumps([1, 1, 1, 1, 1]) → 1 */
public int countClumps(int[] nums) {
  
  // 0.inciyi numbera stokla 1. indexden if 0 == 1 ise falan sequence++ 
  //else if (sequence >= 2 ) clump++
  // loopdan çıkınca bir tur daha kontrol et sonda kalanları if sequence falan
  // clump++
  int sequence = 1 ;
  int clumps = 0 ;
  if (nums.length < 2 ) {
    return 0 ;
  } 
  
  else {
    
    int prev = nums[0] ;
    for (int i = 1 ; i < nums.length ; i++) {
      
      if ( nums [i] == prev   ) {
        sequence++;
      }
      else if (sequence >= 2 ) {
        clumps++;
        sequence = 1 ;
      }
      else {
        sequence = 1 ;
      }
      prev = nums[i] ;
      
    }
    
     if (sequence >= 2 ) {
        clumps++;
      }    
    
  }
  return clumps;
  
}

}
