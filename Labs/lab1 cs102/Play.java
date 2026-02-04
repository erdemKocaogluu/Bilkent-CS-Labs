import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Play {
public static void main(String[] args) {
    Scanner in = new Scanner (System.in) ;
    Player player1 = new Player(1) ;
    Player player2 = new Player(2) ;
    Player player3 = new Player(3) ;
    Player player4 = new Player(4) ;
    int numberOfPlayers = 0 ;
    do {
    System.out.print("How many players are there? ");
    numberOfPlayers = in.nextInt() ;
    } while (numberOfPlayers < 2) ;
    in.nextLine() ;
    String p1Name = "" ;
    String p2Name = "" ;
    String p3Name = "" ;
    String p4Name = "" ;

    if (numberOfPlayers >= 2 ) {
        System.out.print("Player1's name: ");
        p1Name = in.nextLine() ;
        System.out.print("Player2's name: ");
        p2Name = in.nextLine() ;
    }
    if (numberOfPlayers >=3) {
        System.out.print("Player3's name: ");
        p3Name = in.nextLine() ;
    }
    if (numberOfPlayers >=4) {
        System.out.print("Player4's name: ");
        p4Name = in.nextLine() ;
    }

    

    // ArrayList<Player> playerss = new ArrayList<Player>() ;
    // playerss.add(player1) ;
    // playerss.add(player2) ;
    // playerss.add(player3) ;
    // playerss.add(player4) ;
    // Random ra = new Random() ;
    // for (int i = 0 ; i < playerss.size() ; i++ ) {
    //     int randomNumber = ra.nextInt(4) ;
    //     if (i== 0) {
    //         playerss.get(randomNumber).setName(p1Name) ;
    //     }
    //     if (i== 1) {
    //         playerss.get(randomNumber).setName(p2Name) ;
    //     }
    //     if (i== 2) {
    //         playerss.get(randomNumber).setName(p3Name) ;
    //     }
    //     if (i== 3) {
    //         playerss.get(randomNumber).setName(p4Name) ;
    //     }


    // }

    player1.setName(p1Name);
    player2.setName(p2Name);
    player3.setName(p3Name);
    player4.setName(p4Name);

    ArrayList<Integer> intList = new ArrayList<>() ;
    
    while (intList.size() < 4 ) {
        Random ra = new Random() ;
        int num = ra.nextInt(4) + 1 ;
        if (!intList.contains(num)) {
            intList.add(num) ;
        }
    }

    
    Grid grid = new Grid(numberOfPlayers) ;
    if (numberOfPlayers == 2 ) {
        player3.setPointForPlayer(new Point("player", 0, 0));
        player4.setPointForPlayer(new Point("player", 0, 0));
        grid.setPlayer1(player3);
        grid.setPlayer2(player4);
    }
    if (numberOfPlayers == 3 ) {
        grid.setPlayer3(player3);
        player4.setPointForPlayer(new Point("player", 0, 0));
        grid.setPlayer4(player4);
    }
    if (numberOfPlayers == 4 ) {
        grid.setPlayer3(player3);
        grid.setPlayer4(player4);
    }
    grid.setPlayer1(player1);
    grid.setPlayer2(player2);
    boolean done = true ;
    int count = 0 ;
    while (done) {
        int nnumber = intList.get(count) ;
        if (numberOfPlayers == 2 ) {
            System.out.println(player1.getScore());
        System.out.println(player2.getScore());
        
        }
        if (numberOfPlayers == 3 ) {
            System.out.println(player1.getScore());
        System.out.println(player2.getScore());
        System.out.println(player3.getScore());
        
        }
        if (numberOfPlayers == 4 ) {
            System.out.println(player1.getScore());
            System.out.println(player2.getScore());
            System.out.println(player3.getScore());
            System.out.println(player4.getScore());
        }
        
        boolean n = true ;
        int a = count ;
        grid.printGrid();
        
        if (nnumber == 1 && player1.isAlive()) {
        System.out.println(p1Name + "'s turn");
        System.out.print("direction: ");
        String x = in.nextLine() ;
        System.out.print("number of movement: ");
        int number = in.nextInt() ;
        in.nextLine() ;
         n  = player1.move(grid, x, number);
            if (!n) {
                System.out.println("You cant do that try another");
            }
            else {
                count++;
            }
        }

        else if (nnumber == 2 && player2.isAlive()) {
        System.out.println(p2Name+"'s turn");
        System.out.print("direction: ");
        String x = in.nextLine() ;
        System.out.print("number of movement: ");
        int number = in.nextInt() ;
        in.nextLine() ;
         n  = player2.move(grid, x, number) ;
            if (!n) {
                System.out.println("You cant do that try another");
            }
            else {
                count++;
            }
        }

        else if (nnumber == 3 && numberOfPlayers>= 3&& player3.isAlive()) {
        System.out.println(p3Name+"'s turn");
        System.out.print("direction: ");
        String x = in.nextLine() ;
        System.out.print("number of movement: ");
        int number = in.nextInt() ;
        in.nextLine() ;
         n  = player3.move(grid, x, number) ;
            if (!n) {
                System.out.println("You cant do that try another");
            }
            else {
                count++;
            }
        }

        else if (nnumber == 4 && numberOfPlayers >= 4&& player4.isAlive()) {
        System.out.println(p4Name + "'s turn");
        System.out.print("direction: ");
        String x = in.nextLine() ;
        System.out.print("number of movement: ");
        int number = in.nextInt() ;
        in.nextLine() ;
         n  = player4.move(grid, x, number) ;
            if (!n) {
                System.out.println("You cant do that try another");
            }
            else {
                count++;
            }
        }
        // if (a == count+1 && n) {
        //     count++;
        // }

        

        
        if (nnumber == 1 && !player1.isAlive()) {
            count++;
        }
        else if (nnumber == 2 && !player2.isAlive()) {
            count++;
        }
        else if (nnumber == 3 && !player3.isAlive()) {
            count++;
        }
        else if (nnumber == 4 && !player4.isAlive()) {
            count++;
        }
        if (count == numberOfPlayers) {
            count = 0 ;
        }


        ArrayList<Boolean> arrayL = new ArrayList<>() ;
        if (numberOfPlayers == 2 ) {
            arrayL.add(player1.isAlive()) ;
            arrayL.add(player2.isAlive()) ;
        }
        if (numberOfPlayers == 3 ) {
            arrayL.add(player1.isAlive()) ;
            arrayL.add(player2.isAlive()) ;
            arrayL.add(player3.isAlive()) ;
        }
        if (numberOfPlayers == 4 ) {
            arrayL.add(player1.isAlive()) ;
            arrayL.add(player2.isAlive()) ;
            arrayL.add(player3.isAlive()) ;
            arrayL.add(player4.isAlive()) ;
        }

        
        int l = 0 ;
        while (arrayL.contains(false)) {
            arrayL.remove(false ) ;
            l++;
        }
        int num = 0 ;

        if (l == numberOfPlayers-1 || grid.getPointsForPickableObjects().isEmpty()) {
            grid.printGrid();
            int maxScore = Math.max(Math.max(player1.getScore(), player2.getScore()), Math.max(player3.getScore(), player4.getScore())) ;
            if (numberOfPlayers == 2 ) {
                System.out.println(player1.getScore());
            System.out.println(player2.getScore());
            
            }
            if (numberOfPlayers == 3 ) {
                System.out.println(player1.getScore());
            System.out.println(player2.getScore());
            System.out.println(player3.getScore());
            
            }
            if (numberOfPlayers == 4 ) {
                System.out.println(player1.getScore());
                System.out.println(player2.getScore());
                System.out.println(player3.getScore());
                System.out.println(player4.getScore());
            }

            if (maxScore == player1.getScore()) {
                System.out.println(player1.getName() + " WİNS");
            }
            if (maxScore == player2.getScore()) {
                System.out.println(player2.getName() + " WİNS");
            }
            if (maxScore == player3.getScore()) {
                System.out.println(player3.getName() + " WİNS");
            }
            if (maxScore == player4.getScore()) {
                System.out.println(player4.getName() + " WİNS");
            }
            done = false ;
        }




    }
}
    
}
