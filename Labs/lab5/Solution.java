class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0 ) {
            return false ;
        }
        String a = x+"" ;
        int first = 0 ;
        int last = a.length() -1 ;
        while (first > last) { // DOĞRUSU BU ÇÜNKÜ HİÇBİR ZAMAN EŞİT OLMAYABİLİR 
            // MESELA SAYI 6 HANELİYSE YANİ ÇİFT HANELİYSE FİRST > LAst olur AMA EŞİT OLMAZ

            if (a.charAt(first) != a.charAt(last) ) {
                return false ;
            }
            first++;
            last--;
        }
        
            return true ;
        
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12344321));
    }
}