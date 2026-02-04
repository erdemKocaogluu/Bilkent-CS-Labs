import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class Analyzing {

    public static void main(String[] args) throws FileNotFoundException{
        // String filename = "text.txt";
        WordList wordList = new WordList() ;
        // // Scanner sc = new Scanner(new File(filename));
        ArrayList<String> x = new ArrayList<>() ;
        
        // while(sc.hasNext()) {
        // String line = sc.next();
        // wordList.setWords(line);
        // }
        String file = "sonnets.txt";
        Scanner sc = new Scanner(new File(file));
        while(sc.hasNextLine()) {
        String line = sc.nextLine();
        x.add(line) ;
        }
        sc.close();

       
        // sc.close();

        for (String word : x ) {
            wordList.setWords(word );
        }


    System.out.println(wordList.getOccuranceRatios());
    System.out.println(wordList.getWordLengthRatio());
    System.out.println(wordList.getProceedingLetterRatio('o'));
    ArrayList<String> a = wordList.getProceedingLetterRatio('o').get(0);
    ArrayList<String> b = wordList.getProceedingLetterRatio('o').get(1);
    System.out.println(a);
    System.out.println(b);

    }
}