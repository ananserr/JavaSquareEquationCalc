package ua.kpi.fpm.squareequation.controller;

import java.util.Scanner;

import ua.kpi.fpm.squareequation.model.Model;
import ua.kpi.fpm.squareequation.view.View;

/**
 * Created by Anastasia Serhienko on 4/27/16.
 */
public class Controller {

    // Constants
//    public static final int A = 3;
//    public static final int B = 4;
//    public static final int C = 5;
    public static final int NUMBER_OF_COEFFICIENTS = 3;
    public static final int COEF_A_INDEX = 0;
    public static final int COEF_B_INDEX = 1;
    public static final int COEF_C_INDEX = 2;
    public static final double DISCRIMINANT_ACCURACY = 1e-10;

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void solveEquation(){
        Scanner sc = new Scanner(System.in);
        model.setCoefficients(inputIntCoefficientsWithScanner(sc));

        if (model.hasRoots()) {
            view.printCoefsAndArray(View.COEFS_OUTPUT_FORMAT, model.getA(), model.getB(), model.getC(),
                    model.findRoots());
        } else {
            view.printMessage(View.HAS_NO_ROOT);
        }
    }

    // The Utility methods

    public int[] inputIntCoefficientsWithScanner(Scanner sc) {
        int[] coefs = new int[NUMBER_OF_COEFFICIENTS];

        /* Check if A coefficient is equal zero. In this case the equation is not square. */
        while ((coefs[COEF_A_INDEX] = inputIntValueWithScanner(sc, View.INPUT_INT_A)) == 0) {
            view.printMessage(View.WRONG_A_COEF);
        }

        coefs[COEF_B_INDEX] = inputIntValueWithScanner(sc, View.INPUT_INT_B);
        coefs[COEF_C_INDEX] = inputIntValueWithScanner(sc, View.INPUT_INT_C);

        return coefs;
    }

    public int inputIntValueWithScanner(Scanner sc, String message) {
        view.printMessage(message);

        // check int - value
        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA);
            sc.next();
        }

        return sc.nextInt();
    }
}
