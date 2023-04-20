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
        int expResult = 0;
        int result = instance.updateInternalGameBoard(mouseColumn, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of winHandler method, of class Board.
     */
    @Test
    public void testWinHandler() {
        System.out.println("winHandler");
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.winHandler();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayersQueue method, of class Board.
     */
    @Test
    public void testSetPlayersQueue() {
        System.out.println("setPlayersQueue");
        Queue<Player> players = null;
        Board instance = new Board();
        instance.setPlayersQueue(players);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInternalGameBoard method, of class Board.
     */
    @Test
    public void testSetInternalGameBoard() {
        System.out.println("setInternalGameBoard");
        int[][] i = null;
        Board instance = new Board();
        instance.setInternalGameBoard(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayers method, of class Board.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        Board instance = new Board();
        Queue<Player> expResult = null;
        Queue<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardWidth method, of class Board.
     */
    @Test
    public void testGetBoardWidth() {
        System.out.println("getBoardWidth");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getBoardWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardHeight method, of class Board.
     */
    @Test
    public void testGetBoardHeight() {
        System.out.println("getBoardHeight");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getBoardHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInternalGameBoard method, of class Board.
     */
    @Test
    public void testGetInternalGameBoard() {
        System.out.println("getInternalGameBoard");
        Board instance = new Board();
        int[][] expResult = null;
        int[][] result = instance.getInternalGameBoard();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerFromID method, of class Board.
     */
    @Test
    public void testGetPlayerFromID() {
        System.out.println("getPlayerFromID");
        int id = 0;
        Board instance = new Board();
        Player expResult = null;
        Player result = instance.getPlayerFromID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWinnerID method, of class Board.
     */
    @Test
    public void testGetWinnerID() {
        System.out.println("getWinnerID");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getWinnerID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
