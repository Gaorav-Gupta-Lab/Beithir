/**
 * Main entry point for Beithir
 * Package loosely based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.8.0
 */

package gupta_lab.beithir;

import gupta_lab.beithir.Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {
    private static final String VISTA_CSS_PATH = "/gupta_lab/beithir/Views/vista.css";

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Opentrons Parameter File Builder");
        stage.setScene(createScene(loadMainPane()));
        stage.show();
    }

    private Scene createScene(Pane mainPane) {
        // Ensure the resource path is correct
        if (getClass().getResource(VISTA_CSS_PATH) == null) {
            throw new IllegalArgumentException("stylesheet resource not found at: " + VISTA_CSS_PATH);
        }

        Scene scene = new Scene(mainPane);
        scene.getStylesheets().setAll(Objects.requireNonNull(getClass().getResource(VISTA_CSS_PATH)).toExternalForm());

        return scene;
    }

    private Pane loadMainPane() throws IOException {
        // Ensure the resource path is correct
        String resourcePath = VistaNavigator.MAIN;
        if (getClass().getResource(resourcePath) == null) {
            throw new IllegalArgumentException("FXML resource not found at: " + resourcePath);
        }

        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = loader.load(getClass().getResourceAsStream(resourcePath));
        MainController mainController = loader.getController();

        VistaNavigator.setMainController(mainController);
        VistaNavigator.loadVista(VistaNavigator.VISTA_0);

        return mainPane;
    }

    public static void main(String[] args) {
        launch();
    }
}