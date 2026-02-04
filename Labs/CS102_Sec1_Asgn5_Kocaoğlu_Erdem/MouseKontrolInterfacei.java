import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.*;

public class MouseKontrolInterfacei implements MouseListener{
    boolean isOut ;
    ArrayList<Node> listOfNodes ;





    public MouseKontrolInterfacei() {
        isOut = true ;
        listOfNodes = new ArrayList<>() ;
    }




    
    public void mousePressed(MouseEvent e) {
        
    }




    
    public void mouseReleased(MouseEvent e) {
        
    }





    public void mouseEntered(MouseEvent e) {
        
    }




    
    public void mouseExited(MouseEvent e) {
        
    }







    @Override
    public void mouseClicked(MouseEvent e) {
        Node newNode = new Node(e.getX(), e.getY()) ;
        boolean done = true ;
        for ( Node nodes : NodeRemovelansın.listOfAllNodes ) {
            if ( nodes.getX() == e.getX() && nodes.getY() == e.getY() ) {
                done = false ;
            }
        }

        if ( done ) {
            NodeRemovelansın.listOfAllNodes.add(newNode) ;

        }

        
    }


}
