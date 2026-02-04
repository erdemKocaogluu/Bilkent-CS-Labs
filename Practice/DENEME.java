import java.util.Scanner ;
public class DENEME {

    
    
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in) ;
        int maxTemp = -1 ; 
        int previousTemp = -1 ;
        boolean done = true ; 
        int count = 0 ;
        for (int month = 1 ; month <= 12 ; month++) {
            if (count > 0 ) {
                in.nextLine() ;
            }
            done = true ;
            System.out.printf("%d. ayın sıcaklığını giriniz: " , month);

            while ( !in.hasNextInt() && done == true ) {
                System.out.println("Hatalı giriş yaptınız ");
                done = false ;
                month-- ;
            }
            count ++ ;
            if (done) {
            previousTemp = in.nextInt() ;
            if (maxTemp < previousTemp) {
                maxTemp = previousTemp ;
            }
            
            }
        }
        System.out.println(maxTemp) ;
        

       }

}
