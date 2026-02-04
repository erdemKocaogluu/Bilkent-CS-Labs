import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;


public class PathAddle extends JPanel {
    double length ;
    int startX ;
    int startY ;
    int endX ; 
    int endY ;

    public void addPath(Node node1 , Node node2 ) {
        startX = node1.getX() ;
        startY = node1.getY() ;
        endX = node2.getX() ;
        endY = node2.getY() ;
        length = Math.sqrt(Math.pow(startX-endX, 2) +Math.pow(startY-endY, 2) ) ;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(startX, startY, endX, endY);
    }

}
