package com.Java_Boot_Camp.Java_Boot_Camp;

import java.io.*;
import java.util.Scanner;

public class ReadCSV {

    private static final String COMMA_DELIMITER = ",";

    //method for reading information from the xml file
    static int readCSV(String fileName, String table[][], int tableRecord) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            line = br.readLine(); //skip first line with headers
            String[] label = line.split(COMMA_DELIMITER);

            //check valid input line "Title,Author,Album,Category,Votes"
            if (label[0].equals("Title") && label[1].equals("Author") && label[2].equals("Album") &&
                    label[3].equals("Category") && label[4].equals("Votes")) {

                while ((line = br.readLine()) != null) {
                    String[] values = line.split(COMMA_DELIMITER);

                    //looking for song with the same title in table
                    boolean haveSongLikeThis = false;
                    for (int temp = 0; temp < tableRecord; temp++) {
                        if (table[0][temp].equals(values[0])) {
                            int temporaryTableValue = Integer.parseInt(table[4][temp]);
                            int temporaryVote = Integer.parseInt(values[4]);
                            int voteToSet = temporaryTableValue + temporaryVote;
                            table[4][temp] = String.valueOf(voteToSet);
                            haveSongLikeThis = true;
                        }
                    }
                    //if the songs don't repeat themselves
                    if (haveSongLikeThis == false) {
                        table[0][tableRecord] = values[0];
                        table[1][tableRecord] = values[1];
                        table[2][tableRecord] = values[2];
                        table[3][tableRecord] = values[3];
                        table[4][tableRecord] = values[4];
                        tableRecord++;
                    }
                    haveSongLikeThis = false;
                }
            } else {
                System.out.println("Your csv file should start in sequence: Title,Author,Album,Category,Votes");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableRecord;
    }
}
