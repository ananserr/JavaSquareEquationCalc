package ua.kpi.fpm.test;

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
        double d = model.discriminant(5, 3, 4);
        assertEquals("Negative discriminant", -71.0, d, ACCURACY);
        d = model.discriminant(1, -4, 4);
        assertEquals("Zero discriminant", 0.0, d, ACCURACY);
        d = model.discriminant(1, 6, 1); // 32
        assertEquals("Pozitive discriminant", 32.0, d, ACCURACY);
    }

    @Test
    public void testFindRoots() throws Exception {

    }

    @Test
    public void testFindOneRoot() throws Exception {

    }

    @Test
    public void testFindTwoRoots() throws Exception {

    }
}