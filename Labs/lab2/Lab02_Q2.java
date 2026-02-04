import java.util.Scanner ;
public class Lab02_Q2 {

    public static void main(String[] args) {
    Scanner in = new Scanner( System.in ) ;
    System.out.print("Enter phone number: " );
    String x = in.nextLine();
    String countryCode1 = x.substring(x.indexOf("(") + 1, x.indexOf(")")) ;   
    String cityareaCode1 = x.substring(x.indexOf(")") + 1, x.indexOf("-")) ;
    int m = x.indexOf("-" ) + 1 ;
    int n = x.indexOf("-" , m) ;
    String phoneNumberfirst3 = x.substring(x.indexOf("-")+ 1, n) ;
    String phoneNumberlast4 = x.substring(n+1 , x.length()) ;
    String countryCode2 = countryCode1.replace(" ", "") ;
    String cityareaCode2 = cityareaCode1.replace(" ", "") ;
    String phoneNumber2 = phoneNumberfirst3.replace(" ", "") ;
    String phoneNumber3 = phoneNumberlast4.replace(" ", "") ;
    String phoneNumberlast4first2 = phoneNumber3.substring(0, 2) ;
    String phoneNumberlast4last2 = phoneNumber3.substring(2, 4) ;
    System.out.println("Country Code: " + countryCode2 ) ;
    System.out.println("City/Area Code: " + cityareaCode2 ) ;
    System.out.println("Phone Number: " + phoneNumber2 + " - " + phoneNumberlast4first2 + " " + phoneNumberlast4last2 ) ;
    in.close();





    }
}