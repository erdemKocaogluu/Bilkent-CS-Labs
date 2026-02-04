import java.util.Scanner ;
import java.util.Arrays ;
public class removearray {
    

    public static int inOrder(int [] array , int removeIndex) {
        int length = array.length ;

        // 0 1 2 3 4 5 6
         if (removeIndex != length - 1) {
            int i = removeIndex ;
            while ( i < length - 1 ) {

                array[i] = array[i+1] ;

                i++;
            }


        }
        return length - 1  ;

    } 
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in) ;
        int [] array = {0 , 1, 2 , 3, 4 , 5 , 6 ,7 } ;


        System.out.println(Arrays.toString(array));
        System.out.print("çıkarmak istediğiniz indexi giriniz: ");
        int removeIndex = in.nextInt() ;
        while (removeIndex >= array.length ) {
            System.out.print("çıkarmak istediğiniz indexi giriniz: ");
            removeIndex = in.nextInt() ;

        }
        int meaningfulLength = inOrder(array, removeIndex) ;

        int [] meaningfulArray = Arrays.copyOf(array , meaningfulLength) ;
        System.out.println(Arrays.toString(meaningfulArray));

    }
}
