# Beithir

### App to create parameter files for Opentrons robot in Gaorav Gupta's Lab

## Requirements:

-   Windows 11 only
-   Java JDK Runtime v24 (<https://download.oracle.com/java/24/latest/jdk-24_windows-x64_bin.msi>)


## Installation

Beithir.jar is too large to be uploaded to GitHub.
Once the JDK is installed, download Beithir.jar to any folder you have access to and double-click. If it does not open, the most likely cause is the JDK is not in the PATH. To confirm, open PowerShell and cd to the location of Beithir.jar. Run by typing ./Beithir.jar at the command prompt. Note any error messages.

## How to Use

Click on the Modules dropdown and select the template type. Fill in the fields. If a field is outlined in red, it is required or has incorrect data in it. Once done, click File – Save to create the TSV parameter file.

## Known Issues

1.  Beithir will save data that does not pass validation.
2.  Cannot import TSV parameter files.
3.  Adding data to the sample table does not flow. For example, cannot paste data from an Excel sheet here.
    1.  Recommend adding the first sample within Beithir then pasting the remaining data into the TSV file after generating it.
