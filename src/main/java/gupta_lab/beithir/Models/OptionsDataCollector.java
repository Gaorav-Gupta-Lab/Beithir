/**
 * Data collector for Beithir views
 * Package based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.1.1
 */

package gupta_lab.beithir.Models;

import javafx.scene.control.CheckBox;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OptionsDataCollector {

    private static String runModule;
    private static String userName;
    private static String LeftPipetteFirstTip;
    private static String RightPipetteFirstTip;
    private static String BottomOffset;
    private static String setTemperature;
    private static String runDate;
    private static CheckBox useTemperatureModule = new CheckBox();
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


    private static CheckBox excludeChrY = new CheckBox();
    private static CheckBox writeMapFile = new CheckBox();

    private static final StringBuilder returnString = new StringBuilder();

    public static String generateOptionsFile() throws IOException{

        returnString.append(runModule + "\n\n" + "#Run Date:\t" + runDate + "\n" +
                "--User\t" + getUserName() + "\n" +
                "--LeftPipetteFirstTip\t" + getLeftPipetteFirstTip() + "\n" +
                "--RightPipetteFirstTip\t" + getRightPipetteFirstTip() + "\n" +
                "--BottomOffset\t" + getBottomOffset() + "\n" +
                "--UseTemperatureModule\t" + (getUseTemperatureModule().isSelected() ? "True\n" : "False\n") +
                "--Temperature\t" + getsetTemperature() + "\n" +
                "--Slot1\t" + getSlot1() + "\n" + "--Slot2\t" + getSlot2() + "\n" + "--Slot3\t" + getSlot3() + "\n" +
                "--Slot4\t" + getSlot4() + "\n" + "--Slot5\t" + getSlot5() + "\n" + "--Slot6\t" +getSlot6() + "\n" +
                "--Slot7\t" + getSlot7() + "\n" + "--Slot8\t" + getSlot8() + "\n" + "--Slot9\t" +getSlot9() + "\n" +
                "--Slot10\t" + getSlot10() + "\n" + "--Slot11\t" + getSlot11() + "\n" +
                "--Target1\t" + getTarget1Name() + "\n" + "--Target2\t" + getTarget2Name() + "\n" + "--Target3\t" + getTarget3Name() + "\n" +
                "--Target4\t" + getTarget4Name() + "\n"
        );

        return returnString.toString();
    }

    private static String getUserName() {return userName;}
    public static void setUserName(String userName) {OptionsDataCollector.userName = userName;}

    public static void setRunModule(String runModule) {OptionsDataCollector.runModule = runModule;}

    public static void getRunDate(String runDate) {OptionsDataCollector.runDate = formatRunDate(runDate);}
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
    public static String formatRunDate(String runDate) {
        return LocalDate.parse(runDate, DateTimeFormatter.ISO_DATE).format(dateFormatter);
    }

    private static String getLeftPipetteFirstTip() {return LeftPipetteFirstTip;}
    public static void setLeftPipetteFirstTip(String leftPipetteFirstTip) {OptionsDataCollector.LeftPipetteFirstTip = leftPipetteFirstTip;}

    private static String getRightPipetteFirstTip() {return RightPipetteFirstTip;}
    public static void setRightPipetteFirstTip(String RightPipetteFirstTip) {OptionsDataCollector.RightPipetteFirstTip = RightPipetteFirstTip;}

    private static String getBottomOffset() {return BottomOffset;}
    public static void setBottomOffset(String bottomOffset) {OptionsDataCollector.BottomOffset = bottomOffset;}

    private static String getsetTemperature() {if(setTemperature == null){return "";}else{return setTemperature;}}
    public static void setsetTemperature(String setTemperature) {OptionsDataCollector.setTemperature = setTemperature;}

    private static CheckBox getUseTemperatureModule(){return useTemperatureModule;}
    public static void setUseTemperatureModule(CheckBox useTemperatureModule){OptionsDataCollector.useTemperatureModule = useTemperatureModule;}

    public static String getSlot1() {if(Slot1 == null){return "";}else{return Slot1;}}
    public static void setSlot1(String Slot1) {OptionsDataCollector.Slot1 = Slot1;}

    public static String getSlot2() {if(Slot2 == null){return "";}else{return Slot2;}}
    public static void setSlot2(String Slot2) {OptionsDataCollector.Slot2 = Slot2;}

    public static String getSlot3() {if(Slot3 == null){return "";}else{return Slot3;}}
    public static void setSlot3(String Slot3) {OptionsDataCollector.Slot3 = Slot3;}

    public static String getSlot4() {if(Slot4 == null){return "";}else{return Slot4;}}
    public static void setSlot4(String Slot4) {OptionsDataCollector.Slot4 = Slot4;}

    public static String getSlot5() {if(Slot5 == null){return "";}else{return Slot5;}}
    public static void setSlot5(String Slot5) {OptionsDataCollector.Slot5 = Slot5;}

    public static String getSlot6() {if(Slot6 == null){return "";}else{return Slot6;}}
    public static void setSlot6(String Slot6) {OptionsDataCollector.Slot6 = Slot6;}

    public static String getSlot7() {if(Slot7 == null){return "";}else{return Slot7;}}
    public static void setSlot7(String Slot7) {OptionsDataCollector.Slot7 = Slot7;}

    public static String getSlot8() {if(Slot8 == null){return "";}else{return Slot8;}}
    public static void setSlot8(String Slot8) {OptionsDataCollector.Slot8 = Slot8;}

    public static String getSlot9() {if(Slot9 == null){return "";}else{return Slot9;}}
    public static void setSlot9(String Slot9) {OptionsDataCollector.Slot9 = Slot9;}

    public static String getSlot10() {if(Slot10 == null){return "";}else{return Slot10;}}
    public static void setSlot10(String Slot10) {OptionsDataCollector.Slot10 = Slot10;}

    public static String getSlot11() {if(Slot11 == null){return "";}else{return Slot11;}}
    public static void setSlot11(String Slot11) {OptionsDataCollector.Slot11 = Slot11;}

    private static String getTarget1Name() {if(target1Name == null){return "";}else{return target1Name;}}
    public static void setTarget1Name(String target1Name) {OptionsDataCollector.target1Name = target1Name;}

    private static String getTarget2Name() {if(target2Name == null){return "";}else{return target2Name;}}
    public static void setTarget2Name(String target2Name) {OptionsDataCollector.target2Name = target2Name;}

    private static String getTarget3Name() {if(target3Name == null){return "";}else{return target3Name;}}
    public static void setTarget3Name(String target3Name) {OptionsDataCollector.target3Name = target3Name;}

    private static String getTarget4Name() {if(target4Name == null){return "";}else{return target4Name;}}
    public static void setTarget4Name(String target4Name) {OptionsDataCollector.target4Name = target4Name;}

    private static CheckBox getExcludeChrY() {return excludeChrY;}
    public static void setExcludeChrY(CheckBox excludeChrY) {OptionsDataCollector.excludeChrY = excludeChrY;}

    private static CheckBox getWriteMapFile() {
        return writeMapFile;
    }
    public static void setWriteMapFile(CheckBox writeMapFile) {
        OptionsDataCollector.writeMapFile = writeMapFile;
    }

}
