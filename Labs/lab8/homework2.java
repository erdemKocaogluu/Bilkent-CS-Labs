import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random ;

public class homework2 {

    public static String findMostFrequentA(char[] arr, int k) {
        ArrayList<String> substrings = new ArrayList<String>() ;
        ArrayList<Integer> count = new ArrayList<Integer>() ; // can ı create arraylist even though it is not
        // written in the homework file????????
        // int iOfArrayList = 0 ;
        int length = arr.length;
        if (length < k) {
            return "" ;

        }
        else {
        for (int i = 0 ; i <= length-k ; i++) {
            String s = new String(arr,i,k) ;
            boolean done = false ;
            for ( int countNumber = 0 ; countNumber< substrings.size() ; countNumber++ ) {
                if (substrings.get(countNumber).equals(s)) {
                    done = true ;
                }
            }
            if (!done) {
                substrings.add(s) ;
                count.add(1) ;
                
            }
            else {
                int index = substrings.indexOf(s) ;
                count.set(index, count.get(index) + 1 ) ;
                
            }
            
        }
        int biggest = -1 ;
        int indexOfMostFrequent = 0 ;
        for (int x = 0 ; x < count.size() ; x++ ) {

            if (count.get(x) > biggest ) {
                biggest = count.get(x) ;
                indexOfMostFrequent = x;
            }

        }

        return substrings.get(indexOfMostFrequent) ;
    }
    }

    public static String findMostFrequentB(char[] arr, int k) {
        // BURADA DA AYNI CONSTRUCTORI KULLANABİLİR MİYİM
        int length = arr.length ;
        if (length < k) {
            return "" ;

        }
        else {
        String[] substrings = new String[length-k+1] ;
        for (int i = 0 ; i <= length-k ; i++) {
            String s = new String(arr,i,k) ;
            substrings[i] = s ;
        }
        Arrays.sort(substrings);
        int sequence = 1 ;
        int indexOfFrequent = 0 ;
        int longestSequence = -1 ;
        String s = substrings[0] ;
        for (int i = 1 ; i < substrings.length ; i++ ) {
            
            if (substrings[i].equals(s)) {
                sequence++;
            }

            else {
                if (sequence > longestSequence ) {
                    longestSequence = sequence ;
                    indexOfFrequent = i-1;
                }
                s = substrings[i] ;
                sequence = 1 ;
            }


        }
        if (sequence > longestSequence ) {
            longestSequence = sequence ;
            indexOfFrequent = substrings.length-1;
        }

        return substrings[indexOfFrequent] ;

        }
    }
public static void main(String[] args) {
    // char[] x = {'a','b','a','a','a','b','b','a'} ;
    // String n  = findMostFrequentA(x, 3) ;
    // String y  = findMostFrequentB(x, 3) ;

    // System.out.println(n);
    // System.out.println(y);

    Random random = new Random() ;
    int randomNumber;
    int n = 100 ;
    int i = 0 ;
    char[] characters = new char[n];
    while ( i < n && n<=100000) {
        randomNumber = random.nextInt(26) + 97 ; 
        characters[i] = (char)randomNumber ;



        i++;
        if (i == n) {
            Long timeBeforeA = System.nanoTime() ;
            String strA = findMostFrequentA(characters, 3) ;
            Long timeAfterABeforeB = System.nanoTime() ;
            String strB =findMostFrequentB(characters, 3);
            System.out.println(strA);
            System.out.println(strB);
            Long timeAfterB = System.nanoTime() ;
            System.out.printf("%s %14s %13s%n","Size","Time A (ns)","Time B (ns)");
            System.out.printf("%d %12d %12d%n",n,(int) (timeAfterABeforeB-timeBeforeA),(int) (timeAfterB-timeAfterABeforeB));
        n = n*10;
        i = 0;
        characters = new char[n] ;
        }
    }
    

}    
}