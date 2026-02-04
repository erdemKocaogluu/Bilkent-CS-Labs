import java.util.Scanner ;
import java.util.Arrays;

public class ARRAY {

    public static void main(String[] args) {
       
        // System.out.println(array.toString()); // YANLIŞ KULLANIM REFERENCE ADRESİNİ YAZDIRIR
        // System.out.println(Arrays.toString(array));} // ARRAY ELEMANLARINI YAZDIRIR

        Scanner in = new Scanner (System.in ) ;
        System.out.print("kaç ay: ");
        int monthNumber = in.nextInt() ;
        double [] temperatures = new double[monthNumber] ;
        for (int count = 1 ; count <= monthNumber ; count++) {
            System.out.printf("temperature in month %d%n" , count);
            //temperatures += in.nextDouble() ; // bu hatalı kullanım error veriyor
            temperatures[count-1] = in.nextInt() ;  // ARRAY DOUBLE AMA İNT DE ALABİLİR HATA VERMEZ

        }
        double biggest = temperatures[0] ;
        for(double value : temperatures) { // BU DOĞRU
            if (biggest < value) {
                biggest = value ;
            }
        }

        System.out.println("the biggest: " + biggest) ;

        
    }
}