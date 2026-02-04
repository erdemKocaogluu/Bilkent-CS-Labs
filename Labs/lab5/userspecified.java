import java.util.Scanner ;
public class userspecified {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in) ;
        System.out.print("the limit is: ") ;
        while ( !in.hasNextInt()) {
            in.next() ;
            System.out.println("wrong please try again");
            System.out.print("the limit is: ") ;


        }
        int limit = in.nextInt() ;

        for ( int i=1 ;  i <= limit ; i++) {
            System.out.println(i);
        }

in.close();

    }
}
