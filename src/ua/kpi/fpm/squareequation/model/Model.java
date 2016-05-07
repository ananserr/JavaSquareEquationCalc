package ua.kpi.fpm.squareequation.model;

import ua.kpi.fpm.squareequation.controller.Controller;

/**
 * Created by Anastasia Serhienko on 4/27/16.
 */
public class Model {
    private int a;
    private int b;
    private int c;

    // The Program logic

    /**
     *
     *
     * @param coefficients
     */
    public void setCoefficients(int[] coefficients) {
        this.a = coefficients[Controller.COEF_A_INDEX];
        this.b = coefficients[Controller.COEF_B_INDEX];
        this.c = coefficients[Controller.COEF_C_INDEX];
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    /**
     * Calculates discriminant of equation.
     *
     * @return discriminant
     */
    public double discriminant() {
        double d = (double) b * b - 4.0 * a * c;

        if (Math.abs(d) < Controller.DISCRIMINANT_ACCURACY) {
            d = 0.0;
        }

        return d;
    }

    public boolean hasRoots() {
        return !(discriminant() < 0.0 || b == 0 && (double) -c / a < 0.0);
    }

    /**
     * Calls appropriate method of equation resolving depending on it's coefficients.
     * If equation is like Ax^2 = 0 or discriminant is 0, then equation has one root.
     * If discriminant > 0 and b != 0 or c != 0, then two roots.
     *
     * @return equation roots
     */

    public double[] findRoots() {
        double discriminant = discriminant();
        return (((b == 0 && c == 0) || (discriminant == 0.0)) ? findOneRoot() : findTwoRoots(discriminant));
    }

    /**
     * Finds root of square equation which has only one root
     * If equation is like Ax^2 = 0 then x == 0.
     * Else we have B != 0 or C !=0, and discriminant == 0. In this case x = -b/2a
     *
     * @return root of equation
     */
    public double[] findOneRoot() {
        double x = ((b == 0) && (c == 0)) ? 0.0 : ((double) -b) / (2 * a);
        return new double[] {x};
    }

    public double[] findTwoRoots(double discriminant) {
        double x1;
        double x2;

        if (c == 0) {
            x1 = 0;
            x2 = -b/a;
        } else if (b == 0) {
            x1 = Math.sqrt(-c/a);
            x2 = -Math.sqrt(-c/a);
        } else { // D > 0, a,b,c != 0
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        }

        return new double[] {x1, x2};
    }
}
