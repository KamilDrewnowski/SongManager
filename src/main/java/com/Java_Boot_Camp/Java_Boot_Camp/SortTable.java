package com.Java_Boot_Camp.Java_Boot_Camp;

public class SortTable {

    //A method of sorting songs according to the ratings received, from highest to lowest
    static String[][] sortTableByVote(String table[][], int tableRecord) {
        int temp4;
        String temp0, temp1, temp2, temp3;
        for (int ySize = 0; ySize < tableRecord; ySize++) {
            for (int j = 1; j < (tableRecord - ySize); j++) {
                if (Integer.parseInt(table[4][j - 1]) < Integer.parseInt(table[4][j])) {

                    temp4 = Integer.parseInt(table[4][j - 1]);
                    temp3 = table[3][j - 1];
                    temp2 = table[2][j - 1];
                    temp1 = table[1][j - 1];
                    temp0 = table[0][j - 1];

                    table[4][j - 1] = table[4][j];
                    table[3][j - 1] = table[3][j];
                    table[2][j - 1] = table[2][j];
                    table[1][j - 1] = table[1][j];
                    table[0][j - 1] = table[0][j];

                    table[4][j] = String.valueOf(temp4);
                    table[3][j] = temp3;
                    table[2][j] = temp2;
                    table[1][j] = temp1;
                    table[0][j] = temp0;
                }
            }
        }
        return table;
    }
    //Method for sorting songs by category alphabetically from a to z
    static String[][] sortTableByCategory(String table[][], int tableRecord) {
        int temp4;
        String temp0, temp1, temp2, temp3;
        for (int ySize = 0; ySize < tableRecord; ySize++) {
            for (int j = 1; j < (tableRecord - ySize); j++) {
                if (table[3][j - 1].toLowerCase().compareTo(table[3][j].toLowerCase()) > 0) {

                    temp4 = Integer.parseInt(table[4][j - 1]);
                    temp3 = table[3][j - 1];
                    temp2 = table[2][j - 1];
                    temp1 = table[1][j - 1];
                    temp0 = table[0][j - 1];

                    table[4][j - 1] = table[4][j];
                    table[3][j - 1] = table[3][j];
                    table[2][j - 1] = table[2][j];
                    table[1][j - 1] = table[1][j];
                    table[0][j - 1] = table[0][j];

                    table[4][j] = String.valueOf(temp4);
                    table[3][j] = temp3;
                    table[2][j] = temp2;
                    table[1][j] = temp1;
                    table[0][j] = temp0;
                }
            }
        }
        return table;
    }
}



