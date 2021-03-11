package com.Java_Boot_Camp.Java_Boot_Camp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class addVoteTests {

    String tableCorrect[][];
    String table[][];

    @BeforeEach
    public void setUp() throws Exception {
        table = new String[5][3];
        table[0][0] = "a";
        table[1][0] = "a";
        table[2][0] = "a";
        table[3][0] = "a";
        table[4][0] = "5";

        tableCorrect = new String[5][3];
        tableCorrect[0][0] = "a";
        tableCorrect[1][0] = "a";
        tableCorrect[2][0] = "a";
        tableCorrect[3][0] = "a";
        tableCorrect[4][0] = "6";
    }

    //add rating test to an existing song
    @Test
    public void testAddVote() { // sorting by category
        int tableRecord = 5;
        String[][] tableWithVote = AddVote.addingVote(table, 0, tableRecord);
        for (int i = 0; i < 4; i++) {
            assertEquals(tableCorrect[i][0], tableWithVote[i][0]);
        }
    }
}
