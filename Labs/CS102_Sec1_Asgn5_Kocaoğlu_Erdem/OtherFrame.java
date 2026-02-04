import javax.swing.JFrame;
import javax.swing.JPanel;

public class OtherFrame extends JFrame{
    public OtherFrame() {
        JPanel x  = new ClosestPathFinderFrame() ;
        this.add(x) ;
        this.setSize(700,700);
        this.setVisible(true);
                

    }
}
