public class den {

    public static int maxMirror(int[] nums) {
      // i = 0 başla aynı olan bulursan sağındakilere bakmaya başla ordan en uzun sequence i bul

        // çift loop gerekiyor 


        // yenii++ ve yenix++ en iç loopa yazılcak
        int biggest = 0; 
        int a = 0;
        int[] reverse = new int[nums.length];
        
        for (int index = nums.length - 1; index >= 0; index--) {
            reverse[a] = nums[index];
            a++;
        }

        for (int x = 0; x < nums.length; x++) {
            for (int i = 0; i < reverse.length; i++) {
                
         if (reverse[i] == nums[x]) {
             int yenii = i;
            int yenix = x;
                    int sequence = 0; 

                 while (yenix < nums.length && yenii < reverse.length && nums[yenix] == reverse[yenii]) {
                      sequence++;
                yenii++;
                       yenix++;
                }

                if (sequence > biggest) {
                   biggest = sequence;
           }
                }
            }
        }
        return biggest;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 8, 9, 3, 2, 1};
        int x = maxMirror(array);
        System.out.println("En uzun ayna uzunluğu: " + x);
    }
}