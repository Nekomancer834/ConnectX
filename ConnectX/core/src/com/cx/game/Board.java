
package com.cx.game;
import com.badlogic.gdx.Game;
import java.lang.Math;
import java.time.LocalDateTime;  
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Trent
 */
public class Board {
    private Queue<Player> players;
    private int[][] internalGameBoard;
    private int activePlayerIndex;
    private HashMap<Integer, Player> playerIDs = new HashMap<Integer, Player>();
    private int[] tracker;
    private int trackerTotal;
    private Player emptyPlayer = new Player();
    private int winner;
    private int h;
    private int w;
    
    
    Board(){
        Queue<Player> defPlayers = new LinkedList<>();
        defPlayers.add(new Player());
        setPlayersQueue(defPlayers);
        setInternalGameBoard(new int[6][7]);
        tracker = new int[internalGameBoard[0].length];
        for(int i = 0; i<tracker.length; i++)
            this.tracker[i] = internalGameBoard.length-1;
    }
    Board(Queue<Player> players, int width, int height){
        
        setPlayersQueue(players);
        for(Player x : players){
            playerIDs.put(x.getID(), x);
            playerIDs.put(x.getGoID(), x);
        }
        setInternalGameBoard(new int[height][width]);
        tracker = new int[internalGameBoard[0].length];
        for(int i = 0; i<tracker.length; i++)
            this.tracker[i] = internalGameBoard.length-1;
            
    }
    
    public int updateInternalGameBoard(int mouseColumn, int id){
        //write the id of the current player to the lowest unoccupied spot
        if(tracker[mouseColumn]>=0){
            internalGameBoard[tracker[mouseColumn]][mouseColumn] = id;
            tracker[mouseColumn]--;
            //after placing piece on board and iterating the tracker, check if the move was a win
            if(winHandler()){
                //System.out.println("Win detected");
                //System.err.println(toString());
                return 0;
            }
            else{
                //generate new piece for active player then cycle to next player and print current board
                players.peek().getNextPiece();
                players.add(players.remove());
                //System.out.println(toString());
                return 1;
                }
        }else{
            return 2;
        }
    }
    public boolean winHandler(){
        //replace go scenarios and chekc for 4-in-a-row
        checkGoReplacement(this.internalGameBoard);
        int winReturn = checkWin(this.internalGameBoard);
        
        //if board full player 0 wins (draw)
        for(int i=0; i<tracker.length; i++){
            trackerTotal += tracker[i];
        }
        if(trackerTotal==(-1*tracker.length))
            winReturn = 0;
        trackerTotal=0;
        if(winReturn != 999 ){
            this.winner = winReturn;
            return true;
        }
            
        return false;
    }
    private int checkWin(int[][] board){
        for(int i = board.length-1; i >= 0; i--){
            for(int j = 0; j < board[i].length; j++){
                //this if is vital for not find a 4 in a row of ID 0
                if(board[i][j]>0){
                    if(i>=3)
                        if((board[i-1][j]==board[i][j] || board[i-1][j]==(board[i][j]+10) || board[i-1][j]==(board[i][j]-10)) &&
                           (board[i-2][j]==board[i][j] || board[i-2][j]==(board[i][j]+10) || board[i-2][j]==(board[i][j]-10)) &&
                           (board[i-3][j]==board[i][j] || board[i-3][j]==(board[i][j]+10) || board[i-3][j]==(board[i][j]-10))   )
                            return board[i][j];
                    if(j<board[i].length-3)
                        if((board[i][j+1]==board[i][j] || board[i][j+1]==(board[i][j]+10) || board[i][j+1]==(board[i][j]-10)) &&
                           (board[i][j+2]==board[i][j] || board[i][j+2]==(board[i][j]+10) || board[i][j+2]==(board[i][j]-10)) &&
                           (board[i][j+3]==board[i][j] || board[i][j+3]==(board[i][j]+10) || board[i][j+3]==(board[i][j]-10))   )
                            return board[i][j];
                    if(i>=4 && j<board[i].length-3)
                        if((board[i-1][j+1]==board[i][j] || board[i-1][j+1]==(board[i][j]+10) || board[i-1][j+1]==(board[i][j]-10)) &&
                           (board[i-2][j+2]==board[i][j] || board[i-2][j+2]==(board[i][j]+10) || board[i-2][j+2]==(board[i][j]-10)) &&
                           (board[i-3][j+3]==board[i][j] || board[i-3][j+3]==(board[i][j]+10) || board[i-3][j+3]==(board[i][j]-10))   )
                            return board[i][j];
                    if(i>=3 && j>=3)
                        if((board[i-1][j-1]==board[i][j] || board[i-1][j-1]==(board[i][j]+10) || board[i-1][j-1]==(board[i][j]-10)) &&
                           (board[i-2][j-2]==board[i][j] || board[i-2][j-2]==(board[i][j]+10) || board[i-2][j-2]==(board[i][j]-10)) &&
                           (board[i-3][j-3]==board[i][j] || board[i-3][j-3]==(board[i][j]+10) || board[i-3][j-3]==(board[i][j]-10))   )
                            return board[i][j];
                }
            }
        }
        return 999;
    }
    private void checkGoReplacement(int[][] board){
        h = board.length;
        w = board[0].length;
        for(int i = h-1; i >0 ; i--){
            for(int j = 0; j < w; j++){
                if(board[i][j]>10 && board[i][j]<=20){
                    if(i>1 && i<h && j>0 && j<w-1 && true){//the last part of the if is a debug flag to prevent checking if set to false
                        //check up
                        if((board[i][j]==board[i-1][j-1] || board[i][j]-10==board[i-1][j-1]) &&
                           (board[i][j]==board[i-1][j+1] || board[i][j]-10==board[i-1][j+1]) &&
                           (board[i][j]==board[i-2][j] || board[i][j]-10==board[i-2][j])       ){
                            board[i-1][j]=board[i][j]-10;
                        }   
                    }
                    if(i>0 && i<h-2 && j>0 && j<w-1 && true){
                        //check down
                        if((board[i][j]==board[i+1][j-1] || board[i][j]-10==board[i+1][j-1]) &&
                           (board[i][j]==board[i+1][j+1] || board[i][j]-10==board[i+1][j+1]) &&
                           (board[i][j]==board[i+2][j] || board[i][j]-10==board[i+2][j])       ){
                            board[i+1][j]=board[i][j]-10;
                        }
                    }

                    if(i>0 && i<h-1 && j>1 && j<w && true){
                        //check left
                        if((board[i][j]==board[i+1][j-1] || board[i][j]-10==board[i+1][j-1]) &&
                           (board[i][j]==board[i-1][j-1] || board[i][j]-10==board[i-1][j-1]) &&
                           (board[i][j]==board[i][j-2] || board[i][j]-10==board[i][j-2])       ){
                            board[i][j-1]=board[i][j]-10;
                            
                        }
                    }

                    if(i>0 && i<h-1 && j>=0 && j<w-2 && true){
                        //check right
                        if((board[i][j]==board[i+1][j+1] || board[i][j]-10==board[i+1][j+1]) &&
                           (board[i][j]==board[i-1][j+1] || board[i][j]-10==board[i-1][j+1]) &&
                           (board[i][j]==board[i][j+2] || board[i][j]-10==board[i][j+2])       ){
                            board[i][j+1]=board[i][j]-10;
                        }
                        
                    }
                }   
                /*
                if(board[i][j]>=11 && board[i][j]<=20)
                
                if(board[i][j]!=0){
                    // top piece is the fourth
                    if((board[i+1][j]==  players.peek().getNextPiece()) &&
                       (board[i+1][j]==board[i][j-1]) &&
                       (board[i+1][j]== board[i][j+1]  ) ){
                        board[i  ][j]= board[i+1][j];
                    }
                    // left piece is the fourth
                    else if((board[i+1][j]==board[i][j+1]) &&
                       (board[i+1][j]==board[i-1][j]) &&
                       (board[i+1][j]==players.peek().getNextPiece())   ){
                        board[i  ][j]=board[i+1][j];
                    }
                    // right piece is the fourth
                    else if((board[i+1][j]==board[i][j-1]) &&
                       (board[i+1][j]==board[i-1][j]) &&
                       (board[i+1][j]==players.peek().getNextPiece())   ){
                        board[i  ][j]=board[i+1][j];
                    }
                }
                */
            }
        }
    }
    
    
    
    
    
    public void setPlayersQueue(Queue<Player> players) {
        this.players = players;
    }

    public void setInternalGameBoard(int[][] i) {
        this.internalGameBoard = i;
    }

    public Queue<Player> getPlayers() {
        return this.players;
    }
    public int getBoardWidth(){
        return internalGameBoard[0].length;
    }
    public int getBoardHeight(){
        return internalGameBoard.length;
    }

    public int[][] getInternalGameBoard() {
        return this.internalGameBoard;
    }
    public Player getPlayerFromID(int id){
        if(id==0)
            return emptyPlayer;
        else
            return playerIDs.get(id);
    }
    public int getWinnerID(){
        return winner;
    }
    public int[] getTracker(){
        return tracker;
    }
    
    
    
    public String toString(){
        String boardAsString = "Board:\n";
        for(int i = 0; i <= internalGameBoard.length-1; i++){
            boardAsString += "|";
            for(int j = 0; j <= internalGameBoard[i].length-1; j++){
                boardAsString += internalGameBoard[i][j]+"\t"; 
            }
            boardAsString += "|\n";
            
        }
        return boardAsString;
    }

    
}
