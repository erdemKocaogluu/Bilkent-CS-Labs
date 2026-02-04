import java.util.Scanner ;
public class Lab04_Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
    System.out.println("I have a random number in mind, try to guess what it is.");
    int secretNumber = (int) (100 * Math.random()) ;
    boolean done = true ;
    while(done) {
        System.out.print("Guess the number: ");
        int guess = in.nextInt();
    if ( Math.abs( (guess - secretNumber) ) < 10 && guess > secretNumber) {
        System.out.println("close but high, try again…");
        }
    else if (Math.abs( (guess - secretNumber) ) < 10 && guess < secretNumber) {
      System.out.println("close but low, try again…");  
    }
    else if (guess < secretNumber){
        System.out.println("too low, try again…");
    }
    else if (guess > secretNumber){
        System.out.println("too high, try again…");
    }
    else if (guess == secretNumber) {
        System.out.println("Congratulations, you guessed it!");
        done = false ;
    }
    
    


        }

        in.close();
    }
}  
