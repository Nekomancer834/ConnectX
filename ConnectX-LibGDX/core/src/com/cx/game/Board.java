
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
    private Player emptyPlayer = new Player();
    long now;
    
    
    Board(){
        Queue<Player> defPlayers = new LinkedList<>();
        defPlayers.add(new Player());
        setPlayersQueue(defPlayers);
        setInternalGameBoard(new int[3][3]);
        tracker = new int[internalGameBoard[0].length];
        for(int i = 0; i<tracker.length; i++)
            this.tracker[i] = internalGameBoard.length-1;
    }
    Board(ConnectX game, Queue<Player> players, int[][] internalGameBoard){
        setPlayersQueue(players);
        for(Player x : players){
            playerIDs.put(x.getID(), x);
            playerIDs.put(x.getGoID(), x);
        }
        setInternalGameBoard(internalGameBoard);
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
                System.out.println("Win detected");
                return 0;
            }
            else{
                //generate new piece for active player then cycle to next player and print current board
                players.peek().getNextPiece();
                players.add(players.remove());
                System.out.println(toString());
                return 1;
                }
        }else{
            return 2;
        }
    }
    public boolean winHandler(){
        //this.internalGameBoard = checkGoReplacement(this.internalGameBoard);
        int winReturn = checkWin(this.internalGameBoard);
        if(winReturn != 999 ){
            System.out.println(winReturn);
            return true;
        }
            
        return false;
    }
    private int checkWin(int[][] board){
        //tracking fixed, only perform check if i and j are within limits respective to each check type
        now = System.currentTimeMillis();  
        for(int i = board.length-1; i >= 0; i--){
            for(int j = 0; j < board[i].length; j++){
                //this if is vital for not find a 4 in a row of ID 0
                if(board[i][j]!=0){
                    if(i>=4)
                        if(board[i-1][j]==board[i][j] &&
                           board[i-2][j]==board[i][j] &&
                           board[i-3][j]==board[i][j]   )
                            return board[i][j];
                    if(j<board[i].length-4)
                        if(board[i][j+1]==board[i][j] &&
                           board[i][j+2]==board[i][j] &&
                           board[i][j+3]==board[i][j]   )
                            return board[i][j];
                    if(i>=4 && j<board[i].length-4)
                        if(board[i-1][j+1]==board[i][j] &&
                           board[i-2][j+2]==board[i][j] &&
                           board[i-3][j+3]==board[i][j]   )
                            return board[i][j];
                }
            }
        }
        return 999;
    }
    //this is really broken, disabled until i can figure out how to only make it run when a go piece is present in one of the four spaces
    private int[][] checkGoReplacement(int[][] board){
        for(int i = board.length-2; i >= 1; i--){
            for(int j = 0; j < board[i].length-3; j++){
                    if(board[i][j]!=0)
                        if((board[i-1][j+1]==board[i][j] || board[i-1][j+1]==(board[i][j]+6)) &&
                           (board[i  ][j+2]==board[i][j] || board[i  ][j+2]==(board[i][j]+6)) &&
                           (board[i+1][j+1]==board[i][j] || board[i+1][j+1]==(board[i][j]+6))   )
                            board[i  ][j+1]=board[i][j];
            }
        }
        return board;
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
    
    
    
    public String toString(){
        String boardAsString = "Board:\n";
        for(int i = 0; i <= internalGameBoard.length-1; i++){
            boardAsString += "|";
            for(int j = 0; j <= internalGameBoard[i].length-1; j++){
                boardAsString += internalGameBoard[i][j]+" "; 
            }
            boardAsString += "|\n";
            
        }
        return boardAsString;
    }

    
}