/**
 *
 * This class calculates the x and y coordinates of the mathematical function described in the MathFunction method.
 *
 * @author Michael Smith
 */
public class MathFunction {

    static double xScaleFactor = 0.01;
    static double yScaleFactor = 50;
    static int functionNumber = 0;


    public static double mathFunction(double preX) {

        double x = preX * xScaleFactor;
        double output = 0;

        if(functionNumber == 0) output = 1/x;
        if(functionNumber == 1) output = Math.pow(x, 3);
        if(functionNumber == 2) output = Math.sin(x);
        if(functionNumber == 3) output = Math.tan(x);
        if(functionNumber == 4) output = Math.pow(x, 2);
        if(functionNumber == 5) output = Math.sqrt(x);
        if(functionNumber == 6) output = Math.cbrt(x);
        if(functionNumber == 7) output = (Math.pow(x, 6) - 3*Math.pow(x, 4) + 2*Math.pow(x, 2));
        if(functionNumber == 8) output = ((x + 3)*Math.pow((x - 2), 2)*Math.pow((x + 1), 3));
        if(functionNumber == 9) output = x;
        if(functionNumber == 10) output = Math.exp(x);
        if(functionNumber == 11) output = Math.sin(2 * Math.sin(2 * Math.sin(x)));
        if(functionNumber == 12) output = Math.abs(Math.sin(Math.pow(x, x))/Math.pow(2, ((Math.pow(x, x) - Math.PI / 2)) / Math.PI));
        return output * yScaleFactor;

    }

    public static int getFunctionX(double x) {
        int graphX = Window.frame.getWidth() / 2;
        return (int) ((Window.frame.getWidth() / 2 + x));
    }

    public static int getFunctionY(double x) {
        int graphY = Window.frame.getHeight() / 2;
        return (int) (graphY - Math.round(mathFunction(x)));
    }
}
