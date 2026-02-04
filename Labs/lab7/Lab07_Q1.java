import java.util.Arrays;

public class Lab07_Q1 {
public static int[][] addMatrices (int[][] matrixOne , int[][] matrixTwo ) {
    boolean done = true ;
    int length1 = matrixOne.length ;
    int length2 = matrixOne[0].length;

            if(matrixOne.length != matrixTwo.length  ) {
                done = false ;
            }
            else {

                for (int i = 0 ; i < length1 ; i++) {

                    if (matrixOne[i].length != matrixTwo[i].length) {
                        done = false ;
                    }
                }
            }
            if (done) {
                int [][] sum = new int[length1][length2];

                for (int x = 0 ; x < length1 ; x++) {


                    for ( int y = 0 ; y < length2 ; y++) {
                        sum[x][y] = matrixOne[x][y] + matrixTwo[x][y] ;
                    }
                }


                return sum ;
            }
            return null;

           
        }

        public static boolean isIdentityMatrix(int[][] matrix) {

            int length1 = matrix.length ;
            int length2 = matrix[0].length ; 
            boolean bool = true ;
            int prevLength = matrix[0].length ;
            for (int y = 0 ; y < length1 ; y++ ) {

                if (matrix[y].length != prevLength || matrix[y].length != length1 ) {
                    return false ;
                }
                prevLength = matrix[y].length;
            }
            
            for(int i = 0 ; i < length1 ; i++) {


                for (int x = 0 ; x < length2 ; x++ ) {

                    if (x == i && matrix[i][x] != 1) {
                        bool = false ;
                    }
                    else if (x != i && matrix[i][x] != 0) {
                        bool = false ;
                    }
                }
            }

            return bool ;

        }

        public static int[][] rotateMatrix90Degrees(int[][] matrix) {
            int length1 = matrix.length ;
            int prevLength = matrix[0].length ;
            for (int x = 0 ; x < length1 ; x++ ) {

                if (matrix[x].length != prevLength || matrix[x].length != length1 ) {
                    return null ;
                }
                prevLength = matrix[x].length;
            }
            int length2 = prevLength ;

            int [][] output = new int[length1][length2] ;

            for (int i = 0 ; i < length1 ; i++ ) {

                for ( int x = 0 ; x< length2 ; x++ ) {

                    output[x][2-i] = matrix[i][x] ;
                }
            }
            return output ;

        }



        public static boolean isToeplitzMatrix(int[][] matrix) {

            int length1 = matrix.length ;
            int length2 = matrix[0].length ;

            for (int i = 0 ; i < length1 ; i++ ) {
                
                for (int a = 0 ; a < length2 ; a++) {

                    int x = a ; 
                    int y = i ;

                    while (y<length1 && x < length2 ) {
                        
                        if (matrix[i][a] != matrix[y][x])
                        return false ;

                        x++;
                        y++;
                    }

                }
                
            }
            return true ;
        }







        public static void printMatrix(int[][] matrix) {
            for(int [] val : matrix) {
                
                for (int v : val) {
                    System.out.printf("%4d" , v);
                }
                System.out.println();
            }
        }

    public static void main(String[] args) {

        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] matrixB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1} };
        int[][] matrixC = {{1, 2, 3, 4}, {5, 1, 2, 3}, {6, 5, 1, 2} };
        System.out.println("Initially matrix A is: ");
        printMatrix(matrixA);
        System.out.println("Initially matrix B is: ");
        printMatrix(matrixB);
        System.out.println("Initially matrix C is: ");
        printMatrix(matrixC);
        int[][] sum = addMatrices(matrixA, matrixB);
        System.out.println("Sum of matrices:");
        printMatrix(sum);
        System.out.println("Is matrixA an identity matrix? " +
        isIdentityMatrix(matrixA));
        int[][] rotatedMatrix = rotateMatrix90Degrees(matrixA);
        System.out.println("MatrixA rotated 90 degrees clockwise:");
        printMatrix(rotatedMatrix);
        System.out.println("Is matrixA a Toeplitz matrix? " +
        isToeplitzMatrix(matrixA));
        System.out.println("Is matrixC a Toeplitz matrix? " +
        isToeplitzMatrix(matrixC));
    }
}