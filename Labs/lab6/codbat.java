import java.util.Scanner ;
import java.util.Random ;
public class codbat { // LAB YLAN KUYRUK 
    static Random random = new Random() ;
    static Scanner in = new Scanner(System.in) ;
    static int foodX ;
    static int foodY ;
    static int snakeX ;
    static int snakeY ;
    static int [] snakeXArray = {1, 2};
    
    static boolean isGameOver = false ;
    static int y = 10 ;
    static int x = 1 ;
    static boolean done = true ;
    static String direction ;

    public static void moveSnake () {
        
        if (direction.equals("W")) {
            snakeY++;
        }
        if (direction.equals("A")) {
            snakeX--;
        }
        if (direction.equals("S")) {
            snakeY--;

        }
        if (direction.equals("D")) { // BÖYLE OLUNCA HEPSİ ÇALIŞIYOR
            snakeX++;
        }
        

    }

    public static void generateFood() { //DOĞRUSU BU 
        Random random = new Random() ;
        int newFoodX = random.nextInt(10) + 1 ;
        int newFoodY = random.nextInt(10) + 1 ;
        while ( newFoodX == foodX || newFoodY == foodY) {
        newFoodX = random.nextInt(10) + 1 ;
        newFoodY = random.nextInt(10) + 1 ;
        }
        foodX  = newFoodX ;
        foodY = newFoodY ;
        
    }

    public static void checkFood () {
        if ( snakeX == foodX &&  snakeY == foodY ) {
            System.out.println("Yum! Snake ate the food! ");

            generateFood();
        }
    }

    public static void isGameOver () {
        if (snakeX > 10 || snakeX < 1 || snakeY > 10 || snakeY < 1) {
            isGameOver = true ;
        }

    }

    public static void printGrid () {
        
            x = 1 ;
            y = 10 ;   // ÇOK ÖNEEEMLİ BURADA BUNLARI TEKRAR ESKİ HALİNE GETİRMEK
            while ( y > 0) {
                if (x == 10) {
                
                if (snakeX == x && snakeY == y) {
                System.out.println("S");
                }
                else if (foodX == x && foodY == y) {
                System.out.println("O");
                }
                else {
                  System.out.println(".");
                }
                x = 1 ;// bu ikisi burda olmalı
                y -- ; // bu da burda olmalı
                }
                else {
                if (snakeX == x && snakeY == y) {
                    System.out.print("S");
                }
                else if (foodX == x && foodY == y) {
                    System.out.print("O");
                }
                else {
                System.out.print(".");
                }
                
                x++;
                }
            }
            
        }


    public static void playGame () {
        generateFood();
        snakeX = random.nextInt(10) + 1 ;
        snakeY = random.nextInt(10) + 1 ;
        System.out.println("Welcome to Hungry Snake!");
            System.out.println("Use W (Up) , A (Left) , S (Down) , D (Right) to move. ");
        while (done) {
            
            printGrid();
            System.out.print("Move: ");
            direction = in.nextLine(); 
            moveSnake();
            checkFood();

            isGameOver();
            if ( isGameOver ) {
                done = false ;
                System.out.println("Game Over! Snake hit the wall.");
            }
        }

    }
    public static void main(String[] args) {
        playGame();

        

        
    }
}
