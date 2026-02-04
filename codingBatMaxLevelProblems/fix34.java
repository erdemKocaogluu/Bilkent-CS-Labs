public class fix34 {
    /*
Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, but every other number may move. The array contains the same number of 3's and 4's, every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.


fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
fix34([3, 2, 2, 4]) → [3, 4, 2, 2] */

public int[] fix34(int[] nums) {
  
  int length = nums.length ;
  boolean done = true ;
  for (int i = 0 ; i < length ; i++ ) {
    
    if (nums[i] == 3 ) {
      done = true ;
      for (int x = 0 ; x < length && done ; x++ ) {
        
        if ((nums[x] == 4 && x == 0 ) || (nums[x] == 4 && nums[x-1] != 3) ) {
          int prev = nums[i+1] ;
          nums[i+1] = 4 ;
          nums[x] = prev ;
          done = false ;
        }
      }
      
      
    }
  }
  return nums ;
  
}

}
