/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cx.game;
import org.junit.Test;
import static org.junit.Assert.*;
import com.badlogic.gdx.graphics.Color;
/**
 *
 * @author djmitch
 */public class PlayerTest {

    @Test
    public void testDefaultConstructor() {
        Player p = new Player();
        assertEquals("test player", p.getName());
        assertEquals(Color.WHITE, p.getColor());
        assertEquals(0, p.getID());
        assertEquals(0, p.getNextPiece());
    }
    @Test
    public void testConstructorWithColorIdOddsName() {
        Player p = new Player(Color.RED, 1, 50, "test");
        assertEquals("test", p.getName());
        assertEquals(Color.RED, p.getColor());
        assertEquals(1, p.getID());
        assertTrue(p.getNextPiece() >= 1 && p.getNextPiece() <= 11); // expect next piece is between 1 and 11
    }
    @Test
    public void testConstructorWithColorIdName() {
        Player p = new Player(Color.GREEN, 2, "test2");
        assertEquals("test2", p.getName());
        assertEquals(Color.GREEN, p.getColor());
        assertEquals(2, p.getID());
        assertTrue(p.getNextPiece() >= 2 && p.getNextPiece() <= 12); // expect next piece is between 2 and 12
    }
    @Test
    public void testGetNextPiece() {
        Player player = new Player(Color.RED, 1, 50, "test3");
        int result = player.getNextPiece();
        assertTrue(result == player.peekNextPiece()); // check that the result is equal to the peeked next piece
        assertTrue(result == player.getID() || result == player.getGoID()); // check that the result is either the player ID or the go ID
    }
    @Test
    public void testPeekNextPiece() {
        Player player = new Player(Color.GREEN, 2, "test4");
        int expectedPiece = player.getNextPiece();
        int actualPiece = player.peekNextPiece();
        assertEquals(expectedPiece, actualPiece);
    }
}
