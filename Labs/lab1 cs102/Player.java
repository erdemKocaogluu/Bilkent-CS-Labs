import java.util.Random;

public class Player {
    private int number;
    private int score ;
    private Point pointForPlayer ;
    private String name ;

    public Player (int number) {
        this.number = number ;
        score = 0 ;
        pointForPlayer = new Point("player", number, number) ;
        if (number == 1) {
            pointForPlayer.setX(1); 
            pointForPlayer.setY(11); 
            pointForPlayer.setStatus("player");

        }
        if (number == 2) {
            pointForPlayer.setX(11); 
            pointForPlayer.setY(11); 
            pointForPlayer.setStatus("player");


        }
        if (number == 3) {
            pointForPlayer.setX(1); 
            pointForPlayer.setY(1); 
            pointForPlayer.setStatus("player");


        }
        if (number == 4) {
            pointForPlayer.setX(11); 
            pointForPlayer.setY(1); 
            pointForPlayer.setStatus("player");


        }
    }



    public Point getPointForPlayer() {
        return pointForPlayer;
    }

    public void setPointForPlayer(Point pointForPlayer) {
        this.pointForPlayer = pointForPlayer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public boolean move(Grid grid, String direction, int number) {
        Random ran = new Random() ;
        if (number == 0 ) {
            return false ;
        }
        if (direction.equals("east")) {
            for (int i = this.getPointForPlayer().getX() + 1 ; i <= this.getPointForPlayer().getX() + number ; i++ ){
                Point point = new Point(null, i, this.getPointForPlayer().getY()) ;
                if (grid.getPointsForBlocks().contains(point) || 
                (grid.getPlayer1().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getX() + number  )|| 
                (grid.getPlayer2().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getX() + number  )|| 
                (grid.getPlayer3().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getX() + number  )|| 
                (grid.getPlayer4().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getX() + number  )) {
                    return false ;
                }
            }
            if (grid.getPoint(this.getPointForPlayer().getX()+number, this.getPointForPlayer().getY()).equals("*")) {
                pointForPlayer.setX(this.getPointForPlayer().getX()+number);
                int sc = ran.nextInt(2) +1 ;
                System.out.println(this.getNumber() + " earned " + sc + " points!!!") ;
                score += sc ;
                grid.getPointsForPickableObjects().remove(new Point("pickable", pointForPlayer.getX(), pointForPlayer.getY())) ;
                return true ;
            }

            else if (grid.getPoint(this.getPointForPlayer().getX()+number, this.getPointForPlayer().getY()).equals("1")){
                System.out.println("player " + this.getNumber() + " captured player 1" );
                pointForPlayer.setX(this.getPointForPlayer().getX()+number);

                grid.getPlayer1().setPointForPlayer(new Point(null, 0, 0));
                score += 5 ;
                return true ;
            }
            else if (grid.getPoint(this.getPointForPlayer().getX()+number, this.getPointForPlayer().getY()).equals("2")){
                System.out.println("player " + this.getNumber() + " captured player 2" );
                pointForPlayer.setX(this.getPointForPlayer().getX()+number);

                grid.getPlayer2().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;


            }
            else if (grid.getPoint(this.getPointForPlayer().getX()+number, this.getPointForPlayer().getY()).equals("3")){
                System.out.println("player " + this.getNumber() + " captured player 3" );
                pointForPlayer.setX(this.getPointForPlayer().getX()+number);

                grid.getPlayer3().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;


            }
            else if (grid.getPoint(this.getPointForPlayer().getX()+number, this.getPointForPlayer().getY()).equals("4")){
                System.out.println("player " + this.getNumber() + " captured player 4" );
                pointForPlayer.setX(this.getPointForPlayer().getX()+number);

                grid.getPlayer4().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;

            }
            else if (this.getPointForPlayer().getX()+number > 11) {
                return false ;
            }
            else {
                pointForPlayer.setX(pointForPlayer.getX()+number);
                return true ;
            }
            
        }

        
        if (direction.equals("west")) {
            for (int i = this.getPointForPlayer().getX() -1 ; i >= this.getPointForPlayer().getX() - number ; i--){
                Point point = new Point(null, i, this.getPointForPlayer().getY()) ;
                if (grid.getPointsForBlocks().contains(point) || 
                (grid.getPlayer1().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getX() - number  )|| 
                (grid.getPlayer2().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getX() - number  )|| 
                (grid.getPlayer3().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getX() - number  )|| 
                (grid.getPlayer4().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getX() - number  )) {
                    return false ;
                }
            }
            if (grid.getPoint(this.getPointForPlayer().getX()-number, this.getPointForPlayer().getY()).equals("*")) {
                pointForPlayer.setX(this.getPointForPlayer().getX()-number);
                int sc = ran.nextInt(2) +1 ;
                System.out.println(this.getNumber() + " earned " + sc + " points!!!") ;
                score += sc ;
                grid.getPointsForPickableObjects().remove(new Point("pickable", pointForPlayer.getX(), pointForPlayer.getY())) ;
                return true ;
            }

            else if (grid.getPoint(this.getPointForPlayer().getX()-number, this.getPointForPlayer().getY()).equals("1")){
                System.out.println("player " + this.getNumber() + " captured player 1" );
                pointForPlayer.setX(this.getPointForPlayer().getX()-number);

                grid.getPlayer1().setPointForPlayer(new Point(null, 0, 0));
                score += 5 ;
                return true ;
            }
            else if (grid.getPoint(this.getPointForPlayer().getX()-number, this.getPointForPlayer().getY()).equals("2")){
                System.out.println("player " + this.getNumber() + " captured player 2" );
                pointForPlayer.setX(this.getPointForPlayer().getX()-number);

                grid.getPlayer2().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;


            }
            else if (grid.getPoint(this.getPointForPlayer().getX()-number, this.getPointForPlayer().getY()).equals("3")){
                System.out.println("player " + this.getNumber() + " captured player 3" );
                pointForPlayer.setX(this.getPointForPlayer().getX()-number);

                grid.getPlayer3().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;


            }
            else if (grid.getPoint(this.getPointForPlayer().getX()-number, this.getPointForPlayer().getY()).equals("4")){
                System.out.println("player " + this.getNumber() + " captured player 4" );
                pointForPlayer.setX(this.getPointForPlayer().getX()-number);

                grid.getPlayer4().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;

            }
            else if (this.getPointForPlayer().getX()-number < 1) {
                return false ;
            }
            else {
                pointForPlayer.setX(pointForPlayer.getX()-number);
                return true ;
            }
            
        }
        
        if (direction.equals("north")) {
            for (int i = this.getPointForPlayer().getY() + 1 ; i <= this.getPointForPlayer().getY() + number ; i++ ){
                Point point = new Point(null, this.getPointForPlayer().getX(), i) ;
                if (grid.getPointsForBlocks().contains(point) || 
                (grid.getPlayer1().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() + number  )|| 
                (grid.getPlayer2().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() + number  )|| 
                (grid.getPlayer3().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() + number  )|| 
                (grid.getPlayer4().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() + number  )) {
                    return false ;
                }
            }
            if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()+number).equals("*")) {
                pointForPlayer.setY(this.getPointForPlayer().getY()+number);
                int sc = ran.nextInt(2) +1 ;
                System.out.println(this.getNumber() + " earned " + sc + " points!!!") ;
                score += sc ;
                grid.getPointsForPickableObjects().remove(new Point("pickable", pointForPlayer.getX(), pointForPlayer.getY())) ;
                return true ;
            }

            else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()+number).equals("1")){
                System.out.println("player " + this.getNumber() + " captured player 1" );
                pointForPlayer.setY(this.getPointForPlayer().getY()+number);

                grid.getPlayer1().setPointForPlayer(new Point(null, 0, 0));
                score += 5 ;
                return true ;
            }
            else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()+number).equals("2")){
                System.out.println("player " + this.getNumber() + " captured player 2" );
                pointForPlayer.setY(this.getPointForPlayer().getY()+number);

                grid.getPlayer2().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;


            }
            else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()+number).equals("3")){
                System.out.println("player " + this.getNumber() + " captured player 3" );
                pointForPlayer.setY(this.getPointForPlayer().getY()+number);

                grid.getPlayer3().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;


            }
            else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()+number).equals("4")){
                System.out.println("player " + this.getNumber() + " captured player 4" );
                pointForPlayer.setY(this.getPointForPlayer().getY()+number);

                grid.getPlayer4().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;

            }
            else if (this.getPointForPlayer().getY()+number > 11) {
                return false ;
            }
            else {
                pointForPlayer.setY(pointForPlayer.getY()+number);
                return true ;
            }
        }
        if (direction.equals("south")) {
            // for (int i = this.getPointForPlayer().getY() -1 ; i >= this.getPointForPlayer().getY() - number ; i--){
            //     Point point = new Point(null, i, this.getPointForPlayer().getY()) ;
            //     if (grid.getPointsForBlocks().contains(point) || 
            //     (grid.getPlayer1().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() - number  )|| 
            //     (grid.getPlayer2().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() - number  )|| 
            //     (grid.getPlayer3().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() - number  )|| 
            //     (grid.getPlayer4().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() - number  )) {
            //         return false ;
            //     }
            // }
            // if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("*")) {
            //     pointForPlayer.setY(this.getPointForPlayer().getY()-number);
            //     int sc = ran.nextInt(2) +1 ;
            //     System.out.println(this.getNumber() + " earned" + sc + " points!!!") ;
            //     score += sc ;
            //     grid.getPointsForPickableObjects().remove(new Point("pickable", pointForPlayer.getX(), pointForPlayer.getY())) ;
            //     return true ;
            // }

            // else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("1")){
            //     System.out.println("player " + this.getNumber() + " captured player 1" );
            //     pointForPlayer.setY(this.getPointForPlayer().getY()-number);

            //     grid.getPlayer1().setPointForPlayer(new Point(null, 0, 0));
            //     score += 5 ;
            //     return true ;
            // }
            // else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("2")){
            //     System.out.println("player " + this.getNumber() + " captured player 2" );
            //     pointForPlayer.setY(this.getPointForPlayer().getY()-number);

            //     grid.getPlayer2().setPointForPlayer(new Point(null, 0, 0));

            //     score += 5 ;
            //     return true ;


            // }
            // else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("3")){
            //     System.out.println("player " + this.getNumber() + " captured player 3" );
            //     pointForPlayer.setY(this.getPointForPlayer().getY()-number);

            //     grid.getPlayer3().setPointForPlayer(new Point(null, 0, 0));

            //     score += 5 ;
            //     return true ;


            // }
            // else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("4")){
            //     System.out.println("player " + this.getNumber() + " captured player 4" );
            //     pointForPlayer.setY(this.getPointForPlayer().getY()-number);

            //     grid.getPlayer4().setPointForPlayer(new Point(null, 0, 0));

            //     score += 5 ;
            //     return true ;

            // }
            // else if (this.getPointForPlayer().getY()-number < 1) {
            //     return false ;
            // }
            // else {
            //     pointForPlayer.setY(pointForPlayer.getY()-number);
            //     return true ;
            // }
            for (int i = this.getPointForPlayer().getY() -1 ; i >= this.getPointForPlayer().getY() - number ; i--){
                Point point = new Point(null, this.getPointForPlayer().getX(), i) ;
                if (grid.getPointsForBlocks().contains(point) || 
                (grid.getPlayer1().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() - number  )|| 
                (grid.getPlayer2().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() - number  )|| 
                (grid.getPlayer3().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() - number  )|| 
                (grid.getPlayer4().getPointForPlayer().equals(point)&& i != this.getPointForPlayer().getY() - number  )) {
                    return false ;
                }
            }
            if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("*")) {
                pointForPlayer.setY(this.getPointForPlayer().getY()-number);
                int sc = ran.nextInt(2) +1 ;
                System.out.println(this.getNumber() + " earned " + sc + " points!!!") ;
                score += sc ;
                grid.getPointsForPickableObjects().remove(new Point("pickable", pointForPlayer.getX(), pointForPlayer.getY())) ;
                return true ;
            }

            else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("1")){
                System.out.println("player " + this.getNumber() + " captured player 1" );
                pointForPlayer.setY(this.getPointForPlayer().getY()-number);

                grid.getPlayer1().setPointForPlayer(new Point(null, 0, 0));
                score += 5 ;
                return true ;
            }
            else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("2")){
                System.out.println("player " + this.getNumber() + " captured player 2" );
                pointForPlayer.setY(this.getPointForPlayer().getY()-number);

                grid.getPlayer2().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;


            }
            else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("3")){
                System.out.println("player " + this.getNumber() + " captured player 3" );
                pointForPlayer.setY(this.getPointForPlayer().getY()-number);

                grid.getPlayer3().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;


            }
            else if (grid.getPoint(this.getPointForPlayer().getX(), this.getPointForPlayer().getY()-number).equals("4")){
                System.out.println("player " + this.getNumber() + " captured player 4" );
                pointForPlayer.setY(this.getPointForPlayer().getY()-number);

                grid.getPlayer4().setPointForPlayer(new Point(null, 0, 0));

                score += 5 ;
                return true ;

            }
            else if (this.getPointForPlayer().getY()-number < 1) {
                return false ;
            }
            else {
                pointForPlayer.setY(pointForPlayer.getY()-number);
                return true ;
            }
            
        }
        return true;
        
    }

    public boolean isAlive() {
        if (this.getPointForPlayer().getX()== 0 && this.getPointForPlayer().getY()== 0) {
            return false ;
        }
        return true ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public String getName() {
        return name ;
    }

    public boolean equals (Player player ) {
        return this.getNumber() == player.getNumber() ;
    }

}
