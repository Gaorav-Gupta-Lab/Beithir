/**
 * Data collector for Beithir views
 * Package loosely based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.5.0
 */

package gupta_lab.beithir.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OptionsDataCollector {
    private static String versionNumber;
    private static String runModule;
    private static String userName;
    private static String runDate;
    private static String LeftPipetteFirstTip;
    private static String RightPipetteFirstTip;
    private static String BottomOffset;
    private static CheckBox useTemperatureModule = new CheckBox();
    private static String setTemperature;
    private static String pcrPlateSlot;
    private static String dilutionPlateSlot;
    private static String reagentSlot;
    private static String waterReservoirWell;
    private static String waterResVol;
    private static String pcrVolume;
    private static String masterMixPerRxn;
    private static String dnaPerWell;
    private static String Slot1;
    private static String Slot2;
    private static String Slot3;
    private static String Slot4;
    private static String Slot5;
    private static String Slot6;
    private static String Slot7;
    private static String Slot8;
    private static String Slot9;
    private static String Slot10;
    private static String Slot11;
    private static String target1Name;
    private static String target2Name;
    private static String target3Name;
    private static String target4Name;
    private static String target5Name;
    private static String target6Name;
    private static String target7Name;
    private static String target8Name;
    private static String target9Name;
    private static String target10Name;
    private final SimpleStringProperty sampleSlot;
    private final SimpleStringProperty sampleWell;
    private final SimpleStringProperty sampleName;
    private final SimpleStringProperty sampleConcentration;
    private final SimpleStringProperty sampleTargets;
    private final SimpleStringProperty sampleReplicates;

    public OptionsDataCollector(
            String sampleSlotName, String sampleWellName, String sampleNameString, String sampleConcentrationValue,
            String sampleTargetsName, String sampleReplicatesValue) {
        this.sampleSlot = new SimpleStringProperty(sampleSlotName);
        this.sampleWell = new SimpleStringProperty(sampleWellName);
        this.sampleName = new SimpleStringProperty(sampleNameString);
        this.sampleConcentration = new SimpleStringProperty(sampleConcentrationValue);
        this.sampleTargets = new SimpleStringProperty(sampleTargetsName);
        this.sampleReplicates = new SimpleStringProperty(sampleReplicatesValue);
    }

    public String getSampleSlot() {return sampleSlot.get();}
    public void setSampleSlot(String sampleSlotName) {sampleSlot.set(sampleSlotName);}
    public String getSampleWell() {return sampleWell.get();}
    public void setSampleWell(String sampleWellName) {sampleWell.set(sampleWellName);}
    public String getSampleName() {return sampleName.get();}
    public void setSampleName(String sampleNameString) {sampleName.set(sampleNameString);}
    public String getSampleConcentration() {return sampleConcentration.get();}
    public void setSampleConcentration(String sampleConcentrationValue) {sampleConcentration.set(sampleConcentrationValue);}
    public String getSampleTargets() {return sampleTargets.get();}
    public void setSampleTargets(String sampleTargetsName) {sampleTargets.set(sampleTargetsName);}
    public String getSampleReplicates() {return sampleReplicates.get();}
    public void setSampleReplicates(String sampleReplicatesValue) {sampleReplicates.set(sampleReplicatesValue);}

    private static final StringBuilder returnString = new StringBuilder();
    private static final StringBuilder sampleData = new StringBuilder();

    public static void processSampleData(TableView<OptionsDataCollector> sampleTable) {
        sampleData.delete(0, sampleData.length());
        for (int i = 0; i < sampleTable.getItems().size(); i++) {
            //System.out.println("Sample Name: " + sampleTable.getItems().get(i).getSampleName());
            String sampleSlotName = sampleTable.getItems().get(i).getSampleSlot();
            String sampleWellName = sampleTable.getItems().get(i).getSampleWell();
            String sampleNameString = sampleTable.getItems().get(i).getSampleName();
            String sampleConcentrationValue = sampleTable.getItems().get(i).getSampleConcentration();
            String sampleTargetsName = sampleTable.getItems().get(i).getSampleTargets();
            String sampleReplicatesValue = sampleTable.getItems().get(i).getSampleReplicates();

            sampleData.append(sampleSlotName).append("\t").append(sampleWellName).append("\t").append(sampleNameString).
                    append("\t").append(sampleConcentrationValue).append("\t").append(sampleTargetsName).append("\t").
                    append(sampleReplicatesValue).append("\n");
        }
    }
    public static String fileName(){
        return runModule;
    }
    public static String generateOptionsFile() {
        returnString.append(runModule).append(getVersionNumber()).append("#Run Date:\t").append(runDate).append("\n").
                append("--User\t").append(getUserName()).append("\n").

                append("\n#Deck Layout\n").
                append("--Slot1\t").append(getSlot1()).
                append("--Slot2\t").append(getSlot2()).
                append("--Slot3\t").append(getSlot3()).
                append("--Slot4\t").append(getSlot4()).
                append("--Slot5\t").append(getSlot5()).
                append("--Slot6\t").append(getSlot6()).
                append("--Slot7\t").append(getSlot7()).
                append("--Slot8\t").append(getSlot8()).
                append("--Slot9\t").append(getSlot9()).
                append("--Slot10\t").append(getSlot10()).
                append("--Slot11\t").append(getSlot11()).

                append("\nLocation of the first tip in pipette tip boxes and bottom offset value for tips\n").
                append("--LeftPipetteFirstTip\t").append(getLeftPipetteFirstTip()).
                append("--RightPipetteFirstTip\t").append(getRightPipetteFirstTip()).
                append("--BottomOffset\t").append(getBottomOffset()).
                append("\nTemperature Module Settings\n").
                append("--UseTemperatureModule\t").append(getUseTemperatureModule().isSelected() ? "True\n" : "False\n").
                append("--Temperature\t").append(getSetTemperature()).

                append("\nLocation of Reagents and Volumes\n").
                append("--PCR_PlateSlot\t").append(getPCR_PlateSlot()).
                append("--DilutionPlateSlot\t").append(getDilutionPlateSlot()).
                append("--ReagentSlot\t").append(getReagentSlot()).
                append("--WaterResWell\t").append(getWaterReservoirWell()).
                append("--WaterResVol\t").append(getWaterResVol()).
                append("--PCR_Volume\t").append(getPCR_Volume()).
                append("--MasterMixPerRxn\t").append(getMasterMixPerRxn()).
                append("--DNA_in_Reaction\t").append(getDNAPerWell()).

                append("\n#Targets\n").
                append("--Target1\t").append(getTarget1Name()).
                append("--Target2\t").append(getTarget2Name()).
                append("--Target3\t").append(getTarget3Name()).
                append("--Target4\t").append(getTarget4Name()).
                append("--Target5\t").append(getTarget5Name()).
                append("--Target6\t").append(getTarget6Name()).
                append("--Target7\t").append(getTarget7Name()).
                append("--Target8\t").append(getTarget8Name()).
                append("--Target9\t").append(getTarget9Name()).
                append("--Target10\t").append(getTarget10Name()).

                append("\n#Samples\n").
                append(sampleData);

        return returnString.toString();
    }
    public static String getVersionNumber(){return versionNumber+"\n\n";}
    public static void setVersionString(String versionNumber){OptionsDataCollector.versionNumber = versionNumber;}

    public static void setRunModule(String runModule) {OptionsDataCollector.runModule = runModule;}

    private static String getUserName() {return userName;}
    public static void setUserName(String userName) {OptionsDataCollector.userName = userName;}

    public static void getRunDate(String runDate) {OptionsDataCollector.runDate = formatRunDate(runDate);}
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
    public static String formatRunDate(String runDate) {
        return LocalDate.parse(runDate, DateTimeFormatter.ISO_DATE).format(dateFormatter);
    }

    private static String getLeftPipetteFirstTip() {return LeftPipetteFirstTip+"\n"; }
    public static void setLeftPipetteFirstTip(String leftPipetteFirstTip) {OptionsDataCollector.LeftPipetteFirstTip = leftPipetteFirstTip;}

    private static String getRightPipetteFirstTip() {return RightPipetteFirstTip+"\n"; }
    public static void setRightPipetteFirstTip(String RightPipetteFirstTip) {OptionsDataCollector.RightPipetteFirstTip = RightPipetteFirstTip;}

    private static String getBottomOffset() {return BottomOffset+"\n";}
    public static void setBottomOffset(String bottomOffset) {OptionsDataCollector.BottomOffset = bottomOffset;}

    private static String getSetTemperature() {if(setTemperature == null){return "\n";}else{return setTemperature+"\n";}}
    public static void setSetTemperature(String setTemperature) {OptionsDataCollector.setTemperature = setTemperature;}

    private static CheckBox getUseTemperatureModule(){return useTemperatureModule;}
    public static void setUseTemperatureModule(CheckBox useTemperatureModule){OptionsDataCollector.useTemperatureModule = useTemperatureModule;}

    private static String getPCR_PlateSlot(){return pcrPlateSlot+"\n";}
    public static void setPCR_PlateSlot(String pcrPlateSlot){OptionsDataCollector.pcrPlateSlot = pcrPlateSlot;}

    private static String getDilutionPlateSlot(){return dilutionPlateSlot+"\n";}
    public static void setDilutionPlateSlot(String dilutionPlateSlot){OptionsDataCollector.dilutionPlateSlot = dilutionPlateSlot;}

    private static String getReagentSlot(){return reagentSlot+"\n";}
    public static void setReagentSlot(String reagentSlot){OptionsDataCollector.reagentSlot = reagentSlot;}

    private static String getWaterReservoirWell(){return waterReservoirWell+"\n";}
    public static void setWaterReservoirWell(String waterReservoirWell){OptionsDataCollector.waterReservoirWell = waterReservoirWell;}

    private static String getWaterResVol(){return waterResVol+"\n";}
    public static void setWaterResVol(String waterResVol){OptionsDataCollector.waterResVol = waterResVol;}

    private static String getPCR_Volume(){return pcrVolume+"\n";}
    public static void setPCR_Volume(String pcrVolume){OptionsDataCollector.pcrVolume = pcrVolume;}

    private static String getMasterMixPerRxn(){return masterMixPerRxn+"\n";}
    public static void setMasterMixPerRxn(String masterMixPerRxn){OptionsDataCollector.masterMixPerRxn = masterMixPerRxn;}

    private static String getDNAPerWell(){return dnaPerWell+"\n";}
    public static void setDNAPerWell(String dnaPerWell){OptionsDataCollector.dnaPerWell = dnaPerWell;}

    public static String getSlot1() {if(Slot1 == null){return "\n";}else{return Slot1+"\n";}}
    public static void setSlot1(String Slot1) {OptionsDataCollector.Slot1 = Slot1;}
    public static String getSlot2() {if(Slot2 == null){return "\n";}else{return Slot2+"\n";}}
    public static void setSlot2(String Slot2) {OptionsDataCollector.Slot2 = Slot2;}
    public static String getSlot3() {if(Slot3 == null){return "\n";}else{return Slot3+"\n";}}
    public static void setSlot3(String Slot3) {OptionsDataCollector.Slot3 = Slot3;}
    public static String getSlot4() {if(Slot4 == null){return "\n";}else{return Slot4+"\n";}}
    public static void setSlot4(String Slot4) {OptionsDataCollector.Slot4 = Slot4;}
    public static String getSlot5() {if(Slot5 == null){return "\n";}else{return Slot5+"\n";}}
    public static void setSlot5(String Slot5) {OptionsDataCollector.Slot5 = Slot5;}
    public static String getSlot6() {if(Slot6 == null){return "\n";}else{return Slot6+"\n";}}
    public static void setSlot6(String Slot6) {OptionsDataCollector.Slot6 = Slot6;}
    public static String getSlot7() {if(Slot7 == null){return "\n";}else{return Slot7+"\n";}}
    public static void setSlot7(String Slot7) {OptionsDataCollector.Slot7 = Slot7;}
    public static String getSlot8() {if(Slot8 == null){return "\n";}else{return Slot8+"\n";}}
    public static void setSlot8(String Slot8) {OptionsDataCollector.Slot8 = Slot8;}
    public static String getSlot9() {if(Slot9 == null){return "\n";}else{return Slot9+"\n";}}
    public static void setSlot9(String Slot9) {OptionsDataCollector.Slot9 = Slot9;}
    public static String getSlot10() {if(Slot10 == null){return "\n";}else{return Slot10+"\n";}}
    public static void setSlot10(String Slot10) {OptionsDataCollector.Slot10 = Slot10;}
    public static String getSlot11() {if(Slot11 == null){return "\n";}else{return Slot11+"\n";}}
    public static void setSlot11(String Slot11) {OptionsDataCollector.Slot11 = Slot11;}

    private static String getTarget1Name() {if(target1Name == null){return "\n";}else{return target1Name+"\n";}}
    public static void setTarget1Name(String target1Name) {OptionsDataCollector.target1Name = target1Name;}
    private static String getTarget2Name() {if(target2Name == null){return "\n";}else{return target2Name+"\n";}}
    public static void setTarget2Name(String target2Name) {OptionsDataCollector.target2Name = target2Name;}
    private static String getTarget3Name() {if(target3Name == null){return "\n";}else{return target3Name+"\n";}}
    public static void setTarget3Name(String target3Name) {OptionsDataCollector.target3Name = target3Name;}
    private static String getTarget4Name() {if(target4Name == null){return "\n";}else{return target4Name+"\n";}}
    public static void setTarget4Name(String target4Name) {OptionsDataCollector.target4Name = target4Name;}
    private static String getTarget5Name() {if(target5Name == null){return "\n";}else{return target5Name+"\n";}}
    public static void setTarget5Name(String target5Name) {OptionsDataCollector.target5Name = target5Name;}
    private static String getTarget6Name() {if(target6Name == null){return "\n";}else{return target6Name+"\n";}}
    public static void setTarget6Name(String target6Name) {OptionsDataCollector.target6Name = target6Name;}
    private static String getTarget7Name() {if(target7Name == null){return "\n";}else{return target7Name+"\n";}}
    public static void setTarget7Name(String target7Name) {OptionsDataCollector.target7Name = target7Name;}
    public static String getTarget8Name() {if(target8Name == null){return "\n";}else{return target8Name+"\n";}}
    public static void setTarget8Name(String target8Name) {OptionsDataCollector.target8Name = target8Name;}
    public static String getTarget9Name() {if(target9Name == null){return "\n";}else{return target9Name+"\n";}}
    public static void setTarget9Name(String target9Name) {OptionsDataCollector.target9Name = target9Name;}
    public static String getTarget10Name() {if(target10Name == null){return "\n";}else{return target10Name+"\n";}}
    public static void setTarget10Name(String target10Name) {OptionsDataCollector.target10Name = target10Name;}
}