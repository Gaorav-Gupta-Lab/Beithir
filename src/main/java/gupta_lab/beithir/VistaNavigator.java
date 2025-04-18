/**
 * App to swap scenes in Beithir
 * Package based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.1.1
 */

package gupta_lab.beithir;

import gupta_lab.beithir.Controllers.MainController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class VistaNavigator {
    public static final String MAIN = "/gupta_lab/beithir/Views/main.fxml";
    public static final String VISTA_0 = "/gupta_lab/beithir/Views/entryVista.fxml";
    public static final String VISTA_1 = "/gupta_lab/beithir/Views/ddPCR_Vista.fxml";
    public static final String VISTA_2 = "/gupta_lab/beithir/Views/Illumina_Dual_Indexing.fxml";

    /** The main application layout controller. */
    private static MainController mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     * @param mainController the main application layout controller.
     */
    static void setMainController(MainController mainController) {VistaNavigator.mainController = mainController;}

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     *   cache FXMLLoaders
     *   cache loaded vista nodes, so they can be recalled or reused
     *   allow a user to specify vista node reuse or new creation
     *   allow back and forward history like a browser
     *
     * @param fxml the fxml file to be loaded.
     */
    public static void loadVista(String fxml) {

        try {
            mainController.setVista(FXMLLoader.load(VistaNavigator.class.getResource(fxml)));
        }
        catch (IOException X) {
            X.printStackTrace();
        }
    }
}
