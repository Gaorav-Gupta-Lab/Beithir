/**
 * Main Controller for Beithir views
 * Package loosely based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.8.0
 */

package gupta_lab.beithir.Controllers;

import gupta_lab.beithir.Models.ddPCR_OptionsDataCollector;
import gupta_lab.beithir.Models.illumina_Dual_Indexing_OptionsDataCollector;
import gupta_lab.beithir.VistaNavigator;
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
    @FXML private MenuItem ddPCR;

    private boolean savingDdPCRdata = false;
    private boolean savingIlluminaDualIndexingData = false;

    @FXML private void programExit(){System.exit(0);}
    @FXML private void fileSave() throws IOException {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        if (savingDdPCRdata){
            fileChooser.setInitialFileName(ddPCR_OptionsDataCollector.fileName() + ".tsv");
        } else if (savingIlluminaDualIndexingData) {
            fileChooser.setInitialFileName(illumina_Dual_Indexing_OptionsDataCollector.fileName() + ".tsv");
        } else {
            fileChooser.setInitialFileName(ddPCR_OptionsDataCollector.fileName() + ".txt");
        }
        try{
            BufferedWriter bw = Files.newBufferedWriter(fileChooser.showSaveDialog(
                    this.vistaHolder.getScene().getWindow()).toPath());

            if (savingDdPCRdata){
                bw.write(ddPCR_OptionsDataCollector.generateOptionsFile());
            } else if (savingIlluminaDualIndexingData) {
                bw.write(illumina_Dual_Indexing_OptionsDataCollector.generateOptionsFile());
            } else {
                fileChooser.setInitialFileName(ddPCR_OptionsDataCollector.fileName() + ".txt");
            }

            bw.close();
        }catch (NullPointerException e){
            //If the user cancels the save, BufferWriter returns a null exception that can be safely ignored.
        }
    }
    @FXML private void Home(){VistaNavigator.loadVista(VistaNavigator.VISTA_0);}
    @FXML private void ddPCR(){VistaNavigator.loadVista(VistaNavigator.VISTA_1); savingDdPCRdata = true;}
    @FXML private void Illumina_Dual_Indexing(){VistaNavigator.loadVista(VistaNavigator.VISTA_2); savingIlluminaDualIndexingData= true;}


    /**
     * Replaces the vista displayed in the vista holder with a new vista.
     * @param node the vista node to be swapped in.
     */
    public void setVista(Node node) {getVistaHolder().getChildren().setAll(node);}

    /** Holder of a switchable vista. */
    private StackPane getVistaHolder() {return vistaHolder;}
}
