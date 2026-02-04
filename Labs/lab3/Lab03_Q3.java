import java.util.Scanner ;
public class Lab03_Q3 {

    public static void main(String[] args) {
    Scanner in = new Scanner(System.in) ;
    System.out.print("Enter your username: ");
    String username = in.nextLine() ;
    System.out.print("Enter your password: ");
    String password = in.nextLine() ;
    String movieNames = "Joker 2,Gladiator 2,Fear,Inception,Cape Fear" ;
    String movieReviewsList = 
    "Joker 2 (Jinx): Waste of time\n" +
    "Joker 2 (Jayce): It is trash. Don't watch\n"+
    "Joker 2 (Caitlyn): I like Lady Gaga\n"+                  
    "Gladiator 2 ( Jayce ): I really luved it *_* \n" ;
    String admin = "Violet#Cupcake" ;
    String user = "Jinx#Jinx , Jayce#Jayce , Caitlyn#Caitlyn " ;
    String infoToLogin = username + "#" + password ;    
    
    if ( infoToLogin.equals(admin)) {   
        System.out.println("Welcome! Your role is Admin." ) ;
        System.out.println("1- Add Movie");
        System.out.println("2- Delete Movie");
        System.out.println("3- Logout");
        System.out.print("Select an operation: ");
        int operation = in.nextInt() ;
        in.nextLine();
        if (operation == 1 ) {
            System.out.println(movieNames);
            System.out.println("Enter movie name to add:");
            String newMovie = in.nextLine() ;
            int firstCharOfMovieToAdd = movieNames.indexOf(newMovie) ;
            if ( firstCharOfMovieToAdd != -1) 
        System.out.println("This movie is already on your list"); 
        
            else{
            System.out.println("Movie added!");
            movieNames = movieNames + "," + newMovie ;
            System.out.println(movieNames);
        }}
        if (operation == 2 ) {
            System.out.print("Enter movie name to delete:" ) ;
            String movieToDelete = in.nextLine() ;
            int firstCharOfMovieToDelete = movieNames.indexOf(movieToDelete) ;
            if(firstCharOfMovieToDelete!=-1){
            int deleteMovieLength = movieToDelete.length();
            String newMovieList = movieNames.substring(0, firstCharOfMovieToDelete) + movieNames.substring(firstCharOfMovieToDelete+deleteMovieLength+1) ;
            System.out.println("Movie deleted!");
            System.out.println(newMovieList);
            }
            else {
            System.out.println("The movie is not on the list!");
        }
        if (operation == 3) {
            System.out.println("Logged out successfully");
        }
        
    
        }
    }
    else if (user.indexOf(infoToLogin) != -1 ) { 
        System.out.println("Welcome! Your role is User." ) ;
        System.out.println("1 - List Movies and Reviews");
        System.out.println("2 - Submit a Review");
        System.out.println("3 - Logout");
        System.out.print("Select an operation: ");
        int operation = in.nextInt() ;
        in.nextLine() ;
        if (operation == 1 ) {
            System.out.println(movieNames);
            System.out.println(movieReviewsList);
        }
        if (operation == 2) {
            System.out.print("Enter movie name to review:");
            String movieToReview = in.nextLine() ;
            int firstCharOfMovieToReview = movieNames.indexOf(movieToReview ) ;
            if (firstCharOfMovieToReview == -1 ) {
                System.out.println("Movie not found");
            }
            else {
                System.out.print("Enter review: ");
            String newMovieReview = in.nextLine() ;
            newMovieReview = movieToReview + " (" +  username + ") : " + newMovieReview + "\n" ;
            movieReviewsList = movieReviewsList + newMovieReview ;
            System.out.println(movieReviewsList);
            }
        }

        if (operation == 3) {
            System.out.println("Logged out successfully");
        }
    }

    else {
        System.out.println("You shall not pass!");
    }
    in.close();
    }
}