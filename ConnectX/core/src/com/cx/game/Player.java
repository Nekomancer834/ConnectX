
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
    private int odds;
    private Color pColor;
    
    private int nextPiece;
    private int tempPiece;

    Player(Color color, int id, int o, String name){
        //Player Constructor
        setName(name);
        setColor(color);
        setOdds(o);
        setID(id);
        //this is doubled because the way the first piece is generated always returns null on the first call
        //of getNextPiece(). this happens to every player so it doesn't really mess with the odds of any one person getting
        //something better
        getNextPiece();
        getNextPiece();
    }
    Player(Color color, int id, String name){
        //Player Constructor
        setName(name);
        setColor(color);
        setOdds(0); //if no odds specified, always provide base ID piece
        setID(id);
        //this is doubled because the way the first piece is generated always returns null on the first call
        //of getNextPiece(). this happens to every player so it doesn't really mess with the odds of any one person getting
        //something better
        getNextPiece();
        getNextPiece();
    }
    
    Player(){
        //Default player constructor
        setName("test player");
        setColor(Color.WHITE);
        setID(0);
        setNextPiece(0);
    }
    public int getNextPiece(){
        //line 74 sets the rarity of go pieces in mixed mode
        //use three sets of odds: 0, custom, and 100
        //the odds are 0 if go is disabled, custom based on balance tests, 100 for always provide a go piece
        
        //store the next piece before changing it
        tempPiece = nextPiece;
        
        if((Math.random()*100)<odds){nextPiece = goID;}
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
            this.goID = id+10;
        }
    }
    private void setName(String name){
        pName = name;
    }
    private void setOdds(int o){
        switch(o){
            case 0: this.odds = 0;
                    break;
            case 1: this.odds = 30; // the smaller this is, the less likely to get a go piece
                    break;
            case 2: this.odds = 100;
                    break;
            default: this.odds = 0;
        }
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
