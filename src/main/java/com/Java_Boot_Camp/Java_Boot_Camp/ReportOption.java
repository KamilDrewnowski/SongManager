package com.Java_Boot_Camp.Java_Boot_Camp;

import java.util.Scanner;

public class ReportOption {
    //method that allows the user to select report every song, top10, top13, by category
    public static void selectTypeReport(String[][] table, int optionXMLCSVSHOW, int tableRecord, Scanner scan) {
        System.out.println("Enter 1 to generate file in XML, 2 to generate CSV, or 3 to show on screen");
        optionXMLCSVSHOW = scan.nextInt();
        System.out.println("Enter 1 to generate report every song, 2 to top10, 3 to top3, 4 to generate by category");
        int howLong = scan.nextInt();

        if(howLong == 1){ //prepare report for every song
            howLong = tableRecord;
            table=SortTable.sortTableByVote(table, tableRecord);
            prepareReport(howLong, table, optionXMLCSVSHOW);

        }else if (howLong == 2){ //prepare report for top10
            howLong = 10;
            table=SortTable.sortTableByVote(table, tableRecord);
            prepareReport(howLong, table, optionXMLCSVSHOW);

        }else if (howLong == 3){ //prepare report for top3
            howLong = 3;
            table=SortTable.sortTableByVote(table, tableRecord);
            prepareReport(howLong, table, optionXMLCSVSHOW);

        }else if (howLong == 4){ //prepare report for songs sorted by category
            howLong = tableRecord;
            table=SortTable.sortTableByCategory(table, tableRecord);
            prepareReport(howLong, table, optionXMLCSVSHOW);
        } else {
            System.out.println("Incorrect option");
        }
    }

    // method that allows to select an action (xml generating / csv generation / printing to the screen)
    public static void prepareReport(int howLong, String[][] table, int option) {
        if (option == 1) {
            GenerateFile.saveToXML(table, howLong);
        }else if (option == 2) {
            GenerateFile.saveToCSV(table, howLong);
        }else if(option == 3){
            System.out.println(ShowTable.showTable(howLong, table));
        }else{
            System.out.println("Incorrect option");
        }
    }
}
