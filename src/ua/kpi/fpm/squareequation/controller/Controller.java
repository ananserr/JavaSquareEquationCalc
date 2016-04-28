package ua.kpi.fpm.squareequation.controller;

import java.util.Scanner;

import ua.kpi.fpm.squareequation.model.Model;
import ua.kpi.fpm.squareequation.view.View;

/**
 * Created by Anastasia Serhienko on 4/27/16.
 */
public class Controller {

    // Constants
    public static final int A = 3;
    public static final int B = 4;
    public static final int C = 5;

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void solveEquation(){
        //Scanner sc = new Scanner(System.in);

        if(coefficientsAreValid(A, B, C)) {
            model.setD(A, B, C);
            if(hasRoots(A, B, C)) {
                model.findRoots(A, B, C);
                outputResults(A, B, C, model.getRoots());
            }
        }
    }

    // The Utility methods
    public boolean coefficientsAreValid(int a, int b, int c) {
        if(a == 0) {
            // check if not int or A=0
            view.printMessage(View.COEFS_NOT_VALID);
            return false;
        } else {
            return true;
        }
    }

    public boolean hasRoots(int a, int b, int c) {
        if(model.getD() < 0 || b == 0 && -c/a < 0) {
            view.printMessage(View.HAS_NO_ROOT);
            return false;
        } else {
            return true;
        }
    }
    public void outputResults(int a, int b, int c, double[] roots) {
        view.printCoefsAndArray(View.COEFS_OUTPUT_FORMAT, a, b, c, roots);
    }
}
