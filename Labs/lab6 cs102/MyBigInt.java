public class MyBigInt implements Comparable <MyBigInt>{

    int[] terstenSayı ;
    int effectiveLength ;

    public MyBigInt(String string) {
        this.terstenSayı = new int[200] ;

        if (string.equals("")) {
            throw new IllegalArgumentException("Input string boş olamaz");
        }

        for (char c : string.toCharArray() ) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Karakter olmayan sayı bulundu: " + c);
            }
        }

        String sonString = "" ;
        if (string.length() > 200 ) {
            sonString = string.substring(string.length() - 200 ) ;
        }
        else {
            sonString = string ;
        }

        string = sonString ; // BURDAN EMİN DEĞİLİM

        int length = 200 ;
        int a = 0 ;
        // for (int i = length - 1 ; i >= 0 ; i-- ) {
        //     char c = string.charAt(i)  ;
        //     terstenSayı[a] = Character.getNumericValue(c) ;
        //     a++;
        // }
        int len = sonString.length() ;
        for (int i = 0; i < len; i++) {
            String c = sonString.charAt(len - 1 - i) + "";
            this.terstenSayı[i] = Integer.parseInt(c);
        }

        sizeHesapla() ;


    }
    public MyBigInt(long val) {
        this(val + ""); // BURDAN EMİN DEĞİLİM
    }

    public MyBigInt() {
        terstenSayı = new int[200];
        effectiveLength = 1;
    }

    public void sizeHesapla() {
        int b = 0 ;
        int length = terstenSayı.length ;
        for (int i = length - 1  ; i >= 0 ; i-- ) { 
            if ( terstenSayı[i] != 0 ) {
                b = i ;
            }
        }
        effectiveLength = b + 1;
        
    }

    public MyBigInt addBigInt(MyBigInt otherInt) {
        MyBigInt sonuc = new MyBigInt() ;
        int length = 1 ;
        int eldeVar = 0;
        if (otherInt.effectiveLength > effectiveLength ) {
            length = otherInt.effectiveLength ;
        }
        else {
            length = effectiveLength ;
        }
        boolean done = true ;
        for (int i = 0 ; (i < length && done) || eldeVar != 0;  i++ ) {
            if (i >= 200 ){
                done = false ;
            }
            else {

                int toplam = eldeVar + otherInt.terstenSayı[i] + terstenSayı[i] ;

                eldeVar = toplam / 10 ;
                int eklenecekCurrent = toplam % 10 ;

                sonuc.terstenSayı[i] = eklenecekCurrent ;
                


            }
            
        }

        sonuc.sizeHesapla();
        return sonuc ;


    }

    public int compareTo(MyBigInt a) {
        if (a.effectiveLength > effectiveLength ) {
            return -1 ;
        }
        else if (a.effectiveLength < effectiveLength ) {
            return 1 ;
        }
        else {
            for (int i = effectiveLength -1 ; i >= 0 ; i-- ) { // BURDAN EMİN DEĞİLİM
                if (this.terstenSayı[i] > a.terstenSayı[i] ) {
                    return 1 ;
                }
                if (this.terstenSayı[i] < a.terstenSayı[i] ) {
                    return -1 ;
                }
            }

        }

        return 0 ;

        
    }



public MyBigInt add(MyBigInt other) {
    return addBigInt(other);
}

public MyBigInt subtract(MyBigInt other) {
    return subtraxt(other);
}

public MyBigInt multiply(MyBigInt other) {
    return çarpma(other);
}

public int compare(MyBigInt other) {
    return compareTo(other);
}

    public MyBigInt subtraxt(MyBigInt a) {
        MyBigInt sonuc = new MyBigInt() ;
        if (this.compareTo(a) == -1 ) {
            throw new ArithmeticException("Sonux negatif olmamalı") ;
        }

        else {
            int komşudanAl = 0 ;
            // int max = Math.

            for (int i = 0 ; i < this.effectiveLength ; i++ ) {
                int çıkarım = this.terstenSayı[i]  ;
                // çıkarım = çıkarım - a.terstenSayı[i]  ;
                // çıkarım = çıkarım - komşudanAl ;

                // if (çıkarım < 0 ) {
                //     çıkarım = çıkarım +1 ;
                //     çıkarım = çıkarım + 9 ;
                //     komşudanAl = 1 ;
                // }
                // else {
                //     komşudanAl = 0 ;
                // }

                çıkarım = çıkarım - a.terstenSayı[i]  - komşudanAl ;

                if (çıkarım < 0) {
                    çıkarım += 10;      
                    komşudanAl = 1;
                } else {
                    komşudanAl = 0;
                }

                sonuc.terstenSayı[i] = çıkarım ;

            

            }
            sonuc.sizeHesapla();
            return sonuc ;
        }



    }


    public MyBigInt normalÇarpma(MyBigInt bir , MyBigInt iki) {

        // 20 basamaktan küçük mü zaten önceden kontrol et

        // int length = Math.max(a.effectiveLength, effectiveLength) ;
        // MyBigInt sonuc = new MyBigInt() ;
        // int length = effectiveLength ;
        // MyBigInt toplam = new MyBigInt() ;
        // for (int i = 0 ; i < bir.effectiveLength ; i++ ) {
        //     // toplam.addBigInt(new MyBigInt(terstenSayı[i]*a.terstenSayı +"")) ;

            
        // }

        MyBigInt sonuc = new MyBigInt() ;
        boolean done = true ;
        for (int i = 0 ; i < bir.effectiveLength ; i++ ) {
            int eldeVar = 0 ;
            for (int a = 0 ; (a < iki.effectiveLength || eldeVar > 0) && done   ; a++ ) {
                if (a + i >= 200 ) {
                    done = false ;
                }
                else {
                    int bDeğer = 0 ;
                    if (a < iki.effectiveLength ) { ///////////// DEĞİŞTİRDİM
                        bDeğer = iki.terstenSayı[a] ;
                    }
// 20 basamaktan küçük mü zaten önceden kontrol et

        // int length = Math.max(a.effectiveLength, effectiveLength) ;
        // MyBigInt sonuc = new MyBigInt() ;
        // int length = effectiveLength ;
        // MyBigInt toplam = new MyBigInt() ;
        // for (int i = 0 ; i < bir.effectiveLength ; i++ ) {
        //     // toplam.addBigInt(new MyBigInt(terstenSayı[i]*a.terstenSayı +"")) ;

            
        // }
                    // int number = sonuc.terstenSayı[a + i ] ;
                    // number += (bir.terstenSayı[a] * bDeğer) ;
                    // number += eldeVar ;
                    // sonuc.terstenSayı[a+i ] = number % 10 ;
                    // eldeVar = number / 10 ;

                    int çarpım = (bir.terstenSayı[i] * bDeğer) + eldeVar + sonuc.terstenSayı[i + a];
                    sonuc.terstenSayı[i + a] = çarpım % 10;
                    eldeVar = çarpım / 10;



                }
            }
        }
        sonuc.sizeHesapla();
        return sonuc ;

    }


    public MyBigInt üstAyır(int a ) {
        MyBigInt sonuc = new MyBigInt() ;
        for (int i = a ; i < 200 ; i++ ) {
            sonuc.terstenSayı[i-a] = terstenSayı[i] ;
        }
        sonuc.sizeHesapla();
        return sonuc ;

    }


    public MyBigInt altAyır(int a ) {
        MyBigInt sonuc = new MyBigInt() ;
        for (int i = 0 ; i < a && i < 200; i++ ) {
            sonuc.terstenSayı[i] = this.terstenSayı[i] ;

        }
        sonuc.sizeHesapla();
        return sonuc ;

    }

    private MyBigInt karatsubaMultiply(MyBigInt bir , MyBigInt iki ) {
        int number = Math.max(bir.effectiveLength, iki.effectiveLength) ;
        if (number <= 20 ) {
            return normalÇarpma(bir, iki) ;
        }
        else { // (Y1 * 10 + A1 ) * (Y2 * 10 + A2 ) = Y1Y2* 100 + Y1A2* 10 + Y2A1 * 10 + A1A2 
            // 20 basamaktan küçük mü zaten önceden kontrol et

        // int length = Math.max(a.effectiveLength, effectiveLength) ;
        // MyBigInt sonuc = new MyBigInt() ;
        // int length = effectiveLength ;
        // MyBigInt toplam = new MyBigInt() ;
        // for (int i = 0 ; i < bir.effectiveLength ; i++ ) {
        //     // toplam.addBigInt(new MyBigInt(terstenSayı[i]*a.terstenSayı +"")) ;

            
        // }
                    // int number = sonuc.terstenSayı[a + i ] ;
                    // number += (bir.terstenSayı[a] * bDeğer) ;
                    // number += eldeVar ;
                    // sonuc.terstenSayı[a+i ] = number % 10 ;
                    // eldeVar = number / 10 ;
            int araNumber =  ( number / 2 ) +  ( number % 2 )  ;
            MyBigInt yukarıBir = bir.üstAyır(araNumber) ;
            MyBigInt aşağıBir = bir.altAyır(araNumber) ;
            MyBigInt yukarıİki = iki.üstAyır(araNumber) ;
            MyBigInt aşağıİki = iki.altAyır(araNumber) ;

        MyBigInt a1a2 = aşağıBir.çarpma(aşağıİki);
        MyBigInt y1y2 = yukarıBir.çarpma(yukarıİki);
        
        MyBigInt sum1 = aşağıBir.addBigInt(yukarıBir);
        MyBigInt sum2 = aşağıİki.addBigInt(yukarıİki);
        MyBigInt z1ilkHali = sum1.çarpma(sum2);
        
        MyBigInt z1 = z1ilkHali.subtraxt(y1y2).subtraxt(a1a2);

        MyBigInt y1y2SıfırEklendi = y1y2.sonunaSıfırEkle(2 * araNumber);
        MyBigInt z1SonunaSıfırEklendi = z1.sonunaSıfırEkle(araNumber);
        
        return y1y2SıfırEklendi.addBigInt(z1SonunaSıfırEklendi).addBigInt(a1a2);


        }
    }


    private MyBigInt sonunaSıfırEkle(int a ) {
        MyBigInt sonuc = new MyBigInt() ;
        for (int i = 0 ; i < 200 - a ; i++ ) {
            sonuc.terstenSayı[i+ a] = this.terstenSayı[i] ;
        }
        sonuc.sizeHesapla();
        return sonuc ;
    }

    public MyBigInt çarpma(MyBigInt a ) {
        int büyükLength = Math.max(effectiveLength, a.effectiveLength) ;
        if (büyükLength > 20 ) {
            return karatsubaMultiply(a, this ) ;
        }
        else {
            return normalÇarpma(a, this ) ;
        }

    }


    public String toString() {
        String sonuc = "" ;
        for (int i = effectiveLength - 1 ; i >= 0 ; i-- ) {
            sonuc = sonuc + terstenSayı[i] ;
            
        }
        return sonuc ;

    }


    
}