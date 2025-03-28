/**
 * Vista Controller for Beithir ddPCR views
 * Package loosely based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.5.0
 */

package gupta_lab.beithir.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import static gupta_lab.beithir.Models.InputValidation.numberValidate;
import static gupta_lab.beithir.Models.InputValidation.textValidate;
import gupta_lab.beithir.Models.OptionsDataCollector;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.apache.commons.lang3.StringUtils;

public class ddPCR_VistaController implements Initializable{
    //Required Parameters tab
    @FXML private TextField versionNumber;
    @FXML private TextField userName;
    @FXML private DatePicker runDate;
    @FXML private TextField LeftPipetteFirstTip;
    @FXML private TextField RightPipetteFirstTip;
    @FXML private TextField BottomOffset;
    @FXML private CheckBox useTemperatureModule;
    @FXML private TextField setTemperature;
    @FXML private TextField pcrPlateSlot;
    @FXML private TextField dilutionPlateSlot;
    @FXML private TextField reagentSlot;
    @FXML private TextField waterReservoirWell;
    @FXML private TextField waterResVol;
    @FXML private TextField prcVolume;
    @FXML private TextField masterMixPerRxn;
    @FXML private TextField dnaPerWell;

    //Deck Layout Tab
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

    //Target Information Tab
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

    //Sample Information Tab
    @FXML private TableView sampleTable;
    @FXML private TableColumn sampleSlot;
    @FXML private TableColumn sampleWell;
    @FXML private TableColumn sampleName;
    @FXML private TableColumn sampleConcentration;
    @FXML private TableColumn sampleTargets;
    @FXML private TableColumn sampleReplicates;
    @FXML private TextField addSampleSlot;
    @FXML private TextField addSampleWell;
    @FXML private TextField addSampleName;
    @FXML private TextField addSampleConcentration;
    @FXML private TextField addSampleTargets;
    @FXML private TextField addSampleReplicates;
    @FXML private Button addSampleInformationButton;
    @FXML private Button deleteSampleRowButton;

    private final PseudoClass errorClass = PseudoClass.getPseudoClass("error");
    private final ObservableList<OptionsDataCollector> sampleData = FXCollections.observableArrayList();

    /*
    * debugging code to add some data to the sampleTable.  Will remove in future version.
    *
    private final ObservableList<OptionsDataCollector> sampleData = FXCollections.observableArrayList(
            new OptionsDataCollector(
                    "Slot", "Well", "My Awesome  Sample",
                    "27.9", "1,2", "1")
    );
    */

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {

        OptionsDataCollector.setVersionString(versionNumber.getText());
        userName.pseudoClassStateChanged(errorClass, true);
        OptionsDataCollector.setRunModule("#ddPCR Parameters\t");

        runDate.setOnAction(_ -> OptionsDataCollector.getRunDate(runDate.getValue().toString()));

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

//      Selection for use of Temperature Module.  Set Temperature field is only active when module is selected for use.
        useTemperatureModule.setSelected(false);
        setTemperature.disableProperty().bind(useTemperatureModule.selectedProperty().not());
        OptionsDataCollector.setUseTemperatureModule(useTemperatureModule);
        setTemperature.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isNotEmpty(setTemperature.getText()) && textValidate(setTemperature.getText())) {
                setTemperature.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setSetTemperature(setTemperature.getText());
            } else {
                setTemperature.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setSetTemperature(setTemperature.getText());
            }
        });

        pcrPlateSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            OptionsDataCollector.setPCR_PlateSlot(pcrPlateSlot.getText());
        });

        dilutionPlateSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            OptionsDataCollector.setDilutionPlateSlot(dilutionPlateSlot.getText());
        });

        reagentSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            OptionsDataCollector.setReagentSlot(reagentSlot.getText());
        });

        waterReservoirWell.textProperty().addListener((observable, oldValue, newValue) -> {
            OptionsDataCollector.setWaterReservoirWell(waterReservoirWell.getText());
        });

        waterResVol.textProperty().addListener((observable, oldValue, newValue) -> {
            OptionsDataCollector.setWaterResVol(waterResVol.getText());
        });

        prcVolume.textProperty().addListener((observable, oldValue, newValue) -> {
            OptionsDataCollector.setPCR_Volume(prcVolume.getText());
        });

        masterMixPerRxn.textProperty().addListener((observable, oldValue, newValue) -> {
            OptionsDataCollector.setMasterMixPerRxn(masterMixPerRxn.getText());
        });

        dnaPerWell.textProperty().addListener((observable, oldValue, newValue) -> {
            OptionsDataCollector.setDNAPerWell(dnaPerWell.getText());
        });

       /*
       * Beginning the code for the "Samples" Tab. This handles the display and editing of the table.
       */
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
        Slot1.setOnAction(_ -> OptionsDataCollector.setSlot1(Slot1.getSelectionModel().getSelectedItem()));
        Slot2.getItems().addAll(SlotLabware);
        Slot2.setOnAction(_ -> OptionsDataCollector.setSlot2(Slot2.getSelectionModel().getSelectedItem()));
        Slot3.getItems().addAll(SlotLabware);
        Slot3.setOnAction(_ -> OptionsDataCollector.setSlot3(Slot3.getSelectionModel().getSelectedItem()));
        Slot4.getItems().addAll(SlotLabware);
        Slot4.setOnAction(_ -> OptionsDataCollector.setSlot4(Slot4.getSelectionModel().getSelectedItem()));
        Slot5.getItems().addAll(SlotLabware);
        Slot5.setOnAction(_ -> OptionsDataCollector.setSlot5(Slot5.getSelectionModel().getSelectedItem()));
        Slot6.getItems().addAll(SlotLabware);
        Slot6.setOnAction(_ -> OptionsDataCollector.setSlot6(Slot6.getSelectionModel().getSelectedItem()));
        Slot7.getItems().addAll(SlotLabware);
        Slot7.setOnAction(_ -> OptionsDataCollector.setSlot7(Slot7.getSelectionModel().getSelectedItem()));
        Slot8.getItems().addAll(SlotLabware);
        Slot8.setOnAction(_ -> OptionsDataCollector.setSlot8(Slot8.getSelectionModel().getSelectedItem()));
        Slot9.getItems().addAll(SlotLabware);
        Slot9.setOnAction(_ -> OptionsDataCollector.setSlot9(Slot9.getSelectionModel().getSelectedItem()));
        Slot10.getItems().addAll(SlotLabware);
        Slot10.setOnAction(_ -> OptionsDataCollector.setSlot10(Slot10.getSelectionModel().getSelectedItem()));
        Slot11.getItems().addAll(SlotLabware);
        Slot11.setOnAction(_ -> OptionsDataCollector.setSlot11(Slot11.getSelectionModel().getSelectedItem()));

        /*
        * Beginning of code for the Target Reagent information.
        */
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
        target3Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target3Name.getText()) && textValidate(target3Name.getText())) {
                target3Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget3Name(target3Name.getText());
            } else {
                target3Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget3Name(target3Name.getText());
            }
        });
        target4Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target4Name.getText()) && textValidate(target4Name.getText())) {
                target4Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget4Name(target4Name.getText());
            } else {
                target4Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget4Name(target4Name.getText());
            }
        });
        target5Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target5Name.getText()) && textValidate(target5Name.getText())) {
                target5Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget5Name(target5Name.getText());
            } else {
                target5Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget5Name(target5Name.getText());
            }
        });
        target6Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target6Name.getText()) && textValidate(target6Name.getText())) {
                target6Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget6Name(target6Name.getText());
            } else {
                target6Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget6Name(target6Name.getText());
            }
        });
        target7Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target7Name.getText()) && textValidate(target7Name.getText())) {
                target7Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget7Name(target7Name.getText());
            } else {
                target7Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget7Name(target7Name.getText());
            }
        });
        target8Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target8Name.getText()) && textValidate(target8Name.getText())) {
                target8Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget8Name(target8Name.getText());
            } else {
                target8Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget8Name(target8Name.getText());
            }
        });
        target9Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target9Name.getText()) && textValidate(target9Name.getText())) {
                target9Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget9Name(target9Name.getText());
            } else {
                target9Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget9Name(target9Name.getText());
            }
        });
        target10Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target10Name.getText()) && textValidate(target10Name.getText())) {
                target10Name.pseudoClassStateChanged(errorClass, false);
                OptionsDataCollector.setTarget10Name(target10Name.getText());
            } else {
                target10Name.pseudoClassStateChanged(errorClass, true);
                OptionsDataCollector.setTarget10Name(target10Name.getText());
            }
        });

        /*
        * Beginning of code for Sample Table
        * */
        sampleTable.setEditable(true);
        sampleSlot.setEditable(true);
        sampleWell.setEditable(true);
        sampleName.setEditable(true);
        sampleConcentration.setEditable(true);
        sampleTargets.setEditable(true);
        sampleReplicates.setEditable(true);

        sampleSlot.setCellValueFactory(new PropertyValueFactory<>("sampleSlot"));
        sampleWell.setCellValueFactory(new PropertyValueFactory<>("sampleWell"));
        sampleName.setCellValueFactory(new PropertyValueFactory<>("sampleName"));
        sampleConcentration.setCellValueFactory(new PropertyValueFactory<>("sampleConcentration"));
        sampleTargets.setCellValueFactory(new PropertyValueFactory<>("sampleTargets"));
        sampleReplicates.setCellValueFactory(new PropertyValueFactory<>("sampleReplicates"));

        sampleSlot.setCellFactory(TextFieldTableCell.forTableColumn());
        sampleWell.setCellFactory(TextFieldTableCell.forTableColumn());
        sampleName.setCellFactory(TextFieldTableCell.forTableColumn());
        sampleConcentration.setCellFactory(TextFieldTableCell.forTableColumn());
        sampleTargets.setCellFactory(TextFieldTableCell.forTableColumn());
        sampleReplicates.setCellFactory(TextFieldTableCell.forTableColumn());

        sampleSlot.setOnEditCommit(new EventHandler<CellEditEvent<OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleSlot(t.getNewValue());
            }
        });

        sampleWell.setOnEditCommit(new EventHandler<CellEditEvent<OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleWell(t.getNewValue());
            }
        });
        sampleName.setOnEditCommit(new EventHandler<CellEditEvent<OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleName(t.getNewValue());
            }
        });
        sampleConcentration.setOnEditCommit(new EventHandler<CellEditEvent<OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleConcentration(t.getNewValue());
            }
        });
        sampleTargets.setOnEditCommit(new EventHandler<CellEditEvent<OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleTargets(t.getNewValue());
            }
        });
        sampleReplicates.setOnEditCommit(new EventHandler<CellEditEvent<OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleReplicates(t.getNewValue());
            }
        });

        addSampleInformationButton.setOnAction(_ -> {
            sampleData.add(new OptionsDataCollector(
                    addSampleSlot.getText(),
                    addSampleWell.getText(),
                    addSampleName.getText(),
                    addSampleConcentration.getText(),
                    addSampleTargets.getText(),
                    addSampleReplicates.getText()));

            addSampleSlot.clear();
            addSampleWell.clear();
            addSampleName.clear();
            addSampleConcentration.clear();
            addSampleTargets.clear();
            addSampleReplicates.clear();

            sampleTable.setItems(sampleData);
            OptionsDataCollector.processSampleData(sampleTable);
        });

        deleteSampleRowButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                var selectedRow = sampleTable.getSelectionModel().getSelectedItem();
                if (selectedRow != null) {
                    sampleData.remove(selectedRow);
                }
                OptionsDataCollector.processSampleData(sampleTable);
            }
        });

        sampleTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Sample Table Listeners: ");
            OptionsDataCollector.processSampleData(sampleTable);
        });
    }
}
