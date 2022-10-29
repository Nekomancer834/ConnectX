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
    
    public Label p1Label;
    public Label p2Label;
    public Label p3Label;
    public Label p4Label;
    public Label p5Label;
    public Label p6Label;
    public Label[] playerLabelArray;
    
    public Circle p1Icon;
    public Circle p2Icon;
    public Circle p3Icon;
    public Circle p4Icon;
    public Circle p5Icon;
    public Circle p6Icon;
    public Circle[] playerIconArray;
    
    
    
    
    
    private int playerCountValue;
    
    Queue<Color> playerList = new LinkedList<Color>();
    Queue<String> playerNameList = new LinkedList<String>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        playerLabelArray = new Label[]{p1Label, p2Label, p3Label, p4Label, p5Label, p6Label};
        playerIconArray = new Circle[]{p1Icon, p2Icon, p3Icon, p4Icon, p5Icon, p6Icon};
        
        /*
        for(int i=0; i<playerLabelArray.length; i++)
            System.out.println("Label array output: "+playerLabelArray[i].getText());
        for(int i=0; i<playerLabelArray.length; i++)
            System.out.println("Label array output: "+playerIconArray[i].getFill());
        */
        
    }
    @FXML
    private void handleMouseMove(MouseEvent event) {
        //System.out.printf("mouse coordinates: X: %s, Y: %s\n",event.getX(), event.getY());
        activeGamePiece.setLayoutX(event.getX());
        activeGamePiece.setLayoutY(45);
        
    }
    
    
    
    public void setupPlayers(){
        for(int i = 0; i<playerCountValue;i++){
            playerIconArray[i].setVisible(true);
            playerIconArray[i].setFill(playerList.peek());
            playerList.add(playerList.remove());
            
            playerLabelArray[i].setVisible(true);
            playerLabelArray[i].setText(playerNameList.peek());
            playerNameList.add(playerNameList.remove());
            
            //Debug print
            //System.out.println(i);
            
            //RIP the code Trent spent hours on just to find a fix to the bug he was running into
            /*
            switch(i){
                case 0: p1Icon.setVisible(true);
                        p1Label.setVisible(true);
                        p1Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p1Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 1: p2Icon.setVisible(true);
                        p2Label.setVisible(true);
                        p2Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p2Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 2: p3Icon.setVisible(true);
                        p3Label.setVisible(true);
                        p3Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p3Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 3: p4Icon.setVisible(true);
                        p4Label.setVisible(true);
                        p4Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p4Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 4: p5Icon.setVisible(true);
                        p5Label.setVisible(true);
                        p5Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p5Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 5: p6Icon.setVisible(true);
                        p6Label.setVisible(true);
                        p6Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p6Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                default: System.out.println("hi");
            }
            */
        }
        activeGamePiece.setFill(p1Icon.getFill());
    }
    
    @FXML
    private void setActivePlayer(){
        for(int i = 0; i<playerCountValue;i++){
            playerIconArray[i].setFill(playerList.peek());
            playerList.add(playerList.remove());
            
            playerLabelArray[i].setText(playerNameList.peek());
            playerNameList.add(playerNameList.remove());
            
            //Debug print
            //System.out.println(i);
            
            //RIP the code Trent spent hours on just to find a fix to the bug he was running into
            /*
            switch(i){
                case 0: 
                        p1Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p1Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 1: 
                        p2Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p2Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 2: 
                        p3Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p3Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 3: 
                        p4Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p4Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 4: 
                        p5Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p5Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                case 5: 
                        p6Icon.setFill(playerList.peek());
                        playerList.add(playerList.remove());
                        p6Label.setText(playerNameList.peek());
                        playerNameList.add(playerNameList.remove());
                        System.out.println(i);
                        break;
                default: System.out.println("hi");
            }
            */
        }
        //Debug print
        //System.out.println(playerList.peek());
        
        activeGamePiece.setFill(p1Icon.getFill());
        
        playerList.add(playerList.remove());
        playerNameList.add(playerNameList.remove());
        
        //activeGamePiece.setFill(playerList.peek());
    }
    
    @FXML
    private void onMouseClick(){
        //add piece to backend piece tracker
        //update board with information from backend piece tracker
        setActivePlayer();
        
    }
    public void setGameVariables(Color[] playerColors, int playerCount, double difficulty, boolean goEnabled){
        
        for(int i = 0; i<playerCount; i++){
            playerList.add(playerColors[i]);
            //Debug print
            //System.out.printf("color: %s, i: %s\n", playerColors[i], i);
            playerNameList.add(String.format("Player %d",i+1));
        }
        playerCountValue = playerCount;
        
        //Debug print
        //System.out.println(playerCountValue);
    }
    
}
