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
    public Circle icon1;
    public Circle icon2;
    public Circle icon3;
    public Circle icon4;
    public Circle icon5;
    public Circle icon6;
    public Label playerLabell;
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
        for(int i = 0; i<playerCountValue;i++){
            switch(i){
                case 0: icon1.setVisible(true);
                        icon1.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        //System.out.println(playerList.peek());
                        break;
                case 1: icon2.setVisible(true);
                        icon2.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        //System.out.println(playerList.peek());
                        break;
                case 2: icon3.setVisible(true);
                        icon3.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        //System.out.println(playerList.peek());
                        break;
                case 3: icon4.setVisible(true);
                        icon4.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        //System.out.println(playerList.peek());
                        break;
                case 4: icon5.setVisible(true);
                        icon5.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        //System.out.println(playerList.peek());
                        break;
                case 5: icon6.setVisible(true);
                        icon6.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        //System.out.println(playerList.peek());
                        break;
            }
        }
        System.out.println(playerList.peek());
        activeGamePiece.setFill(icon1.getFill());
        
        
        
        //playerList.add(playerList.remove());
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
        playerCountValue = playerCount;
        System.out.println(playerCountValue);
        difficultyValue = difficulty;
        goEnable = goEnabled;
    }
    
}
