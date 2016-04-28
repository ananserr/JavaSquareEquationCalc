package ua.kpi.fpm.squareequation.model;

/**
 * Created by Anastasia Serhienko on 4/27/16.
 */
public class Model {

    private double[] roots;
    private double d;

    // The Program logic

    public double[] getRoots() {
        return this.roots;
    }

    public double getD() {
        return this.d;
    }

    public void setD(int a, int b, int c) {
        this.d = discriminant(a, b, c);
    }

    public double discriminant(int a, int b, int c) {
        return b*b - 4*a*c;
    }

    public void findRoots(int a, int b, int c) {
        if(b == 0 && c == 0 || this.d == 0) {
            this.roots = findOneRoot(a, b, c);
        } else { // d>0, b or c != 0
            this.roots = findTwoRoots(a, b, c);
        }
    }

    public double[] findOneRoot(int a, int b, int c) {
        double x;
        if(b == 0 && c == 0) {
            x = 0;
        } else { // b or c != 0, d == 0
            x = -b / (2 * a);
        }
        return new double[] {x};
    }

    public double[] findTwoRoots(int a, int b, int c) {
        double x1;
        double x2;
        if(c == 0) {
            x1 = 0;
            x2 = -b/a;
        } else if(b == 0) {
            x1 = Math.sqrt(-c/a);
            x2 = -Math.sqrt(-c/a);
        } else { // D > 0, a,b,c != 0
            x1 = (-b + Math.sqrt(this.d)) / (2 * a);
            x2 = (-b - Math.sqrt(this.d)) / (2 * a);
        }
        return new double[]{x1, x2};
    }
}
