import java.util.ArrayList;
import java.util.Random ;

public class Grid {
    private ArrayList<Point> points ;
    private ArrayList<Point> pointsForPickableObjects ;
    private ArrayList<Point> pointsForBlocks ;
    private ArrayList<Point> pointsNotAvailableForBlocks ;
    private ArrayList<Point> pointsNotAvailable ;
    private Player player1 ;
    private Player player2 ;
    private Player player3 ;
    private Player player4 ;


    public Grid(int numberOfPlayers){
        player3 = new Player(3) ;
        player4 = new Player(4) ;
        player3.setPointForPlayer(new Point(null, 0, 0));
        player4.setPointForPlayer(new Point(null, 0, 0));
        points = new ArrayList<>() ;
        pointsNotAvailable = new ArrayList<>() ;
        pointsForPickableObjects = new ArrayList<>() ;
        pointsNotAvailableForBlocks = new ArrayList<>() ;
        pointsForBlocks = new ArrayList<>() ;
        if (numberOfPlayers >= 2) {
            player1 = new Player(1) ;
            Point point1 = new Point("player", 1, 11) ;
            pointsNotAvailable.add(new Point("dot", 1, 10) ) ;
            pointsNotAvailable.add(new Point("dot", 2,11) ) ;
            pointsNotAvailable.add(new Point("dot", 2, 10) ) ;
            pointsNotAvailable.add(new Point("dot", 10, 11) ) ;
            pointsNotAvailable.add(new Point("dot", 10, 10) ) ;
            pointsNotAvailable.add(new Point("dot", 11, 10) ) ;
            player1.setPointForPlayer(point1) ;
            
            Point point2 = new Point("player", 11, 11) ;
            player2= new Player(2) ;

            pointsNotAvailable.add(point1) ;
            pointsNotAvailable.add(point2) ;


        }
        if (numberOfPlayers >= 3) {
            player3 = new Player(3) ;

            Point point3 = new Point("player", 1, 1) ;
            pointsNotAvailable.add(new Point("dot", 2, 1) ) ;
            pointsNotAvailable.add(new Point("dot", 2, 2) ) ;
            pointsNotAvailable.add(new Point("dot", 1, 2) ) ;


            pointsNotAvailable.add(point3) ;

        }
        if (numberOfPlayers >= 4) {
            player4 = new Player(4) ;

            Point point4 = new Point("player", 11, 1) ;
            pointsNotAvailable.add(new Point("dot", 10, 1) ) ;
            pointsNotAvailable.add(new Point("dot", 10, 2) ) ;
            pointsNotAvailable.add(new Point("dot", 11, 2) ) ;


            pointsNotAvailable.add(point4) ;

        }
        

        Random ran = new Random() ;
        Point point = new Point(null, 0, 0) ;
        int b = ran.nextInt(10) + 5 ;
        pointsNotAvailable.add(point) ;
        int left = ran.nextInt(6) + 3 ;
        Point poin = new Point("Block", 1, left ) ;
        pointsNotAvailable.add(poin) ;
        pointsForBlocks.add(poin) ;
        blockEnvironment(poin);

        
        Point bottom = new Point("Block", left, 1 ) ;
        pointsNotAvailable.add(bottom) ;
        pointsForBlocks.add(bottom) ;
        blockEnvironment(bottom);


        Point right = new Point("Block", 11, left ) ;
        pointsNotAvailable.add(right) ;
        pointsForBlocks.add(right) ;
        blockEnvironment(right);


        Point top = new Point("Block", left, 11 ) ;
        pointsNotAvailable.add(top) ;
        pointsForBlocks.add(top) ;
        blockEnvironment(top);


        

        for (int i = 0 ; i < b ; i++ ) {
            int x = 11 ;
            int y = 11 ;
            do {
            x = ran.nextInt(11) + 1;
            y = ran.nextInt(11) + 1;
            point = new Point("block", x, y) ;
            } while (pointsNotAvailable.contains(point)|| pointsNotAvailableForBlocks.contains(point)) ;
            pointsForBlocks.add(point) ;

            pointsNotAvailable.add(point) ; 
            blockEnvironment(point);
            
        }
         point = new Point(null, 0, 0) ;
        int p = ran.nextInt(10) + 10 ;
        for (int i = 0 ; i < p ; i++ ) {
            int x = 11 ;
            int y = 11 ;
            do {
            x = ran.nextInt(11) + 1;
            y = ran.nextInt(11) + 1;
            point = new Point("pickable", x, y) ;
            } while (pointsNotAvailable.contains(point)) ;
            pointsForPickableObjects.add(point) ;
            pointsNotAvailable.add(point) ;

        }

        
 

    }

    

    public void printGrid() {
        for (int y = 11 ; y >= 1 ; y-- ) {

            for (int x = 1 ; x < 12 ; x++ ) {
                Point point = new Point(null, x, y) ;
                if (pointsForPickableObjects.contains(point)) {
                    System.out.print("*");
                }
                else if (pointsForBlocks.contains(point)) {
                    System.out.print("X");
                }
                else if (point.equals(player1.getPointForPlayer())){
                    System.out.print("1");
                }
                else if (point.equals(player2.getPointForPlayer())){
                    System.out.print("2");
                }
                else if (point.equals(player3.getPointForPlayer())){
                    System.out.print("3");
                }
                else if (point.equals(player4.getPointForPlayer())){
                    System.out.print("4");
                }
                else {
                    System.out.print(".");
                }
                        }
            System.out.println();
        }
    }

    public ArrayList<Point> getPointsForPickableObjects() {
        return pointsForPickableObjects;
    }

    public void setPointsForPickableObjects(ArrayList<Point> pointsForPickableObjects) {
        this.pointsForPickableObjects = pointsForPickableObjects;
    }

    public ArrayList<Point> getPointsForBlocks() {
        return pointsForBlocks;
    }

    public void setPointsForBlocks(ArrayList<Point> pointsForBlocks) {
        this.pointsForBlocks = pointsForBlocks;
    }

    public ArrayList<Point> getPointsNotAvailable() {
        return pointsNotAvailable;
    }

    public void setPointsNotAvailable(ArrayList<Point> pointsNotAvailable) {
        this.pointsNotAvailable = pointsNotAvailable;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public Player getPlayer4() {
        return player4;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }

    


    public String getPoint(int x, int y) {
        Point point = new Point(null, x, y) ;
        if (pointsForBlocks.contains(point)) {
            return "X" ;
        }
        if (pointsForPickableObjects.contains(point)) {
            return "*" ;
        }
        if (player1.getPointForPlayer().equals(point)) {
            return "1" ;
        }
        if (player2.getPointForPlayer().equals(point)) {
            return "2" ;
        }
        if (player3.getPointForPlayer().equals(point)) {
            return "3" ;
        }
        if (player4.getPointForPlayer().equals(point)) {
            return "4" ;
        }
        else {
            return "." ;
        }
    }



    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public void blockEnvironment(Point point ) {
        pointsNotAvailableForBlocks.add(new Point(null, point.getX(), point.getY()+1)) ;
            pointsNotAvailableForBlocks.add(new Point(null, point.getX(), point.getY()-1)) ;
            pointsNotAvailableForBlocks.add(new Point(null, point.getX()+1, point.getY())) ;
            pointsNotAvailableForBlocks.add(new Point(null, point.getX()+1, point.getY()+1)) ;
            pointsNotAvailableForBlocks.add(new Point(null, point.getX()+1, point.getY()-1)) ;
            pointsNotAvailableForBlocks.add(new Point(null, point.getX()-1, point.getY()+1)) ;
            pointsNotAvailableForBlocks.add(new Point(null, point.getX()-1, point.getY()-1)) ;
            pointsNotAvailableForBlocks.add(new Point(null, point.getX()-1, point.getY())) ;
    }

}
