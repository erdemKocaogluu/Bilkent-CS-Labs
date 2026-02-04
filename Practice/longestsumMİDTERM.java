import java.util.Scanner ;
public class longestsumMİDTERM {

    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in) ;
        int currentSequence = 0 ;
        int longestSequence = 0 ;
        int longestSum = 0 ;
        int currentSum = 0 ;
        int prevInt = -1 ; //POZİTİF VARSAYIYORUM
        int currentInt = 0 ;
        System.out.print("Enter a set of positive integer values: ");
        // NONINTEGER GİRENE KADAR İNPUT AL
        while ( in.hasNextInt() ) {
        currentInt = in.nextInt() ;
        if ( currentInt > prevInt) {
            currentSum += currentInt ;
            currentSequence += 1 ;
        }
        else {

            if ( currentSequence > longestSequence) {
                longestSequence = currentSequence ;
                longestSum = currentSum ;
            }
            currentSum = currentInt ;
            currentSequence = 1;
        }

        
        prevInt = currentInt ; // ÖNEMLİİİİİ!!!!
        //1. SAYIDAN BAŞLAYARAK EĞER O KONUMDAKİ SAYI ÖNCEKİNDEN BÜYÜKSE 
        // CURRENTSUM += SAYI ; CURRENTSEQUENCE++ ;BAŞTA BUNLAR 0 VE HER LOOP SONU CURRENTSUM 0 LANIR DİĞERİ 1 LENİR
        //BÜYÜK DEĞİLSE CURRENT SEQUENCE İLE LONGESTSEQUENCE KARŞILAŞTIR BÜYÜK OLANI KAYDET DEPOLA// CURRENTSUM
        }
        if ( currentSequence > longestSequence) {
            longestSequence = currentSequence ;
            longestSum = currentSum ;
        }
        System.out.println("longest sequence" + longestSequence);
        System.out.println("longest sum :" + longestSum);
    }
}