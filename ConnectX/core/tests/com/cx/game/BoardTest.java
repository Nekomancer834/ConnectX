/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.cx.game;

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
        assertEquals(expResult, result);
        
    }


    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Board instance = new Board();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void testWinHandler() {
        Board board = new Board();
        int[][] gameBoard = board.getInternalGameBoard();
        int playerID = 1;
        gameBoard[5][0] = playerID;
        gameBoard[4][0] = playerID;
        gameBoard[3][0] = playerID;
        gameBoard[2][0] = playerID;
        board.setInternalGameBoard(gameBoard);
        assertTrue(board.winHandler());
        
    }
    @Test
    public void testCheckWin(){
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
        
        //righ diagonal win
        Board board3 = new Board();
        gameBoard = board3.getInternalGameBoard();
        playerID = 3;
        gameBoard[1][4] = playerID;
        gameBoard[2][3] = playerID;
        gameBoard[3][2] = playerID;
        gameBoard[4][1] = playerID;
        board3.setInternalGameBoard(gameBoard);
        assertTrue(board3.winHandler());
        
        //righ diagonal  fail
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
        Board board = new Board();
        int[][] gameBoard = board.getInternalGameBoard();
        int playerID = 1;
        gameBoard[2][3] = playerID;
        gameBoard[3][2] = playerID;
        gameBoard[3][3] = 2; // middle piece
        gameBoard[3][4] = playerID;
        gameBoard[4][3] = playerID - 10;
        //gameBoard[5][2] = playerID;
        board.setInternalGameBoard(gameBoard);
        int[][] testBoard = board.getInternalGameBoard();
        //assertTrue(board.checkGoReplacement(testBoard));
        
    }
}
