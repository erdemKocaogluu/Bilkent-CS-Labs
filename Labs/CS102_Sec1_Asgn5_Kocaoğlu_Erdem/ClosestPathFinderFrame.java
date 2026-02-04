import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.* ;
import javax.swing.* ;


public class ClosestPathFinderFrame extends JPanel {
    
    // public static JFrame leftFrame ;
    public static int[][] xyCoordinatesOfNodes ;

    ClosestPathFinderFrame() {
        // leftFrame = new JFrame() ;
        this.setPreferredSize(new Dimension(500,500));
        



    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(50, 200, 20, 20);
        g.drawRect(200, 100, 20, 20);
        g.drawRect(100, 400, 20, 20);
        g.drawRect(250, 250, 20, 20);
        g.drawRect(400, 150, 20, 20);
        g.drawRect(400, 400, 20, 20);
        g.drawLine(70, 200, 200, 120);
        g.drawLine(220, 120, 400, 150);


    }

}
