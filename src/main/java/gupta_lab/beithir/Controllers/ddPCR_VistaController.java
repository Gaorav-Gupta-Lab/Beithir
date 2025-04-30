/**
 * Vista Controller for Beithir ddPCR views
 * Package loosely based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.9.0
 */

package gupta_lab.beithir.Controllers;

import gupta_lab.beithir.Models.commonDataCollector;
import gupta_lab.beithir.Models.LabwareDefinitions;
import gupta_lab.beithir.Models.ddPCR_OptionsDataCollector;
import static gupta_lab.beithir.Models.InputValidation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
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
    @FXML private TextField target1Well;
    @FXML private TextField target1Volume;
    @FXML private TextField target2Name;
    @FXML private TextField target2Well;
    @FXML private TextField target2Volume;
    @FXML private TextField target3Name;
    @FXML private TextField target3Well;
    @FXML private TextField target3Volume;
    @FXML private TextField target4Name;
    @FXML private TextField target4Well;
    @FXML private TextField target4Volume;
    @FXML private TextField target5Name;
    @FXML private TextField target5Well;
    @FXML private TextField target5Volume;
    @FXML private TextField target6Name;
    @FXML private TextField target6Well;
    @FXML private TextField target6Volume;
    @FXML private TextField target7Name;
    @FXML private TextField target7Well;
    @FXML private TextField target7Volume;
    @FXML private TextField target8Name;
    @FXML private TextField target8Well;
    @FXML private TextField target8Volume;
    @FXML private TextField target9Name;
    @FXML private TextField target9Well;
    @FXML private TextField target9Volume;
    @FXML private TextField target10Name;
    @FXML private TextField target10Well;
    @FXML private TextField target10Volume;

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
    private final ObservableList<ddPCR_OptionsDataCollector> sampleData = FXCollections.observableArrayList();

    /*
    * debugging code to add some data to the sampleTable.  Will remove in a future version.
    *
    private final ObservableList<OptionsDataCollector> sampleData = FXCollections.observableArrayList(
            new OptionsDataCollector("Slot", "Well", "My Awesome Sample", "27.9", "1,2", "1")
    );
    */

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

        ddPCR_OptionsDataCollector.setVersionString(versionNumber.getText());
        ddPCR_OptionsDataCollector.setRunModule("#ddPCR Parameters\t");

        runDate.setOnAction(_ -> commonDataCollector.getRunDate(runDate.getValue().toString()));

        userName.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setUserName(userName.getText());
            if (!StringUtils.isBlank(userName.getText()) && textValidate(userName.getText())) {
                userName.pseudoClassStateChanged(errorClass, false);
            } else {
                userName.pseudoClassStateChanged(errorClass, true);
            }
        });

        if (LeftPipetteFirstTip.getText().equalsIgnoreCase("A1")){
            commonDataCollector.setLeftPipetteFirstTip("A1");
        }
        LeftPipetteFirstTip.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setLeftPipetteFirstTip(LeftPipetteFirstTip.getText().toUpperCase());
            if (!StringUtils.isBlank(LeftPipetteFirstTip.getText()) && firstTipLocationValidate(LeftPipetteFirstTip.getText().toUpperCase())) {
                LeftPipetteFirstTip.pseudoClassStateChanged(errorClass, false);
            } else {
                LeftPipetteFirstTip.pseudoClassStateChanged(errorClass, true);
            }
        });

        if (RightPipetteFirstTip.getText().equalsIgnoreCase("A1")){
            commonDataCollector.setLeftPipetteFirstTip("A1");
        }
       RightPipetteFirstTip.textProperty().addListener((observable, oldValue, newValue) -> {
           commonDataCollector.setRightPipetteFirstTip(RightPipetteFirstTip.getText().toUpperCase());
           if (!StringUtils.isBlank(RightPipetteFirstTip.getText()) && firstTipLocationValidate(RightPipetteFirstTip.getText().toUpperCase())) {
               RightPipetteFirstTip.pseudoClassStateChanged(errorClass, false);
           } else {
               RightPipetteFirstTip.pseudoClassStateChanged(errorClass, true);
           }
       });
        //System.out.println(numberValidate(BottomOffset.getText()));
        if (BottomOffset.getText().equalsIgnoreCase("1.0")){
            commonDataCollector.setBottomOffset("1.0");
        }
        BottomOffset.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setBottomOffset(BottomOffset.getText());
            if (!StringUtils.isBlank(BottomOffset.getText()) && numberValidate(BottomOffset.getText())) {
                BottomOffset.pseudoClassStateChanged(errorClass, false);
            } else {
                BottomOffset.pseudoClassStateChanged(errorClass, true);
            }
        });

//      Selection for use of Temperature Module.  Set Temperature field is only active when the module is selected for use.
        useTemperatureModule.setSelected(false);
        setTemperature.disableProperty().bind(useTemperatureModule.selectedProperty().not());
        commonDataCollector.setUseTemperatureModule(useTemperatureModule);
        setTemperature.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isNotEmpty(setTemperature.getText()) && numberValidate(setTemperature.getText())) {
                setTemperature.pseudoClassStateChanged(errorClass, false);
            } else {
                setTemperature.pseudoClassStateChanged(errorClass, true);
            }
        });

        pcrPlateSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setPCR_PlateSlot(pcrPlateSlot.getText());
            if (!StringUtils.isBlank(pcrPlateSlot.getText()) && slotValidate(pcrPlateSlot.getText())) {
                pcrPlateSlot.pseudoClassStateChanged(errorClass, false);
            }else {
                pcrPlateSlot.pseudoClassStateChanged(errorClass, true);
            }
        });

        dilutionPlateSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setDilutionPlateSlot(dilutionPlateSlot.getText());
            if (!StringUtils.isBlank(dilutionPlateSlot.getText()) && slotValidate(dilutionPlateSlot.getText())) {
                dilutionPlateSlot.pseudoClassStateChanged(errorClass, false);
            }else {
                dilutionPlateSlot.pseudoClassStateChanged(errorClass, true);
            }
        });

        reagentSlot.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setReagentSlot(reagentSlot.getText());
            if (!StringUtils.isBlank(reagentSlot.getText()) && slotValidate(reagentSlot.getText())) {
                reagentSlot.pseudoClassStateChanged(errorClass, false);
            }else {
                reagentSlot.pseudoClassStateChanged(errorClass, true);
            }
        });

        waterReservoirWell.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setWaterReservoirWell(waterReservoirWell.getText().toUpperCase());
            if (!StringUtils.isBlank(waterReservoirWell.getText()) && wellValidate(waterReservoirWell.getText().toUpperCase())) {
                waterReservoirWell.pseudoClassStateChanged(errorClass, false);
            }else {
                waterReservoirWell.pseudoClassStateChanged(errorClass, true);
            }
        });

        waterResVol.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setWaterResVol(waterResVol.getText());
            if (!StringUtils.isBlank(waterResVol.getText()) && numberValidate(waterResVol.getText())) {
                waterResVol.pseudoClassStateChanged(errorClass, false);
            }else {
                waterResVol.pseudoClassStateChanged(errorClass, true);
            }
        });

        prcVolume.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setPCR_Volume(prcVolume.getText());
            if (!StringUtils.isBlank(prcVolume.getText()) && numberValidate(prcVolume.getText())) {
                prcVolume.pseudoClassStateChanged(errorClass, false);
            }else {
                prcVolume.pseudoClassStateChanged(errorClass, true);
            }
        });

        masterMixPerRxn.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setMasterMixPerRxn(masterMixPerRxn.getText());
            if (!StringUtils.isBlank(masterMixPerRxn.getText()) && numberValidate(masterMixPerRxn.getText())) {
                masterMixPerRxn.pseudoClassStateChanged(errorClass, false);
            }else {
                masterMixPerRxn.pseudoClassStateChanged(errorClass, true);
            }
        });

        dnaPerWell.textProperty().addListener((observable, oldValue, newValue) -> {
            commonDataCollector.setDNAPerWell(dnaPerWell.getText());
            if (!StringUtils.isBlank(dnaPerWell.getText()) && numberValidate(dnaPerWell.getText())) {
                dnaPerWell.pseudoClassStateChanged(errorClass, false);
            }else {
                dnaPerWell.pseudoClassStateChanged(errorClass, true);
            }
        });

       /*
       * Beginning the code for the "Samples" Tab. This handles the display and editing of the table.
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
        * Beginning of code for the Target Reagent information.
        */
        target1Name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!StringUtils.isBlank(target1Name.getText()) && textValidate(target1Name.getText())) {
                target1Name.pseudoClassStateChanged(errorClass, false);
                ddPCR_OptionsDataCollector.setTarget1Name(target1Name.getText());
            } else {
                target1Name.pseudoClassStateChanged(errorClass, true);
                ddPCR_OptionsDataCollector.setTarget1Name(target1Name.getText());
            }
        });
        target1Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget1Well(target1Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target1Well.getText()) && wellValidate(target1Well.getText())) {
                target1Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target1Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target1Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget1Volume(target1Volume.getText());
            if (!StringUtils.isBlank(target1Volume.getText()) && numberValidate(target1Volume.getText())) {
                target1Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target1Volume.pseudoClassStateChanged(errorClass, true);
            }
        });
        target2Name.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget2Name(target2Name.getText());
            if (!StringUtils.isBlank(target2Name.getText()) && textValidate(target2Name.getText())) {
                target2Name.pseudoClassStateChanged(errorClass, false);
            } else {
                target2Name.pseudoClassStateChanged(errorClass, true);
            }
        });
        target2Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget2Well(target2Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target2Well.getText()) && wellValidate(target2Well.getText())) {
                target2Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target2Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target2Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget2Volume(target2Volume.getText());
            if (!StringUtils.isBlank(target2Volume.getText()) && numberValidate(target2Volume.getText())) {
                target2Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target2Volume.pseudoClassStateChanged(errorClass, true);
            }
        });
        target3Name.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget3Name(target3Name.getText());
            if (!StringUtils.isBlank(target3Name.getText()) && textValidate(target3Name.getText())) {
                target3Name.pseudoClassStateChanged(errorClass, false);
            } else {
                target3Name.pseudoClassStateChanged(errorClass, true);
            }
        });
        target3Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget3Well(target3Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target3Well.getText()) && wellValidate(target3Well.getText())) {
                target3Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target3Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target3Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget3Volume(target3Volume.getText());
            if (!StringUtils.isBlank(target3Volume.getText()) && numberValidate(target3Volume.getText())) {
                target3Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target3Volume.pseudoClassStateChanged(errorClass, true);
            }
        });
        target4Name.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget4Name(target4Name.getText());
            if (!StringUtils.isBlank(target4Name.getText()) && textValidate(target4Name.getText())) {
                target4Name.pseudoClassStateChanged(errorClass, false);
            } else {
                target4Name.pseudoClassStateChanged(errorClass, true);
            }
        });
        target4Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget4Well(target4Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target4Well.getText()) && wellValidate(target4Well.getText())) {
                target4Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target4Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target4Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget4Volume(target4Volume.getText());
            if (!StringUtils.isBlank(target4Volume.getText()) && numberValidate(target4Volume.getText())) {
                target4Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target4Volume.pseudoClassStateChanged(errorClass, true);
            }
        });
        target5Name.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget5Name(target5Name.getText());
            if (!StringUtils.isBlank(target5Name.getText()) && textValidate(target5Name.getText())) {
                target5Name.pseudoClassStateChanged(errorClass, false);
            } else {
                target5Name.pseudoClassStateChanged(errorClass, true);
            }
        });
        target5Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget5Well(target5Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target5Well.getText()) && wellValidate(target5Well.getText())) {
                target5Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target5Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target5Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget5Volume(target5Volume.getText());
            if (!StringUtils.isBlank(target5Volume.getText()) && numberValidate(target5Volume.getText())) {
                target5Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target5Volume.pseudoClassStateChanged(errorClass, true);
            }
        });
        target6Name.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget6Name(target6Name.getText());
            if (!StringUtils.isBlank(target6Name.getText()) && textValidate(target6Name.getText())) {
                target6Name.pseudoClassStateChanged(errorClass, false);
            } else {
                target6Name.pseudoClassStateChanged(errorClass, true);
            }
        });
        target6Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget6Well(target6Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target6Well.getText()) && wellValidate(target6Well.getText())) {
                target6Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target6Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target6Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget6Volume(target6Volume.getText());
            if (!StringUtils.isBlank(target6Volume.getText()) && numberValidate(target6Volume.getText())) {
                target6Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target6Volume.pseudoClassStateChanged(errorClass, true);
            }
        });
        target7Name.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget7Name(target7Name.getText());
            if (!StringUtils.isBlank(target7Name.getText()) && textValidate(target7Name.getText())) {
                target7Name.pseudoClassStateChanged(errorClass, false);
            } else {
                target7Name.pseudoClassStateChanged(errorClass, true);
            }
        });
        target7Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget7Well(target7Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target7Well.getText()) && wellValidate(target7Well.getText())) {
                target7Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target7Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target7Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget7Volume(target7Volume.getText());
            if (!StringUtils.isBlank(target7Volume.getText()) && numberValidate(target7Volume.getText())) {
                target7Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target7Volume.pseudoClassStateChanged(errorClass, true);
            }
        });
        target8Name.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget8Name(target8Name.getText());
            if (!StringUtils.isBlank(target8Name.getText()) && textValidate(target8Name.getText())) {
                target8Name.pseudoClassStateChanged(errorClass, false);
            } else {
                target8Name.pseudoClassStateChanged(errorClass, true);
            }
        });
        target8Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget8Well(target8Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target8Well.getText()) && wellValidate(target8Well.getText())) {
                target8Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target8Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target8Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget8Volume(target8Volume.getText());
            if (!StringUtils.isBlank(target8Volume.getText()) && numberValidate(target8Volume.getText())) {
                target8Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target8Volume.pseudoClassStateChanged(errorClass, true);
            }
        });
        target9Name.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget9Name(target9Name.getText());
            if (!StringUtils.isBlank(target9Name.getText()) && textValidate(target9Name.getText())) {
                target9Name.pseudoClassStateChanged(errorClass, false);
            } else {
                target9Name.pseudoClassStateChanged(errorClass, true);
            }
        });
        target9Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget9Well(target9Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target9Well.getText()) && wellValidate(target9Well.getText())) {
                target9Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target9Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target9Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget9Volume(target9Volume.getText());
            if (!StringUtils.isBlank(target9Volume.getText()) && numberValidate(target9Volume.getText())) {
                target9Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target9Volume.pseudoClassStateChanged(errorClass, true);
            }
        });
        target10Name.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget10Name(target10Name.getText());
            if (!StringUtils.isBlank(target10Name.getText()) && textValidate(target10Name.getText())) {
                target10Name.pseudoClassStateChanged(errorClass, false);
            } else {
                target10Name.pseudoClassStateChanged(errorClass, true);
            }
        });
        target10Well.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget10Well(target10Well.getText().toUpperCase());
            if (!StringUtils.isBlank(target10Well.getText()) && wellValidate(target10Well.getText())) {
                target10Well.pseudoClassStateChanged(errorClass, false);
            } else {
                target10Well.pseudoClassStateChanged(errorClass, true);
            }
        });
        target10Volume.textProperty().addListener((observable, oldValue, newValue) -> {
            ddPCR_OptionsDataCollector.setTarget10Volume(target10Volume.getText());
            if (!StringUtils.isBlank(target10Volume.getText()) && numberValidate(target10Volume.getText())) {
                target10Volume.pseudoClassStateChanged(errorClass, false);
            } else {
                target10Volume.pseudoClassStateChanged(errorClass, true);
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

        sampleSlot.setOnEditCommit(new EventHandler<CellEditEvent<ddPCR_OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<ddPCR_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleSlot(t.getNewValue());
            }
        });

        sampleWell.setOnEditCommit(new EventHandler<CellEditEvent<ddPCR_OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<ddPCR_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleWell(t.getNewValue());
            }
        });
        sampleName.setOnEditCommit(new EventHandler<CellEditEvent<ddPCR_OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<ddPCR_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleName(t.getNewValue());
            }
        });
        sampleConcentration.setOnEditCommit(new EventHandler<CellEditEvent<ddPCR_OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<ddPCR_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleConcentration(t.getNewValue());
            }
        });
        sampleTargets.setOnEditCommit(new EventHandler<CellEditEvent<ddPCR_OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<ddPCR_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleTargets(t.getNewValue());
            }
        });
        sampleReplicates.setOnEditCommit(new EventHandler<CellEditEvent<ddPCR_OptionsDataCollector, String>>() {
            @Override
            public void handle(CellEditEvent<ddPCR_OptionsDataCollector, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSampleReplicates(t.getNewValue());
            }
        });

        addSampleInformationButton.setOnAction(_ -> {
            sampleData.add(new ddPCR_OptionsDataCollector(
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
            ddPCR_OptionsDataCollector.processSampleData(sampleTable);
        });

        deleteSampleRowButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                var selectedRow = sampleTable.getSelectionModel().getSelectedItem();
                if (selectedRow != null) {
                    sampleData.remove(selectedRow);
                }
                ddPCR_OptionsDataCollector.processSampleData(sampleTable);
            }
        });

        sampleTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("Sample Table Listeners: ");
            ddPCR_OptionsDataCollector.processSampleData(sampleTable);
        });
    }
}
