import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.* ;
import javax.swing.* ;
import java.util.* ;


public class AddNode {
    ArrayList<Node> listOfNodesWithReel ;
    ArrayList<Integer> nodesX ;
    ArrayList<Integer> nodesY ;

    public AddNode(Node node ) {
        listOfNodesWithReel = new ArrayList<>() ;
        nodesX = new ArrayList<>() ;
        nodesY = new ArrayList<>() ;
        if ( !listOfNodesWithReel.contains(node) ) {
            listOfNodesWithReel.add(node) ;
            nodesX.add(node.getX()) ;
            nodesY.add(node.getY()) ;
        }
        
    }
}
