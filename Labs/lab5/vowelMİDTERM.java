import java.util.Scanner ;
public class vowelMİDTERM {

    public static void main(String[] args) {
        // sesli harflerin olduğu string
        String alphabetOfVowels = "aeiou" ;
        Scanner in = new Scanner ( System .in) ;
        System.out.print("Enter sentence: ");
        String sentence = in.nextLine() ;
        int lengthOfSentence = sentence.length ( ) ;
        int inputNumber = 0 ;
        int countOfVowel = 0 ;
        int count = 0 ;
        double totalCountOfVowel = 0 ; // BUNU DOUBLE YAPMAZSAN AŞAĞISI DA DÜZGÜN ÇIKMIYOR 3.0 ÇIKIYOR
        // kelime input al exit girene kadar // her input girildiğinde inputnumber a 1 ekle
        while (!sentence.equals("exit")) {
            lengthOfSentence = sentence.length() ;
            countOfVowel = 0;
            inputNumber ++;
            count = 0 ;// COUNTU YENİLEMEYİ YİNE UNUTTTUM LAAAAAANNNN
            while (count < lengthOfSentence) {
                
                if (alphabetOfVowels.contains(sentence.charAt(count) + "")) {
                    countOfVowel++;
                }
                count++;
            }
            totalCountOfVowel += countOfVowel ;

            System.out.print("Enter sentence: ");
            sentence = in.nextLine() ;
        }
        // lengthini bul ve o lengthe kadar olan harflere tek tek bak
        // eğer o string.contains ise countofvowel a 1 ekle ; 
        double output = totalCountOfVowel / inputNumber ;
        // sonuç = countofvowel / inputnumber olcak
        System.out.println(output);
    }
}