package com.Java_Boot_Camp.Java_Boot_Camp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteVotesTests {

    String zeroTableVote[][];
    String table[][];
    int tableRecord=2;
    
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

        zeroTableVote = new String[5][3];
        zeroTableVote[0][1] = "a";
        zeroTableVote[1][1] = "a";
        zeroTableVote[2][1] = "a";
        zeroTableVote[3][1] = "a";
        zeroTableVote[4][1] = "0";

        zeroTableVote[0][0] = "f";
        zeroTableVote[1][0] = "f";
        zeroTableVote[2][0] = "f";
        zeroTableVote[3][0] = "f";
        zeroTableVote[4][0] = "0";

        zeroTableVote[0][2] = "b";
        zeroTableVote[1][2] = "b";
        zeroTableVote[2][2] = "b";
        zeroTableVote[3][2] = "b";
        zeroTableVote[4][2] = "0";
    }

    //testing of removing all voices
    @Test
    public void deleteVotes() {
        String[][] setTable = DeleteVotes.deleteAllVotes(table, tableRecord);
            for (int j = 0; j < 2; j++) {
                assertEquals(zeroTableVote[4][j], setTable[4][j]);
            }
    }
}




