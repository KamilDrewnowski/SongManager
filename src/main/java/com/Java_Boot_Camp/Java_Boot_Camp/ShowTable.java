package com.Java_Boot_Camp.Java_Boot_Camp;

import java.util.Arrays;

public class ShowTable {

    //method of listing the contents of an array to string builder
    static String showTable(int tableRecord, String table[][]) {
        String s="\n";
        StringBuilder sB = new StringBuilder(s);

        for (int ySize = 0; ySize < tableRecord; ySize++) { //going through all the songs
            sB.append("Song number: " + ySize + "\n");
            for (int xSize = 0; xSize < table.length; xSize++) { //going through all the attributes of the song
                sB.append(table[xSize][ySize] + "\n");
            }
            sB.append("...............................\n");
        }
        return sB.toString();
    }
}
