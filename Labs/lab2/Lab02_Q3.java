import java.util.Scanner ;
public class Lab02_Q3 {

    public static void main(String[] args) {
    Scanner in = new Scanner( System.in ) ;
    System.out.print("Enter your name: ");
    String name = in.nextLine();
    System.out.print("Enter your favorite color: ") ;
    String favoriteColor = in.next() ;
    int h = name.length() - 1;
    char x = name.charAt(0) ;
    char y = name.charAt(h) ;
    int last = favoriteColor.length() - 1 ;
    String favoriteColorMiddle = favoriteColor.substring(1, last) ;
    StringBuilder sb = new StringBuilder(favoriteColorMiddle);
    favoriteColorMiddle = sb.reverse().toString() ;
    String reversedVersion = favoriteColor.charAt(0) + (favoriteColorMiddle) + favoriteColor.charAt(last);
    System.out.print(y + name.substring(1 , h) + x + reversedVersion + "ion");
    in.close();
    }        

    }