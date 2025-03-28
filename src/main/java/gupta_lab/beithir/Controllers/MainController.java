/**
 * Main Controller for Beithir views
 * Package loosely based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.5.0
 */

package gupta_lab.beithir.Controllers;

import gupta_lab.beithir.VistaNavigator;
import gupta_lab.beithir.Models.OptionsDataCollector;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

public class MainController {
    @FXML private StackPane vistaHolder;
    @FXML private MenuItem fileSave;
    @FXML private MenuItem programExit;

    @FXML private void programExit(){System.exit(0);}
    @FXML private void fileSave() throws IOException {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        fileChooser.setInitialFileName(OptionsDataCollector.fileName() + ".tsv");
        try{
            BufferedWriter bw = Files.newBufferedWriter(fileChooser.showSaveDialog(
                    this.vistaHolder.getScene().getWindow()).toPath());
            bw.write(OptionsDataCollector.generateOptionsFile());
            bw.close();
        }catch (NullPointerException e){
            //If the user cancels the save, BufferWriter returns a null exception that can be safely ignored.
        }
    }
    @FXML private void Home(){VistaNavigator.loadVista(VistaNavigator.VISTA_0);}
    @FXML private void ddPCR(){VistaNavigator.loadVista(VistaNavigator.VISTA_1);}


    /**
     * Replaces the vista displayed in the vista holder with a new vista.
     * @param node the vista node to be swapped in.
     */
    public void setVista(Node node) {getVistaHolder().getChildren().setAll(node);}

    /** Holder of a switchable vista. */
    private StackPane getVistaHolder() {return vistaHolder;}
}
