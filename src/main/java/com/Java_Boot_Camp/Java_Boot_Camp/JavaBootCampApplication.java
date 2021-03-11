/*
Kamil Drewnowski
tel. +48 511 143 145
Date: 09.03.2021
*/

package com.Java_Boot_Camp.Java_Boot_Camp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


//main class containing the menu
@SpringBootApplication
public class JavaBootCampApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaBootCampApplication.class, args);

        String table[][] = new String[5][100]; // two-dimensional array for songs
        int tableRecord = 0; //number of songs in the array
        Scanner scan = new Scanner(System.in);
        int option = 0; // choose from user

        do {
            System.out.println("Chose option: \n" +
                    "1 - Open file \n" +
                    "2 - Show your songs \n" +
                    "3 - Add vote for song  \n" +
                    "4 - Set 0 as a vote \n" +
                    "5 - Add single song\n" +
                    "6 - Generate report by ranking or category\n" +
                    "0 - close program");

            try {
                option = scan.nextInt();
            }catch(Exception e){
                System.out.println("Incorrect option");
            }
            switch (option) {
                case 1:
                    tableRecord = OpenFile.openFile(tableRecord, table); // open file
                    break;

                case 2:
                    System.out.println(ShowTable.showTable(tableRecord, table)); // print songs from table
                    break;

                case 3:
                    AddVote.addVote(table, tableRecord); // add vote for song
                    break;

                case 4:
                    DeleteVotes.deleteVotes(table, tableRecord); // delete vote from song
                    break;

                case 5:
                    SongsPOJO songsPOJO = AddSingleSong.addSingleSong(table, tableRecord); // adding single song
                    tableRecord = songsPOJO.getTableRecord();
                    table = songsPOJO.getTable();
                    break;

                case 6:
                    ReportOption.selectTypeReport(table, option, tableRecord, scan); // generate report, sorted table
                    break;
            }
        }
        while (option != 0);


    }



}
