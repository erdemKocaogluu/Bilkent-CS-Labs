import java.util.Arrays;

public class Uretici {
    
    public static MyBigInt[] generateList(MyBigInt baslangicTohumu, int adet) {
        
        // Sonuçları saklayacağımız dizi
        MyBigInt[] sonucListesi = new MyBigInt[adet];
        MyBigInt aktifDeger = baslangicTohumu;
        
        // 'n' basamak sayısı (Seed'in uzunluğu sabittir)
        int n = baslangicTohumu.toString().length();

        for (int i = 0; i < adet; i++) {
            
            
            // MyBigInt içindeki 'multiply' ve 'add' metodlarını kullanıyoruz.
            MyBigInt kareDeger = aktifDeger.multiply(aktifDeger);
            MyBigInt hesaplanan = kareDeger.add(aktifDeger);
            
            String sVal = hesaplanan.toString();
            
            // Sayı uzunluğu 2n olana kadar başa '0' ekle.
            while (sVal.length() < 2 * n) {
                sVal = "0" + sVal;
            }
            
            // 3. ADIM: Ortayı Alma (Middle Extraction)
            // Başlangıç noktası: (Uzunluk - n) / 2
            int baslangicIndex = (sVal.length() - n) / 2;
            String middle = sVal.substring(baslangicIndex, baslangicIndex + n);

            // HATA BURADAYDI: y++ yerine y-- olmalı (Sola kaydırma)
            // Eğer sayı '0' ile başlıyorsa ve sola gidecek yerimiz varsa (index > 0)
            while (baslangicIndex > 0 && middle.charAt(0) == '0') {
                baslangicIndex--; // İndeksi azaltarak SOLA kaydırıyoruz
                middle = sVal.substring(baslangicIndex, baslangicIndex + n);
            }
            
            // Yeni sayıyı oluştur ve listeye kaydet
            aktifDeger = new MyBigInt(middle);
            sonucListesi[i] = aktifDeger;
        }
        
        return sonucListesi;
    }
}