/**
 * Main entry point for Beithir
 * Package loosely based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.10.0
 */

package gupta_lab.beithir;

import gupta_lab.beithir.Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class MainApp extends Application {
    private static final String VISTA_CSS_PATH = "/gupta_lab/beithir/Views/vista.css";
    private static final String APPLICATION_TITLE = "Opentrons Parameter File Builder";
    private static final String ERROR_RESOURCE_NOT_FOUND = "Resource not found at: %s";

    @Override
    public void start(Stage stage) throws IOException {
        initializeStage(stage);
    }

    private void initializeStage(Stage stage) throws IOException {
        Pane mainPane = initializeMainPane();
        Scene scene = createSceneWithStyles(mainPane);

        stage.setTitle(APPLICATION_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    private Scene createSceneWithStyles(Pane mainPane) {
        URL cssResource = validateResource(VISTA_CSS_PATH);
        Scene scene = new Scene(mainPane);
        scene.getStylesheets().setAll(cssResource.toExternalForm());
        return scene;
    }

    private Pane initializeMainPane() throws IOException {
        validateResource(VistaNavigator.MAIN);

        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = loader.load(getClass().getResourceAsStream(VistaNavigator.MAIN));

        MainController mainController = loader.getController();
        VistaNavigator.setMainController(mainController);
        VistaNavigator.loadVista(VistaNavigator.VISTA_0);

        return mainPane;
    }

    private URL validateResource(String resourcePath) {
        URL resource = getClass().getResource(resourcePath);
        if (resource == null) {
            throw new IllegalArgumentException(String.format(ERROR_RESOURCE_NOT_FOUND, resourcePath));
        }
        return resource;
    }

    public static void main(String[] args) {
        launch();
    }
}