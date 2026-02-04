import java.util.Scanner ;
public class Lab03_Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        System.out.print("Alice's coordinates: " ) ;
        String alicestring = in.nextLine();
        double alicex = Double.parseDouble(alicestring.substring(0, alicestring.indexOf(","))) ;
        double alicey = Double.parseDouble(alicestring.substring(alicestring.indexOf(",") + 2)) ;


        System.out.print("Bob's coordinates: " ) ;
        String bobstring = in.nextLine();
        double bobx = Double.parseDouble(bobstring.substring(0, bobstring.indexOf(","))) ;
        double boby = Double.parseDouble(bobstring.substring(bobstring.indexOf(",") + 2)) ;

        double x = Math.pow(Math.abs(alicex - bobx), 2) ;
        double y = Math.pow(Math.abs(alicey - boby), 2) ;
        double distance = Math.sqrt( x + y ) ;
        double h = distance - Math.round(distance) ;
        if ( h == 0){
            System.out.printf("Distance: %.1f meters %n" , distance ) ;
        }
        else {
        System.out.printf("Distance: %.2f meters %n", distance ); 
        }
        
        
        if (distance <= 5)  {
            System.out.println("Alice and Bob have found each other :D") ;

        
        }
        else {
            System.out.println("Alice and Bob have not found each other :(" ) ;
        
    }
    in.close();
}}