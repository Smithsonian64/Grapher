import jdk.swing.interop.SwingInterOpUtils;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 *
 * <p>This class is the class that calculates where each point plot should go relative to the window described
 * in the Window class based on the calculation from the MathFunction.</p>
 *
 * @author Michael Smith
 */
public class Plotter extends JPanel {

    static double i;
    static double step = 1;
    static boolean fillLine = false;
    static boolean plotPoint = true;
    int points = 0;


    public Plotter() {

        this.setPreferredSize(new Dimension(Window.frame.getWidth(), Window.frame.getHeight()));


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        long startTime = System.nanoTime();

        i = 0;

        g.drawLine(0, Window.frame.getHeight() / 2, Window.frame.getWidth(), Window.frame.getHeight() / 2);
        g.drawLine(Window.frame.getWidth() / 2, 0, Window.frame.getWidth() / 2, Window.frame.getHeight());

        while ((i + Window.frame.getWidth() / 2 < Window.frame.getWidth() + Window.frame.getWidth() / 2)) {
            g.drawLine((int) (i *( MathFunction.xScaleFactor / 50)), Window.frame.getHeight() / 2 - 3, (int) (i *( MathFunction.xScaleFactor / 50)), Window.frame.getHeight() / 2 + 3);
            i += MathFunction.xScaleFactor;
        }
        i = 0;
        while ((i + Window.frame.getHeight() / 2 < Window.frame.getHeight() + Window.frame.getHeight() / 2)) {
            g.drawLine(Window.frame.getWidth() / 2 - 3, (int) (i *( MathFunction.yScaleFactor / 50)), Window.frame.getWidth() / 2 + 3, (int) (i *( MathFunction.yScaleFactor / 50)));
            i += MathFunction.yScaleFactor;
        }

        if(plotPoint) {

            i = 0 - Window.frame.getWidth() / 2;

            while (MathFunction.getFunctionX(i) <= Window.frame.getWidth()) {
                int absoluteX = MathFunction.getFunctionX(i);
                int absoluteY = MathFunction.getFunctionY(i);
                if (absoluteY >= 0 &&
                        absoluteY <= Window.frame.getHeight()) {
                        new Point().draw(g, absoluteX, absoluteY, 1, 1);
                        points++;
                }
                i += step;
            }
        }

        if(fillLine) {
            i = 0 - Window.frame.getWidth() / 2;
            while (i < Window.frame.getWidth()) {
                g.drawLine(MathFunction.getFunctionX(i), MathFunction.getFunctionY(i), MathFunction.getFunctionX(i + step), MathFunction.getFunctionY(i + step));
                i += step;
            }
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000;
        System.out.println("Done drawing with " + points + " points plotted in " + duration + " milliseconds.");
        points = 0;
        System.out.println("frame width: " + Window.frame.getWidth() + " frame Height: " + Window.frame.getHeight());
        System.out.println("plotPanel width: " + Window.frame.getWidth() + " frame height: " + Window.frame.getHeight());

    }
}
