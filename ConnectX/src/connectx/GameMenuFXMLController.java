/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package connectx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import java.util.Queue;
import java.util.LinkedList;

/**
 * FXML Controller class
 *
 * @author Trent
 */
public class GameMenuFXMLController implements Initializable {

    
    public Pane gameWindowPane;
    public Pane sidePanelPane;
    public Pane gameBoardPane;
    public Circle activeGamePiece;
    
    public Circle playericon1;
    public Circle playericon2;
    public Circle playericon3;
    public Circle playericon4;
    public Circle playericon5;
    public Circle playericon6;
    
    public Label playerLabel1;
    public Label playerLabel2;
    public Label playerLabel3;
    public Label playerLabel4;
    public Label playerLabel5;
    public Label playerLabel6;
    
    
    
    private Color player1Color;
    private Color player2Color;
    private Color player3Color;
    private Color player4Color;
    private Color player5Color;
    private Color player6Color;
    private int playerCountValue;
    private double difficultyValue;
    private boolean goEnable;
    
    Queue<Color> playerList = new LinkedList<Color>();
    Queue<String> playerNameList = new LinkedList<String>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void handleMouseMove(MouseEvent event) {
        //System.out.printf("mouse coordinates: X: %s, Y: %s\n",event.getX(), event.getY());
        activeGamePiece.setLayoutX(event.getX());
        activeGamePiece.setLayoutY(event.getY());
        
    }
    
    @FXML
    private void setActivePlayer(){
        for(int i = 0; i<=playerCountValue;i++){
            switch(i){
                case 0: playericon1.setVisible(true);
                        playerLabel1.setVisible(true);
                        playericon1.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        playerLabel1.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 1: playericon2.setVisible(true);
                        playerLabel2.setVisible(true);
                        playericon2.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        playerLabel2.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 2: playericon3.setVisible(true);
                        playerLabel3.setVisible(true);
                        playericon3.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        playerLabel3.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 3: playericon4.setVisible(true);
                        playerLabel4.setVisible(true);
                        playericon4.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        playerLabel4.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 4: playericon5.setVisible(true);
                        playerLabel5.setVisible(true);
                        playericon5.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        playerLabel5.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 5: playericon6.setVisible(true);
                        playerLabel6.setVisible(true);
                        playericon6.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        playerLabel6.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                default: System.out.println("8==D");
            }
        }
        System.out.println(playerList.peek());
        activeGamePiece.setFill(playericon1.getFill());
        
        playerList.add(playerList.remove());
        playerNameList.add(playerNameList.remove());
        
        //activeGamePiece.setFill(playerList.peek());
    }
    @FXML
    private void onMouseClick(String currentPlayer){
        //check if mouse in valid position
        //if yes 
            //place piece below mouse
            //call method to update whose turn it is
            //
        //if no do nothing
        
    }
    public void setGameVariables(Color[] playerColors, int playerCount, double difficulty, boolean goEnabled){
        
        for(int i = 0; i<playerCount; i++){
            playerList.add(playerColors[i]);
            System.out.printf("color: %s, i: %s\n", playerColors[i], i);
        }
        playerNameList.add("Player 1");
        playerNameList.add("Player 2");
        playerNameList.add("Player 3");
        playerNameList.add("Player 4");
        playerNameList.add("Player 5");
        playerNameList.add("Player 6");
        playerCountValue = playerCount;
        System.out.println(playerCountValue);
        difficultyValue = difficulty;
        goEnable = goEnabled;
    }
    
}
