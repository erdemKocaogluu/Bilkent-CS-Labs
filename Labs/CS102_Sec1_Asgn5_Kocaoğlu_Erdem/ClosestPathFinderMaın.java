import java.util.ArrayList;

public class ClosestPathFinderMaın {
        ArrayList<Node> listOfNodesWithReel ;
        ArrayList<Integer> paths ;

    public ClosestPathFinderMaın() {
        listOfNodesWithReel = new ArrayList<>() ;
        paths = new ArrayList<>() ;
        for (Node node : listOfNodesWithReel ) {
            if (node.getX() > node.getY() ) {
                paths.add(1 ) ;
                
            }
        }
    }
}
