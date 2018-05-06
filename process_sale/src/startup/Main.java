package startup;

import controller.Controller;
import view.View;
import integration.ExtSystemHandler;
import integration.DbHandler;


public class Main {
    /**
     * Starts the application.
     *
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        ExtSystemHandler extSystemHandler = new ExtSystemHandler();
        DbHandler dbHandler = new DbHandler();
        Controller controller = new Controller(extSystemHandler, dbHandler);
        new View(controller).sampleExecution();
    }
}
