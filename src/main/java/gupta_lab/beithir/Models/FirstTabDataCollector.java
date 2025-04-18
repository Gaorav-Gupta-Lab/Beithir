package gupta_lab.beithir.Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FirstTabDataCollector {
    public static String userName;
    public static String runDate;
    public static String LeftPipetteFirstTip;
    public static String RightPipetteFirstTip;
    public static String pcrPlateSlot;
    public static String dilutionPlateSlot;
    public static String reagentSlot;
    public static String waterReservoirWell;


    public static String getUserName() {return userName;}
    public static void setUserName(String userName) {
        FirstTabDataCollector.userName = userName;}

    public static void getRunDate(String runDate) {
        FirstTabDataCollector.runDate = formatRunDate(runDate);}
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
    public static String formatRunDate(String runDate) {
        return LocalDate.parse(runDate, DateTimeFormatter.ISO_DATE).format(dateFormatter);
    }
    public static String getLeftPipetteFirstTip() {return LeftPipetteFirstTip+"\n"; }
    public static void setLeftPipetteFirstTip(String leftPipetteFirstTip) {
        FirstTabDataCollector.LeftPipetteFirstTip = leftPipetteFirstTip;
        System.out.println("\nLeft Tip: " + getLeftPipetteFirstTip());
    }
    public static String getRightPipetteFirstTip() {return RightPipetteFirstTip+"\n"; }
    public static void setRightPipetteFirstTip(String RightPipetteFirstTip) {
        FirstTabDataCollector.RightPipetteFirstTip = RightPipetteFirstTip;}

}
