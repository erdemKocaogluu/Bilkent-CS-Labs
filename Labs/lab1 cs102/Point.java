public class Point {
    private String status;
    private int x ; 
    private int y ;

    public Point(String status , int x , int y) {
        this.status = status ;
        this.x = x ;
        this.y = y ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Point point) {
        if (point.getX() == this.x && point.getY() == this.y ) {
            return true ;
        }
        return false ;
    }

    public boolean equals (Object obj) {
        if (obj == this ) return true ;
        if (obj.getClass() != this.getClass() ) return false ;
        else {
            Point po = (Point) obj ;
            return po.getX()== this.getX() && po.getY() == this.getY() ;
        }

    }



}