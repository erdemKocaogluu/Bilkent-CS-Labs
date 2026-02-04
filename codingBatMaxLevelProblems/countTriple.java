public class countTriple {
    /*
We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in the given string. The triples may overlap.


countTriple("abcXXXabc") → 1
countTriple("xxxabyyyycd") → 3
countTriple("a") → 0 */

public int countTriple(String str) {
 int length = str.length() ;
 int toplam = 0 ;
 if (length < 3) {
   return 0 ;
 }
 else {
   char before = str.charAt(0) ;
   int seq = 1 ;
   for (int i = 1 ; i < length ; i++ ) {
     if (str.charAt(i) == before ) {
       seq++;
     }
     else {
       int dif = seq - 2 ;
       if (dif > 0 ) {
         toplam += dif ;
       }
       seq = 1 ;
     }
     before = str.charAt(i) ; // bunu yenilemeyi de unutma
   }
   int dif = seq - 2 ;// HATA VERİR DİF VARİABLEINA GÖREMİYORUM DİYOR BİR KOŞULUN
   // İÇİNDE.... O NEDENLE SENİN TEKRAR İNT DİF YAZMAN LAZIM 
       if (dif > 0 ) {
         toplam += dif ;
       }
   
   return toplam ;
 }
}

}
