
package com.cx.game;

import com.badlogic.gdx.graphics.Color;

/**
 *
 * @author Trent
 */
public class Player {
    private String pName;
    private int pID;
    private int goID;
    private Color pColor;
    
    private int nextPiece;
    private int tempPiece;

    Player(Color color, int id, String name){
        //Player Constructor
        setName(name);
        setColor(color);
        setID(id);
        setNextPiece(id);
    }
    
    Player(){
        //Default player constructor
        setName("test player");
        setColor(Color.WHITE);
        setID(0);
        setNextPiece(0);
    }
    public int getNextPiece(){
        //grab go odds from ConnectX class
        //use three sets of odds: 0, custom, and 100
        //the odds are 0 if go is disabled, custom based on balance tests, 100 for always provide a go piece
        
        //store the next piece before changing it
        tempPiece = nextPiece;
        
        if((Math.random()*100)<0){nextPiece = goID;}
        else{nextPiece = pID;}
        return tempPiece;
    }
    public int peekNextPiece(){
        //this method returns the next piece to be used without grabbing a new piece
        return nextPiece;
    }
    public void setColor(Color color) {
        this.pColor = color;
    }
    public void setID(int id) {
        this.pID = id;
        if(id==0){
            this.goID = id;
        }else{
            this.goID = id+6;
        }
    }
    public void setName(String name){
        pName = name;
    }
    private void setNextPiece(int i) {
        nextPiece = i;
    }
    public Color getColor() {
        return this.pColor;
    }
    public int getID() {
        return this.pID;
    }
    public int getGoID() {
        return this.goID;
    }
    public String getName(){
        return pName;
    }
}
