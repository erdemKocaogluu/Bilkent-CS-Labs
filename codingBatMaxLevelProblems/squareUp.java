public class squareUp {
    /*
Given n>=0, create an array length n*n with the following pattern, shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).


squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
squareUp(2) → [0, 1, 2, 1]
squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1] */

public int[] squareUp(int n) {
  int sayac = 0 ;
  int[] array = new int[n*n] ;
  for (int i = n ; i >0 ; i--) {
    
    for (int x = 1 ; x <= i ; x++ ) {
      array[sayac] = x ;
      sayac++;
    }
    for (int y = 0 ; y < n - i ; y++ ) {
      array[sayac] = 0 ;
      sayac++;
    }
    
  }
  int[] output = new int[array.length] ;
  for (int i = 0 ; i < array.length ; i++ ) {
    output[i] = array[array.length-1-i] ;
  }
  return output ;
}

}
