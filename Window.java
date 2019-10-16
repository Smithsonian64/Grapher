import javax.swing.*;
import java.awt.*;

/**
 *
 * <p>This class is the basic window showing the plot of the MathFunction</p>
 *
 * @author Michael Smith
 */
public class Window {

    public final static int WINDOW_WIDTH = 800;
    public final static int WINDOW_HEIGHT = 800;
    public static JFrame frame;





    public Window() {

        frame = new JFrame("Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frame.setSize(frame.getPreferredSize());


        frame.add(new Plotter(), BorderLayout.CENTER);
        frame.add(new OptionsToolBar(), BorderLayout.SOUTH);

        frame.setVisible(true);


    }

    public static void main(String[] args) {

        Window window1 = new Window();

    }



}



