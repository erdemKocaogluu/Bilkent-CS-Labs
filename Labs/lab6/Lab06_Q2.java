import java.util.Scanner ;
import java.util.Random ;
public class Lab06_Q2 {
    static Random random = new Random() ;
    static Scanner in = new Scanner(System.in) ;
    static int foodX ;
    static int foodY ;
    static int snakeX ;
    static int snakeY ;
    static boolean isGameOver = false ;
    static int y = 10 ;
    static int x = 1 ;
    static boolean done = true ;
    static String direction ;
    static int snakeBeforex = 20 ;
    static int snakeBeforey = 20 ;
    static int snake2Beforex = 20 ;
    static int snake3Beforex = 20 ;
    static int snake4Beforex = 20 ;
    static int snake5Beforex = 20 ;
    static int snake6Beforex = 20 ;
    static int snake7Beforex = 20 ;
    static int snake8Beforex = 20 ;
    static int snake9Beforex = 20 ;
    static int snake10Beforex = 20 ;
    static int snake11Beforex = 20 ;
    static int snake12Beforex = 20 ;
    static int snake2Beforey = 20 ;
    static int snake3Beforey = 20 ;
    static int snake4Beforey = 20 ;
    static int snake5Beforey = 20 ;
    static int snake6Beforey = 20 ;
    static int snake7Beforey = 20 ;
    static int snake8Beforey = 20 ;
    static int snake9Beforey = 20 ;
    static int snake10Beforey = 20 ;
    static int snake11Beforey = 20 ;
    static int snake12Beforey = 20 ;
    static int snake2x = 20 ;
    static int snake2y = 20 ;
    static int snake3x = 20 ;
    static int snake3y = 20 ;
    static int snake4x = 20 ;
    static int snake4y = 20 ;
    static int snake5x = 20 ;
    static int snake5y = 20 ;
    static int snake6x = 20 ;
    static int snake6y = 20 ;
    static int snake7x = 20 ;
    static int snake7y = 20 ;
    static int snake8x = 20 ;
    static int snake8y = 20 ;
    static int snake9x = 20 ;
    static int snake9y = 20 ;
    static int snake10x = 20 ;
    static int snake10y = 20 ;
    static int snake11x = 20 ;
    static int snake11y = 20 ;
    static int snake12x = 20 ;
    static int snake12y = 20 ;
public static void generateSnakeTail () {

}

    public static void moveSnake () {
        
        if (direction.equals("W")) {
            snakeBeforex = snakeX ;
            snakeBeforey = snakeY ;
            snakeY++;
        }
        if (direction.equals("A")) {
            snakeBeforex = snakeX ;
            snakeBeforey = snakeY ;
            snakeX--;
        }
        if (direction.equals("S")) {
            snakeBeforex = snakeX ;
            snakeBeforey = snakeY ;
            snakeY--;

        }
        if (direction.equals("D")) { // BÖYLE OLUNCA HEPSİ ÇALIŞIYOR
            snakeBeforex = snakeX ;
            snakeBeforey = snakeY ;
            snakeX++;
        }
        if (snake2x < 20 ) {
            snake2Beforex = snake2x ;
            snake2Beforey = snake2y ;
            snake2x = snakeBeforex ;
            snake2y = snakeBeforey ;
        }
        if (snake3x < 20 ) {
            snake3Beforex = snake3x ;
            snake3Beforey = snake3y ;
            snake3x = snake2Beforex ;
            snake3y = snake2Beforey ;
        }
        if (snake4x < 20 ) {
            snake4Beforex = snake4x ;
            snake4Beforey = snake4y ;
            snake4x = snake3Beforex ;
            snake4y = snake3Beforey ;
        }
        if (snake5x < 20 ) {
            snake5Beforex = snake5x ;
            snake5Beforey = snake5y ;
            snake5x = snake4Beforex ;
            snake5y = snake4Beforey ;
        }
        if (snake6x < 20 ) {
            snake6Beforex = snake6x ;
            snake6Beforey = snake6y ;
            snake6x = snake5Beforex ;
            snake6y = snake5Beforey ;
        }
        if (snake7x < 20 ) {
            snake7Beforex = snake7x ;
            snake7Beforey = snake7y ;
            snake7x = snake6Beforex ;
            snake7y = snake6Beforey ;
        }
        if (snake8x  < 20 ) {
            snake8Beforex = snake8x ;
            snake8Beforey = snake8y ;
            snake8x = snake7Beforex ;
            snake8y = snake7Beforey ;
        }
        if (snake9x < 20 ) {
            snake9Beforex = snake9x ;
            snake9Beforey = snake9y ;
            snake9x = snake8Beforex ;
            snake9y = snake8Beforey ;
        }
        if (snake10x < 20 ) {
            snake10Beforex = snake10x ;
            snake10Beforey = snake10y ;
            snake10x = snake9Beforex ;
            snake10y = snake9Beforey ;
        }
        if (snake11x < 20 ) {
            snake11Beforex = snake11x ;
            snake11Beforey = snake11y ;
            snake11x = snake10Beforex ;
            snake11y = snake10Beforey ;
        }
        if (snake12x < 20 ) {
            snake12Beforex = snake12x ;
            snake12Beforey = snake12y ;
            snake12x = snake11Beforex ;
            snake12y = snake11Beforey ;
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
            if (snake2x == 20 ) {
                snake2x = snakeBeforex ;
                snake2y = snakeBeforey ;
            }
            else if (snake3x == 20 ) {
                snake3x = snake2Beforex ;
                snake3y = snake2Beforey ;
            }
            else if (snake4x == 20 ) {
                snake4x = snake3Beforex ;
                snake4y = snake3Beforey ;
            }
            else if (snake5x == 20 ) {
                snake5x = snake4Beforex ;
                snake5y = snake4Beforey ;
            }
            else if (snake6x == 20 ) {
                snake6x = snake5Beforex ;
                snake6y = snake5Beforey ;
            }
            else if (snake7x == 20 ) {
                snake7x = snake6Beforex ;
                snake7y = snake6Beforey ;
            }
            else if (snake8x == 20 ) {
                snake8x = snake7Beforex ;
                snake8y = snake7Beforey ;
            }
            else if (snake9x == 20 ) {
                snake9x = snake8Beforex ;
                snake9y = snake8Beforey ;
            }
            else if (snake10x == 20 ) {
                snake10x = snake9Beforex ;
                snake10y = snake9Beforey ;
            }
            else if (snake11x == 20 ) {
                snake11x = snake10Beforex ;
                snake11y = snake10Beforey ;
            }
            else if (snake12x == 20 ) {
                snake12x = snake11Beforex ;
                snake12y = snake11Beforey ;
            }
            
            printGrid(); 
            generateFood();
        }
    }

    public static void isGameOver () {
        if (snakeX > 10 || snakeX < 1 || snakeY > 10 || snakeY < 1 || (snakeX == snake2x && snakeY == snake2y) || (snakeX == snake3x && snakeY == snake3y) ||(snakeX == snake4x && snakeY == snake4y) ||(snakeX == snake5x && snakeY == snake5y) ||(snakeX == snake6x && snakeY == snake6y) ||(snakeX == snake7x && snakeY == snake7y) ||(snakeX == snake8x && snakeY == snake8y) ||(snakeX == snake9x && snakeY == snake9y) ||(snakeX == snake10x && snakeY == snake11y) ||(snakeX == snake12x && snakeY == snake12y)  ) {
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
                if ((snakeX == x && snakeY == y) || (snake2x == x && snake2y == y) ||(snake3x == x && snake3y == y) ||(snake4x == x && snake4y == y) ||(snake5x == x && snake5y == y) ||(snake6x == x && snake6y == y) ||(snake7x == x && snake7y == y) ||(snake8x == x && snake8y == y) || (snake9x == x && snake9y == y) ||(snake10x == x && snake10y == y) ||(snake11x == x && snake11y == y) ||(snake12x == x && snake12y == y) ) {
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
                System.out.println("Game Over! Snake hit the wall or itself.");
            }
        }

    }
    public static void main(String[] args) {
        playGame();

        

        
    }
}
