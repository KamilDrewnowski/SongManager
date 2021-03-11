package com.Java_Boot_Camp.Java_Boot_Camp;

import java.util.Scanner;

public class AddSingleSong {

    //method for adding songs from the keyboard by the user
    static SongsPOJO addSingleSong(String table[][], int tableRecord){
        SongsPOJO songsPOJO = new SongsPOJO();
        Scanner scan = new Scanner(System.in);
        System.out.println("Add title of the song");
        String songName=scan.nextLine();

        boolean haveSongLikeThis = false;
        haveSongLikeThis=checkSetSong(table, tableRecord, songName, haveSongLikeThis);

        //if the songs don't repeat themselves
        if (haveSongLikeThis == false) {
            setSong(table, tableRecord, songName);
            tableRecord++;
        }
        haveSongLikeThis = false;

        songsPOJO.setTable(table);
        songsPOJO.setTableRecord(tableRecord);
        return songsPOJO;
    }
    //method to check if a song is already in the table, if so only adds a rating to an existing song
    public static boolean checkSetSong(String[][] table, int tableRecord, String songName, boolean haveSongLikeThis) {
        Scanner scan = new Scanner(System.in);
        for (int temp = 0; temp < tableRecord; temp++) { //go across the blackboard
            if (table[0][temp].equals(songName)) { //if song exists
                System.out.println("Your song is already in base, enter vote");
                int temporaryTableValue = Integer.parseInt(table[4][temp]);
                int temporaryVote = Integer.parseInt(scan.nextLine());
                int voteToSet = temporaryTableValue + temporaryVote;
                table[4][temp] = String.valueOf(voteToSet);
                haveSongLikeThis=true;
            }
        }
        return haveSongLikeThis;
    }

    //if the songs don't repeat themselves
    public static String[][] setSong(String[][] table, int tableRecord, String songName) {
        Scanner scan = new Scanner(System.in);
        table[0][tableRecord] = songName;
        System.out.println("Add author of the song");
        table[1][tableRecord] = scan.nextLine();

        System.out.println("Add album name");
        table[2][tableRecord] = scan.nextLine();

        System.out.println("Add category");
        table[3][tableRecord] = scan.nextLine();

        System.out.println("Add votes");
        table[4][tableRecord] = scan.nextLine();
        try {
            Integer.parseInt(table[4][tableRecord]);
                }catch(Exception e){
            System.out.println("Incorrect input, next time insert correct vote like 1, 3, 10");
            }
        return table;
    }
}
