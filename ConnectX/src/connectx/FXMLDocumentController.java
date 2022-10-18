/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package connectx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

/**
 *
 * @author Trent
 */
public class FXMLDocumentController implements Initializable {
    
    public Label p1;
    public ChoiceBox playerCount1;
    public Slider difficultySlider;
    public CheckBox goFeat;
    public ColorPicker cpP1;
    public ColorPicker cpP2;
    public ColorPicker cpP3;
    public ColorPicker cpP4;
    public ColorPicker cpP5;
    public ColorPicker cpP6;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        p1.setText("Slayer 1");
    }
    @FXML
    private void startGameAction(ActionEvent event){
        //System.out.println(playerCount1.getValue());
        
        System.out.printf("values:\ncolors: %s %s %s %s %s %s \nnumber of players: %s \ndifficulty: %s \ngo toggle: %s", cpP1.getValue(), cpP2.getValue(), cpP3.getValue(), cpP4.getValue(), cpP5.getValue(), cpP6.getValue(), playerCount1.getValue(), difficultySlider.getValue(), goFeat.isSelected());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cpP1.setValue(Color.RED);
        cpP2.setValue(Color.ORANGE);
        cpP3.setValue(Color.YELLOW);
        cpP4.setValue(Color.GREEN);
        cpP5.setValue(Color.BLUE);
        cpP6.setValue(Color.INDIGO);
        
        // TODO
    }    
    
}
