import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.* ;
import javax.swing.* ;

public class ToolsFrame extends JFrame {

    public ToolsFrame() {
        this.setTitle("Tools");
        this.setLayout(new GridLayout(8,1));
        JButton addNode = new JButton("Add Node") ;
        JButton addPath = new JButton("Add Path") ;
        JButton removeNode = new JButton("Remove Node") ;
        JButton removePath = new JButton("Remove Path") ;
        JButton setStart = new JButton("Set Start") ;
        JButton setFinish = new JButton("Set Finish") ;
        JButton moveNode = new JButton("Move Node") ;
        JButton findPath = new JButton("Find Path") ;



        this.add(addNode) ;
        this.add(addPath) ;
        this.add(removeNode) ;
        this.add(removePath) ;
        this.add(setStart) ;
        this.add(setFinish) ;
        this.add(moveNode) ;
        this.add(findPath) ;
        this.setSize(100,700);
        this.setVisible(true);

        


    }

    
}