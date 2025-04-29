/**
 * Data collector for Beithir views
 * Package loosely based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since April 2025
 * @version 0.8.0
 */

package gupta_lab.beithir.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableView;

public class illumina_Dual_Indexing_OptionsDataCollector {
    private static String versionNumber;
    private static String runModule;
    public static String errorClass;
    private static String indexPrimerSlot;
    private static String primerD501;
    private static String primerD502;
    private static String primerD503;
    private static String primerD504;
    private static String primerD505;
    private static String primerD506;
    private static String primerD507;
    private static String primerD508;
    private static String primerD701;
    private static String primerD702;
    private static String primerD703;
    private static String primerD704;
    private static String primerD705;
    private static String primerD706;
    private static String primerD707;
    private static String primerD708;
    private static String primerD709;
    private static String primerD710a;
    private static String primerD711;
    private static String primerD712;


    private final SimpleStringProperty sampleSlot;
    private final SimpleStringProperty sampleWell;
    private final SimpleStringProperty sampleName;
    private final SimpleStringProperty sampleConcentration;
    private final SimpleStringProperty sampleTargets;
    private final SimpleStringProperty sampleReplicates;

    public illumina_Dual_Indexing_OptionsDataCollector(
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

    public static String fileName(){return "Illumina Dual Indexing Parameters";}

    public static void processSampleData(TableView<illumina_Dual_Indexing_OptionsDataCollector> sampleTable) {
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

    public static String generateOptionsFile() {
        returnString.append(runModule).append(getVersionNumber()).append("#Run Date:\t").append(commonDataCollector.runDate).append("\n").
                append("--User\t").append(commonDataCollector.getUserName()).append("\n").
                append("\n# Deck Layout\n").
                append("--Slot1\t").append(commonDataCollector.getSlot1()).
                append("--Slot2\t").append(commonDataCollector.getSlot2()).
                append("--Slot3\t").append(commonDataCollector.getSlot3()).
                append("--Slot4\t").append(commonDataCollector.getSlot4()).
                append("--Slot5\t").append(commonDataCollector.getSlot5()).
                append("--Slot6\t").append(commonDataCollector.getSlot6()).
                append("--Slot7\t").append(commonDataCollector.getSlot7()).
                append("--Slot8\t").append(commonDataCollector.getSlot8()).
                append("--Slot9\t").append(commonDataCollector.getSlot9()).
                append("--Slot10\t").append(commonDataCollector.getSlot10()).
                append("--Slot11\t").append(commonDataCollector.getSlot11()).

                append("\n# Location of the first tip in pipette tip boxes and bottom offset value for tips\n").
                append("--LeftPipetteFirstTip\t").append(commonDataCollector.getLeftPipetteFirstTip()).
                append("--RightPipetteFirstTip\t").append(commonDataCollector.getRightPipetteFirstTip()).
                append("--BottomOffset\t").append(commonDataCollector.getBottomOffset()).
                append("\n# Temperature Module Settings\n").
                append("--UseTemperatureModule\t").append(commonDataCollector.getUseTemperatureModule().isSelected() ? "True\n" : "False\n").
                append("--Temperature\t").append(commonDataCollector.getSetTemperature()).

                append("\n# Location of Reagents and Volumes\n").
                append("--PCR_PlateSlot\t").append(commonDataCollector.getPCR_PlateSlot()).
                append("--DilutionPlateSlot\t").append(commonDataCollector.getDilutionPlateSlot()).
                append("--ReagentSlot\t").append(commonDataCollector.getReagentSlot()).
                append("--WaterResWell\t").append(commonDataCollector.getWaterReservoirWell()).
                append("--WaterResVol\t").append(commonDataCollector.getWaterResVol()).
                append("--PCR_Volume\t").append(commonDataCollector.getPCR_Volume()).
                append("--MasterMixPerRxn\t").append(commonDataCollector.getMasterMixPerRxn()).
                append("--DNA_in_Reaction\t").append(commonDataCollector.getDNAPerWell()).

                append("\n# Indexing Primers\n").
                append("--IndexPrimerSlot\t").append(getIndexPrimerSlot()).
                append("--D501\t").append(getPrimerD501()).
                append("--D502\t").append(getPrimerD502()).
                append("--D503\t").append(getPrimerD503()).
                append("--D504\t").append(getPrimerD504()).
                append("--D505\t").append(getPrimerD505()).
                append("--D506\t").append(getPrimerD506()).
                append("--D507\t").append(getPrimerD507()).
                append("--D508\t").append(getPrimerD508()).
                append("--D701\t").append(getPrimerD701()).
                append("--D702\t").append(getPrimerD702()).
                append("--D703\t").append(getPrimerD703()).
                append("--D704\t").append(getPrimerD704()).
                append("--D705\t").append(getPrimerD705()).
                append("--D706\t").append(getPrimerD706()).
                append("--D707\t").append(getPrimerD707()).
                append("--D708\t").append(getPrimerD708()).
                append("--D709\t").append(getPrimerD709()).
                append("--D710a\t").append(getPrimerD710a()).
                append("--D711\t").append(getPrimerD711()).
                append("--D712\t").append(getPrimerD712()).

                append("\n# Samples\n").
                append(sampleData);
        // System.out.println("User Name: " + commonDataCollector.userName + "\nModule: " + runModule + "\nLeft Tip: " + commonDataCollector.getLeftPipetteFirstTip());
        return returnString.toString();
    }

    private static String getErrorClass() {return errorClass;}
    public static void setErrorClass(String errorClass){illumina_Dual_Indexing_OptionsDataCollector.errorClass = errorClass;}

    public static String getVersionNumber(){return versionNumber+"\n\n";}
    public static void setVersionString(String versionNumber){illumina_Dual_Indexing_OptionsDataCollector.versionNumber = versionNumber;}

    public static void setRunModule(String runModule) {
        illumina_Dual_Indexing_OptionsDataCollector.runModule = runModule;}

    public static String getIndexPrimerSlot() {return indexPrimerSlot+"\n";}
    public static void setIndexPrimerSlot(String indexPrimerSlot){illumina_Dual_Indexing_OptionsDataCollector.indexPrimerSlot = indexPrimerSlot;}

    public static String getPrimerD501() {return primerD501+"\n";}
    public static void setPrimerD501(String indexPrimerSlot){illumina_Dual_Indexing_OptionsDataCollector.primerD501 = primerD501;}

    public static String getPrimerD502() {return primerD502+"\n";}
    public static void setPrimerD502(String indexPrimerSlot){illumina_Dual_Indexing_OptionsDataCollector.primerD502 = primerD502;}

    public static void setPrimerD503(String primerD503) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD503 = primerD503;
    }
    public static String getPrimerD503() {return primerD503+"\n";}
    public static void setPrimerD504(String primerD504) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD504 = primerD504;
    }
    public static String getPrimerD504() {return primerD504+"\n";}
    public static void setPrimerD505(String primerD505) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD505 = primerD505;
    }
    public static String getPrimerD505() {return primerD505+"\n";}
    public static void setPrimerD506(String primerD506) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD506 = primerD506;
    }
    public static String getPrimerD506() {return primerD506+"\n";}
    public static void setPrimerD507(String primerD507) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD507 = primerD507;
    }
    public static String getPrimerD507() {return primerD507+"\n";}

    public static void setPrimerD508(String primerD508) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD508 = primerD508;
    }
    public static String getPrimerD508() {return primerD508+"\n";}
    public static void setPrimerD701(String primerD701) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD701 = primerD701;
    }
    public static String getPrimerD701() {return primerD701+"\n";}
    public static void setPrimerD702(String primerD702) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD702 = primerD702;
    }
    public static String getPrimerD702() {return primerD702+"\n";}
    public static void setPrimerD703(String primerD703) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD703 = primerD703;
    }
    public static String getPrimerD703() {return primerD703+"\n";}
    public static void setPrimerD704(String primerD704) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD704 = primerD704;
    }
    public static String getPrimerD704() {return primerD704+"\n";}
    public static void setPrimerD705(String primerD705) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD705 = primerD705;
    }
    public static String getPrimerD705() {return primerD705+"\n";}
    public static void setPrimerD706(String primerD706) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD706 = primerD706;
    }
    public static String getPrimerD706() {return primerD706+"\n";}
    public static void setPrimerD707(String primerD707) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD707 = primerD707;
    }
    public static String getPrimerD707() {return primerD707+"\n";}
    public static void setPrimerD708(String primerD708) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD708 = primerD708;
    }
    public static String getPrimerD708() {return primerD708+"\n";}
    public static void setPrimerD709(String primerD709) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD709 = primerD709;
    }
    public static String getPrimerD709() {return primerD709+"\n";}
    public static void setPrimerD710a(String primerD710a) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD710a = primerD710a;
    }
    public static String getPrimerD710a() {return primerD710a+"\n";}
    public static void setPrimerD711(String primerD711) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD711 = primerD711;
    }
    public static String getPrimerD711() {return primerD711+"\n";}
    public static void setPrimerD712(String primerD712) {
        illumina_Dual_Indexing_OptionsDataCollector.primerD712 = primerD712;
    }
    public static String getPrimerD712() {return primerD712+"\n";}
}
