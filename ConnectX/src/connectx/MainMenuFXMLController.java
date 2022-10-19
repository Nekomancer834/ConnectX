/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package connectx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

/**
 *
 * @author Trent
 */
public class MainMenuFXMLController implements Initializable {
    
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
    private void startGameAction(ActionEvent event) throws Exception{
        System.out.printf("values:\ncolors: %s %s %s %s %s %s \nnumber of players: %s \ndifficulty: %s \ngo toggle: %s\n", cpP1.getValue(), cpP2.getValue(), cpP3.getValue(), cpP4.getValue(), cpP5.getValue(), cpP6.getValue(), playerCount1.getValue(), difficultySlider.getValue(), goFeat.isSelected());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameMenuFXML.fxml"));
        
        Parent gameRoot = loader.load();
        connectx.GameMenuFXMLController gameWindow = loader.getController();
        Color[] playerColors = {cpP1.getValue(), cpP2.getValue(), cpP3.getValue(), cpP4.getValue(), cpP5.getValue(), cpP6.getValue()};
        gameWindow.setGameVariables(playerColors, Integer.parseInt(playerCount1.getValue().toString()), difficultySlider.getValue(), goFeat.isSelected());
        gameWindow.setupPlayers();
        
        Stage gameStage = new Stage();
        Scene scene = new Scene(gameRoot, 1280, 720);
        
        gameStage.setScene(scene);
        gameStage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cpP1.setValue(Color.RED);
        cpP2.setValue(Color.ORANGE);
        cpP3.setValue(Color.YELLOW);
        cpP4.setValue(Color.GREEN);
        cpP5.setValue(Color.BLUE);
        cpP6.setValue(Color.PURPLE);
        
        // TODO
    }    
    
}
