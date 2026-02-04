/*
Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.


canBalance([1, 1, 1, 2, 1]) → true
canBalance([2, 1, 1, 2, 1]) → false
canBalance([10, 10]) → true */


public class canBalance {

    public boolean canBalance(int[] nums) {
  double toplam = 0 ;
  double basToplam = 0 ;
  for (int val : nums) {
    toplam += val ;
  }
  
  for (int i = 0 ; i < nums.length ; i++ )  {
    
    basToplam += nums[i] ;
    if (basToplam == toplam / 2 ) {
      return true ;
    
    }
  }
  

return false ;
}

}