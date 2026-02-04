import java.util.Scanner ;
public class deneaa {

    public static void main(String[] args) {
        boolean done = true ;
        boolean bool = true ;
        int previous = -1 ; 
        int last  = 0 ;
        int previousDif = Integer.MIN_VALUE ;
        int maxDif = 0 ;
        Scanner in = new Scanner ( System.in) ;
        System.out.println("Enter numbers:");
        int count = 0 ; 
        while ( done && in.hasNextInt() ) { // LOOKS AT THE NUMBERS AND DECİDES THEY ARE ASCENDING OR NOT

            last = in.nextInt() ; 

            if (last < 0 ) {
                done = false ;
            }
            
            else {
            if ( last < previous && bool ) {

                bool = false ; 
            
            }

            maxDif = last - previous ; 
            if ( maxDif > previousDif)
            previous = last ;
            previousDif = maxDif ;
            count ++;
            }

        }
        if ( count <= 1 ) {
            System.out.println("please enter more numbers");
        }
        else {
        if ( bool) {
            System.out.println("numbers are in ascending order");
        }
        else {
            System.out.println("numbers are not in ascending order");
        }

        }
        in.close();
    }
}