package gupta_lab.beithir.Models;

import javafx.scene.control.CheckBox;

import java.io.IOException;

public class OptionsDataCollector {

    private static String runModule;
    private static String userName;

    private static String segmentFile;
    private static String targetFile;
    private static String fastqFile1;
    private static String indexFile;
    private static String cellName;
    private static String spawnJobs;
    private static String indexMisMatch;
    private static String targetMisMatch;
    private static String freqIterations;
    private static String repeatCount;
    private static String bedGroup;
    private static String targetGroupSize;
    private static String progCheck;
    private static String minLength;
    private static String targetLength;
    private static String targetStart;
    private static String targetPadding;
    private static String expectedPosition;
    private static CheckBox excludeChrY = new CheckBox();
    private static CheckBox writeMapFile = new CheckBox();
    private static CheckBox targetPermFile = new CheckBox();
    private static CheckBox segPermFile = new CheckBox();
    private static CheckBox writeBreakPointDistFile = new CheckBox();
    private static CheckBox writeBreakPointChromDistFile = new CheckBox();
    private static CheckBox writeChromPloidyFile = new CheckBox();
    private static CheckBox deleteNewFastq = new CheckBox();
    private static CheckBox revComp = new CheckBox();
    private static CheckBox compressFastq = new CheckBox();

    public OptionsDataCollector(){
        setTargetFile("");
        setFastqFile1("");
        setIndexFile("");
        setSegmentFile("");
        setCellName("");
        setBedGroup("");
        setTargetGroupSize("");
        setMinLength("");
        setTargetLength("");
        setTargetStart("");
        setExpectedPosition("");
        getExcludeChrY().setSelected(false);
        getWriteMapFile().setSelected(false);
        getTargetPermFile().setSelected(false);
        getSegPermFile().setSelected(false);
        getWriteBreakPointDistFile().setSelected(false);
        getWriteBreakPointChromDistFile().setSelected(false);
        getWriteChromPloidyFile().setSelected(false);
        getDeleteNewFastq().setSelected(false);
        getRevComp().setSelected(false);
        getCompressFastq().setSelected(false);
    }

    public static String generateOptionsFile() throws IOException{
        String userName = "--User\t" + getUserName() + "\n";

        return userName;
    }

    private static String getUserName() {return userName;}
    public static void setUserName(String userName) {OptionsDataCollector.userName = userName;}

    private static String getRunModule() {return runModule;}
    public static void setRunModule(String runModule) {OptionsDataCollector.runModule = runModule;}


    private static CheckBox getExcludeChrY() {return excludeChrY;}
    public static void setExcludeChrY(CheckBox excludeChrY) {OptionsDataCollector.excludeChrY = excludeChrY;}

    private static CheckBox getWriteMapFile() {
        return writeMapFile;
    }
    public static void setWriteMapFile(CheckBox writeMapFile) {
        OptionsDataCollector.writeMapFile = writeMapFile;
    }

    private static CheckBox getSegPermFile() {
        return segPermFile;
    }
    public static void setSegPermFile(CheckBox segPermFile) {
        OptionsDataCollector.segPermFile = segPermFile;
    }

    private static String getTargetGroupSize() {return targetGroupSize;}
    public static void setTargetGroupSize(String targetGroupSize) {OptionsDataCollector.targetGroupSize = targetGroupSize;}

    private static CheckBox getTargetPermFile() {return targetPermFile;}
    public static void setTargetPermFile(CheckBox targetPermFile) {OptionsDataCollector.targetPermFile = targetPermFile;}



    private static String getCellName() {return cellName;}
    public static void setCellName(String cellName) {OptionsDataCollector.cellName = cellName;}

    private static String getSegmentFile() {return segmentFile;}
    public static void setSegmentFile(String segmentFile) {OptionsDataCollector.segmentFile = segmentFile;}

    private static String getBedGroup() {return bedGroup;}
    public static void setBedGroup(String bedGroup) {OptionsDataCollector.bedGroup = bedGroup;}

    private static String getSpawnJobs() {return spawnJobs;}
    public static void setSpawnJobs(String spawnJobs) {OptionsDataCollector.spawnJobs = spawnJobs;}

    private static String getIndexMisMatch() {return indexMisMatch;}
    public static void setIndexMisMatch(String indexMisMatch) {OptionsDataCollector.indexMisMatch = indexMisMatch;}

    private static String getProgCheck() {return progCheck;}
    public static void setProgCheck(String progCheck) {OptionsDataCollector.progCheck = progCheck;}

    private static String getRepeatCount() {return repeatCount;}
    public static void setRepeatCount(String repeatCount) {OptionsDataCollector.repeatCount = repeatCount;}

    private static String getFreqIterations() {return freqIterations;}
    public static void setFreqIterations(String freqIterations) {OptionsDataCollector.freqIterations = freqIterations;}

    private static String getTargetFile() {return targetFile;}
    public static void setTargetFile(String targetFile) {OptionsDataCollector.targetFile = targetFile;}



    private static CheckBox getWriteChromPloidyFile() {return writeChromPloidyFile;}
    public static void setWriteChromPloidyFile(CheckBox writeChromPloidyFile) {OptionsDataCollector.writeChromPloidyFile = writeChromPloidyFile;}

    private static CheckBox getWriteBreakPointDistFile() {return writeBreakPointDistFile;}
    public static void setWriteBreakPointDistFile(CheckBox writeBreakPointDistFile) {OptionsDataCollector.writeBreakPointDistFile = writeBreakPointDistFile;}

    private static CheckBox getWriteBreakPointChromDistFile() {return writeBreakPointChromDistFile;}
    public static void setWriteBreakPointChromDistFile(CheckBox writeBreakPointChromDistFile) {OptionsDataCollector.writeBreakPointChromDistFile = writeBreakPointChromDistFile;}

    private static CheckBox getDeleteNewFastq(){return deleteNewFastq;}
    public static void setDeleteNewFastq(CheckBox deleteNewFastq) {OptionsDataCollector.deleteNewFastq = deleteNewFastq;}

    private static CheckBox getRevComp(){return revComp;}
    public static void setRevComp(CheckBox revComp){OptionsDataCollector.revComp = revComp;}

    private static CheckBox getCompressFastq(){return compressFastq;}
    public static void setCompressFastq(CheckBox compressFastq){OptionsDataCollector.compressFastq = compressFastq;}

    private static String getFastqFile1() {return fastqFile1;}
    public static void setFastqFile1(String fastqFile1) {OptionsDataCollector.fastqFile1 = fastqFile1;}

    private static String getIndexFile(){return indexFile;}
    public static void setIndexFile(String indexFile) {OptionsDataCollector.indexFile = indexFile;}

    private static String getMinLength(){return minLength;}
    public static void setMinLength(String minLength) {OptionsDataCollector.minLength = minLength;}

    private static String getTargetLength(){return targetLength;}
    public static void setTargetLength(String targetLength) {OptionsDataCollector.targetLength = targetLength;}

    private static String getTargetStart(){return targetStart;}
    public static void setTargetStart(String targetStart) {OptionsDataCollector.targetStart = targetStart;}

    private static String getTargetPadding(){return targetPadding;}
    public static void setTargetPadding(String targetPadding) {OptionsDataCollector.targetPadding = targetPadding;}

    private static String getTargetMisMatch(){return targetMisMatch;}
    public static void setTargetMisMatch(String targetMisMatch) {OptionsDataCollector.targetMisMatch = targetMisMatch;}

    private static String getExpectedPosition(){return expectedPosition;}
    public static void setExpectedPosition(String expectedPosition) {OptionsDataCollector.expectedPosition = expectedPosition;}

}
