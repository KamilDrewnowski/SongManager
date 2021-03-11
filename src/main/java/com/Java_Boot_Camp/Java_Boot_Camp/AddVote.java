package com.Java_Boot_Camp.Java_Boot_Camp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddVote {

        //method to add voice to a specific song
        static void addVote(String table[][], int tableRecord) {

        Scanner scanA=new Scanner(System.in);
            System.out.println("choose song to add vote");
            int songNumber=-1;
            try {
                songNumber = Integer.parseInt(scanA.nextLine()); // get number of song from user
            }catch(Exception e){
                System.out.println("Incorrect input, next time insert correct number of song");
            }
            table=addingVote(table, songNumber, tableRecord);
        }

        static String[][] addingVote(String table[][], int songNumberInt, int tableRecord){
            int temp;
            if(songNumberInt>=0 && songNumberInt<= tableRecord) { // checking the correctness of the song number
                temp = Integer.parseInt(table[4][songNumberInt]) + 1;
                table[4][songNumberInt] = String.valueOf(temp);
            } else{
                System.out.println("You chose a non-existent song, correct it");
            }
            return table;
        }
    }
