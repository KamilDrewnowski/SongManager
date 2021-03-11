package com.Java_Boot_Camp.Java_Boot_Camp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddSingleSongTests {

    String tableCorrect[][];
    String table[][];
    Scanner scan=new Scanner(System.in);
    String songName = "ala";

    @BeforeEach
    public void setUp() throws Exception {
        table = new String[5][3];

        tableCorrect = new String[5][3];
        tableCorrect[0][0] = "ala";
        tableCorrect[1][0] = "test0";
        tableCorrect[2][0] = "test1";
        tableCorrect[3][0] = "test2";
        tableCorrect[4][0] = "5";
        tableCorrect[0][1] = "ala";
        tableCorrect[1][1] = "test0";
        tableCorrect[2][1] = "test1";
        tableCorrect[3][1] = "test2";
        tableCorrect[4][1] = "5";
    }

    @Test
    //test of adding a single song to the board
    public void testAddVote() { // sorting by category

        int tableRecord=0;
        AddSingleSong inputOutput= new AddSingleSong();

        String input = "test0\n" + "test1\n" + "test2\n" + "test3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("ala" , AddSingleSong.setSong(table, tableRecord, songName)[0][0]);
    }

    //test for the presence of the song in the board
    @Test
    public void testCheckSetSong() { // sorting by category

        int tableRecord=1;
        AddSingleSong inputOutput= new AddSingleSong();
        boolean haveSongLikeThis = false;

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(true, AddSingleSong.checkSetSong(tableCorrect, tableRecord, songName, haveSongLikeThis));
    }
}
