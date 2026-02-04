import java.util.Scanner ;


public class method {
public static String reverse(String str)    {
    //string olsa ne olur
    int length = str.length() ;
    int count = length -1 ;
    String list = "" ;
    while ( count >= 0) {
        list += str.charAt(count) ;
        count -- ;
    }
    return list ;
}

public static boolean isPalindrome (String str) {

    if (str.equals(reverse(str))) {
        return true ;
    }
    else {
        return false ;
    }
}

public static boolean hasAllUniqueCharacter ( String str) {

    int count = 0 ;
    int length = str.length() ;
    boolean done = true ;
    while (count < length) {
        String word = str.charAt(count) + "" ;
        String withoutStr = str.substring(0, count) + str.substring(count + 1) ;
        if ( withoutStr.contains(word)) {
            done = false ;
        }
        count++;
    }

    if (!done ) {
        return false ;
    }
    else {
        return true ;
    }
}

public static void main(String[] args) {
    Scanner in = new Scanner ( System.in ) ;

    System.out.print("Enter a string: ");
    String input = in.next() ;
    System.out.println("Reversed String: " + reverse(input));
    System.out.println("Is Palindrome:" + isPalindrome(input));
    System.out.println("Has All Unique Characters: " + hasAllUniqueCharacter(input));
    in.close();
}
}