
import java.util.Scanner ;
public class Lab05_Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        boolean isValid = true ;
        boolean done = false ;
        int count = 0;
        int index = 0 ;
        int lengthOfNumber = 0 ;
        String numberAsString = "" ;
        double previous = -1 ;
        int numberss = 0 ;
        while (!done ) {
        done = true ;
        if (numberss > 0 ) {
            System.out.println("Invalid input. Please only enter digits(0-9).");
        }
        System.out.print("Please enter the chart data as string: ") ;
        numberAsString = in.nextLine() ;
        lengthOfNumber = numberAsString.length() ;
        int n = 0 ;
        while ( n < lengthOfNumber && done ) {
            
            if ( !Character.isDigit(numberAsString.charAt(n))) {
                done = false ;
            }
            n++ ;
        }
            numberss++;
            }
        // İNTTEN STRİNGE ÇEVİRDİĞİM İÇİN O TÜM İNTİN LENGTHİNİ 1 OLARAK ALIYOR
        double biggest = 0 ;
        while (lengthOfNumber != 1 ) {
            if (numberAsString.charAt(lengthOfNumber-1) > numberAsString.charAt(lengthOfNumber-2)) {
                biggest = Double.parseDouble(numberAsString.charAt(lengthOfNumber-1) + "") ;
            
            }

            else {
                biggest = Double.parseDouble(numberAsString.charAt(lengthOfNumber-2) + "") ;

            }
            if ( biggest > previous ) {
            previous = biggest ;
            } 
            lengthOfNumber-- ;

        }
        int leftNumbers = (int )previous ;

        lengthOfNumber = numberAsString.length() ;// İNTTEN STRİNGE ÇEVİRDİĞİM İÇİN O TÜM İNTİN LENGTHİNİ 1 OLARAK ALIYOR
        leftNumbers++;
        while (isValid) {
            leftNumbers-- ;
            index = 0 ;
            System.out.println("\n");
                System.out.print(leftNumbers + "|");

            while (index <= lengthOfNumber - 1) {
                String x = numberAsString.charAt(index) + "" ;
                Double doubleX = Double.parseDouble(x) ;



                if ( leftNumbers == 0) {
                    lengthOfNumber = numberAsString.length() ;
                    while ( count < lengthOfNumber) {
                        System.out.print("_");
                        count++;
                    }
                    isValid = false ;
                }
                else {
                if ( leftNumbers <= doubleX) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
                index++;

                }
            }
            
        }

                 in.close() ;

    }
}

