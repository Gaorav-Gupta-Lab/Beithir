/**
 * Vista Controller for Beithir ddPCR views
 * Package based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.1.1
 */

package gupta_lab.beithir.Controllers;

import javafx.collections.FXCollections;
import javafx.css.PseudoClass;

import static gupta_lab.beithir.Models.InputValidation.numberValidate;
import static gupta_lab.beithir.Models.InputValidation.textValidate;
import gupta_lab.beithir.Models.OptionsDataCollector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import org.apache.commons.lang3.StringUtils;


public class ddPCR_VistaController implements Initializable{
    @FXML private TextField userName;
    @FXML private DatePicker runDate;
    @FXML private TextField LeftPipetteFirstTip;
    @FXML private TextField RightPipetteFirstTip;
    @FXML private TextField BottomOffset;
    @FXML private CheckBox useTemperatureModule;
    @FXML private TextField setTemperature;
    @FXML private ComboBox<String> Slot1;
    @FXML private ComboBox<String> Slot2;
    @FXML private ComboBox<String> Slot3;
    @FXML private ComboBox<String> Slot4;
    @FXML private ComboBox<String> Slot5;
    @FXML private ComboBox<String> Slot6;
    @FXML private ComboBox<String> Slot7;
    @FXML private ComboBox<String> Slot8;
    @FXML private ComboBox<String> Slot9;
    @FXML private ComboBox<String> Slot10;
    @FXML private ComboBox<String> Slot11;
    @FXML private TextField target1Name;
    @FXML private TextField target2Name;
    @FXML private TextField target3Name;
    @FXML private TextField target4Name;
    @FXML private TextField target5Name;
    @FXML private TextField target6Name;
    @FXML private TextField target7Name;
    @FXML private TextField target8Name;
    @FXML private TextField target9Name;
    @FXML private TextField target10Name;
    @FXML private TableView sampleTable;
    @FXML private TableColumn sampleSlot;
    @FXML private TableColumn sampleWell;

    private final PseudoClass errorClass = PseudoClass.getPseudoClass("error");

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        userName.pseudoClassStateChanged(errorClass, true);
        OptionsDataCollector.setRunModule("#ddPCR Parameters");

        runDate.setOnAction(e -> {
            String runDateItem = runDate.getValue().toString();
            OptionsDataCollector.getRunDate(runDateItem);
        });

        //FXCollections.observableArrayList(new User("zaza","zaza","zaza"));
        //sampleTable.getItems().add(new User("John","NewYork","+16879060"));
        sampleTable.setEditable(true);
        sampleTable.setVisible(true);
        sampleTable.setItems(FXCollections.observableArrayList("zaza","zaza","zaza"));
        sampleTable.getItems().add("zaza");
        System.out.println(sampleSlot.getColumns());


        userName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(userName.getText()) && textValidate(userName.getText())) {
                userName.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setUserName(userName.getText());
            } else {
                userName.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setUserName(userName.getText());
            }
        });

        if (StringUtils.isNotEmpty(LeftPipetteFirstTip.getText()) && textValidate(LeftPipetteFirstTip.getText())) {
            LeftPipetteFirstTip.pseudoClassStateChanged(errorClass, false);
            OptionsDataCollector.setLeftPipetteFirstTip(LeftPipetteFirstTip.getText());

        } else {
            LeftPipetteFirstTip.pseudoClassStateChanged(errorClass, true);
            OptionsDataCollector.setLeftPipetteFirstTip(LeftPipetteFirstTip.getText());
        }

        if (StringUtils.isNotEmpty(RightPipetteFirstTip.getText()) && textValidate(RightPipetteFirstTip.getText())) {

            RightPipetteFirstTip.pseudoClassStateChanged(errorClass, false);
            OptionsDataCollector.setRightPipetteFirstTip(RightPipetteFirstTip.getText());
        } else {
            RightPipetteFirstTip.pseudoClassStateChanged(errorClass, true);
            OptionsDataCollector.setRightPipetteFirstTip(RightPipetteFirstTip.getText());
        }

        if (!StringUtils.isNotEmpty(BottomOffset.getText()) && numberValidate(BottomOffset.getText())) {
            BottomOffset.pseudoClassStateChanged(errorClass, false);
            OptionsDataCollector.setBottomOffset(BottomOffset.getText());
        } else {
            BottomOffset.pseudoClassStateChanged(errorClass, true);
            OptionsDataCollector.setBottomOffset(BottomOffset.getText());
        }

        OptionsDataCollector.setUseTemperatureModule(useTemperatureModule);


        setTemperature.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isNotEmpty(setTemperature.getText()) && textValidate(setTemperature.getText())) {
                setTemperature.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setsetTemperature(setTemperature.getText());
            } else {
                setTemperature.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setsetTemperature(setTemperature.getText());
            }
        });

        String[] SlotLabware = {
                "8_well_strip_tubes_200ul",
                "bigwell_96_tuberack_200ul_dilution_tube",
                "stacked_96_well",
                "biorad_ddpcr_plate_aluminum_block_100ul",
                "eppendorftwin.tecpcrplates_96_aluminumblock_150ul",
                "parhelia_temp_module_with_biorad_ddpcr_plate_100ul",
                "parhelia_temp_module_with_twintec_ddpcr_plate_150ul",
                "opentrons_96_tiprack_300ul",
                "opentrons_96_filtertiprack_200ul",
                "opentrons_96_tiprack_20ul",
                "opentrons_96_filtertiprack_20ul",
                "screwcap_24_tuberack_500ul",
                "opentrons_24_tuberack_generic_2ml_screwcap",
                "opentrons_24_tube_rack_vwr_microfuge_tube_1.5ml",
                "vwrscrewcapcentrifugetube5ml_15_tuberack_5000ul"
        };

        Slot1.getItems().addAll(SlotLabware);
        Slot1.setOnAction(e -> {
            String Slot1Item = Slot1.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot1(Slot1Item);
        });

        Slot2.getItems().addAll(SlotLabware);
        Slot2.setOnAction(e -> {
            String Slot2Item = Slot2.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot2(Slot2Item);
        });
        Slot3.getItems().addAll(SlotLabware);
        Slot3.setOnAction(e -> {
            String Slot3Item = Slot3.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot3(Slot3Item);
        });
        Slot4.getItems().addAll(SlotLabware);
        Slot4.setOnAction(e -> {
            String Slot4Item = Slot4.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot4(Slot4Item);
        });
        Slot5.getItems().addAll(SlotLabware);
        Slot5.setOnAction(e -> {
            String Slot5Item = Slot5.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot5(Slot5Item);
        });
        Slot6.getItems().addAll(SlotLabware);
        Slot6.setOnAction(e -> {
            String Slot6Item = Slot6.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot6(Slot6Item);
        });
        Slot7.getItems().addAll(SlotLabware);
        Slot7.setOnAction(e -> {
            String Slot7Item = Slot7.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot7(Slot7Item);
        });
        Slot8.getItems().addAll(SlotLabware);
        Slot8.setOnAction(e -> {
            String Slot8Item = Slot8.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot8(Slot8Item);
        });
        Slot9.getItems().addAll(SlotLabware);
        Slot9.setOnAction(e -> {
            String Slot9Item = Slot9.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot9(Slot9Item);
        });
        Slot10.getItems().addAll(SlotLabware);
        Slot10.setOnAction(e -> {
            String Slot10Item = Slot10.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot10(Slot10Item);
        });
        Slot11.getItems().addAll(SlotLabware);
        Slot11.setOnAction(e -> {
            String Slot11Item = Slot11.getSelectionModel().getSelectedItem().toString();
            OptionsDataCollector.setSlot11(Slot11Item);
        });
        target1Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target1Name.getText()) && textValidate(target1Name.getText())) {
                target1Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget1Name(target1Name.getText());
            } else {
                target1Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget1Name(target1Name.getText());
            }
        });
        target2Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target2Name.getText()) && textValidate(target2Name.getText())) {
                target2Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget2Name(target2Name.getText());
            } else {
                target2Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget2Name(target2Name.getText());
            }
        });
    }
}

