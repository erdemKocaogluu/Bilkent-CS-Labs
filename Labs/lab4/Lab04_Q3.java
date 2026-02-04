import java.util.Scanner ;
public class Lab04_Q3 {

    public static void main(String[] args) {
        System.out.print("Enter a positive integer of at least 5 digits: ");
        Scanner in = new Scanner(System.in) ;
        int number = in.nextInt();
        int digit ;
        double sum = 0;
        int pow = 0 ;
        if (number < 0) {
            System.out.println("Program finished.");
        }
        else {
        if ((number / 10000) < 1) {
            System.out.println("The number you entered is invalid, please try again…");
        }
        else {
        while (number != 0 ) {
                digit = number % 10 ;
                if (Math.round((digit/2)) != (digit / 2.0) )  {
                    sum = sum + digit * Math.pow(10, pow) ;
                    pow++ ;
                }
                number = number / 10 ;
            
            
        }
        System.out.println("Here is the number without the odd digits: " + (int)sum);
    }   }
    in.close();
} }