public class Edge {
    double length ;
    Node n1 ;
    Node n2 ;
    public Edge(Node n1 , Node n2)  {
        this.n1 = n1 ;
        this.n2 = n2 ;
        int x = n1.getX() - n2.getX() ;
        int y = n1.getY() - n2.getY() ;
        length = Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2)) ;
        
    }
}
