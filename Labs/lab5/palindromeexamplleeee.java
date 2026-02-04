import java.util.Scanner ;

public class palindromeexamplleeee {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Cümle giriniz: ");
        
        String word = "";
        String list = "";
        int indexOfPreviousSpace = -1;
        String sentence = in.nextLine();
        boolean done = true;
        
        sentence = sentence.trim(); 
        int indexOfCurrentSpace = sentence.indexOf(" ");

        while (indexOfCurrentSpace != -1 && done) {
            word = sentence.substring(indexOfPreviousSpace + 1, indexOfCurrentSpace);
            
            list = ""; 
            
            int lengthOfWord = word.length();
            int count = lengthOfWord - 1;
            
            while (count > -1) {
                list += word.charAt(count);
                count--;
            }
            
            if (!list.equalsIgnoreCase(word)) { 
                done = false;
            }

            indexOfPreviousSpace = indexOfCurrentSpace;
            indexOfCurrentSpace = sentence.indexOf(" ", indexOfCurrentSpace + 1);
        }

        
        if (done) { 
            String wordLast = sentence.substring(indexOfPreviousSpace + 1);
            int sayac = wordLast.length() - 1;
            String listLast = "";
            
            while (sayac > -1) {
                listLast += wordLast.charAt(sayac);
                sayac--;
            }
            
            if (!listLast.equalsIgnoreCase(wordLast)) {
                done = false;
            }
        }

        if (!done) {
            System.out.println("it is not palindrome");
        } else {
            System.out.println("it is a palindrome");
        }
    }
}
