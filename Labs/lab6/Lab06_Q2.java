import java.util.Scanner ;
import java.util.Random ;

public class Lab06_Q2 {
    static Random random = new Random() ;
    static Scanner in = new Scanner(System.in) ;
    static int foodX, foodY ;
    static int[] snakeX = new int[100];
    static int[] snakeY = new int[100];
    static int snakeLength = 1;
    static boolean isGameOver = false ;
    static boolean done = true ;

    public static void generateFood() {
        boolean onSnake;
        do {
            onSnake = false;
            foodX = random.nextInt(10) + 1;
            foodY = random.nextInt(10) + 1;
            for (int i = 0; i < snakeLength; i++) {
                if (snakeX[i] == foodX && snakeY[i] == foodY) {
                    onSnake = true;
                    break;
                }
            }
        } while (onSnake);
    }

    public static void moveSnake (int nextX, int nextY) {
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
        }
        snakeX[0] = nextX;
        snakeY[0] = nextY;
    }

    public static void printGrid () {
        for (int y = 10; y > 0; y--) {
            for (int x = 1; x <= 10; x++) {
                boolean isBody = false;
                for (int i = 0; i < snakeLength; i++) {
                    if (snakeX[i] == x && snakeY[i] == y) {
                        System.out.print("S");
                        isBody = true;
                        break;
                    }
                }
                if (!isBody) {
                    if (foodX == x && foodY == y) System.out.print("O");
                    else System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static void playGame () {
        snakeX[0] = random.nextInt(10) + 1 ;
        snakeY[0] = random.nextInt(10) + 1 ;
        generateFood();
        System.out.println("Welcome to Hungry Snake!");
        
        while (done) {
            printGrid();
            System.out.print("Move: ");
            String input = in.nextLine().toUpperCase();
            
            if (!input.equals("W") && !input.equals("A") && !input.equals("S") && !input.equals("D")) continue;

            int nextX = snakeX[0];
            int nextY = snakeY[0];
            if (input.equals("W")) nextY++;
            else if (input.equals("S")) nextY--;
            else if (input.equals("A")) nextX--;
            else if (input.equals("D")) nextX++;

            if (nextX > 10 || nextX < 1 || nextY > 10 || nextY < 1) {
                isGameOver = true;
            }

            for (int i = 0; i < snakeLength; i++) {
                if (nextX == snakeX[i] && nextY == snakeY[i]) {
                    isGameOver = true;
                    break;
                }
            }

            if (isGameOver) {
                done = false;
                System.out.println("Game Over! Snake hit the wall or itself.");
            } else {
                int oldTailX = snakeX[snakeLength - 1];
                int oldTailY = snakeY[snakeLength - 1];
                
                moveSnake(nextX, nextY);

                if (snakeX[0] == foodX && snakeY[0] == foodY) {
                    System.out.println("Yum! Snake ate the food! ");
                    snakeX[snakeLength] = oldTailX;
                    snakeY[snakeLength] = oldTailY;
                    snakeLength++;
                    generateFood();
                }
            }
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
