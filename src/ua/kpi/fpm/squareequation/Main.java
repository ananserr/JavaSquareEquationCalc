package ua.kpi.fpm.squareequation;

import ua.kpi.fpm.squareequation.controller.Controller;
import ua.kpi.fpm.squareequation.model.Model;
import ua.kpi.fpm.squareequation.view.View;

public class Main {

    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.solveEquation();
    }

}
