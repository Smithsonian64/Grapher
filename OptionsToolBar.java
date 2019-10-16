import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsToolBar extends JToolBar implements ActionListener {

    JButton resizeButton;
    JButton replotButton;
    JButton ChangeSizeButton;
    JButton TogglePointsButton;
    JButton ToggleLinesButton;
    JSpinner stepSize;
    JSpinner xScaleFactorSpinner;
    JSpinner yScaleFactorSpinner;

    public OptionsToolBar() {
        resizeButton = new JButton("Resize");
        resizeButton.setAlignmentX(0);
        resizeButton.setAlignmentY(0);
        resizeButton.addActionListener(this);
        resizeButton.setActionCommand("Resize");
        replotButton = new JButton("Replot");
        replotButton.setAlignmentX(50);
        replotButton.setAlignmentY(0);
        replotButton.addActionListener(this);
        replotButton.setActionCommand("Replot");
        ChangeSizeButton = new JButton("Change");
        ChangeSizeButton.setAlignmentX(100);
        ChangeSizeButton.setAlignmentY(0);
        ChangeSizeButton.addActionListener(this);
        ChangeSizeButton.setActionCommand("ChangeSize");
        TogglePointsButton = new JButton("Points");
        TogglePointsButton.setAlignmentX(150);
        TogglePointsButton.setAlignmentY(0);
        TogglePointsButton.addActionListener(this);
        TogglePointsButton.setActionCommand("TogglePoints");
        ToggleLinesButton = new JButton("Lines");
        ToggleLinesButton.setAlignmentX(200);
        ToggleLinesButton.setAlignmentY(0);
        ToggleLinesButton.addActionListener(this);
        ToggleLinesButton.setActionCommand("ToggleLines");
        SpinnerModel model = new SpinnerNumberModel(Plotter.step, 0.001, 100, 0.01);
        stepSize = new JSpinner(model);
        stepSize.setAlignmentX(200);
        stepSize.setAlignmentY(0);
        stepSize.addChangeListener(e -> {
            Plotter.step = (double) ((JSpinner)e.getSource()).getValue();
            Window.frame.repaint();
        });
        SpinnerModel model1 = new SpinnerNumberModel( MathFunction.xScaleFactor, 0.0001, 1, 0.01);
        xScaleFactorSpinner = new JSpinner(model1);
        xScaleFactorSpinner.setAlignmentX(250);
        xScaleFactorSpinner.setAlignmentY(0);
        xScaleFactorSpinner.addChangeListener(e -> {
            MathFunction.xScaleFactor = (double) ((JSpinner)e.getSource()).getValue();
            Window.frame.repaint();
        });
        SpinnerModel model2 = new SpinnerNumberModel( MathFunction.yScaleFactor, 1, 100, 1);
        yScaleFactorSpinner = new JSpinner(model2);
        yScaleFactorSpinner.setAlignmentX(250);
        yScaleFactorSpinner.setAlignmentY(0);
        yScaleFactorSpinner.setValue(MathFunction.yScaleFactor);
        yScaleFactorSpinner.addChangeListener(e -> {
            MathFunction.yScaleFactor = (double) ((JSpinner)e.getSource()).getValue();
            Window.frame.repaint();
        });

        this.add(resizeButton);
        this.add(replotButton);
        this.add(ChangeSizeButton);
        this.add(TogglePointsButton);
        this.add(ToggleLinesButton);
        this.add(xScaleFactorSpinner);
        this.add(yScaleFactorSpinner);
        this.add(stepSize);

        this.add(Box.createHorizontalGlue());




    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Replot")) Window.frame.repaint();
        if(e.getActionCommand().equals("Resize")) Window.frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        if(e.getActionCommand().equals(("ChangeSize"))) {
            if(MathFunction.functionNumber == 12) {
                MathFunction.functionNumber = 0;
                Window.frame.repaint();
            }
            else MathFunction.functionNumber++;
            Window.frame.repaint();
            System.out.println("Changed Function");
        }
        if(e.getActionCommand().equals("TogglePoints")) {
            if(Plotter.plotPoint) {
                Plotter.plotPoint = false;
                Window.frame.repaint();
                return;
            }
                Plotter.plotPoint = true;
                Window.frame.repaint();
        }
        if(e.getActionCommand().equals("ToggleLines")) {
            if(Plotter.fillLine) {
                Plotter.fillLine = false;
                Window.frame.repaint();
                return;
            }
                Plotter.fillLine = true;
                Window.frame.repaint();
        }

    }

}
