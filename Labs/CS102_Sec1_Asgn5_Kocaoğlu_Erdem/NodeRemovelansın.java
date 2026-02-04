import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.*;

public class NodeRemovelansın {
    static ArrayList<Node> listOfAllNodes ; 
    boolean bool ; 
    public void removeNode(Node node) {
        if (listOfAllNodes.contains(node)) {
            listOfAllNodes.remove(node) ;
        }
        else {
            JFrame frame = new JFrame() ;
            frame.setTitle("infrmation");
            JLabel label = new JLabel() ;
            label.setText("there is no node like this");
            label.setSize(400,400);
            frame.setSize(400,400);
            frame.add(label) ;
            frame.setVisible(true);


        }
    }
    public ArrayList<Node> getListOfAllNodes() {
        return listOfAllNodes;
    }
    public void setListOfAllNodes(ArrayList<Node> listOfAllNodes) {
        this.listOfAllNodes = listOfAllNodes;
    }
    public boolean isBool() {
        return bool;
    }
    public void setBool(boolean bool) {
        this.bool = bool;
    }


}
