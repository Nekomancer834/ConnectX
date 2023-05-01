/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.cx.game;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Trent
 */
public class BoardTest {
    
    public BoardTest() {
    }
    @Test
    public void testDefaultConstructor(){
        System.out.println("Default Constructor");
        Board defCon = new Board();
        assertEquals(defCon.getInternalGameBoard(), new int[6][7]); // test empty board
        assertEquals(defCon.getTracker().length, defCon.getBoardWidth()); // test board tracker
    }
    @Test
    public void testCustomConstructor(){
        System.out.println("Custom Constructor");
        //add code to create new things to put into the custom constructor
        Queue<Player> defPlayers = new LinkedList<>();
        defPlayers.add(new Player());

        Board cusCon = new Board(defPlayers, 7, 6);
        assertEquals(cusCon.getPlayers(), defPlayers); // test if internal player queue is the same as queue we put in
        assertEquals(cusCon.getInternalGameBoard(), new int[6][7]); // test empty board
        assertEquals(cusCon.getTracker().length, cusCon.getBoardWidth()); // test board tracker
    }
    /**
     * Test of updateInternalGameBoard method, of class Board.
     */
    @Test
    public void testUpdateInternalGameBoard() {
        System.out.println("updateInternalGameBoard");
        int mouseColumn = 0;
        int id = 0;
        Board instance = new Board();
        int expResult = 1;
        int result = instance.updateInternalGameBoard(mouseColumn, id);
        assertEquals(expResult, result); //successfully place piece on board
        instance.updateInternalGameBoard(mouseColumn, id);
        instance.updateInternalGameBoard(mouseColumn, id);
        instance.updateInternalGameBoard(mouseColumn, id);
        instance.updateInternalGameBoard(mouseColumn, id);
        instance.updateInternalGameBoard(mouseColumn, id);
        result = instance.updateInternalGameBoard(mouseColumn, id);
        assertEquals(2, result); //identify that column is full
    }


    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Board instance = new Board();
        String expResult =  "Board:\n" +
                            "|0\t0\t0\t0\t0\t0\t0\t|\n" +
                            "|0\t0\t0\t0\t0\t0\t0\t|\n" +
                            "|0\t0\t0\t0\t0\t0\t0\t|\n" +
                            "|0\t0\t0\t0\t0\t0\t0\t|\n" +
                            "|0\t0\t0\t0\t0\t0\t0\t|\n" +
                            "|0\t0\t0\t0\t0\t0\t0\t|\n";
        String result = instance.toString();
        assertEquals(expResult, result); // test that toString prints in the proper format
        
    }
    
     @Test
    public void testWinHandler() {
         System.out.println("WinHandler");
         Board board = new Board();
         int[][] gameBoard = board.getInternalGameBoard();
         int playerID = 1;
         gameBoard[5][0] = playerID;
         gameBoard[4][0] = playerID;
         gameBoard[3][0] = playerID;
         gameBoard[2][0] = playerID;
         board.setInternalGameBoard(gameBoard);
         assertTrue(board.winHandler()); // test to make sure the winHandler detects the win successfully
         gameBoard[5][0] = playerID;
         gameBoard[4][0] = playerID;
         gameBoard[3][0] = playerID;
         gameBoard[2][0] = 0;
         board.setInternalGameBoard(gameBoard);
         assertFalse(board.winHandler()); // test to make sure the winHandler doesn't detect a win successfully
    }
    @Test
    public void testCheckWin(){
        System.out.println("CheckWin");
        //vertical win
        Board board = new Board();
        int[][] gameBoard = board.getInternalGameBoard();
        int playerID = 1;
        gameBoard[5][0] = playerID;
        gameBoard[4][0] = playerID;
        gameBoard[3][0] = playerID;
        gameBoard[2][0] = playerID;
        board.setInternalGameBoard(gameBoard);
        assertTrue(board.winHandler());
        
        //vertical fail
        board = new Board();
        gameBoard = board.getInternalGameBoard();
        playerID = 1;
        gameBoard[5][0] = playerID;
        gameBoard[4][0] = 2;
        gameBoard[3][0] = 3;
        gameBoard[2][0] = 4;
        board.setInternalGameBoard(gameBoard);
        assertFalse(board.winHandler());
        
        //horizontal win
        Board board2 = new Board();
        gameBoard = board2.getInternalGameBoard();
        playerID = 2;
        gameBoard[0][5] = playerID;
        gameBoard[0][4] = playerID;
        gameBoard[0][3] = playerID;
        gameBoard[0][2] = playerID;
        board2.setInternalGameBoard(gameBoard);
        assertTrue(board2.winHandler());
        
        //horizontal fail
        board2 = new Board();
        playerID = 2;
        gameBoard[0][5] = playerID;
        gameBoard[0][4] = 3;
        gameBoard[0][3] = 5;
        gameBoard[0][2] = 6;
        board2.setInternalGameBoard(gameBoard);
        assertFalse(board2.winHandler());
        
        //right diagonal win
        Board board3 = new Board();
        gameBoard = board3.getInternalGameBoard();
        playerID = 3;
        gameBoard[1][4] = playerID;
        gameBoard[2][3] = playerID;
        gameBoard[3][2] = playerID;
        gameBoard[4][1] = playerID;
        board3.setInternalGameBoard(gameBoard);
        assertTrue(board3.winHandler());
        
        //right diagonal fail
        board3 = new Board();
        playerID = 3;
        gameBoard[1][4] = 2;
        gameBoard[2][3] = 4;
        gameBoard[3][2] = 5;
        gameBoard[4][1] = playerID;
        board3.setInternalGameBoard(gameBoard);
        assertFalse(board3.winHandler());
        
        
        //left diagonal win
        Board board4 = new Board();
        gameBoard = board4.getInternalGameBoard();
        playerID = 4;
        gameBoard[4][1] = playerID;
        gameBoard[3][2] = playerID;
        gameBoard[2][3] = playerID;
        gameBoard[1][4] = playerID;
        board3.setInternalGameBoard(gameBoard);
        assertTrue(board3.winHandler());
        
        //left diagonal  fail
        board3 = new Board();
        playerID = 4;
        gameBoard[4][1] = 7;
        gameBoard[3][2] = 9;
        gameBoard[2][3] = 6;
        gameBoard[1][4] = playerID;
        board3.setInternalGameBoard(gameBoard);
        assertFalse(board3.winHandler());
    }
    
    @Test
    public void checkGoReplacement() {
        System.out.println("GoReplacement");
        Board board = new Board();
        int[][] gameBoard = board.getInternalGameBoard();
        int playerID = 1;
        gameBoard[2][3] = playerID;
        gameBoard[3][2] = playerID;
        gameBoard[3][3] = 2; // middle piece
        gameBoard[3][4] = playerID;
        gameBoard[4][3] = playerID + 10;

        board.setInternalGameBoard(gameBoard); //set internal board while the gameBoard array is in this state
        board.winHandler();
        gameBoard[3][3] = playerID;
        assertEquals(board.getInternalGameBoard(), gameBoard);
        
    }
}
