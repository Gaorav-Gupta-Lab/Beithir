package gupta_lab.beithir.Models;

import javafx.scene.control.CheckBox;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class commonDataCollector {
    public static String userName;
    public static String runDate;
    public static String LeftPipetteFirstTip;
    public static String RightPipetteFirstTip;
    public static String BottomOffset;
    public static CheckBox useTemperatureModule = new CheckBox();
    public static String setTemperature;
    public static String pcrPlateSlot;
    public static String dilutionPlateSlot;
    public static String reagentSlot;
    public static String waterReservoirWell;
    public static String waterResVol;
    public static String pcrVolume;
    public static String masterMixPerRxn;
    public static String dnaPerWell;

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

    public static String getUserName() {return userName;}
    public static void setUserName(String userName) {
        commonDataCollector.userName = userName;}

    public static void getRunDate(String runDate) {
        commonDataCollector.runDate = formatRunDate(runDate);}
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
    public static String formatRunDate(String runDate) {
        return LocalDate.parse(runDate, DateTimeFormatter.ISO_DATE).format(dateFormatter);
    }
    public static String getLeftPipetteFirstTip() {return LeftPipetteFirstTip+"\n"; }
    public static void setLeftPipetteFirstTip(String leftPipetteFirstTip) {
        commonDataCollector.LeftPipetteFirstTip = leftPipetteFirstTip;
    }
    public static String getRightPipetteFirstTip() {return RightPipetteFirstTip+"\n"; }
    public static void setRightPipetteFirstTip(String RightPipetteFirstTip) {
        commonDataCollector.RightPipetteFirstTip = RightPipetteFirstTip;
    }
    public static String getBottomOffset() {return BottomOffset+"\n";}
    public static void setBottomOffset(String bottomOffset) {
        commonDataCollector.BottomOffset = bottomOffset;
    }
    public static CheckBox getUseTemperatureModule(){return useTemperatureModule;}
    public static void setUseTemperatureModule(CheckBox useTemperatureModule){
        commonDataCollector.useTemperatureModule = useTemperatureModule;
    }
    public static String getSetTemperature() {if(setTemperature == null){return "\n";}else{return setTemperature+"\n";}}
    public static void setSetTemperature(String setTemperature) {
        commonDataCollector.setTemperature = setTemperature;
    }
    public static String getPCR_PlateSlot(){return pcrPlateSlot+"\n";}
    public static void setPCR_PlateSlot(String pcrPlateSlot){
        commonDataCollector.pcrPlateSlot = pcrPlateSlot;
    }
    public static String getDilutionPlateSlot(){return dilutionPlateSlot+"\n";}
    public static void setDilutionPlateSlot(String dilutionPlateSlot){
        commonDataCollector.dilutionPlateSlot = dilutionPlateSlot;
    }
    public static String getReagentSlot(){return reagentSlot+"\n";}
    public static void setReagentSlot(String reagentSlot){
        commonDataCollector.reagentSlot = reagentSlot;
    }
    public static String getWaterReservoirWell(){return waterReservoirWell+"\n";}
    public static void setWaterReservoirWell(String waterReservoirWell){
        commonDataCollector.waterReservoirWell = waterReservoirWell;
    }
    public static String getWaterResVol(){return waterResVol+"\n";}
    public static void setWaterResVol(String waterResVol){
        commonDataCollector.waterResVol = waterResVol;
    }
    public static String getPCR_Volume(){return pcrVolume+"\n";}
    public static void setPCR_Volume(String pcrVolume){
        commonDataCollector.pcrVolume = pcrVolume;
    }
    public static String getMasterMixPerRxn(){return masterMixPerRxn+"\n";}
    public static void setMasterMixPerRxn(String masterMixPerRxn){
        commonDataCollector.masterMixPerRxn = masterMixPerRxn;
    }
    public static String getDNAPerWell(){return dnaPerWell+"\n";}
    public static void setDNAPerWell(String dnaPerWell){
        commonDataCollector.dnaPerWell = dnaPerWell;
    }

    public static String getSlot1() {if(Slot1 == null){return "\n";}else{return Slot1+"\n";}}
    public static void setSlot1(String Slot1) {
        commonDataCollector.Slot1 = Slot1;}
    public static String getSlot2() {if(Slot2 == null){return "\n";}else{return Slot2+"\n";}}
    public static void setSlot2(String Slot2) {
        commonDataCollector.Slot2 = Slot2;}
    public static String getSlot3() {if(Slot3 == null){return "\n";}else{return Slot3+"\n";}}
    public static void setSlot3(String Slot3) {
        commonDataCollector.Slot3 = Slot3;}
    public static String getSlot4() {if(Slot4 == null){return "\n";}else{return Slot4+"\n";}}
    public static void setSlot4(String Slot4) {
        commonDataCollector.Slot4 = Slot4;}
    public static String getSlot5() {if(Slot5 == null){return "\n";}else{return Slot5+"\n";}}
    public static void setSlot5(String Slot5) {
        commonDataCollector.Slot5 = Slot5;}
    public static String getSlot6() {if(Slot6 == null){return "\n";}else{return Slot6+"\n";}}
    public static void setSlot6(String Slot6) {
        commonDataCollector.Slot6 = Slot6;}
    public static String getSlot7() {if(Slot7 == null){return "\n";}else{return Slot7+"\n";}}
    public static void setSlot7(String Slot7) {
        commonDataCollector.Slot7 = Slot7;}
    public static String getSlot8() {if(Slot8 == null){return "\n";}else{return Slot8+"\n";}}
    public static void setSlot8(String Slot8) {
        commonDataCollector.Slot8 = Slot8;}
    public static String getSlot9() {if(Slot9 == null){return "\n";}else{return Slot9+"\n";}}
    public static void setSlot9(String Slot9) {
        commonDataCollector.Slot9 = Slot9;}
    public static String getSlot10() {if(Slot10 == null){return "\n";}else{return Slot10+"\n";}}
    public static void setSlot10(String Slot10) {
        commonDataCollector.Slot10 = Slot10;}
    public static String getSlot11() {if(Slot11 == null){return "\n";}else{return Slot11+"\n";}}
    public static void setSlot11(String Slot11) {
        commonDataCollector.Slot11 = Slot11;
    }

}
