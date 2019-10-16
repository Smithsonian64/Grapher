import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

/**
 *
 * This class describes the individual points that are plotted graphically.
 *
 * @author Michael Smith
 */
public class Point extends JComponent {



    public void draw(Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D)g;

        Rectangle point = new Rectangle(x, y, width, height);
        g2d.fill(point);
        g2d.draw(point);

    }

}