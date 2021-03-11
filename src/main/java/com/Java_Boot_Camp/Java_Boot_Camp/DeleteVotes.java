package com.Java_Boot_Camp.Java_Boot_Camp;

import java.util.Scanner;

public class DeleteVotes {

    static String[][] deleteVotes(String table[][], int tableRecord) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1 to remove vote for one song or enter 2 to remove votes from all");
        int oneAll = -1;
        try {
            oneAll = Integer.parseInt(scan.nextLine());
        } catch (Exception e){
            System.out.println("Incorrect input, next time insert correct number 1 or 2");
        }

        //set 0 vote for one song
        if (oneAll == 1) {
            System.out.println("Enter number of song");
            Scanner scanB = new Scanner(System.in);
            int songNumber=-1;
            try {
                songNumber = Integer.parseInt(scanB.nextLine());
            }catch(Exception e){
                System.out.println("Incorrect input, next time insert correct number of song");
            }

            //checking the correctness of the song number
            if(songNumber>=0 && songNumber<= tableRecord){
                table[4][songNumber] = "0";
            } else{
                System.out.println("You chose a non-existent song, correct it");
            }
            //set 0 vote for every song
        } else if (oneAll == 2) {
            deleteAllVotes(table, tableRecord);
        } else {
            System.out.println("Incorect option");
        }
        return table;
    }

    //method for removing all voices - setting 0
    public static String[][] deleteAllVotes(String[][] table, int tableRecord){
        int temp = 0;
        do {
            table[4][temp] = "0";
            temp++;
        } while (temp < tableRecord);
        return table;
    }
}
