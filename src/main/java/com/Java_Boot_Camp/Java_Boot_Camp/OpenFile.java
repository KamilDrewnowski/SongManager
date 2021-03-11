package com.Java_Boot_Camp.Java_Boot_Camp;

import org.apache.commons.io.FilenameUtils;

import java.util.Scanner;

public class OpenFile {

    //method to open the file
    static int openFile(int tableRecord, String table[][]) {
        Scanner scan=new Scanner(System.in);
        String fileName = null;
        System.out.println("Select file to read");
        try {
            fileName=scan.nextLine(); // get file name from user
        }catch(Exception e){
            System.out.println("Your name is incorrect");
        }
        String filenameExtension = getExtensionByApacheCommonLib(fileName); // get the file extension


        if (filenameExtension.equals("xml")) {
            tableRecord = ReadXML.readXML(fileName, table, tableRecord); // method for reading xml
        } else if (filenameExtension.equals("csv")) {
            tableRecord = ReadCSV.readCSV(fileName, table, tableRecord); // method for reading csv
        } else {
            System.out.println("I can not read file with extension" + filenameExtension);
        }
        return tableRecord;
    }


    // method to get the file extension
    static String getExtensionByApacheCommonLib(String filenameExtension) {
        return FilenameUtils.getExtension(filenameExtension);
    }
}
