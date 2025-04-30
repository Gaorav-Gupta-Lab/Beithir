/**
 * Vista Controller for Beithir Illumina Dual Indexing views
 * Package loosely based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since April 2025
 * @version 0.9.0
 */

package gupta_lab.beithir.Controllers;

import gupta_lab.beithir.Models.commonDataCollector;
import gupta_lab.beithir.Models.illumina_Dual_Indexing_OptionsDataCollector;
import gupta_lab.beithir.Models.LabwareDefinitions;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.apache.commons.lang3.StringUtils;

import static gupta_lab.beithir.Models.InputValidation.*;
import static gupta_lab.beithir.Models.InputValidation.textValidate;

public class Illumina_Dual_Indexing_VistaController implements Initializable {
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

    //Indexing Primer Tab
    @FXML private TextField indexPrimerSlot;
    @FXML private TextField primerD501;
    @FXML private TextField primerD502;
    @FXML private TextField primerD503;
    @FXML private TextField primerD504;
    @FXML private TextField primerD505;
    @FXML private TextField primerD506;
    @FXML private TextField primerD507;
    @FXML private TextField primerD508;
    @FXML private TextField primerD701;
    @FXML private TextField primerD702;
    @FXML private TextField primerD703;
    @FXML private TextField primerD704;
    @FXML private TextField primerD705;
    @FXML private TextField primerD706;
    @FXML private TextField primerD707;
    @FXML private TextField primerD708;
    @FXML private TextField primerD709;
    @FXML private TextField primerD710a;
    @FXML private TextField primerD711;
    @FXML private TextField primerD712;

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
    private final ObservableList<illumina_Dual_Indexing_OptionsDataCollector> sampleData = FXCollections.observableArrayList();

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        userName.pseudoClassStateChanged(errorClass, true);
        runDate.pseudoClassStateChanged(errorClass, true);
        pcrPlateSlot.pseudoClassStateChanged(errorClass, true);
        setTemperature.pseudoClassStateChanged(errorClass, true);
        dilutionPlateSlot.pseudoClassStateChanged(errorClass, true);
        reagentSlot.pseudoClassStateChanged(errorClass, true);
        waterReservoirWell.pseudoClassStateChanged(errorClass, true);
        waterResVol.pseudoClassStateChanged(errorClass, true);
        masterMixPerRxn.pseudoClassStateChanged(errorClass, true);
        dnaPerWell.pseudoClassStateChanged(errorClass, true);
        addSampleSlot.pseudoClassStateChanged(errorClass, true);
        addSampleWell.pseudoClassStateChanged(errorClass, true);
        addSampleName.pseudoClassStateChanged(errorClass, true);
        addSampleConcentration.pseudoClassStateChanged(errorClass, true);
        addSampleTargets.pseudoClassStateChanged(errorClass, true);

        illumina_Dual_Indexing_OptionsDataCollector.setVersionString(versionNumber.getText());
        illumina_Dual_Indexing_OptionsDataCollector.setRunModule("#Illumina Dual Indexing Parameters\t");

        runDate.setOnAction(_ -> commonDataCollector.getRunDate(runDate.getValue().toString()));

        userName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(userName.getText()) && textValidate(userName.getText())) {
                userName.pseudoClassStateChanged(errorClass, false);
                commonDataCollector.setUserName(userName.getText());
            } else {
                userName.pseudoClassStateChanged(errorClass, true);
                commonDataCollector.setUserName(userName.getText());
            }
        });

        if (LeftPipetteFirstTip.getText().equalsIgnoreCase("A1")){
            commonDataCollector.setLeftPipetteFirstTip("A1");
            // System.out.println("Left Tip: "+LeftPipetteFirstTip.getText().toUpperCase());
        }
        LeftPipetteFirstTip.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!StringUtils.isBlank(LeftPipetteFirstTip.getText()) && firstTipLocationValidate(LeftPipetteFirstTip.getText())) {
                LeftPipetteFirstTip.pseudoClassStateChanged(errorClass, false);
                commonDataCollector.setLeftPipetteFirstTip(LeftPipetteFirstTip.getText().toUpperCase());
            } else {
                LeftPipetteFirstTip.pseudoClassStateChanged(errorClass, true);
                commonDataCollector.setLeftPipetteFirstTip(LeftPipetteFirstTip.getText().toUpperCase());
            }
        });

        if (RightPipetteFirstTip.getText().equalsIgnoreCase("A1")){
            commonDataCollector.setRightPipetteFirstTip("A1");
            // System.out.println("Right Tip: "+RightPipetteFirstTip.getText().toUpperCase());
        }
        RightPipetteFirstTip.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(RightPipetteFirstTip.getText()) && firstTipLocationValidate(RightPipetteFirstTip.getText())) {
                RightPipetteFirstTip.pseudoClassStateChanged(errorClass, false);
                commonDataCollector.setRightPipetteFirstTip(RightPipetteFirstTip.getText().toUpperCase());
            } else {
                RightPipetteFirstTip.pseudoClassStateChanged(errorClass, true);
            }
        });
        //System.out.println(numberValidate(BottomOffset.getText()));
        if (BottomOffset.getText().equalsIgnoreCase("1.0")){
            commonDataCollector.setBottomOffset("1.0");
            // System.out.println("Bottom Offset: "+BottomOffset.getText());
        }
        BottomOffset.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(BottomOffset.getText()) && numberValidate(BottomOffset.getText())) {
                BottomOffset.pseudoClassStateChanged(errorClass, false);
                commonDataCollector.setBottomOffset(BottomOffset.getText());
            } else {
                BottomOffset.pseudoClassStateChanged(errorClass, true);
            }
        });

//      Selection for use of Temperature Module.  Set Temperature field is only active when module is selected for use.
        commonDataCollector.getUseTemperatureModule().setSelected(false);
        setTemperature.disableProperty().bind(commonDataCollector.useTemperatureModule.selectedProperty().not());
        commonDataCollector.setUseTemperatureModule(useTemperatureModule);

        setTemperature.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isNotEmpty(setTemperature.getText()) && textValidate(setTemperature.getText())) {
                setTemperature.pseudoClassStateChanged(errorClass, false);
                commonDataCollector.setSetTemperature(setTemperature.getText());
            } else {
                setTemperature.pseudoClassStateChanged(errorClass, true);
                commonDataCollector.setSetTemperature(setTemperature.getText());
            }
        });

        pcrPlateSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setPCR_PlateSlot(pcrPlateSlot.getText());
        });

        dilutionPlateSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setDilutionPlateSlot(dilutionPlateSlot.getText());
        });

        reagentSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setReagentSlot(reagentSlot.getText());
        });

        waterReservoirWell.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setWaterReservoirWell(waterReservoirWell.getText());
        });

        waterResVol.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setWaterResVol(waterResVol.getText());
        });

        prcVolume.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setPCR_Volume(prcVolume.getText());
        });

        masterMixPerRxn.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setMasterMixPerRxn(masterMixPerRxn.getText());
        });

        dnaPerWell.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setDNAPerWell(dnaPerWell.getText());
        });

        /*
         * Beginning the code for the Deck Layout Tab.
         */
        Slot1.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot1.setOnAction(_ -> commonDataCollector.setSlot1(Slot1.getSelectionModel().getSelectedItem()));
        Slot2.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot2.setOnAction(_ -> commonDataCollector.setSlot2(Slot2.getSelectionModel().getSelectedItem()));
        Slot3.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot3.setOnAction(_ -> commonDataCollector.setSlot3(Slot3.getSelectionModel().getSelectedItem()));
        Slot4.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot4.setOnAction(_ -> commonDataCollector.setSlot4(Slot4.getSelectionModel().getSelectedItem()));
        Slot5.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot5.setOnAction(_ -> commonDataCollector.setSlot5(Slot5.getSelectionModel().getSelectedItem()));
        Slot6.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot6.setOnAction(_ -> commonDataCollector.setSlot6(Slot6.getSelectionModel().getSelectedItem()));
        Slot7.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot7.setOnAction(_ -> commonDataCollector.setSlot7(Slot7.getSelectionModel().getSelectedItem()));
        Slot8.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot8.setOnAction(_ -> commonDataCollector.setSlot8(Slot8.getSelectionModel().getSelectedItem()));
        Slot9.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot9.setOnAction(_ -> commonDataCollector.setSlot9(Slot9.getSelectionModel().getSelectedItem()));
        Slot10.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot10.setOnAction(_ -> commonDataCollector.setSlot10(Slot10.getSelectionModel().getSelectedItem()));
        Slot11.getItems().addAll(LabwareDefinitions.getSupportedLabwareTypes());
        Slot11.setOnAction(_ -> commonDataCollector.setSlot11(Slot11.getSelectionModel().getSelectedItem()));

        /*
         * Beginning of code for Indexing Primer Tab
         */
        indexPrimerSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setIndexPrimerSlot(indexPrimerSlot.getText());
        });
        primerD501.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD501(primerD501.getText());
        });
        primerD502.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD502(primerD502.getText());
        });
        primerD503.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD503(primerD503.getText());
        });
        primerD504.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD504(primerD504.getText());
        });
        primerD505.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD505(primerD505.getText());
        });
        primerD506.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD506(primerD506.getText());
        });
        primerD507.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD507(primerD507.getText());
        });
        primerD508.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD508(primerD508.getText());
        });
        primerD701.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD701(primerD701.getText());
        });
        primerD702.textProperty().addListener((observable, oldValue, newValue) -> {

        });
        primerD703.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD703(primerD703.getText());
        });
        primerD704.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD704(primerD704.getText());
        });
        primerD705.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD705(primerD705.getText());
        });
        primerD706.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD706(primerD706.getText());
        });
        primerD707.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD707(primerD707.getText());
        });
        primerD708.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD708(primerD708.getText());
        });
        primerD709.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD709(primerD709.getText());
        });
        primerD710a.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD710a(primerD710a.getText());
        });
        primerD711.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD711(primerD711.getText());
        });
        primerD712.textProperty().addListener((observable, oldValue, newValue) -> {
            illumina_Dual_Indexing_OptionsDataCollector.setPrimerD712(primerD712.getText());
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

        sampleSlot.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleSlot(t.getNewValue());
            }
        });

        sampleWell.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleWell(t.getNewValue());
            }
        });
        sampleName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleName(t.getNewValue());
            }
        });
        sampleConcentration.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleConcentration(t.getNewValue());
            }
        });
        sampleTargets.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleTargets(t.getNewValue());
            }
        });
        sampleReplicates.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<illumina_Dual_Indexing_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleReplicates(t.getNewValue());
            }
        });

        /*
         * Apply error checking to samples.
         * */
        addSampleSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(addSampleSlot.getText()) && slotValidate(addSampleSlot.getText())) {
                addSampleSlot.pseudoClassStateChanged(errorClass, false);
            } else {
                addSampleSlot.pseudoClassStateChanged(errorClass, true);
            }
        });
        addSampleWell.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(addSampleWell.getText()) && wellValidate(addSampleWell.getText())) {
                addSampleWell.pseudoClassStateChanged(errorClass, false);
            } else {
                addSampleWell.pseudoClassStateChanged(errorClass, true);
            }
        });
        addSampleName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(addSampleName.getText())) {
                addSampleName.pseudoClassStateChanged(errorClass, false);
            } else {
                addSampleName.pseudoClassStateChanged(errorClass, true);
            }
        });
        addSampleConcentration.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(addSampleConcentration.getText()) && numberValidate(addSampleConcentration.getText())) {
                addSampleConcentration.pseudoClassStateChanged(errorClass, false);
            } else {
                addSampleConcentration.pseudoClassStateChanged(errorClass, true);
            }
        });
        addSampleTargets.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(addSampleTargets.getText()) && targetValidate(addSampleConcentration.getText())) {
                addSampleTargets.pseudoClassStateChanged(errorClass, false);
            } else {
                addSampleTargets.pseudoClassStateChanged(errorClass, true);
            }
        });
        addSampleInformationButton.setOnAction(_ -> {
            sampleData.add(new illumina_Dual_Indexing_OptionsDataCollector(
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
            illumina_Dual_Indexing_OptionsDataCollector.processSampleData(sampleTable);
        });

        deleteSampleRowButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                var selectedRow = sampleTable.getSelectionModel().getSelectedItem();
                if (selectedRow != null) {
                    sampleData.remove(selectedRow);
                }
                illumina_Dual_Indexing_OptionsDataCollector.processSampleData(sampleTable);
            }
        });

        sampleTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("Sample Table Listeners: ");
            illumina_Dual_Indexing_OptionsDataCollector.processSampleData(sampleTable);
        });
    }
}
