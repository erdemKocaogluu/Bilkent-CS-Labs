import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.* ;
import javax.swing.* ;

public class Start {
    public static void main(String[] args) {
        Node node = new Node(20, 20) ;
        MouseKontrolInterfacei x = new MouseKontrolInterfacei() ;
        JFrame frame = new ToolsFrame() ;
        JPanel panel = new ClosestPathFinderFrame() ;
        JFrame a = new JFrame() ;
        a.add(panel ) ;
        a.setSize(500,500);
        a.setVisible(true);

        


    }
}
