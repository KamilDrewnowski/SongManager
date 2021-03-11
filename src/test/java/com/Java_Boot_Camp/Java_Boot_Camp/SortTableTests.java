package com.Java_Boot_Camp.Java_Boot_Camp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortTableTests {

    String orderedTableVote[][];
    String orderedTableCategory[][];
    String table[][];

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

        orderedTableVote = new String[5][3];
        orderedTableVote[0][1] = "a";
        orderedTableVote[1][1] = "a";
        orderedTableVote[2][1] = "a";
        orderedTableVote[3][1] = "a";
        orderedTableVote[4][1] = "5";

        orderedTableVote[0][0] = "f";
        orderedTableVote[1][0] = "f";
        orderedTableVote[2][0] = "f";
        orderedTableVote[3][0] = "f";
        orderedTableVote[4][0] = "7";

        orderedTableVote[0][2] = "b";
        orderedTableVote[1][2] = "b";
        orderedTableVote[2][2] = "b";
        orderedTableVote[3][2] = "b";
        orderedTableVote[4][2] = "1";

        orderedTableCategory = new String[5][3];
        orderedTableCategory[0][0] = "a";
        orderedTableCategory[1][0] = "a";
        orderedTableCategory[2][0] = "a";
        orderedTableCategory[3][0] = "a";
        orderedTableCategory[4][0] = "5";

        orderedTableCategory[0][2] = "b";
        orderedTableCategory[1][2] = "b";
        orderedTableCategory[2][2] = "b";
        orderedTableCategory[3][2] = "b";
        orderedTableCategory[4][2] = "7";

        orderedTableCategory[0][1] = "f";
        orderedTableCategory[1][1] = "f";
        orderedTableCategory[2][1] = "f";
        orderedTableCategory[3][1] = "f";
        orderedTableCategory[4][1] = "1";
    }

    // test sorting the table by ratings
    @Test
    public void testSortingVote() { // sorting by category
        String[][] sortedTable = SortTable.sortTableByVote(table, 2);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals(orderedTableVote[i][j], sortedTable[i][j]);
            }
        }
    }

    // sort the table by category
    @Test
    public void testSortingCategory() { // sorting by category
        String[][] sortedTable = SortTable.sortTableByCategory(table, 2);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals(orderedTableCategory[i][j], sortedTable[i][j]);
            }
        }
    }
}
