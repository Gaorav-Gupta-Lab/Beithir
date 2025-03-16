package gupta_lab.beithir.Controllers;

import javafx.css.PseudoClass;
import gupta_lab.beithir.Models.OptionsDataCollector;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;

import static gupta_lab.beithir.Models.InputValidation.textValidate;

public class ddPCR_VistaController {
    @FXML private TextField userName;

    private final PseudoClass errorClass = PseudoClass.getPseudoClass("error");

    @FXML public void initialize(){
        userName.pseudoClassStateChanged(errorClass, true);

        userName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(userName.getText()) && textValidate(userName.getText())) {
                userName.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setUserName(userName.getText());
            } else {
                userName.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setUserName(userName.getText());
            }
        });
}
    @FXML
    private AnchorPane root;

    @FXML
    private TextField BottomOffset;

    @FXML
    private TextField LeftPipetteFirstTip;

    @FXML
    private TextField RightPipetteFirstTip;

    @FXML
    private ComboBox<?> Slot1;

    @FXML
    private ToggleButton UseTemperatureModule;

    @FXML
    private DatePicker runDate;

    @FXML
    private TextField setTemperature;



}
