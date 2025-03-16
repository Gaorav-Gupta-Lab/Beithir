package gupta_lab.beithir;

import gupta_lab.beithir.Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Opentrons Parameter File Builder");
        stage.setScene(createScene(loadMainPane()));
        stage.show();
    }

    private Scene createScene(Pane mainPane) {
        // Ensure the resource path is correct
        String resourcePath = "/gupta_lab/beithir/Views/vista.css";
        if (getClass().getResource(resourcePath) == null) {
            throw new IllegalArgumentException("stylesheet resource not found at: " + resourcePath);
        }

        Scene scene = new Scene(mainPane);
        scene.getStylesheets().setAll(getClass().getResource(resourcePath).toExternalForm());

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