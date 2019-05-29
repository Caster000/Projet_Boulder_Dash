/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.util.Timer;

import contract.UserOrder;
import controller.Controller;
import model.Model;
import view.View;
import entity.Map;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.control();
        controller.orderPerform(UserOrder.L1);
        
//        Timer chrono = new Timer();
//        chrono.schedule(new Map (), 250,250);
    }
}
