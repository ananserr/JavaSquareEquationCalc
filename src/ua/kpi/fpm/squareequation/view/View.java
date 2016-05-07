package ua.kpi.fpm.squareequation.view;

/**
 * Created by Anastasia Serhienko on 4/27/16.
 */
public class View {
    // Text's constants
    public static final String INPUT_INT_A = "Input INT coefficient A: ";
    public static final String INPUT_INT_B = "Input INT coefficient B: ";
    public static final String INPUT_INT_C = "Input INT coefficient C: ";
    public static final String WRONG_A_COEF = "Wrong coefficient A. It shouldn't be equal 0. Try once more, please.";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! It must be integer. Repeat please. ";
    public static final String HAS_NO_ROOT = "This equation has no real root. ";
    public static final String COEFS_OUTPUT_FORMAT = "Square equation with coefficients %d, %d, %d has roots: ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printCoefsAndArray(String message, int a, int b, int c, double[] array){
        System.out.printf(message, a, b, c);
        for(int i=0; i < array.length; i++) {
            System.out.printf("x%d= %d", i+1, array[i]);
        }
    }

}
