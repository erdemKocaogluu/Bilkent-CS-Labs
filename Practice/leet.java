import java.util.Arrays;

public class leet {
    public static void main(String[] args) {
        int[] nums = { 3 ,3 } ;
        int target = 6 ;
            int target1 = 0 ;
            int target2 = 0 ;
            int count = 0 ;
            for(int i = 0 ; i < nums.length ; i ++) {
                count = i+ 1 ;
                while(count < nums.length  && nums[i] + nums[count] != target  ) {
                    count++;
                }
                if (count < nums.length  &&  nums[i] + nums[count] == target) {
                    target1 = i ; 
                    target2 = count ;
                }
            }
            int [] array = {target1 , target2} ;
            System.out.println(Arrays.toString(array));
    
        
    }
        // LEET TWO SUM PROBLEM
    
}
