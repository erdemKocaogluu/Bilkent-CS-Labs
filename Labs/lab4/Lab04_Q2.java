import java.util.Scanner ;
public class Lab04_Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        String listOfPrimes = "2, (3)" ;
        int paranthese = 2 ;
        int count = 4 ; // NUMBERA GELENE KADAR OLAN SAYILARI COUNT İLE BULACAĞIZ COUNT = NUMBER OLANA KADAR COUNTU ARTIRACAĞIZ
        int numberToDivideCount = 2 ; // NUMBER TO DİVİDE COUNT COUNTUN KAREKÖKÜNE EŞİT OLANA KADAR COUNTU BU SAYIYA BÖLECEĞİZ EĞER HİÇ BÖLÜNMEDEN EŞİTLENMEYİ BAŞARIRSA VE COUNT ONA DA 
        // BÖLÜNMEZSE COUNT ASAL DİYECEĞİZ
        if ( number < 2 ) {
            System.out.println("Program finished.");
        }
        else {

        while (count <= number) {
            while (count%numberToDivideCount != 0 && numberToDivideCount < count) {
            
                numberToDivideCount++;

            }
            if (numberToDivideCount == count ) {
                paranthese++;

            }
            if(numberToDivideCount == count && (listOfPrimes.contains(", " + paranthese) || paranthese == 3 || listOfPrimes.contains("(" + paranthese + ")"))) {
                listOfPrimes += ", (" + count + ")" ; 
            }
            else if (numberToDivideCount == count && (!listOfPrimes.contains(", " + paranthese) || !listOfPrimes.contains("(" + paranthese + ")") )) {
                listOfPrimes += ", " + count ; 

            }
            count++;
            numberToDivideCount = 2 ;

        }
        if (number == 2 ) {
            listOfPrimes = "2" ;
        }
        System.out.println("Prime numbers less than or equal to " + number + ": " +listOfPrimes);
        }

        

        in.close();
        }}

 