import java.util.Scanner ;
public class FrontAndEndSameSubstrings {
    // SINAVDA İFLERİN SUSLU PARANTEZLERİNİ BELLİ HIZAYA KOYMAM LAZIM MI KOYARSAM YA DA KOYMAZSAM ONA GÖRE PUAN 
    // KAYBEDER MİYİM??

    public static void main(String[] args) { // This program looks at front and end . And thisplays the same substrings at the front and end
        Scanner in = new Scanner ( System.in ) ;
        System.out.print("the input:") ;
        String input = in.nextLine();
        int length = input.length() ;
        String samePart = "" ;
        if (length <= 1 ) {
            System.out.println("Not enough length of input");
        }
        else {
        if ( length % 2 != 0 ) {
            int n = 1 ;
            boolean done = true ;
            while (done && (length-n)/2 > 0 ) {

                if (input.substring(0,(length-n)/ 2).equals(input.substring((length-n)/ 2 + n)) ) {
                    samePart = input.substring(0, (length-n) / 2) ;
                    done = false ;
                }
                n += 2;
            } 
            
        }
        else {
            boolean isValid = true ; 
            int count = 0 ;
            while ( isValid && (length-count)/2 > 0 ) {
                if (input.substring(0, (length - count ) / 2).equals(input.substring((length-count) / 2 + count)) ) {
                    isValid = false ;
                    samePart = input.substring(0, (length-count) / 2 ) ;
                }
                count += 2 ;
            }

        }
        if ( samePart.equals("")) {
            System.out.println("There is no same part");
        }
        else {
            System.out.printf("Same part is: %s%n" , samePart);
        }
        
    }
    in.close();
}
}