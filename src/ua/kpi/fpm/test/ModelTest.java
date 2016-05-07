package ua.kpi.fpm.test;

import com.sun.javafx.sg.prism.NGShape;
import org.junit.Test;

import static org.junit.Assert.*;

import ua.kpi.fpm.squareequation.model.Model;

/**
 * Created by Anastasia Serhienko on 4/27/16.
 */
public class ModelTest {

    public static final double ACCURACY = 1e-10;
    @Test
    public void testDiscriminant() throws Exception {
        Model model = new Model();
        model.setCoefficients(new int[] {5, 3, 4});
        double d = model.discriminant();
        assertEquals("Negative discriminant", -71.0, d, ACCURACY);
        model.setCoefficients(new int[] {1, -4, 4});
        d = model.discriminant();
        assertEquals("Zero discriminant", 0.0, d, ACCURACY);
        model.setCoefficients(new int[] {1, 6, 1});
        d = model.discriminant();
        assertEquals("Positive discriminant", 32.0, d, ACCURACY);
    }

    @Test
    public void hasRoots() throws Exception {
        Model model = new Model();
        model.setCoefficients(new int[] {5, 3, 4});
        assertFalse("Negative discriminant", model.hasRoots());
        model.setCoefficients(new int[] {5, 0, 4});
        assertFalse("B=0, -C/A<0", model.hasRoots());
        model.setCoefficients(new int[] {5, 0, -4});
        assertTrue("D>0, -C/A > 0", model.hasRoots());
    }

    @Test
    public void testFindRoots() throws Exception {
        Model model = new Model();
        model.setCoefficients(new int[] {5, 0, 0});
        double[] roots = model.findRoots();
        assertEquals("One root when B=0, C=0", 1, roots.length);
        model.setCoefficients(new int[] {1, -4, 4});
        roots = model.findRoots();
        assertEquals("One root when discriminant=0", 1, roots.length);
        model.setCoefficients(new int[] {5, 3, 4});
        roots = model.findRoots();
        assertEquals("Two roots", 2, roots.length);
    }

    @Test
    public void testFindOneRoot() throws Exception {
        Model model = new Model();
        model.setCoefficients(new int[] {5, 0, 0});
        assertEquals("B=0, C=0", 0.0, model.findOneRoot()[0], ACCURACY);
        model.setCoefficients(new int[] {1, -4, 4});
        assertEquals("Discriminant=0", 2.0, model.findOneRoot()[0], ACCURACY);
    }

    @Test
    public void testFindTwoRoots() throws Exception {
        Model model = new Model();
        model.setCoefficients(new int[] {5, 10, 0});
        double[] roots = model.findTwoRoots(model.discriminant());
        assertEquals("", 0.0, roots[0], ACCURACY);
        assertEquals("", -2.0, roots[1], ACCURACY);

        model.setCoefficients(new int[] {1, 0, -4});
        roots = model.findTwoRoots(model.discriminant());
        assertEquals("", 2.0, roots[0], ACCURACY);
        assertEquals("", -2.0, roots[1], ACCURACY);

        model.setCoefficients(new int[] {2, 5, 2});
        roots = model.findTwoRoots(model.discriminant());
        assertEquals("", -0.5, roots[0], ACCURACY);
        assertEquals("", -2.0, roots[1], ACCURACY);
    }
}