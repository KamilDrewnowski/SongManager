package com.Java_Boot_Camp.Java_Boot_Camp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class showTableTests {

    String zeroTableVote[][];
    String table[][];
    int tableRecord = 3;

    @BeforeEach
    public void setUp() throws Exception {
        table = new String[5][3];
        table[0][0] = "a";
        table[1][0] = "a";
        table[2][0] = "a";
        table[3][0] = "a";
        table[4][0] = "5";

        table[0][1] = "f";
        table[1][1] = "f";
        table[2][1] = "f";
        table[3][1] = "f";
        table[4][1] = "7";

        table[0][2] = "b";
        table[1][2] = "b";
        table[2][2] = "b";
        table[3][2] = "b";
        table[4][2] = "1";
    }

    //testing the display of the array correctly
    @Test
    public void testShowTable() {
        String showTable = ShowTable.showTable(tableRecord, table);
        String correctShow =
                "\n" +
                "Song number: 0\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "5\n" +
                "...............................\n" +
                "Song number: 1\n" +
                "f\n" +
                "f\n" +
                "f\n" +
                "f\n" +
                "7\n" +
                "...............................\n" +
                "Song number: 2\n" +
                "b\n" +
                "b\n" +
                "b\n" +
                "b\n" +
                "1\n" +
                "..............................." +
                "\n";
            assertEquals(correctShow, showTable);
    }
}
