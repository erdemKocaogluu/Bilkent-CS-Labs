import java.util.Scanner ;
import java.util.Arrays ;
public class quiizzz {
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in) ;
        System.out.print("pozitif sayılar giriniz çıkmak için negatif sayı giriniz: ");
        int number = in.nextInt() ;
        int [ ] array = new int[10000000] ;
            int i = 0 ;
            int meaningful = 0 ;
        while (number >= 0 ) {
            array[i] = number ;
            i++;
            number = in.nextInt() ;
            meaningful++;
        }

        int [] meaningfulArray = Arrays.copyOf(array, meaningful) ;

        int toplam = 0 ;
        for (int val : meaningfulArray) {
            toplam += val ;

        }
        double average = (toplam + 0.0 ) / meaningful ;

        System.out.printf("average is: %.2f%n" , average ) ;
        System.out.printf("%-8s %s%n" , "Value" , "AVG - NUM");
        System.out.println("------------");
        for (int val : meaningfulArray) {
            System.out.printf("%d %10.2f%n" , val , average-val);
        }

        in.close(); 
    
    





}



}
