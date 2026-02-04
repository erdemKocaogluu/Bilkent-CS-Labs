package lab1;
public class Lab01_Q3 {

    public static void main(String[] args) {
    int n = 1 ;
    int F;
    double GoldenRatio = (1 + Math.sqrt(5)) / 2 ;
    final double h = (Math.pow(GoldenRatio , n) - Math.pow(-GoldenRatio, -n)) / Math.sqrt(5);
    F = (int) h ;
    System.out.println( F );
    

    }
}