import java.util.ArrayList;
import java.util.Random;

public class WordList {
    private ArrayList<String> words  ;

    public WordList(){
        words = new ArrayList<String>() ;
        
        // while(sc.hasNext()) {
        //     String line = sc.next();
        //     x.add(line) ;
        //     }
    }


    public void addWord(String wordText){
        if (!words.contains(wordText)) {
            words.add(wordText) ;
        }
    }

    public void printExamples() {
        Random ran = new Random() ;
        if (words.size() >= 10) {
            int a = ran.nextInt(words.size()-10) ;
            for (int i = a ; i < a + 10 ; i++ ){
                System.out.println(words.get(i));
            }
        }
    }

    public boolean doesWordContainsTheLetter(char letter, int indexOfTheWord) {
        String word = words.get(indexOfTheWord) ;
        if (word.contains(letter+"")) {
            return true ;
        }
        return false ;
    }
    public char[] getAlphabet(){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',    
        'u','v','w','x','y','z' } ;  
        return alphabet ; 
    }

    public ArrayList<String> getOccuranceRatios() {
        char[] alphabet = getAlphabet() ;
        ArrayList<Integer> list = new ArrayList<>() ;
        ArrayList<String> returningList = new ArrayList<>() ;
        int size = words.size() ;
        for (int i = 0 ; i < alphabet.length ; i++ ){
            int count = 0 ;
            for (int a = 0 ; a < words.size() ; a++ ){
                if (words.get(a).contains(alphabet[i]+ "")) {
                    count++;
                }
            }
            list.add(count) ;
        }
        for (int b : list ){
            returningList.add(b + "/" + size ) ;
        }
        return returningList ;
    }

    public int getHighestLength() {
        int highest = 0 ;
        for (int i = 0 ; i < words.size() ; i++ ) {
            if (words.get(i).length() > highest ) {
                highest = words.get(i).length() ;
            }
        }
        return highest ;
    }

    public ArrayList<String> getWordLengthRatio() {
        int size = words.size() ;
        int word1Length = 0 ;
        int word2Length = 0 ;
        int word3Length = 0 ;
        int word4Length = 0 ;

        for (int i = 0 ; i < size ; i++ ) {
            if (words.get(i).length() == 1 ) {
                word1Length++;
            }
            if (words.get(i).length() == 2 ) {
                word2Length++;
            }
            if (words.get(i).length() == 3 ) {
                word3Length++;
            }
            if (words.get(i).length() == 4  ) {
                word4Length++;
            }

        }

        ArrayList<String> list = new ArrayList<>() ;
        list.add(word1Length + "/" +  this.getHighestLength() + "one-letter words") ;
        list.add(word2Length + "/" +  this.getHighestLength() + "two-letter words") ;
        list.add(word3Length + "/" +  this.getHighestLength() + "three-letter words") ;
        list.add(word4Length + "/" +  this.getHighestLength() + "four-letter words") ;
        return list ;
    }
    //(int) b falan nasıl yapılıyodu unuttum stringde falan oluyo muydu
    // BU ARRAYLİSTTEKİ İNDEX OF VE REMOVELARIN ÇALIŞMA BİÇİMLERİ NASILDI OBJECGT VE PRİMİTİVE DİFFİ FALAN
    // (INTEGER) 5  FALAN YAZMA MUHABBETİ REMOVEDA SIRF İNDEXİ DEĞİL DE OBJEYİ REMOVELASIN DİYE
    // doubledlettersgetoccuranceınt.get(i)++ işe yaramaz sadece int değişir obje değişmez set kullanmalısın
    // bu diğer objelerde de geçerli böyle önemli yerleri ATLAMAAA
    public ArrayList<ArrayList<String>> getProceedingLetterRatio(char character) {
        String letter = character + "" ;
        ArrayList<String> doubledLettersForString = new ArrayList<>() ;
        ArrayList<Integer> doubledLettersOccuranceInt = new ArrayList<>() ;
        ArrayList<String> doubledLettersRatios = new ArrayList<>() ;
        int size = words.size() ;
        for (int i = 0 ; i < size ; i++ ) {
            String word = words.get(i) ;
            
            for (int a = 0 ; a < word.length()-1 ; a++ ) {
                if ( word.charAt(a) == character ) {
                    String doubledLetterString = word.charAt(a) + ""+ word.charAt(a+1)  ;
                    if (!doubledLettersForString.contains(doubledLetterString)) {
                        doubledLettersForString.add(doubledLetterString) ;
                        doubledLettersOccuranceInt.add(1) ;
                    }
                    else {
                        int index = doubledLettersForString.indexOf(doubledLetterString) ;
                        doubledLettersOccuranceInt.set(doubledLettersForString.indexOf(doubledLetterString), doubledLettersOccuranceInt.get(doubledLettersForString.indexOf(doubledLetterString))+1) ;
                    }
                }
            }

        
        }
        int sum = 0 ;
        for (int i = 0 ; i < doubledLettersOccuranceInt.size() ; i++ ) {
            sum += doubledLettersOccuranceInt.get(i) ;
        }
        for (int i = 0 ; i < doubledLettersOccuranceInt.size() ; i++ ) {
            doubledLettersRatios.add(doubledLettersOccuranceInt.get(i) + "/" + sum) ;
        }

        ArrayList<ArrayList<String>> returning = new ArrayList<>() ;

        returning.add(doubledLettersForString) ;
        returning.add(doubledLettersRatios) ;

        return returning ;
    }



    public void setWords(String s) {
        words.add(s) ;
    }

}
