import java.util.Scanner ;
public class Lab03_Revision {

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
        System.out.println("3- Edit Movie Name");
        System.out.println("4- Logout");
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
        }}
        if (operation == 3 ) {
            System.out.println("-- Edit Movie Name --" ) ;
            System.out.print("Enter the movie name that you want to edit: " ); // BUNU YAPMIYOR HATAYI BUL DÜZELT
            String movieToEdit = in.nextLine();
            if(movieNames.indexOf(movieToEdit) == -1) {
                System.out.println("The movie is not on the list!");

            }
            else {
            System.out.print("Enter the move’s new name: ");
            String movieNewName = in.nextLine();
            System.out.println("Now, " + movieToEdit + " is known as " + movieNewName);
            System.out.println(movieNames.replace(movieToEdit, movieNewName));
            }
        }
        if (operation == 4) {
            System.out.println("Logged out successfully");
        }
        
    
        }
    
    else if (user.indexOf(infoToLogin) != -1 ) { 
        System.out.println("Welcome! Your role is User." ) ;
        System.out.println("1 - List Movies and Reviews");
        System.out.println("2 - Submit a Review");
        System.out.println("3 - Logout");
        System.out.println("Select an operation: ");
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
            if (newMovieReview.length() <= 10 ) {
                System.out.println("As your review was too short, we regret to inform you that we ignored it :(") ;
            }
            else {
            newMovieReview = movieToReview + " (" +  username + ") : " + newMovieReview + "\n" ;
            movieReviewsList = movieReviewsList + newMovieReview ;
            System.out.println(movieReviewsList);
        }
            }
        }

        if (operation == 3) {
            System.out.println("Logged out successfully");
        }
    }
    
    // where each username/password pair are separated by commas ensuring easy retrieval and verification. BUNU YAPMADIM BU NE


    else {
        System.out.println("You shall not pass!");
    }
    in.close();
    }
}
