import java.util.Arrays;
import java.util.Random;

public class SortAlgroitma {

    public static <T extends Comparable<T> > void bubbleSort(T[] array ) {
        int length = array.length ;
        boolean devam = true ;

        for (int i = 0 ; i < length - 1 && devam ; i++ ) {
            boolean değiştiMi = false ;

            for (int j = 0 ; j < length - 1 - i ; j++ ) {
                if (array[j].compareTo(array[j+1] ) > 0 ) {
                    swap(array, j , j+1 ) ;
                    System.out.println(Arrays.toString(array));
                    değiştiMi = true ;
                }
            }

            if (!değiştiMi ) {
                devam = false ;
            }
        }
        
    }

    public static <T extends Comparable<T> > void mergeSort(T[] array ){
        int length = array.length ;
        if (length < 2 ) {
            return ;
        }
        else {
            int mid = length / 2 ;

            // T[] first = new T[mid] ; // BU NEDEN BÖYLE OLMUYOR????

            T[] first = (T[] ) (new Comparable[mid]) ;
            T[] second = (T[] ) (new Comparable[length - mid ]) ;

            for (int i = 0 ; i < mid ; i++ ){
                first[i] = array[i] ;
            }

            // for (int i = mid ; i < length ; i++ ) {
            //     second[i - mid ] = array[i] ;
            // } alttaki mi daha iyi bu mu kararsızım


            for (int a = 0 ; a < length - mid ; a++ ) {
                second[a] = array[a + mid ] ;
            }

            mergeSort(first);
            mergeSort(second);
            merge(array, first, second) ;




        }

    }


    public static <T extends Comparable<T> > void merge(T[] array ,T[] first,T[] second ) {
        // int firstİçin = 0 ; int secondİçin = 0 ; int arrayİçin = 0 ;
        // while (firstİçin < first.length && secondİçin < second.length && arrayİçin < array.length ) { // ŞU ARRAYİÇİN < ARRAY.LENGTH GEREK VAR MI
        //     int i = first[firstİçin].compareTo(second[secondİçin]) ;
        //     if ( i < 0  ) {
        //         array[arrayİçin] = first[firstİçin] ;
        //         arrayİçin++;
        //         firstİçin++;
        //     }
        //     else if ( i > 0 ) {
        //         array[arrayİçin] = second[secondİçin] ;
        //         arrayİçin++;
        //         secondİçin++;
        //     }
        //     else if (i == 0 ) {
        //         array[arrayİçin] = first[firstİçin] ;
        //         arrayİçin++;
        //         array[arrayİçin] = second[secondİçin] ;
        //         firstİçin++;
        //         secondİçin++;
        //     }


        // }

        // if (secondİçin < second.length ) {
        //     for (int i = secondİçin ; i < second.length && arrayİçin < array.length; i++ ) { // ŞU ARRAYİÇİN < ARRAY.LENGTH GEREK VAR MI
        //         array[arrayİçin] = second[i] ;
        //         arrayİçin++;
        //     }
        // }
        // else if (firstİçin < first.length ) {
        //     for (int i = firstİçin ; i < first.length && arrayİçin < array.length; i++ ) { // ŞU ARRAYİÇİN < ARRAY.LENGTH GEREK VAR MI
        //         array[arrayİçin] = first[i] ;
        //         arrayİçin++;
        //     }
        // }



        int i = 0; 
        int j = 0; 
        int k = 0; 

        while (i < first.length && j < second.length) {
            int durum = first[i].compareTo(second[j]);
            
            
            if (durum <= 0) {
                array[k] = first[i];
                i++;
            } else {
                array[k] = second[j];
                j++;
            }
            k++;
        }

        while (j < second.length) {
            array[k] = second[j];
            j++;
            k++;
        }
        
        while (i < first.length) {
            array[k] = first[i];
            i++;
            k++;
        }


    }

    public  static <T extends Comparable<T> > void swap(T[] array, int firstIndex , int lastIndex ) {
        T f = array[firstIndex] ;
        T s = array[lastIndex] ;
        array[firstIndex] = s ;
        array[lastIndex] = f ;
    }


    public  static <T extends Comparable<T> > int partitionNormal(T[] array, int left , int right ) {
        int pivotunIndexi = left ;
        int l = left + 1 ;
        int r = right ;
        boolean done = true ;
        T pivot = array[pivotunIndexi] ;
        while (done) {
            while(l <= right && (array[l].compareTo(pivot) < 0 || array[l].compareTo(pivot) == 0)) {
                l++;
            }
            while (array[r].compareTo(pivot) > 0) {
                r-- ;
            }
            if (l > r ) {
                done = false ;
            }
            else {
                T p = array[l] ;
                T ş = array[r] ;
                array[l] = ş ;
                array[r] = p ;
                l++; 
                r--;
            }

        }
        T p = array[left] ;
        T ş = array[r] ;
        array[left] = ş ;
        array[r] = p ;

        return r ;
        
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, String mode) {
        if (low < high) {
            int a = 0 ;
            // int pi = partition(arr, low, high, mode);
            if (mode.equals("normal")) {
                a = partitionNormal(array, low, high) ;
            }
            else if (mode.equals("random")) {
                a = partitionRandom(array, low, high);
            }
            else if (mode.equals("median")) {
                a = partitionMedian(array, low, high) ;
            }
            quickSort(array, low, a - 1, mode);
            quickSort(array, a + 1, high, mode);
        }
    }

    public static <T extends Comparable<T>> void quickSortStandard(T[] arr) {
        quickSort(arr, 0, arr.length - 1, "normal");
    }

    public static <T extends Comparable<T>> void quickSortRandom(T[] arr) {
        quickSort(arr, 0, arr.length - 1, "random");
    }

    public static <T extends Comparable<T>> void quickSortMedian(T[] arr) {
        quickSort(arr, 0, arr.length - 1, "median");
    }


    public static <T extends Comparable<T> > int partitionMedian(T[] array, int left , int right ) {
        T aşağıdaki = array[left] ;
        T yukarıdaki = array[right] ;
        int ortaIndex = left +  ( (right - left ) / 2 )  ; // LEFTİ EKLEMEM GEREKİYO DİMİ TEKRAR ARALIĞA SOKABİLMEK İÇİN
        T ortadaki = array[ortaIndex] ;
        if (array[left].compareTo(array[ortaIndex]) > 0) swap(array, left, ortaIndex);
        if (array[left].compareTo(array[right]) > 0) swap(array, left, right);
        if (array[ortaIndex].compareTo(array[right]) > 0) swap(array, ortaIndex, right);
        int pivotIndex = ortaIndex ;
        swap(array, pivotIndex, left);
        int a = partitionNormal(array, left, right) ;
        return a ;
    }

    // 0 1 2 3 4 5 6 7 8
    // 0 1 2 3 5 4 6 7 8  
    public  static <T extends Comparable<T> > int partitionRandom(T[] array, int left , int right ) {
        Random ran = new Random( ) ;
        int randomIndex = ran.nextInt(right - left + 1) + left ; // RANDOMUN İÇİNE +1 KOYMALI MIYIM????
        T lefttekiGeçici = array[left] ;
        T pivottakiGeçici = array[randomIndex] ;
        swap(array, left, randomIndex);
        // T pivot = array[left] ;
        // int l = left + 1 ;
        int a = SortAlgroitma.partitionNormal(array, left, right) ;
        return a ;

    }

    // BU PARTİTİONLAR SORTLAR VE BUNLARIN METHODLARI YANİ RECURSİVE OLMAYAN YENİ BİR TANE KOYUP ONU RECURSİVE E BAĞLAMA İŞLERİNİ FALAN
    // SAKIN UNUTMMAAA!!!!














}