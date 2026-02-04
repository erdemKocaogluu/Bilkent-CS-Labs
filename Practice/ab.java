public class ab {

    public static void main(String[] args) {
        String str = "abc" ;
        char b = 'b' ;
        String c = b ;
        if ( str.contains(c)) {  // CONTAİNSİN İÇİNE CHAR YAZMAMALISIN SYNTAX COMPİLE ERROR VERİR
            System.out.println("yes");
        }

        if ( str.contains(b + "")) { // BU DOĞRU YOL BURADA HATA VERMEZ DİREKT yes YAZDIRIR
            System.out.println("yes"); 
        }
    }
}