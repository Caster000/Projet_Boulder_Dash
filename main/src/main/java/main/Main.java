/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

//import java.util.Timer;
import contract.UserOrder;
import controller.Controller;
import model.Model;
import view.View;

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
        final Model model = new Model();			//instantiate a new model
        final View view = new View(model);			//instantiate a new view
        final Controller controller = new Controller(view, model);//instantiate a new controller
        view.setController(controller);

        controller.orderPerform(UserOrder.L1);//Start the default game
        
//        Timer chrono = new Timer();				//next update to add a timer
//        chrono.schedule(new Map (), 250,250);
    }
}
